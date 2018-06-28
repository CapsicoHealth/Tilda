define(["jointjs", "./parser_element",
 "./custom_element_view", "./helpers", 
 "./relation_renderer", "./custom_object_collection"],
function(joint, ParserElement, CEV, Helpers, LinkRenderer, ObjectCollection){
  function offsetToLocalPoint(paper, x, y) {
    var svgPoint = paper.svg.createSVGPoint();
    svgPoint.x = x;
    svgPoint.y = y;

    var pointTransformed = svgPoint.matrixTransform(paper.viewport.getCTM().inverse());
    return pointTransformed;
  }
  var x = 0;
  var y = 0;

  var CustomLinkView = CEV.CustomLinkView;
  var CustomElementView = CEV.CustomElementView;
  var renderObject = Helpers.renderObject;
  var renderObjectRelations = LinkRenderer;
  var findByCustomId = LinkRenderer.findByCustomId;
  var p = function(package, eleId, opts){
    x = 0;
    y = 0;
    this.package = package;
    this.opts = opts;
    this.eleId = eleId;
    this.objects = new ObjectCollection();
    this.paper = null;
    this.collection = window.collection.clone();
    this.schemaName = this.package.split(".")[1];
    this.pKey = opts.package+"."+this.opts.name;
    this.canvasName = this.opts.name;
    this.currentScale = this.opts.scale || 1;
    console.log("Scale --> "+this.currentScale);
    var that = this;
    // reset object positions.
    _.each(this.collection, function(object, i){
      var object = that.collection.at(i);
      object.set({"graphId": null});
    })
    if(this.opts.viewOnly)
    {
      this.objects = new ObjectCollection(this.collection.where({_type: "View", schemaName: this.schemaName}));
    }
    else 
    {
      var objects = this.collection.filter(function (obj) {
        return obj.get('_type') !== 'View' && obj.get('schemaName') == that.schemaName;
      });
      this.objects = new ObjectCollection(objects);
    }
    var currentPos = { x: -150, y: 30 }

    this.resetAll = function(){
      var elements = this.paper.model.getElements();
      var links = this.paper.model.getLinks();
      var paper = this.paper;
      _.each(elements, function(ele, i){
        paper.findViewByModel(ele).$el.css("opacity", 1);
      })
      _.each(links, function(ele, i){
        var $el = paper.findViewByModel(ele).$el;
        $el.css("opacity", 1);
        $el.find(".connection").attr("stroke-width", 1);
      })
    }
    this.render = function(what){
      var that = this;

      var elementChangeHandler = function(event)
      {
        var eventObject = that.collection.findWhere({graphId: this.get("id")})
        if(eventObject == null)
        {
          return true;
        }
        var key = that.pKey+"#"+eventObject.get("friendlyName");
        if(eventObject.get("hidden") == true)
        {
          key = key+".hidden";
        }
        var position = eventObject.get("data").position;
        if(eventObject.get("data").position == null){
          eventObject.get("data").position = {};
          var position = eventObject.get("data").position;
        }
        window.tildaCache[key] = this.toJSON();
      }

      var gotoNextPosition = function(currentPos){
        if(currentPos.x+300 > window.screen.availWidth){
          currentPos.x = 150;
          currentPos.y = currentPos.y+300;
        } else{
          currentPos.y = 150;
          currentPos.x = currentPos.x+300;
        }
        return currentPos;
      }

      var graph = new joint.dia.Graph;
      var dock_graph = new joint.dia.Graph;
      dock_graph.set("docket_view", true);
      var paper = new joint.dia.Paper({
        el: $("#"+this.eleId),
        width: window.screen.availWidth,
        height: (window.screen.availHeight),
        model: graph,
        gridSize: 10,
        elementView: CustomElementView,
        linkView: CustomLinkView,
      });

      $("#robj").html('');
      var dock_paper = new joint.dia.Paper({
        el: $("#robj"),
        width: $('#robj').width(),
        height: 200,
        model: dock_graph,
        gridSize: 1,
        restrictTranslate: true,
        elementView: CustomElementView,
        linkView: CustomLinkView
      });


      graph.on('remove', function(view)
      {
        var cell = view.model;
        if(cell && cell.get('type') == 'basic.Rect')
        {
          var id = cell.get('customId');
          var currentPosition = cell.get('position');
          var obj = that.objects.findWhere({friendlyName: id}, {caseInsensitive: true});
          if(obj == null)
          {
            obj = that.collection.findWhere({friendlyName: id}, {caseInsensitive: true});
          }
          // var c = findByCustomId(dock_graph, obj);
          // if(c != null)
          // {
          //   console.error(c.toJSON()+"  Already exists in dock_graph");
          //   return
          // }
          var key = that.pKey+"#"+obj.get("friendlyName");
          cell.set({hidden: true});
          window.tildaCache[key] = cell.toJSON();
          var objectAttr = window.tildaCache[key+".hidden"];
          obj.set({graphId: null, rendered: false, nocache: true});
          var objFn = renderObject[obj.get("_type")];
          var t = objFn(dock_graph, obj, {'x': x, 'y': y}, objectAttr, key+".hidden", elementChangeHandler);
          t.set({gPosition: currentPosition});
          dock_paper.scale(that.currentScale);
          x = x+200;
          if(x >= $('#robj').width())
          {
            x = 0;
            y = y + 60;
          }
        }
      })


      dock_graph.on('remove', function(view) 
      {
        var cell = view.model;
        if(cell && cell.get('type') == 'basic.Rect')
        {
          var id = cell.get('customId');
          var obj = that.objects.findWhere({friendlyName: id}, {caseInsensitive: true});
          if(obj == null)
          {
            obj = that.collection.findWhere({friendlyName: id}, {caseInsensitive: true});
          }
          // var c = findByCustomId(graph, obj);
          // if(c != null)
          // {
          //   console.error(c.toJSON()+"  Already exists in graph");
          //   return
          // }
          obj.set({graphId: null, rendered: false});
          obj.unset('hidden');
          cell.unset('hidden');
          var key = that.pKey+"#"+obj.get("friendlyName");
          if(x <= $('#robj').width() && y > 0)
          {
            y = y - 60;
          }
          else
          {
            x = x - 200;
          }
          x = x < 0 ? 0 : x;
          y = y < 0 ? 0 : y;

          var objFn = renderObject[obj.get("_type")];
          if ( objFn != null)
          {
            var position = cell.get('gPosition') || gotoNextPosition(currentPos);
            var objectAttr = window.tildaCache[key];
            if(objectAttr)
            {
              delete objectAttr["hidden"];
            }
            window.tildaCache[key] = objectAttr;
            var t = objFn(graph, obj, position, objectAttr, that.pKey, elementChangeHandler);
            var key = obj.get("_type");
            var objFn = renderObjectRelations[key]
            if(objFn != null)
            {
              objFn(graph, obj, that.pKey);
            }
            renderAllLinks();
          }
        }
      })

      this.paper = paper;
      var V = joint.V;
      window.paper = paper;
      window.dock_paper = dock_paper;

      var dragStartPosition = null;
      paper.on('blank:pointerdown',function(event, x, y) {

        var scale = V(paper.viewport).scale();
        dragStartPosition = { x: x * scale.sx, y: y * scale.sy};
      });
      paper.on('cell:pointerup blank:pointerup', function(cellView, x, y) {
        dragStartPosition = null;
      });
      paper.$el.mousemove(function(event) {
        if (dragStartPosition != null){
          paper.setOrigin(event.offsetX - dragStartPosition.x, event.offsetY - dragStartPosition.y);
        }
      });

      paper.$el.on('mousewheel DOMMouseScroll', function onMouseWheel(e) {
        //function onMouseWheel(e){
        e.preventDefault();
        e = e.originalEvent;
        var delta = Math.max(-1, Math.min(1, (e.wheelDelta || -e.detail))) / 50;
        var offsetX = (e.offsetX || e.clientX - $(this).offset().left);

        var offsetY = (e.offsetY || e.clientY - $(this).offset().top);
        var p = offsetToLocalPoint(paper, offsetX, offsetY);
        var newScale = V(paper.viewport).scale().sx + delta;
        // console.log(' delta' + delta + ' ' + 'offsetX' + offsetX + 'offsety--' + offsetY + 'p' + p.x + 'newScale' + newScale)
        if (newScale > 0.4 && newScale < 2) {
          paper.setOrigin(0, 0);
          paper.scale(newScale, newScale, p.x, p.y);
          that.currentScale = newScale;
          dock_paper.scale(newScale);
        }
      });


      _.each(this.objects, function(object, i){
        var object = that.objects.at(i);
        var key = that.pKey+"#"+object.get("friendlyName");
        var objFn = renderObject[object.get("_type")];
        if ( objFn != null){
          var position = gotoNextPosition(currentPos);
          var objectAttr = window.tildaCache[key];
          var t = objFn(graph, object, position, objectAttr, that.pKey, elementChangeHandler);
        }
      })
      var renderAllLinks = function(){
        _.each(that.objects, function(object, i){
          var object = that.objects.at(i);
          var key = object.get("_type");
          var objFn = renderObjectRelations[key]
          if(objFn != null && object.get('hidden') != true ){
            objFn(graph, object, that.pKey);
          }
        })
      }
      renderAllLinks();
      dock_paper.scale(that.currentScale);
      paper.scale(that.currentScale);
      // Global dock graph
      window.graph = graph;
      window.dock_graph = dock_graph;
    }
    try{
      this.render();
    } catch(e){
      console.error(e.message);
      console.error(e.stack);
    }
  }

  return p;
})
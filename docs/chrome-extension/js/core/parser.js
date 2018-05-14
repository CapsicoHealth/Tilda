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
  var CustomLinkView = CEV.CustomLinkView;
  var CustomElementView = CEV.CustomElementView;
  var renderObject = Helpers.renderObject;
  var renderObjectRelations = LinkRenderer;
  var p = function(package, eleId, opts){
    this.package = package;
    this.opts = opts;
    this.eleId = eleId;
    this.objects = new ObjectCollection();
    this.paper = null;
    this.collection = window.collection.clone();
    this.schemaName = this.package.split(".")[1];
    this.pKey = opts.package+"."+this.opts.name;
    this.currentScale = 1;
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

      var elementChangeHandler = function(event){
        var eventObject = that.collection.findWhere({graphId: this.get("id")})
        if(eventObject == null){
          return true;
        }
        var key = that.pKey+"#"+eventObject.get("friendlyName");
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
          currentPos.x = currentPos.x+300;
        }
        return currentPos;
      }

      var graph = new joint.dia.Graph;
      var graph_1 = new joint.dia.Graph;

      var paper = new joint.dia.Paper({
        el: $("#"+this.eleId),
        width: window.screen.availWidth,
        height: (window.screen.availHeight),
        model: graph,
        gridSize: 10,
        restrictTranslate: true,
        elementView: CustomElementView,
        linkView: CustomLinkView
      });

      $("#robj").html('');
      var paper_1 = new joint.dia.Paper({
        el: $("#robj"),
        width: $('#robj').width(),
        height: (window.screen.availHeight),
        model: graph_1,
        gridSize: 1,
        restrictTranslate: true,
        elementView: CustomElementView,
        linkView: CustomLinkView
      });

      graph.on('remove', function(view){
        var cell = view.model;
        if(cell && cell.get('type') == 'basic.Rect')
        {
          var obj = that.objects.findWhere({friendlyName: cell.get('attrs').id}, {caseInsensitive: true});
          if(obj == null)
          {
            obj = that.collection.findWhere({friendlyName: cell.get('attrs').id}, {caseInsensitive: true});
          }
          obj = obj.clone();
          cell.set(that.pKey, {hidden: true});
          var key = that.pKey+"#"+obj.get("friendlyName")+".hidden";
          window.tildaCache[key] = cell.toJSON();
          obj.set({graphId: null, rendered: false, nocache: true});
          var objFn = renderObject[obj.get("_type")];
          graph_1.addCell(cell);
          var t = objFn(graph_1, obj, {'x': x, 'y': y}, undefined, that.pKey+".hidden", elementChangeHandler);
          paper_1.scale(that.currentScale);
          y = y+40;
        }
      })


      graph_1.on('remove', function(view) {
        var cell = view.model;
        if(cell && cell.get('type') == 'basic.Rect'){
          var obj = that.objects.findWhere({friendlyName: cell.get('attrs').id}, {caseInsensitive: true});
          if(obj == null){
            obj = that.collection.findWhere({friendlyName: cell.get('attrs').id}, {caseInsensitive: true});
          }
          cell.unset(that.pKey);
          var key = that.pKey+"#"+object.get("friendlyName");
          window.tildaCache[key] = cell.toJSON();
          object.set({graphId: null, rendered: false});
          var key = that.pKey+"#"+object.get("friendlyName");
          var objFn = renderObject[object.get("_type")];

          if ( objFn != null){
            console.log("Graph ID "+object.get("graphId") )
            var position = gotoNextPosition(currentPos);
            var objectAttr = window.tildaCache[key];
            var t = objFn(graph, object, position, objectAttr, that.pKey, elementChangeHandler);
            objectAttr.id = t.id;
            t.set(objectAttr);
            var key = object.get("_type");
            var objFn = renderObjectRelations[key]
            if(objFn != null){
              objFn(graph, object, that.pKey);
            }
            renderAllLinks();
          }
        }
      })

      this.paper = paper;
      var V = joint.V;
      window.paper = paper;
      window.paper_1 = paper_1;

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
          paper_1.scale(newScale);
        }
      });


      var x = 0;
      var y = 20;
      _.each(this.objects, function(object, i){
        var object = that.objects.at(i);
        var object_1 = that.objects.at(i).clone();
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
          if(objFn != null){
            objFn(graph, object, that.pKey);
          }
        })        
      }
      renderAllLinks();
    }
    try{
      this.render();
    } catch(e){
      console.error(e.message);
      console.error(e.stack)
    }
  }

  return p;
})
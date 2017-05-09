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
  var p = function(schema, eleId, opts){
    this.schema = schema
    this.opts = opts;
    this.eleId = eleId;
    this.pKey = this.schema.package.toLowerCase()+"#"+this.opts.viewOnly;
    this.objects = new ObjectCollection();
    this.paper = null;
    console.log("pKey --> "+this.pKey)
    var currentPos = { x: -150, y: 30 }
    this.parse = function(){
      var that = this;
      var pushElement = function(collection, schemaObj, _type, _inSchema){
        var t = new ParserElement();
        t.set({data: schemaObj, name: schemaObj.name,
         _type: _type, inSchema: _inSchema, package: that.schema.package, pKey: that.pKey});
        collection.add(t);
      }
      _.each(this.schema.objects, function(object, i){
        pushElement(that.objects, object, "Object", true)
      })
      if(this.opts.viewOnly){
        _.each(this.schema.views, function(view, i){
          pushElement(that.objects, view, "View", true)
        })
      }
      else{
        _.each(this.schema.enumerations, function(enumeration, i){
          pushElement(that.objects, enumeration, "Enumeration", true)
        })

        _.each(this.schema.mappers, function (mapper, i){
          pushElement(that.objects, mapper, "Mapper", true)
        })

      }
    }
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
        var eventObject = that.objects.findWhere({graphId: event.get("id")});
        var key = that.schema.package.toLowerCase()+"#"+eventObject.get("name").toLowerCase();
        var position = eventObject.get("data").position;
        if(eventObject.get("data").position == null){
          eventObject.get("data").position = {};
          var position = eventObject.get("data").position;
        }
        // Store preferences.
        var syncSet = {};
        // console.log("key -> "+key+"\nObject -> "+JSON.stringify(event.toJSON()));
        window.tildaCache[key] = event.toJSON();
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
      this.paper = paper;


      var dragStartPosition = null;
      paper.on('blank:pointerdown',function(event, x, y) {
        dragStartPosition = { x: x, y: y};
      });
      paper.on('cell:pointerup blank:pointerup', function(cellView, x, y) {
        dragStartPosition = null;
      });
      paper.$el.mousemove(function(event) {
        if (dragStartPosition != null){
          paper.setOrigin(event.offsetX - dragStartPosition.x-$(this).offset().left,
           event.offsetY - dragStartPosition.y-$(this).offset().top);
        }
      });

      paper.$el.on('mousewheel DOMMouseScroll', function onMouseWheel(e) {
        //function onMouseWheel(e){
        e.preventDefault();
        e = e.originalEvent;
        var V = joint.V;
        var delta = Math.max(-1, Math.min(1, (e.wheelDelta || -e.detail))) / 50;
        var offsetX = (e.offsetX || e.clientX - $(this).offset().left);

        var offsetY = (e.offsetY || e.clientY - $(this).offset().top);
        var p = offsetToLocalPoint(paper, offsetX, offsetY);
        var newScale = V(paper.viewport).scale().sx + delta;
        // console.log(' delta' + delta + ' ' + 'offsetX' + offsetX + 'offsety--' + offsetY + 'p' + p.x + 'newScale' + newScale)
        if (newScale > 0.4 && newScale < 2) {
          paper.setOrigin(0, 0);
          paper.scale(newScale, newScale, p.x, p.y);
        }
      });

      var that = this;
      var elementChangeHandler = function(event){
        var eventObject = that.objects.findWhere({graphId: event.get("id")});
        var key = eventObject.get("pKey")+"#"+eventObject.get("name").toLowerCase();
        var position = eventObject.get("data").position;
        if(eventObject.get("data").position == null){
          eventObject.get("data").position = {};
          var position = eventObject.get("data").position;
        }
        // Store preferences.
        window.tildaCache[key] = event.toJSON();
      }
      var objects = this.objects
      if(this.opts.viewOnly){
        objects = new ObjectCollection(objects.where({_type: "View"}));
      }

      _.each(objects, function(object, i){
        var object = objects.at(i);
        var key = object.get("pKey")+"#"+object.get("name").toLowerCase();
        var objFn = renderObject[object.get("_type")]
        if ( objFn != null){
          var position = gotoNextPosition(currentPos);
          var objectAttr = window.tildaCache[key];
          var t = objFn(graph, object, position, objectAttr);
          object.set("graphId", t.get("id"));
          object.set("rendered", true);
          t.on('change:position', _.debounce(elementChangeHandler, 500, { 'maxWait' : 1000 }));
        }
      })

      _.each(objects, function(object, i){
        var object = objects.at(i);
        var key = that.opts.viewOnly ? "only"+object.get("_type") : object.get("_type")
        var objFn = renderObjectRelations[key]
        if(objFn != null){
          objFn(graph, object, that.objects, gotoNextPosition(currentPos));
        }
      })

    }
    this.parse();
    this.render();
  }

  return p;
})
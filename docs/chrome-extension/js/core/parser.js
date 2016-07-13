define(["jointjs", "./parser_element"], function(joint, ParserElement){
  var ObjectCollection = Backbone.Collection.extend({
    where: function(attrs, first, options){
      options = options || {};

      if (_.isEmpty(attrs)) return first ? void 0 : [];

      return this[first ? 'find' : 'filter'](function(model) {
        for (var key in attrs) {
          if (options.caseInsensitive) {
            if (attrs[key].toLowerCase() !== model.get(key).toLowerCase()) return false;
          } else {
            if (attrs[key] !== model.get(key)) return false;
          }
        }

        return true;
      });
    },

    findWhere: function(attrs, options) {
      return this.where(attrs, true, options);
    }
  })
  var p = function(_file, eleId){
    this.objects = new ObjectCollection();
    this.eleId = eleId;
    var currentPos = { x: -150, y: 30 }
    this.parse = function(){
      var that = this;
      var pushElement = function(collection, schemaObj, _type){
        var t = new ParserElement();
        t.set({data: schemaObj, name: schemaObj.name, _type: _type, inSchema: true});
        collection.add(t);
      }
      _.each(this.schema.enumerations, function(enumeration, i){
        pushElement(that.objects, enumeration, "Enumeration")
      })

      _.each(this.schema.views, function(view, i){
        pushElement(that.objects, view, "View")
      })

      _.each(this.schema.objects, function(object, i){
        pushElement(that.objects, object, "Object")
      })

      _.each(this.schema.mappers, function (mapper, i){
        pushElement(that.objects, mapper, "Mapper")
      })
    }
    var renderObject = {
      "View": function(graph, collection, position){
        var object = collection.at(position);
        gotoNextPosition(currentPos);
        var objectAttr = {
          position: currentPos,
          size: { width: object.get("name").length*12+10, height: 30 },
          attrs: { 
            id: object.get("name"), 
            rect: { fill: 'rgb(169,209,142)', stroke: "rgb(0,176,80)", "stoke-width": 1, "stroke-dasharray": "3,3" },
            text: { text: object.get("name"), fill: 'black'} 
          } 
        }
        var t = new joint.shapes.basic.Rect(objectAttr);
        // t.translate((position+1)*110, (position+1)*30);
        object.set({graphId: t.id})
        graph.addCell(t);
      },
      "Object": function(graph, collection, position){
        var object = collection.at(position);
        var objectAttr = {}
        gotoNextPosition(currentPos);
        if(object.get("inSchema")){
          // , "stroke-dasharray": "3,3"  },
          objectAttr = _.merge({
            position: currentPos,
            size: { width: object.get("name").length*12+10, height: 30 },
            attrs: { 
              id: object.get("name"), 
              rect: { fill: 'rgb(46,117,182)', stroke: "rgb(65,113,156)", "stoke-width": 2 },
              text: { text: object.get("name"), fill: 'white'} 
            } 
          })
        } else {
          objectAttr = _.merge({
            position: currentPos,
            size: { width: object.get("name").length*12+10, height: 30 },
            attrs: { 
              id: object.get("name"), 
              rect: { fill: 'rgb(166,201,232)', stroke: "white", "stoke-width": 0  },
              text: { text: object.get("name"), fill: 'white'} 
            } 
          })
        }
        var t = new joint.shapes.basic.Rect(objectAttr);
        object.set({graphId: t.id})
        graph.addCell(t);
      },
      "Enumeration": function(graph, collection, position){
        var object = collection.at(position);
        gotoNextPosition(currentPos);
        var objectAttr = {
          position: currentPos,
          size: { width: object.get("name").length*12+10, height: 30 },
          attrs: { 
            id: object.get("name"), 
            rect: { fill: 'rgb(251,229,214)', stroke: "rgb(248,203,173)", "stoke-width": 1  },
            text: { text: object.get("name"), fill: 'black'} 
          } 
        }
        var t = new joint.shapes.basic.Rect(objectAttr);
        object.set({graphId: t.id})
        graph.addCell(t);
      },
      "Mapper": function(graph, collection, position){
        var object = collection.at(position);
        gotoNextPosition(currentPos);
        var objectAttr = {
          position: currentPos,
          size: { width: object.get("name").length*12+10, height: 30 },
          attrs: { 
            id: object.get("name"), 
            rect: { fill: 'rgb(248,203,173)', stroke: "rgb(244,177,131)", "stoke-width": 2  },
            text: { text: object.get("name"), fill: 'black'} 
          } 
        }
        var t = new joint.shapes.basic.Rect(objectAttr);
        object.set({graphId: t.id})
        graph.addCell(t);
      }
    };
    var renderLink = function(graph, source, target){
      var attrs = {
        '.marker-target': { d: 'M 10 0 L 0 5 L 10 10 z' }
      }
      if(source.get('_type') == "Object"){
        if(target.get("inSchema")){
          attrs = _.merge(attrs, {
            '.connection': { stroke: 'rgb(65,113,156)', 'stroke-width': 1 }
          })
        } else {
          attrs = _.merge(attrs, {
            '.connection': { stroke: 'rgb(5,113,156)', 'stroke-width': 1, 'stroke-dasharray': '5 2' }
          })
        }
      } else if(source.get('_type') == "View"){
        if(target.get("inSchema")){
          attrs = _.merge(attrs, {
            '.connection': { stroke: 'rgb(0,176,80)', 'stroke-width': 1 }
          })
        } else {
          attrs = _.merge(attrs, {
            '.connection': { stroke: 'rgb(0,176,80)', 'stroke-width': 1, 'stroke-dasharray': '5 2' }
          })
        }
      }
      var link = new joint.dia.Link({
        source: { id: source.get("graphId") },
        target: { id: target.get("graphId") },
        attrs: attrs
      });
      graph.addCell(link);
    }
    var gotoNextPosition = function(currentPos){
      if(currentPos.x+300 > window.screen.availWidth){
        currentPos.x = 150;
        currentPos.y = currentPos.y+300;
      } else{
        currentPos.x = currentPos.x+300;
      }
    }

    var renderObjectRelations = {
      // This method will add outSchema object
      "Object": function(graph, collection, index){
        var object = collection.at(index);
        if(object.get("data").foreign != null){
          // var rels = _.map(object.get("data").foreign, function(ele, i){ return ele.destObject });
          var rels = [];
          _.each(object.get("data").columns, function(ele, i){
            if(ele.sameas != null && ele.sameas.split(".").length > 1 ){
              rels.push(ele.sameas.split(".").reverse()[1]);
            }
          })
          rels = _.uniq(rels);
          _.each(rels, function(relation, i){
            var target = collection.findWhere({name: relation}, {caseInsensitive: true})
            if(target == null){
              target = new ParserElement({data: {name: relation }, name: relation, _type: "Object", inSchema: false });
              collection.add(target);
              var i = collection.size();
              renderObject[target.get("_type")](graph, collection, collection.indexOf(target));
            }
            renderLink(graph, object, target)
          })
        }
      },
      "View": function(graph, collection, index){
        var rels = [];
        var object = collection.at(index)
        _.each(object.get("data").columns, function(ele, i){
          if(ele.sameas != null && ele.sameas.split(".").length > 1 ){
            rels.push(ele.sameas.split(".").reverse()[1]);
          }
        })
        rels = _.uniq(rels);
        _.each(rels, function(relation, i){
          var target = that.objects.findWhere({name: relation}, {caseInsensitive: true})
          if(target == null){
            target = new ParserElement({data: {name: relation }, name: relation, _type: "Object", inSchema: false });
            that.objects.add(target);
            var i = collection.size();
            renderObject[target.get("_type")](graph, collection, collection.indexOf(target));
          }
          renderLink(graph, object, target)
        })

      },
      "Mapper": function(graph, collection, index){

      }
    }

    this.render = function(){
      var graph = new joint.dia.Graph;
      var paper = new joint.dia.Paper({
        el: $("#"+this.eleId),
        width: window.screen.availWidth,
        height: window.screen.availHeight-80,
        model: graph,
        gridSize: 1,
        restrictTranslate: true
      });
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
        var p = offsetToLocalPoint(offsetX, offsetY);
        var newScale = V(paper.viewport).scale().sx + delta;
        // console.log(' delta' + delta + ' ' + 'offsetX' + offsetX + 'offsety--' + offsetY + 'p' + p.x + 'newScale' + newScale)
        if (newScale > 0.4 && newScale < 2) {
          paper.setOrigin(0, 0);
          paper.scale(newScale, newScale, p.x, p.y);
        }
      });



      function offsetToLocalPoint(x, y) {
        var svgPoint = paper.svg.createSVGPoint();
        svgPoint.x = x;
        svgPoint.y = y;

        var pointTransformed = svgPoint.matrixTransform(paper.viewport.getCTM().inverse());
        return pointTransformed;
      }
      var that = this;
      _.each(this.objects, function(object, i){
        var object = that.objects.at(i);
        if(renderObject[object.get("_type")] != null){
          renderObject[object.get("_type")](graph, that.objects, i);
        }
      })
      _.each(this.objects, function(object, i){
        var object = that.objects.at(i)
        if(renderObjectRelations[object.get("_type")] != null){
          renderObjectRelations[object.get("_type")](graph, that.objects, i);
        }
      })
    }
    // start parsing
    var reader = new FileReader();
    var that = this;
    reader.onload = function(event) {
      try{
        that.schema = JSON.parse(event.target.result);
        that.parse();
        that.render();
      } catch(e){
        console.log("Error occured -> "+e.message);
        console.error(e.stack);
      }
    };
    reader.readAsText(_file);
  }

  return p;
})
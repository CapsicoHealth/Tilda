define(["jointjs", "./parser_element"], function(joint, ParserElement){
  function offsetToLocalPoint(paper, x, y) {
    var svgPoint = paper.svg.createSVGPoint();
    svgPoint.x = x;
    svgPoint.y = y;

    var pointTransformed = svgPoint.matrixTransform(paper.viewport.getCTM().inverse());
    return pointTransformed;
  }
  var CustomElementView = joint.dia.ElementView.extend({
    events: {
      'dblclick': 'dblclick'
    },
    dblclick: function(evt, x, y){
      var neighbors = this.paper.model.getNeighbors(this.model);
      neighbors.push(this.model)
      var connectedLinks = this.paper.model.getConnectedLinks(this.model, {deep: true});
      var elements = this.paper.model.getElements();
      var links = this.paper.model.getLinks();
      var paper = this.paper
      _.each(elements, function(ele, i){
        if(_.indexOf(neighbors, ele) == -1){
          paper.findViewByModel(ele).$el.css("opacity", 0.2);
        }
      })
      _.each(links, function(ele, i){
        if(_.indexOf(connectedLinks, ele) == -1){
          var $el = paper.findViewByModel(ele).$el
          $el.css("opacity", 0.2);
          $el.find(".connection").attr("stroke-width", 1);
        }
      })

      _.each(neighbors, function(ele, i){
        paper.findViewByModel(ele).$el.css("opacity", 1);
      })
      _.each(connectedLinks, function(ele, i){
          var $el = paper.findViewByModel(ele).$el
          $el.css("opacity", 1);
          $el.find(".connection").attr("stroke-width", 4);
      })

    }
  })

  var CustomLinkView = joint.dia.LinkView.extend({
    events: {
      'dblclick': 'dblclick'
    },
    dblclick: function(evt, x, y){
      var neighbors = [];
      neighbors.push(this.model.getSourceElement());
      neighbors.push(this.model.getTargetElement());
      var connectedLinks = [this.model];
      var elements = this.paper.model.getElements();
      var links = this.paper.model.getLinks();
      var paper = this.paper
      _.each(elements, function(ele, i){
        if(_.indexOf(neighbors, ele) == -1){
          paper.findViewByModel(ele).$el.css("opacity", 0.2);
        }
      })
      _.each(links, function(ele, i){
        if(_.indexOf(connectedLinks, ele) == -1){
          var $el = paper.findViewByModel(ele).$el
          $el.css("opacity", 0.2);
          $el.find(".connection").attr("stroke-width", 1);
        }
      })

      _.each(neighbors, function(ele, i){
        paper.findViewByModel(ele).$el.css("opacity", 1);
      })
      _.each(connectedLinks, function(ele, i){
          var $el = paper.findViewByModel(ele).$el
          $el.css("opacity", 1);
          $el.find(".connection").attr("stroke-width", 4);
      })
    }
  })
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
    this.paper = null;
    var currentPos = { x: -150, y: 30 }
    this.parse = function(){
      var that = this;
      var pushElement = function(collection, schemaObj, _type, _inSchema){
        var t = new ParserElement();
        t.set({data: schemaObj, name: schemaObj.name, _type: _type, inSchema: _inSchema});
        collection.add(t);
      }
      _.each(this.schema.enumerations, function(enumeration, i){
        pushElement(that.objects, enumeration, "Enumeration", true)
      })

      _.each(this.schema.views, function(view, i){
        pushElement(that.objects, view, "View", true)
      })

      _.each(this.schema.objects, function(object, i){
        pushElement(that.objects, object, "Object", true)
      })

      _.each(this.schema.mappers, function (mapper, i){
        pushElement(that.objects, mapper, "Mapper", true)
      })
      if(this.schema.jointjs != null){
        var outSchemaObj = this.schema.jointjs;
        _.each(outSchemaObj.enumerations, function(enumeration, i){
          pushElement(that.objects, enumeration, "Enumeration", false)
        })

        _.each(outSchemaObj.views, function(view, i){
          pushElement(that.objects, view, "View", false)
        })

        _.each(outSchemaObj.objects, function(object, i){
          pushElement(that.objects, object, "Object", false)
        })

        _.each(outSchemaObj.mappers, function (mapper, i){
          pushElement(that.objects, mapper, "Mapper", false)
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
        syncSet[key] = event.toJSON();
        chrome.storage.sync.set(syncSet);
      }
      var renderObject = {
        "View": function(graph, object, position, objectAttr){
          if(objectAttr == null){
            objectAttr = {
              position: position,
              size: { width: object.get("name").length*12, height: 30 },
              attrs: { 
                id: object.get("name"), 
                rect: { fill: 'rgb(169,209,142)', stroke: "rgb(0,176,80)", "stroke-width": 1, "stroke-dasharray": "3,3" },
                text: { text: object.get("name"), fill: 'black'} 
              } 
            }
          }
          // console.log("objectAttr --> "+objectAttr+"\n");
          var t = new joint.shapes.basic.Rect(objectAttr);
          t.on('change:position', _.debounce(elementChangeHandler, 500, { 'maxWait' : 1000 }));
          // t.translate((position+1)*110, (position+1)*30);
          object.set({graphId: t.id})
          graph.addCell(t);
        },
        "Object": function(graph, object, position, objectAttr){
          if(objectAttr == null){
            if(object.get("inSchema")){
              // , "stroke-dasharray": "3,3"  },
              objectAttr = {
                position: position,
                size: { width: object.get("name").length*12, height: 30 },
                attrs: { 
                  id: object.get("name"), 
                  rect: { fill: 'rgb(46,117,182)', stroke: "rgb(65,113,156)", "stroke-width": 2 },
                  text: { text: object.get("name"), fill: 'white'} 
                } 
              }
            } else {
              objectAttr = {
                position: position,
                size: { width: object.get("name").length*12, height: 30 },
                attrs: { 
                  id: object.get("name"), 
                  rect: { fill: 'rgb(166,201,232)', stroke: "white", "stroke-width": 0  },
                  text: { text: object.get("name"), fill: 'white'} 
                } 
              }
            }            
          }
          // console.log("objectAttr --> "+objectAttr+"\n");
          var t = new joint.shapes.basic.Rect(objectAttr);
          t.on('change:position', _.debounce(elementChangeHandler, 500, { 'maxWait' : 1000 }));
          object.set({graphId: t.id})
          graph.addCell(t);
        },
        "Enumeration": function(graph, object, position, objectAttr){
          if(objectAttr == null){
            objectAttr = {
              position: position,
              size: { width: object.get("name").length*12, height: 30 },
              attrs: { 
                id: object.get("name"), 
                rect: { fill: 'rgb(251,229,214)', stroke: "rgb(248,203,173)", "stroke-width": 1  },
                text: { text: object.get("name"), fill: 'black'} 
              } 
            }
          }
          // console.log("objectAttr --> "+objectAttr+"\n");
          var t = new joint.shapes.basic.Rect(objectAttr);
          t.on('change:position', _.debounce(elementChangeHandler, 500, { 'maxWait' : 1000 }));
          object.set({graphId: t.id})
          graph.addCell(t);
        },
        "Mapper": function(graph, object, position, objectAttr){
          if(objectAttr == null){
            objectAttr = {
              position: currentPos,
              size: { width: object.get("name").length*12, height: 30 },
              attrs: { 
                id: object.get("name"), 
                rect: { fill: 'rgb(248,203,173)', stroke: "rgb(244,177,131)", "stroke-width": 2  },
                text: { text: object.get("name"), fill: 'black'} 
              } 
            }           
          }
          var t = new joint.shapes.basic.Rect(objectAttr);
          t.on('change:position', _.debounce(elementChangeHandler, 
            500, { 'maxWait' : 1000 })
          );
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
        } else if(source.get('_type') == "Mapper"){
          if(target.get("inSchema")){
            attrs = _.merge(attrs, {
              '.connection': { stroke: 'rgb(248,203,173)', 'stroke-width': 1 }
            })
          } else {
            attrs = _.merge(attrs, {
              '.connection': { stroke: 'rgb(248,203,173)', 'stroke-width': 1, 'stroke-dasharray': '5 2' }
            })
          }
        }
        var link = new joint.dia.Link({
          source: { id: source.get("graphId") },
          target: { id: target.get("graphId") },
          attrs: attrs
        });
        link.on('change', _.debounce(function(element){
          var source = element.getSourceElement();
          var eventObject = that.objects.findWhere({graphId: source.get("id")});
          var links = eventObject.get("data").links;
          if(eventObject.get("data").links == null){
            eventObject.get("data").links = {};
            var links = eventObject.get("data").links;
          }
          links[element.get("id")] = element.toJSON();
        }, 500, { 'maxWait' : 1000 }));
        graph.addCell(link);
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

      var renderObjectRelations = {
        // This method will add outSchema object
        "Object": function(graph, object, superset){
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
              var target = superset.findWhere({name: relation}, {caseInsensitive: true})
              if(target == null){
                target = new ParserElement({data: {name: relation }, name: relation, _type: "Object", inSchema: false });
                superset.add(target);
                renderObject[target.get("_type")](graph, target);
              } else if(target.get("graphId") == null){// which means object is on in graph
                renderObject[target.get("_type")](graph, target);
              }
              renderLink(graph, object, target)
            })
          }
        },
        "View": function(graph, object, superset){
          var rels = [];
          _.each(object.get("data").columns, function(ele, i){
            if(ele.sameas != null && ele.sameas.split(".").length > 1 ){
              rels.push(ele.sameas.split(".").reverse()[1]);
            }
          })
          rels = _.uniq(rels);
          _.each(rels, function(relation, i){
            var target = superset.findWhere({name: relation}, {caseInsensitive: true})
            if(target == null){
              target = new ParserElement({data: {name: relation }, name: relation, _type: "Object", inSchema: false });
              superset.add(target);
              renderObject[target.get("_type")](graph, target);
            } else if(target.get("graphId") == null){// which means object is on in graph
              renderObject[target.get("_type")](graph, target);
            }
            renderLink(graph, object, target)
          })

        },
        "Mapper": function(graph, object, superset){
          var rels = [];
          _.each(object.get("data").primaryColumns, function(ele, i){
            if(ele.sameas != null && ele.sameas.split(".").length > 1 ){
              rels.push(ele.sameas.split(".").reverse()[1]);
            }
          })
          rels = _.uniq(rels);
          _.each(rels, function(relation, i){
            var target = superset.findWhere({name: relation}, {caseInsensitive: true})
            if(target == null){
              target = new ParserElement({data: {name: relation }, name: relation, _type: "Object", inSchema: false });
              superset.add(target);
              renderObject[target.get("_type")](graph, target);
            } else if(target.get("graphId") == null){// which means object is on in graph
              renderObject[target.get("_type")](graph, target);
            }

            renderLink(graph, object, target)
          })

        }
      }

      var graph = new joint.dia.Graph;
      var paper = new joint.dia.Paper({
        el: $("#"+this.eleId),
        width: window.screen.availWidth,
        height: (window.screen.availHeight-80),
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

      var renderObjectRels = function(){
        _.each(that.objects, function(object, i){
          var object = that.objects.at(i);
          if(renderObjectRelations[object.get("_type")] != null){
            renderObjectRelations[object.get("_type")](graph, object, that.objects);
          }
        })
      }
      _.each(this.objects, function(object, i){
        var object = that.objects.at(i);
        var key = that.schema.package.toLowerCase()+"#"+object.get("name").toLowerCase();
        if (renderObject[object.get("_type")] != null){
          chrome.storage.sync.get(key, function(objectAttr){
            var position = gotoNextPosition(currentPos);
            // console.log("key -> "+key+"\nObject -> "+JSON.stringify(objectAttr[key]))
            renderObject[object.get("_type")](graph, object, position, objectAttr[key]);
            if(i == that.objects.length-1){
              // Hack todo research
              renderObjectRels();
            }
          })
        }
      })
    }

    this.saveSchema = function(event){
      var that = this;
      this.schema.enumerations = _.map(that.objects.where({_type: "Enumeration", inSchema: true }), function(e) {return e.get("data"); });
      this.schema.objects      = _.map(that.objects.where({_type: "Object", inSchema: true}), function(e) {return e.get("data"); });
      this.schema.views        = _.map(that.objects.where({_type: "View", inSchema: true}), function(e) {return e.get("data"); });
      this.schema.mappers      = _.map(that.objects.where({_type: "Mapper", inSchema: true}), function(e) {return e.get("data"); });
      this.schema.jointjs = {}
      this.schema.jointjs.enumerations = _.map(that.objects.where({_type: "Enumeration", inSchema: false }), function(e) {return e.get("data"); });
      this.schema.jointjs.objects = _.map(that.objects.where({_type: "Object", inSchema: false }), function(e) {return e.get("data"); });
      this.schema.jointjs.views = _.map(that.objects.where({_type: "View", inSchema: false }), function(e) {return e.get("data"); });
      this.schema.jointjs.mappers = _.map(that.objects.where({_type: "Mapper", inSchema: false }), function(e) {return e.get("data"); });
      var jsonString = JSON.stringify(this.schema,null,4);

      chrome.fileSystem.chooseEntry( {
        type: 'saveFile',
        acceptsAllTypes: true
      }, function(fileEntry){
        fileEntry.createWriter(function(fileWriter) {
          var truncated = false;
          var blob = new Blob([jsonString], {type: "text/plain"});
          fileWriter.onwriteend = function(e) {
            if (!truncated) {
              truncated = true;
              // You need to explicitly set the file size to truncate
              // any content that might have been there before
              this.truncate(blob.size);
              return;
            }
            console.log('Export to '+fileDisplayPath+' completed');
          };
          fileWriter.onerror = function(e) {
            console.error('Export failed: '+e.toString());
          };
          fileWriter.write(blob);
        });
      });
    }

    // start parsing
    that = this;
    var readFile = function(_file){
      var reader = new FileReader();
      reader.onload = function(event) {
        try{
          that.schema = JSON.parse(event.target.result);
          var key = that.schema.package.toLowerCase();
          that.parse();
          that.render();
        } catch(e){
          console.error("Error occured -> "+e.message);
          console.error(e.stack);
        }
      };
      reader.readAsText(_file);
    }
    readFile(_file);

  }

  return p;
})
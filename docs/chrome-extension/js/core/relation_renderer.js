define(["jointjs", "lodash", "jquery",
 "./parser_element", "./helpers"],
 function(joint, _, $, ParserElement, Helpers){
  var renderObject = Helpers.renderObject;

  var renderLink = function(graph, source, target, superset){
    var key = source.get("pKey")+"#"+source.get("name")+"#"+target.get("name");
    key = key.toLowerCase();    
    var linkAttrs = window.tildaCache[key];
    if(linkAttrs == null){
      linkAttrs = {
        source: { id: source.get("graphId") },
        target: { id: target.get("graphId") }
      }
      var attrs = {
        '.marker-target': { d: 'M 10 0 L 0 5 L 10 10 z' },
        'key': source.get("pKey")+"#"+source.get("name")+"#"+target.get("name")
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
      linkAttrs["attrs"] = attrs
    } else {
      linkAttrs = _.merge(linkAttrs, {
        source: { id: source.get("graphId") },
        target: { id: target.get("graphId") }
      })
    }
    var vertices = linkAttrs.vertices;
    var link = new joint.dia.Link(linkAttrs);
    var eventHandler = function(event){
      var key = event.get("attrs").key.toLowerCase();
      var syncSet = {}
      var attributes = event.attributes;
      window.tildaCache[key] = _.merge(attributes, { vertices: this.get('vertices') })
    }
    if(vertices){
      link.set('vertices', vertices);
    }
    link.on("change:vertices", _.debounce(eventHandler, 500, { 'maxWait' : 1000 }));
    graph.addCell(link);
  }

  var elementChangeHandler = function(superset, event){
    var eventObject = superset.findWhere({graphId: event.get("id")});
    var key = eventObject.get("pKey")+"#"+eventObject.get("name").toLowerCase();
    var position = eventObject.get("data").position;
    if(eventObject.get("data").position == null){
      eventObject.get("data").position = {};
      var position = eventObject.get("data").position;
    }
    // Store preferences.
    var syncSet = {};
    window.tildaCache[key] = event.toJSON();
  }

  var renderObjectRelations = {
    // This method will add outSchema object
    "Object": function(graph, object, superset, position){
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
          var package = superset.at(0).get("package")
          var pKey = superset.at(0).get("pKey");
          var key = pKey+"#"+relation.toLowerCase();
          var target = superset.findWhere({name: relation}, {caseInsensitive: true})
          if(target == null){
            target = new ParserElement({data: {name: relation }, name: relation,
               _type: "Object", inSchema: false, package: package, pKey: pKey });
            superset.add(target);
            var objectAttr = window.tildaCache[key];
            var t = renderObject[target.get("_type")](graph, target, position, objectAttr);
            target.set({graphId: t.get("id")});
            t.on('change:position', _.debounce(function(event){
              elementChangeHandler(superset, event);
            }, 500, { 'maxWait' : 1000 }));
          }
          renderLink(graph, object, target, superset)
        })
      }
    },
    "View": function(graph, object, superset, position){
      var rels = [];
      _.each(object.get("data").columns, function(ele, i){
        if(ele.sameas != null && ele.sameas.split(".").length > 1 ){
          rels.push(ele.sameas.split(".").reverse()[1]);
        }
      })
      rels = _.uniq(rels);
      _.each(rels, function(relation, i){
        var package = superset.at(0).get("package")
        var pKey = superset.at(0).get("pKey");
        var key = pKey+"#"+relation.toLowerCase();
        var target = superset.findWhere({name: relation}, {caseInsensitive: true})
        if(target == null){
          target = new ParserElement({data: {name: relation }, name: relation,
             _type: "Object", inSchema: false, package: package, pKey: pKey });
          superset.add(target);
          var objectAttr = window.tildaCache[key];
          var t = renderObject[target.get("_type")](graph, target, position, objectAttr);
          target.set({graphId: t.get("id")});
          t.on('change:position', _.debounce(function(event){
            elementChangeHandler(superset, event);
          }, 500, { 'maxWait' : 1000 }));
        }
        renderLink(graph, object, target, superset)
      })

    },
    "onlyView": function(graph, object, superset, position){
      var rels = [];
      _.each(object.get("data").columns, function(ele, i){
        if(ele.sameas != null && ele.sameas.split(".").length > 1 ){
          rels.push(ele.sameas.split(".").reverse()[1]);
        }
      })
      rels = _.uniq(rels);
      _.each(rels, function(relation, i){
        var package = superset.at(0).get("package")
        var pKey = superset.at(0).get("pKey");
        var key = pKey+"#"+relation.toLowerCase();
        var target = superset.findWhere({name: relation}, {caseInsensitive: true})
        if(target == null){
          target = new ParserElement({data: {name: relation }, name: relation,
             _type: "Object", inSchema: false, package: package, pKey: pKey });
          superset.add(target);
        }
        if(target.get("rendered") != true){
          var objectAttr = window.tildaCache[key];
          var t = renderObject[target.get("_type")](graph, target, position, objectAttr);
          target.set({graphId: t.get("id")});
          t.on('change:position', _.debounce(function(event){
            elementChangeHandler(superset, event);
          }, 500, { 'maxWait' : 1000 }));
          target.set("rendered", true);
        }
        renderLink(graph, object, target, superset)

      })
    },
    "Mapper": function(graph, object, superset, position){
      var rels = [];
      _.each(object.get("data").primaryColumns, function(ele, i){
        if(ele.sameas != null && ele.sameas.split(".").length > 1 ){
          rels.push(ele.sameas.split(".").reverse()[1]);
        }
      })
      rels = _.uniq(rels);
      _.each(rels, function(relation, i){
        var package = superset.at(0).get("package")
        var pKey = superset.at(0).get("pKey");
        var key = pKey+"#"+relation.toLowerCase();
        var target = superset.findWhere({name: relation}, {caseInsensitive: true})
        if(target == null){
          target = new ParserElement({data: {name: relation }, name: relation,
             _type: "Object", inSchema: false, package: package, pKey: pKey });
          superset.add(target);
          var objectAttr = window.tildaCache[key];
          var t = renderObject[target.get("_type")](graph, target, position, objectAttr);
          target.set({graphId: t.get("id")});
          t.on('change:position', _.debounce(function(event){
            elementChangeHandler(superset, event);
          }, 500, { 'maxWait' : 1000 }));
        }

        renderLink(graph, object, target, superset)
      })
    }
  }
  return renderObjectRelations;
});
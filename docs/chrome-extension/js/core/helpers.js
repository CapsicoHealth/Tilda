define(["jointjs", "lodash", "jquery"], function(joint, _, $){
  var gotoNextPosition = function(currentPos){
    if(currentPos.x+200 > window.screen.availWidth){
      currentPos.x = 100;
      currentPos.y = currentPos.y+200;
    } else{
      currentPos.x = currentPos.x+200;
    }
    return currentPos;
  }
  var X = {};
  var renderView = function(graph, object, position, objectAttr, package){
    var renderFn = function(g, o, p, attr, pkg){
      if(attr == null){
        var name = o.get("schemaName")+"."+o.get("name");
        attr = {
          position: position,
          size: { width: name.length*12, height: 30 },
          attrs: { 
            rect: { fill: 'rgb(169,209,142)', stroke: "rgb(0,176,80)", "stroke-width": 1, "stroke-dasharray": "3,3" },
            text: { text: name, fill: 'black'} 
          }
        }
      }
      if(o.get('graphId') == null){
        var t = new joint.shapes.basic.Rect(attr);
        g.addCell(t);
        o.set({graphId: t.id, rendered: true})
      }
      return t;
    }
    var a = renderFn.apply(this, arguments);
    // dependencies;
    console.log("Deps --> "+object.get("name"));
    var references = object.get("references") || [];
    _.each(references, function(value, i){
      var key = package+"#"+value.get("friendlyName");
      console.log("Key --> "+key);
      objectAttr = window.tildaCache[key];
      var fn = X[value.get("_type")];
      fn.apply(this, [graph, value, gotoNextPosition(position), objectAttr, package])
    })
    return a;
  }
  var renderObject = function(graph, object, position, objectAttr, package){
    var renderFn = function(g, o, p, attr, pkg){
      var name = o.get("schemaName")+"."+o.get("name");
      if(attr == null){
        // , "stroke-dasharray": "3,3"  },
        console.log("Name --> Object "+name);
        attr = {
          position: p,
          size: { width: name.length*12, height: 30 },
          attrs: {
            id: o.get("friendlyName"),
            rect: { fill: 'rgb(46,117,182)', stroke: "rgb(65,113,156)", "stroke-width": 2 },
            text: { text: name, fill: 'white'}
          } 
        }
      }

      if(o.get('graphId') == null){
        var t = new joint.shapes.basic.Rect(attr);
        g.addCell(t);
        o.set({graphId: t.id, rendered: true, package: package})
      }
      return t;
    }
    var a = renderFn.apply(this, arguments);

    var references = object.get("references") || [];
    _.each(references, function(value, i){
      var key = package+"#"+value.get("friendlyName");
      console.log("Key --> "+key);
      console.log("Type --> "+value.get("_type"));
      objectAttr = window.tildaCache[key];
      var fn = X[value.get("_type")];
      fn.apply(this, [graph, value, gotoNextPosition(position), objectAttr, package])
    })
    return a;
  }
  var renderEnumeration = function(graph, object, position, objectAttr, package){
    var renderFn = function(g, o, p, attr, pkg){
      if(attr == null){
        var name = o.get("schemaName")+"."+o.get("name");
        attr = {
          position: position,
          size: { width: name.length*12, height: 30 },
          attrs: { 
            id: o.get("friendlyName"),
            rect: { fill: 'rgb(251,229,214)', stroke: "rgb(248,203,173)", "stroke-width": 1  },
            text: { text: name, fill: 'black'} 
          } 
        }

      }
      if(object.get('rendered') == null){
        var t = new joint.shapes.basic.Rect(attr);
        graph.addCell(t);
        o.set({graphId: t.id, rendered: true, package: package})
        return t;
      }
    }
    var a = renderFn.apply(this, arguments);

    var references = object.get("references") || [];
    _.each(references, function(value, i){
      var key = package+"#"+value.get("friendlyName");
      objectAttr = window.tildaCache[key];
      var fn = X[value.get("_type")];
      fn.apply(this, [graph, value, gotoNextPosition(position), objectAttr, package])
    })
    return a;

  }
  var renderMapper = function(graph, object, position, objectAttr, package){
    var renderFn = function(g, o, p, attr, pkg){

      if(attr == null){
        var name = o.get("schemaName")+"."+o.get("name");
        attr = {
          position: position,
          size: { width: name.length*12, height: 30 },
          attrs: { 
            id: o.get("friendlyName"),
            rect: { fill: 'rgb(248,203,173)', stroke: "rgb(244,177,131)", "stroke-width": 2  },
            text: { text: name, fill: 'black'} 
          } 
        }           
      }
      if(o.get('graphId') == null){
        var t = new joint.shapes.basic.Rect(attr);
        graph.addCell(t);
        o.set({graphId: t.id, rendered: true, package: package})
        return t;
      }
    }
    var a = renderFn.apply(this, arguments);

    // dependencies;
    var references = object.get("references") || [];
    _.each(references, function(value, i){
      var key = package+"#"+value.get("friendlyName");
      objectAttr = window.tildaCache[key];
      var fn = X[value.get("_type")];
      fn.apply(this, [graph, value, gotoNextPosition(position), objectAttr, package])
    })
    return a;
  }
  X = {
    "View": renderView,
    "Object": renderObject,
    "Enumeration": renderEnumeration,
    "Mapper": renderMapper
  };
  return { renderObject: X };
})
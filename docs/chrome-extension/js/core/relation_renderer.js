define(["jointjs", "lodash", "jquery",
 "./parser_element", "./helpers"],
 function(joint, _, $, ParserElement, Helpers){
  var renderObject = Helpers.renderObject;
  var renderedLinks = [];
  var renderLink = function(graph, source, target, pKey){
    var key = pKey+"#"+source.get("friendlyName")+"#"+target.get("friendlyName");
    var linkAttrs = window.tildaCache[key];
    if(linkAttrs == null){
      linkAttrs = {
        source: { id: source.get("graphId") },
        target: { id: target.get("graphId") }
      }
      var attrs = {
        '.marker-target': { d: 'M 10 0 L 0 5 L 10 10 z' },
        'key': pKey+"#"+source.get("name")+"#"+target.get("name")
      }
      if(source.get('_type') == "Object"){
        if(target.get("schemaName") != source.get("schemaName")){
          attrs = _.merge(attrs, {
            '.connection': { stroke: 'rgb(65,113,156)', 'stroke-width': 1 }
          })
        } else {
          attrs = _.merge(attrs, {
            '.connection': { stroke: 'rgb(5,113,156)', 'stroke-width': 1, 'stroke-dasharray': '5 2' }
          })
        }
      } else if(source.get('_type') == "View"){
        if(target.get("schemaName") != source.get("schemaName")){
          attrs = _.merge(attrs, {
            '.connection': { stroke: 'rgb(0,176,80)', 'stroke-width': 1 }
          })
        } else {
          attrs = _.merge(attrs, {
            '.connection': { stroke: 'rgb(0,176,80)', 'stroke-width': 1, 'stroke-dasharray': '5 2' }
          })
        }
      } else if(source.get('_type') == "Mapper"){
        if(target.get("schemaName") != source.get("schemaName")){
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
    var hoorah = _.filter(renderedLinks, function(ele){
      return ele.source.id == linkAttrs.source.id && ele.target.id == linkAttrs.target.id
    })
    console.log("hoorah --> "+JSON.stringify(hoorah));
    console.log("linkAttrs --> "+JSON.stringify(linkAttrs));
    if(hoorah.length == 0){
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
      renderedLinks.push(linkAttrs); 
    }
  }

  var X = {};
  var objRel = function(graph, object, pKey){
    var rels = object.get('references') || [];
    _.each(rels, function(target){
      renderLink(graph, object, target, pKey)
      objRel.apply(this, [graph, target, pKey]);
    })
  }
  var renderObjectRelations = {
    // This method will add outSchema object
    "Object": objRel,
    "View": objRel,
    "onlyView": objRel,
    "Mapper": objRel
  }
  return renderObjectRelations;
});
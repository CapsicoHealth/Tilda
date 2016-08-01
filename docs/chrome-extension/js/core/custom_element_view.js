define(["jointjs", "lodash", "jquery"], function(joint, _, $){

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
  
  return { CustomLinkView: CustomLinkView, CustomElementView: CustomElementView }
})

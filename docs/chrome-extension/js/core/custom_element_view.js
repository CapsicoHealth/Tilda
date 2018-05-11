define(["jointjs", "lodash", "jquery"], function(joint, _, $){
  joint.shapes.basic.CustomRect = joint.shapes.basic.Rect.extend({
    markup: '<g class="rotatable"><g class="scalable"><rect/></g><g class="deleteTool"><circle fill="red" r="11" transform="translate(10, 10)"></circle><path transform="scale(.8) translate(-4, -4)" d="M24.778,21.419 19.276,15.917 24.777,10.415 21.949,7.585 16.447,13.087 10.945,7.585 8.117,10.415 13.618,15.917 8.116,21.419 10.946,24.248 16.447,18.746 21.948,24.248z"/><title>Remove this element</title></g><text/></g>',
    defaults: joint.util.deepSupplement({
      type: 'basic.Rect',
      attrs: {
        'rect': {
          fill: '#ffffff',
          stroke: '#000000',
          width: 100,
          height: 60
        },
        'text': {
          fill: '#000000',
          text: '',
          'font-size': 14,
          'ref-x': .5,
          'ref-y': .5,
          'text-anchor': 'middle',
          'y-alignment': 'middle',
          'font-family': 'Arial, helvetica, sans-serif'
        }
      }
    }, joint.shapes.basic.Generic.prototype.defaults)
  });


  var CustomElementView = joint.dia.ElementView.extend({
    events: {
      'dblclick': 'dblclick',
      'click .deleteTool': 'deleteElement'
    },
    deleteElement: function(event){
      var connectedLinks = this.paper.model.getConnectedLinks(this.model, {deep: true});
      this.remove();
      _.each(connectedLinks, function(ele, i){
        ele.remove();
      })
      this.paper.model.trigger('remove', this)
    },
    dblclick: function(evt, x, y){
      var neighbors = this.paper.model.getNeighbors(this.model);
      neighbors.push(this.model)
      var connectedLinks = this.paper.model.getConnectedLinks(this.model, {deep: true});
      var elements = this.paper.model.getElements();
      var links = this.paper.model.getLinks();
      var paper = this.paper
      var resetAll = function(){
        _.each(elements, function(ele, i){
          paper.findViewByModel(ele).$el.css("opacity", 1);
        })
        _.each(links, function(ele, i){
          var $el = paper.findViewByModel(ele).$el;
          $el.css("opacity", 1);
          $el.find(".connection").attr("stroke-width", 1);
        })
      }
      if(this.model.get("highlighted") == null){
        this.model.set("highlighted", true);
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
      } else {
        resetAll();
        this.model.set("highlighted", null);
      }
    },

    // template: [
    //   '<div class="html-element">',
    //   '<button class="delete">x</button>',
    //   '<label></label>',
    //   '<span></span>', '<br/>',
    //   '<input type="text" value="I\'m HTML input" />',
    //   '</div>'
    // ].join(''),

    // initialize: function() {
    //     _.bindAll(this, 'updateBox');
    // },
    // render: function() {
    //     joint.dia.ElementView.prototype.render.apply(this, arguments);
    //     joint.dia.ElementView.prototype.initialize.apply(this, arguments);
    //     this.paper.$el.prepend($(_.template(this.template)()));
    //     // Prevent paper from handling pointerdown.
    //     this.paper.$el.find('.html-element').find('input,select').on('mousedown click', function(evt) {
    //         evt.stopPropagation();
    //     });
    //     // This is an example of reacting on the input change and storing the input data in the cell model.
    //     this.paper.$el.find('.html-element').find('input').on('change', _.bind(function(evt) {
    //         this.model.set('input', $(evt.target).val());
    //     }, this));
    //     this.paper.$el.find('.html-element').find('select').on('change', _.bind(function(evt) {
    //         this.model.set('select', $(evt.target).val());
    //     }, this));
    //     this.paper.$el.find('.html-element').find('select').val(this.model.get('select'));
    //     this.paper.$el.find('.html-element').find('.delete').on('click', _.bind(this.model.remove, this.model));
    //     // Update the box position whenever the underlying model changes.
    //     this.model.on('change', this.updateBox, this);
    //     // Remove the box when the model gets removed from the graph.
    //     this.model.on('remove', this.removeBox, this);
    //     this.updateBox();
    //     return this;
    // },
    // updateBox: function() {
    //     // Set the position and dimension of the box so that it covers the JointJS element.
    //     var bbox = this.model.getBBox();
    //     // Example of updating the HTML with a data stored in the cell model.
    //     this.paper.$el.find('label').text(this.model.get('label'));
    //     this.paper.$el.find('span').text(this.model.get('select'));
    //     this.paper.$el.css({
    //         width: bbox.width,
    //         height: bbox.height,
    //         left: bbox.x,
    //         top: bbox.y,
    //         transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)'
    //     });
    // },
    // removeBox: function(evt) {
    //     this.paper.$el.find('.html-element').remove();
    // }
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
      var paper = this.paper;
      var resetAll = function(){
        _.each(elements, function(ele, i){
          paper.findViewByModel(ele).$el.css("opacity", 1);
        })
        _.each(links, function(ele, i){
          var $el = paper.findViewByModel(ele).$el;
          $el.css("opacity", 1);
          $el.find(".connection").attr("stroke-width", 1);
        })
      }

      if(this.model.get("highlighted") == null){
        this.model.set("highlighted", true);

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
      } else {
        resetAll();
        this.model.set("highlighted", null);
      }
    }
  })
  
  return { CustomLinkView: CustomLinkView, CustomElementView: CustomElementView }
})

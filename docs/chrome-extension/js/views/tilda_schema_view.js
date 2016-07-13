define(['text!../templates/tilda_schema/_new.html', "../core/parser"], function(_NewView, _Parser){
  var Backbone = require('backbone');
  var _ = require('lodash');
  var TildaSchemaView = Backbone.View.extend({
    events: {
      'change input[type=file][name="schema-file"]': 'handleFileInput'
    },
    render: function(){
      var that = this;
      that.$el.html(_NewView);
      return this;
    },
    handleFileInput: function(event){
      $("#abc").remove()
      var p = document.createElement("div");
      p.id = "abc";
      this.$el.append($(p));
      var file = $(event.target)[0].files[0]; // only one file at a time.
      new _Parser(file, "abc");
    }
  })
  return TildaSchemaView;
})
define(function(require){
  var Backbone = require('backbone');
  var _ = require('lodash');
  var TildaSchemaView = require('views/tilda_schema_view');
  var boot = function(){
    window.tilda_schema_view = new TildaSchemaView().render();
    $("body").append(tilda_schema_view.$el);
  }
  return boot;
})
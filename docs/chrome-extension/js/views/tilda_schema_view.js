define(['text!../templates/tilda_schema/_new.html', "../core/parser"], function(_NewView, _Parser){
  var Backbone = require('backbone');
  var _ = require('lodash');
  var TildaSchemaView = Backbone.View.extend({
    events: {
      'change input[type=file][name="schema-file"]': 'handleFileInput',
      'click .saveSchema': 'saveSchema',
      'click .reset': 'resetView',
      'change input:radio[name="showObj"]': "togglePapers"
    },
    togglePapers: function(){
      if($(event.target).val() == "object"){
        this.$el.find("#view_c").hide(); // hide for now.
        this.$el.find("#obj_c").show();
      } else{
        this.$el.find("#obj_c").hide(); // hide for now.
        this.$el.find("#view_c").show();
      }
    },
    render: function(){
      var that = this;
      that.$el.html(_NewView);
      return this;
    },
    handleFileInput: function(event){
      var that = this;
      var file = $(event.target)[0].files[0]; // only one file at a time.
      if(file == null){
        return true;
      }
      $("#view_c").html("");
      $("#obj_c").html("");
      $("#obj_c").show();
      $("#view_c").show();
      chrome.storage.local.get(null, function(items) {
        var allKeys = Object.keys(items);
        window.tildaCache = items; // used across 
        var readFile = function(_file){
          var reader = new FileReader();
          reader.onload = function(event) {
            try{
              var schema = JSON.parse(event.target.result);
              that.schemaParser_object = new _Parser(_.clone(schema), "obj_c", {viewOnly: false});
              that.schemaParser_view = new _Parser(_.clone(schema), "view_c", {viewOnly: true});
            } catch(e){
              console.error("Error occured -> "+e.message);
              console.error(e.stack);
            }
          };
          reader.readAsText(_file);
        }
        readFile(file);
      })

    },
    saveSchema: function(event){
      // TODO write to a file.
      var objSVG = this.schemaParser_object.paper.$el.find("svg")[0]
      var objSVGDATA = 'data:image/svg+xml;base64,'+window.btoa(new XMLSerializer().serializeToString(document.getElementById(objSVG.id)))
      var viewSVG = this.schemaParser_view.paper.$el.find("svg")[0]
      var viewSVGDATA = 'data:image/svg+xml;base64,'+window.btoa(new XMLSerializer().serializeToString(document.getElementById(viewSVG.id)))
      var canvas = this.$el.find("canvas#result")[0];
      var context = canvas.getContext('2d');
      var objImage = new Image();
      var viewImage = new Image();

      objImage.onload = function() {
        viewImage.src = viewSVGDATA
      };
      viewImage.onload = function() {
        drawCanvas()
      };
      var drawCanvas = function(){
        context.canvas.width = objImage.width;
        context.canvas.height = objImage.height+viewImage.height+10;
        context.globalAlpha = 1.0;
        context.drawImage(objImage, 0, 0, objImage.width, objImage.height);
        context.drawImage(viewImage, 0, objImage.height+10, viewImage.width, viewImage.height);
        //
        var contentToWrite = context.canvas.toDataURL();
        chrome.fileSystem.chooseEntry( {
          type: 'saveFile',
          acceptsAllTypes: true
        }, function(fileEntry){
          fileEntry.createWriter(function(fileWriter) {
            var truncated = false;
            var blob = new Blob([contentToWrite], {type: "image/png"});
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
      objImage.src = objSVGDATA;
    },
    resetView: function(event){
      if(this.schemaParser_object){
        this.schemaParser_object.resetAll();
      }
      if(this.schemaParser_view){
        this.schemaParser_view.resetAll();
      }
    }
  })
  return TildaSchemaView;
})
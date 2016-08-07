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

      var viewSVG = this.schemaParser_view.paper.$el.find("svg")[0];
      var that = this;
      $.get('css/joint.css', function(css){
        chrome.fileSystem.chooseEntry( {
          type: 'saveFile',
          acceptsAllTypes: true
        }, function(fileEntry){
          fileEntry.createWriter(function(fileWriter) {
            var truncated = false;
            var script = "\n\
              <script>\n\
                window.onload = function(){\n\
                  debugger;\n\
                  var svgs = document.getElementsByTagName('svg');\n\
                  for(i=0;i<svgs.length;i++){\n\
                    var svg = svgs[i];\n\
                    var bbox = svg.getBBox();\n\
                    svg.setAttribute('viewBox', [bbox.x, bbox.y, bbox.width, bbox.height]);\n\
                    svg.width.baseVal.valueAsString = bbox.width;\n\
                    svg.height.baseVal.valueAsString = bbox.height;\n\
                  }\n\
                }\n\
              </script>";
            var blob = new Blob(["<style>"+css+"</style>", "<div class='container'>"
              +objSVG.parentElement.innerHTML,"</div>", "<br/>"
              ,"<div class='container'>", viewSVG.parentElement.innerHTML,"</div>"
              , script], {type: "image/svg"});
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
      })


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
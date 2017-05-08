define(['text!../templates/tilda_schema/_new.html', 
    "../core/parser", '../core/file_search', '../core/read_schema'],
  function(_NewView, _Parser, _FileSearch, _ReadSchema){
  var error = function(error){
    console.log(error.message);
    console.log(error.stack);
  }

  var Backbone = require('backbone');
  var _ = require('lodash');
  var promiseError = function(error, reject){
    console.error(error.message);
    console.error(error.stack);
    reject(error);
  }
  var SCHEMA_REGEX = /\_tilda\.([A-Z][A-Za-z_0-9]+)\.json/i;

  var fileInputHandler = function(viewScope, entry) {
    viewScope.currentEntry = entry;
    var reader = entry.createReader();
    var errorCallback = function(e) {
      console.error(e);
    }
    var $select = viewScope.$el.find('select');
    viewScope.$el.find('.actions').hide();
    var f = new _FileSearch(entry, viewScope.excludeRegex, function(files){
      viewScope.$el.find('.actions').show();
      var rs = new _ReadSchema(files, function(){
        $select.html('');
        $select.append('<option value=\'\'>--- select a schema ---</option');
        for(i=0;i<files.length;i++){
          var file = files[i];
          viewScope.schemaEntries[file.name] = viewScope.schemaEntries[file.name] || {};
          viewScope.schemaEntries[file.name] = file;
          $select.append('<option value=\''+file.name+'\'>'+file.name+'</option');
        }
      })
    })
  }
  var TildaSchemaView = Backbone.View.extend({
    schemaName: null,
    currentEntry: null,
    packageInfo: null,
    schemaEntries: {},
    excludeRegex: null,
    events: {
      'click button[name="schema-file"]': 'handleFileInput',
      'click .saveSchema': 'saveSchema',
      'change input:radio[name="showObj"]': "togglePapers",
      'change select': "changeView",
      'click .save-regex': 'saveRegex',
      'click .filterRegex': function(){
        $('#filterD').modal('show');
      }
    },
    saveRegex: function(event){
      var value = $('.regex-f').val();
      this.excludeRegex = new RegExp(value, 'i');
      console.log(chrome.storage);
      if(chrome.storage){
        chrome.storage.local.set("regex-f", value);
      }
      console.log(value);
      console.log(this.excludeRegex);
      $('#filterD').modal('hide');
      fileInputHandler(this, this.savedEntry);
    },
    changeView: function(event){
      var that = this;
      var fName = $(event.target).val();
      var schemaEntry = this.schemaEntries[fName];
      var init = function(objectEntries){
        var pkgInfo = objectEntries.packageInfo;
        that.packageInfo = pkgInfo;
        that.initCache(objectEntries.cacheEntry).then(function(cache){
          window.tildaCache = cache;
          var schemaFname = "_tilda."+pkgInfo.schema.name+".json";
          that.$el.find(".fName").html("<h4>loaded <i>"+schemaFname+"</i></h4>")
          that.$el.find("#obj_c").html("");
          that.schemaParser_object = new _Parser(schemaFname, "obj_c", {viewOnly: false});
        }).catch(error);
      }
      var schemaName = schemaEntry.name.split(".")[1];
      var graphInfoName = "_tilda."+schemaName+".graphInfo.json"
      var fullPath = schemaEntry.fullPath.replace(schemaEntry.name, graphInfoName)
      schemaEntry.filesystem.root.getFile(fullPath, {create: true }, function(dEntry){
        var objects = {}
        objects.cacheEntry = dEntry;
        objects.packageInfo = {
          "schema": {
            "name": schemaName,
            "path": schemaEntry.fullPath
          }
        };
        init(objects);
      }, error)

    },
    togglePapers: function(){
      var schemaFname = $('select').val();
      this.$el.find("#obj_c").html("");
      if($(event.target).val() == "object"){
          this.schemaParser_object = new _Parser(schemaFname, "obj_c", {viewOnly: false});
      } else{
          this.schemaParser_object = new _Parser(schemaFname, "obj_c", {viewOnly: true});
      }
    },
    render: function(){
      var that = this;

      that.$el.html(_NewView);
      if(chrome.storage){
        chrome.storage.local.get("regex-f", function(value){
          if(value != null || value.length > 0){
            that.excludeRegex = new RegExp(value, "i");
            that.$el.find('.regex-f').val(value);
          }
        });        
      } else {
        that.excludeRegex = new RegExp("\/bin\/*", "i"); // default filter
      }

      that.$el.find('.actions').hide();

      return this;
    },
    initCache: function(fileEntry){
      var p = new Promise(function (resolve, reject) {
        var readFile = function(_file){
          var reader = new FileReader();
          reader.onload = function(event) {
            try{
              var tildaCache = JSON.parse(event.target.result) || {};
              resolve(tildaCache)
            } catch(e){
              resolve({})
            }
          };
          reader.readAsText(_file);
        }
        if(fileEntry == null){
          // fileEntry might not be there.
          resolve({})
        } else {
          fileEntry.file(function(file){
            readFile(file);
          })
        }
      })
      return p;
    },
    handleFileInput: function(event){
      var that = this;
      var $select = that.$el.find('select');
      that.$el.find('.actions').hide();
      var error = function(error){
        console.log(error.message);
        console.log(error.stack);
      }
      chrome.fileSystem.chooseEntry({ type: 'openDirectory'},  function(entry) {
        that.savedEntry = entry;
        fileInputHandler(that, entry);
      });
      return 0;
    },
    saveSchema: function(event){
      that = this;
      this.currentEntry.getParent(function(dEntry){
        that.writeUserPrefs(dEntry, event);
        that.writeSVG(dEntry, event);
      })
    },
    writeSVG: function(entry, event){
      // TODO write to a file.
      var objSVG = this.schemaParser_object.paper.$el.find("svg")[0]

      var viewSVG = this.schemaParser_view.paper.$el.find("svg")[0];
      var that = this;
      var fileName = "_tilda."+this.packageInfo.schema.name.toUpperCase()+".html";
      // var docText = _.map(that.schemaParser_object.schema.documentation.description, function(line){
      //   return "<h4>"+line+"</h4>\n"
      // }).join("\n")
      $.get('css/viewonly_joint.css', function(css){
        entry.getFile(fileName, {create: true}, function(fileEntry){
          fileEntry.createWriter(function(fileWriter) {
            var truncated = false;
            var script = "\n\
              <script>\n\
                var bindElementClickEvent = function(){\n\
                  var eventHandler = function(event){\n\
                    var name = this.querySelector('tspan').innerHTML;\n\
                    console.log(name);\n\
                    window.location.href = '#'+name.toUpperCase()+'_DIV';\n\
                  }\n\
                  elements = document.getElementsByClassName('element')\n\
                  for (var i = 0; i < elements.length; i++) {\n\
                      elements[i].addEventListener('click', eventHandler, false);\n\
                  }\n\
                }\n\
                window.onload = function(){\n\
                  var svgs = document.getElementsByTagName('svg');\n\
                  for(i=0;i<svgs.length;i++){\n\
                    var svg = svgs[i];\n\
                    var bbox = svg.getBBox();\n\
                    svg.setAttribute('viewBox', [bbox.x, bbox.y, bbox.width, bbox.height]);\n\
                    svg.width.baseVal.valueAsString = bbox.width;\n\
                    svg.height.baseVal.valueAsString = bbox.height;\n\
                  }\n\
                  bindElementClickEvent();\n\
                }\n\
              </script>";
            var blob = new Blob(["<style>"+css+"</style>", 
                "<div><h1>Tables Graph</h1></div>\n",
                "<div class='container'>\n",
                objSVG.parentElement.innerHTML,
                "\n</div>\n", 
                "<br/>\n",
                "<div><h1>Views Graph</h1></div>\n",
                "<div class='container'>\n",
                viewSVG.parentElement.innerHTML,
                "\n</div>\n",
                script
              ], {type: "image/svg"});
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
        })
      })
    },
    writeUserPrefs: function(entry, event){
      var fileName = "_tilda."+this.packageInfo.schema.name+".graphInfo.json";
      entry.getFile(fileName, {create: true}, function(fileEntry){
        fileEntry.createWriter(function(fileWriter) {
          var blob = new Blob([JSON.stringify(window.tildaCache,null,2)]);
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
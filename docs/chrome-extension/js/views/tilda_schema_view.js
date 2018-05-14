define(['text!../templates/tilda_schema/_new.html', 
    "../core/parser", '../core/file_search', '../core/read_schema'],
  function(_NewView, _Parser, _FileSearch, _ReadSchema){
  var error = function(error){
    console.log(error.message);
    console.log(error.stack);
  }
  window.renderedCache = {};
  var svgHTML = {}
  var defaultCanvases = [{name: "object", title: "Tables Graph", package: null, viewOnly: false}, {name: "view", title: "Views Graph", package: null, viewOnly: true}];
  svgHTML["object"] = { name: "Tables Graph", svg: null };
  svgHTML["view"] = { name: "Views Graph", svg: null };
  var olderViewName = null;
  var Backbone = require('backbone');
  var _ = require('lodash');
  var promiseError = function(error, reject){
    console.error(error.message);
    console.error(error.stack);
    reject(error);
  }
  var SCHEMA_REGEX = /\_tilda\.([A-Z][A-Za-z_0-9]+)\.json/i;
  var populateSVGHTML = function(canvases, fName, package)
  {
    $.each(canvases, function(key, value){
      if(value != null)
      {
        value.package = package;
        var p = new _Parser(fName, "obj_c", {viewOnly: value.viewOnly, package: value.package, name: value.name});
        svgHTML[value.name] = svgHTML[value.name] || {};
        svgHTML[value.name]["svg"] = p.paper.$el.find("svg")[0].parentElement.innerHTML;
      }
    })
  }
  var fileInputHandler = function(viewScope, entry) {
    viewScope.currentEntry = entry;
    var reader = entry.createReader();
    var errorCallback = function(e) {
      console.error(e);
    };
    var $select = viewScope.$el.find('select.schemas');
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
      'change select.add-view-holder': "togglePapers",
      'change select.schemas': "changeView",
      'click .save-regex': 'saveRegex',
      'click .createCanvas': 'createCanvas',
      'click .renameCanvas': 'renameCanvas',
      'click .deleteCanvas': 'deleteCanvas',
      'click .filterRegex': function(){
        $('#filterD').modal('show');
      },
      'click .newCanvas': function(){
        $('#createCanvasD').modal('show');
      }
    },
    renameCanvas: function()
    {
      var $select = $('select.add-view-holder');
      var selectValue = $select.val();
      $("#canvas_name").val(102);
      var canvasConfig = tildaCache.canvases.filter(function(canvas)
      {
        return canvas!= null && canvas.name == selectValue;
      })[0];
      tildaCache.canvases = tildaCache.canvases.filter(function(canvas)
      {
        return canvas != null;
      })[0];
      $('#canvas_name').val(selectValue);
      $('#createCanvasD').modal('show');
    },
    deleteCanvas: function()
    {
      var $select = $('select.add-view-holder');
      var selectValue = $select.val();
      var canvasConfig = tildaCache.canvases.filter(function(canvas)
      {
        return canvas!= null && canvas.name == selectValue;
      })[0];
      tildaCache.canvases = tildaCache.canvases.filter(function(canvas)
      {
        return canvas != null;
      });
      var index = tildaCache.canvases.indexOf(canvasConfig);
      delete tildaCache.canvases[index];
      $select.find('option[value="'+selectValue+'"]').remove();
    },
    createCanvas: function(event)
    {
      var currentOpts = this.schemaParser_object.opts;
      var name = $("#canvas_name").val();
      var new_canvas = parseInt($("#new_canvas").val());
      if(name == "object" || name == "view")
      {
        console.error("Name cannot be object or view");
        return false;
      }
      if(new_canvas != 1)
      {
        var canvasConfig = tildaCache.canvases.filter(function(canvas)
        {
          return canvas!= null && canvas.name == name;
        })[0];
        tildaCache.canvases = tildaCache.canvases.filter(function(canvas)
        {
          return canvas != null;
        });

        var index = tildaCache.canvases.indexOf(canvasConfig);
        delete tildaCache.canvases[index];
        $select.find('option[value="'+selectValue+'"]').remove();
      }

      window.tildaCache.canvases.push({
        name: name,
        package: currentOpts.package,
        viewOnly: currentOpts.viewOnly || false
      })

      $("select.add-view-holder").append("<option value='"+name+"'>"+name+"</option>");
      $("select.add-view-holder").val(name);        
      $(".showObj").val(name);
      $('#createCanvasD').modal('hide');      
      $("#canvas_name").val('');
      $("#new_canvas").val(1);
      $('select.add-view-holder').trigger('change');
    },
    saveRegex: function(event){
      var value = $('.regex-f').val();
      this.excludeRegex = new RegExp(value, 'i');
      if(chrome.storage){
        chrome.storage.local.set("regex-f", value);
      }
      $('#filterD').modal('hide');
      fileInputHandler(this, this.savedEntry);
    },
    changeView: function(event){
      var that = this;
      var fName = $(event.target).val();
      var schemaEntry = this.schemaEntries[fName];
      that.currentEntry = schemaEntry;
      var init = function(objectEntries){
        var pkgInfo = objectEntries.packageInfo;
        that.packageInfo = pkgInfo;
        that.initCache(objectEntries.cacheEntry).then(function(cache){
          window.tildaCache = cache;
          var t= {};
          $("select.add-view-holder").html('');
          $.each(tildaCache.canvases, function(key, v)
          {
            if(v != null && t[v.name] == null)
            {
              t[v.name] = v.name;
              $("select.add-view-holder").append("<option value='"+v.name+"'>"+v.name+"</option>");
            }
          })

          var schemaFname = "_tilda."+pkgInfo.schema.name+".json";
          that.$el.find(".fName").html("<h4>loaded <i>"+schemaFname+"</i></h4>")
          that.$el.find("#obj_c").html("");
          var reader = new FileReader();
          reader.onload = function(e) {
            var schema = JSON.parse(e.target.result);
            olderViewName = "object";
            populateSVGHTML(tildaCache.canvases, schemaFname, schema.package);
            that.schemaParser_object = new _Parser(schemaFname, "obj_c", {viewOnly: false, package: schema.package, name: "object"});
          }
          schemaEntry.file(function(schemaEntryF){
            reader.readAsText(schemaEntryF);
          });

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
    togglePapers: function(event){
      var schemaFname = $('select.schemas').val();
      var selectValue = $(event.target).val();
      window.renderedCache = {};
      $('.renameCanvas').parent().addClass('hidden');
      $('.deleteCanvas').parent().addClass('hidden');
      if(selectValue != 'object' || selectValue != 'view')
      {
        $('.renameCanvas').parent().removeClass('hidden');
        $('.deleteCanvas').parent().removeClass('hidden');
      }
      var that = this;
      svgHTML[olderViewName]["svg"] = this.$el.find("#obj_c").find("svg")[0].parentElement.innerHTML;
      var schemaEntry = this.schemaEntries[schemaFname];
      var reader = new FileReader();
      this.$el.find("#obj_c").html("");
      reader.onload = function(e) {
        var schema = JSON.parse(e.target.result);
        canvasConfig = tildaCache.canvases.filter(function(canvas)
        {
          return canvas!= null && canvas.name == selectValue;
        })[0]
        that.schemaParser_object = new _Parser(schemaFname, "obj_c", {viewOnly: canvasConfig.viewOnly, package: canvasConfig.package, name: canvasConfig.name});
      }
      olderViewName = selectValue;
      schemaEntry.file(function(schemaEntryF){
        reader.readAsText(schemaEntryF);
      });
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
              var tildaCache = event.target.result.length > 0 ? (JSON.parse(event.target.result) || {}) : {};
              tildaCache.canvases = tildaCache.canvases || defaultCanvases;
              resolve(tildaCache);
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
      var $select = that.$el.find('select.schemas');
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
      return false;
    },
    writeSVG: function(entry, event){
      // TODO write to a file.
      // var objSVG = this.schemaParser_object.paper.$el.find("svg")[0];

      // var viewSVG = this.schemaParser_view.paper.$el.find("svg")[0];

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
            var blobArr = ["<style>"+css+"</style>"];

            $.each(svgHTML, function(key, value){
              blobArr.push("<fieldset><legend>"+value.name+"</legend>");
              blobArr.push("<div class='container'>");
              blobArr.push(value.svg);
              blobArr.push("\n</div>\n");
              blobArr.push("<br/>\n");
              blobArr.push("<br/>\n");
              blobArr.push("<br/>\n");
              blobArr.push("</fieldset>");
            });
            var blob = new Blob(blobArr, {type: "image/svg"});
            fileWriter.onwriteend = function(e) {
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
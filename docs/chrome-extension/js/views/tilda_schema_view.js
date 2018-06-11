define(['text!../templates/tilda_schema/_new.html', 
    "../core/parser", '../core/file_search', '../core/read_schema'],
  function(_NewView, _Parser, _FileSearch, _ReadSchema){
  var error = function(error){
    console.log(error.message);
    console.log(error.stack);
  }
  Array.prototype.diff = function(a) {
      return this.filter(function(i) {return a.indexOf(i) < 0;});
  };
  var SCHEMA_REGEX = /\_tilda\.([A-Z][A-Za-z_0-9]+)\.json$/i;
  window.renderedCache = {};
  var svgHTML = {}
  var defaultCanvases = [{name: "object", title: "Tables Graph", package: null, viewOnly: false, scale: 1}, {name: "view", title: "Views Graph", package: null, viewOnly: true, scale: 1}];
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
  var copyTildaCache = function(from, to)
  {
    var testRegex = new RegExp("\\."+from+"#\.*")
    var tildaCache = _.pick(_.clone(window.tildaCache), function(v, k, object)
    {
      return testRegex.test(k);
    })
    var t = {}
    _.each(tildaCache, function(v,  k , obj)
    {
      var newKey = k.replace(from, to);
      t[newKey] = v;
    })
    _.extend(window.tildaCache, t);
  }

  var deleteTildaCache = function(canvasName)
  {
    var testRegex = new RegExp("\\."+canvasName+"#\.*")
    var t = _.pick(window.tildaCache, function(v, k, object)
    {
      return testRegex.test(canvasName);
    }) || {};
    _.each(t, function(v,  k , obj)
    {
      delete window.tildaCache[k];
    });
  }
  var populateSVGHTML = function(canvases, fName, package)
  {
    $.each(canvases, function(key, value){
      if(value != null)
      {
        value.package = package;
        var p = new _Parser(fName, "obj_c", {viewOnly: value.viewOnly, package: value.package, name: value.name, scale: value.scale});
        svgHTML[value.name] = svgHTML[value.name] || {};
        svgHTML[value.name]["svg"] = p.paper.$el.find("svg")[0].parentElement.innerHTML;
        svgHTML[value.name]["name"] = value.name;
        $("#obj_c").html('');
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
      'click .hideContent': 'hideActions',
      'click .filterRegex': function(){
        $('#filterD').modal('show');
      },
      'click .newCanvas': function(){
        $('.deleteCanvas').hide();
        $('#createCanvasD').modal('show');
      }
    },
    hideActions: function()
    {
      $(".hideableContent").toggle();
    },
    renameCanvas: function()
    {
      var $select = $('select.add-view-holder');
      var selectValue = $select.val();
      $("#new_canvas").val(102);
      $('.deleteCanvas').show();
      var canvasConfig = tildaCache.canvases.filter(function(canvas)
      {
        return canvas!= null && canvas.name == selectValue;
      })[0];
      tildaCache.canvases = tildaCache.canvases.filter(function(canvas)
      {
        return canvas != null;
      });
      $("#canvas_name").data('oldValue', selectValue);
      $('#canvas_name').val(selectValue);
      $('.deleteCanvas').html('Delete ?');
      $('.deleteCanvas').data('confirmed', false);
      $('#createCanvasD').modal('show');
      return false;
    },
    deleteCanvas: function()
    {
      var $target = $(event.target);
      if($target.data('confirmed') == null || $target.data('confirmed') == false)
      {
        $target.html('Confirmation: Are you sure to delete ?');
        $target.data('confirmed', true);
        $target.attr('disabled', 'disabled');
        setTimeout(function()
        {
          $target.removeAttr('disabled');
        }, 1000);
        return false;
      }
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
      delete svgHTML[name];
      delete tildaCache.canvases[index];
      debugger;
      deleteTildaCache(canvasConfig.name);
      $select.find('option[value="'+selectValue+'"]').remove();
      $("#canvas_name").val('');
      $("#new_canvas").val(1);
      $('select.add-view-holder').trigger('change');
      $('#createCanvasD').modal('hide');
      $target.data('confirmed', false);
      $target.html('Delete ?');
      return false;
    },
    createCanvas: function(event)
    {
      var currentOpts = this.schemaParser_object.opts;
      var $select = $("select.add-view-holder");
      var name = $("#canvas_name").val();
      var oldName = $("#canvas_name").data('oldValue');
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
          return canvas!= null && canvas.name == oldName;
        })[0];
        tildaCache.canvases = tildaCache.canvases.filter(function(canvas)
        {
          return canvas != null;
        });
        canvasConfig.name = name;
        $select.find('option[value="'+oldName+'"]').remove();
        t = svgHTML[oldName]
        svgHTML[name] = t;
        deleteTildaCache(oldName);
        delete svgHTML[oldName];
      }
      else
      {
        oldName = this.schemaParser_object.canvasName;
        svgHTML[name] = { name: name, svg: null };
        window.tildaCache.canvases.push({
          name: name,
          package: currentOpts.package,
          viewOnly: (currentOpts.viewOnly || false),
          scale: currentOpts.scale
        })
      }
      copyTildaCache(oldName, name);
      $select.append("<option value='"+name+"'>"+name+"</option>");
      $select.val(name);
      // $(".showObj").val(name);
      $('#createCanvasD').modal('hide');      
      $("#canvas_name").val('');
      $("#new_canvas").val(1);
      olderViewName = name;
      $('select.add-view-holder').trigger('change');
      return false;
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
          $("select.add-view-holder").html('');
          $("select.add-view-holder").append("<option value=''>--- select a canvas ---</option>");
          $.each(tildaCache.canvases, function(key, v)
          {
            if(v != null)
            {
              $("select.add-view-holder").append("<option value='"+v.name+"'>"+v.name+"</option>");
            }
          })

          var schemaFname = fName;
          that.$el.find(".fName").html("<h4>loaded <i>"+schemaFname+"</i></h4>")
          that.$el.find("#obj_c").html("");
          var reader = new FileReader();
          reader.onload = function(e) {
            var schema = JSON.parse(e.target.result);
            populateSVGHTML(tildaCache.canvases, schemaFname, schema.package);
            that.$el.find("#obj_c").html("");
            $("#robj").html('');
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
      var that = this;
      var currentScale = 1
      if(that.schemaParser_object != null)
      {
        currentScale = that.schemaParser_object.currentScale;
      }
      var schemaFname = $('select.schemas').val();
      var selectValue = $(event.target).val();
      if(selectValue == null && selectValue.length == 0)
      {
        $('.newCanvas').parent().hide();
        $('.renameCanvas').parent().hide();
        return null;
      }
      $('.newCanvas').parent().show();
      $('.renameCanvas').parent().show();
      console.log("selectValue -> "+selectValue);
      if(schemaFname == null || selectValue == null || schemaFname.length == 0 || selectValue.length == 0)
      {
        this.$el.find("#obj_c").html("");
        return false;
      }
      $('.renameCanvas').parent().removeClass('hidden');
      if(selectValue == 'object' || selectValue == 'view')
      {
        $('.renameCanvas').parent().addClass('hidden');
      }
      if(olderViewName != null)
      {
        if(svgHTML[olderViewName] == null)
        {
          console.error("Cannot find "+olderViewName+" in svgHTML");
        }
        else
        {
          delete svgHTML[olderViewName]["svg"];
          svgHTML[olderViewName]["svg"] = this.$el.find("#obj_c").html();
        }
      }
      var schemaEntry = this.schemaEntries[schemaFname];
      var reader = new FileReader();
      this.$el.find("#obj_c").html("");
      reader.onload = function(e) {
        var schema = JSON.parse(e.target.result);
        canvasConfig = tildaCache.canvases.filter(function(canvas)
        {
          return canvas!= null && canvas.name == selectValue;
        })[0];
        canvasConfig.scale = currentScale;
        that.schemaParser_object = new _Parser(schemaFname, "obj_c", {viewOnly: canvasConfig.viewOnly, package: canvasConfig.package, name: canvasConfig.name, scale: canvasConfig.scale});
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
      that.$el.find('.newCanvas').parent().hide();
      that.$el.find('.renameCanvas').parent().hide();

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
        if(entry != null)
        {
          that.savedEntry = entry;
          fileInputHandler(that, entry);
        }
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
      // saving currently opened view
      var name = $("select.add-view-holder").val();
      if(svgHTML[name] == null)
      {
        console.error("Cannot find "+name+" in svgHTML");
      }
      else
      {
        delete svgHTML[name]["svg"];
        svgHTML[name]["svg"] = this.$el.find("#obj_c").html();
      }

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
            blobArr.push("<div class='container'>"); 
            $.each(svgHTML, function(key, value){
              blobArr.push("<fieldset><legend>"+value.name+"</legend>");
              blobArr.push(value.svg);
              blobArr.push("</fieldset>");
              blobArr.push("<br/>\n");
              blobArr.push("<br/>\n");
            });
            blobArr.push("\n</div>\n");
            blobArr.push(script);
            var blob = new Blob(blobArr);
            fileWriter.onwriteend = function(e) {
              this.truncate(blob.size);
              fileWriter.onwriteend = null; // stop looping
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
        var truncated = false;
        fileEntry.createWriter(function(fileWriter) {
          var blob = new Blob([JSON.stringify(window.tildaCache,null,2)]);
          fileWriter.onwriteend = function(e) {
            this.truncate(blob.size);
            fileWriter.onwriteend = null; // stop looping
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
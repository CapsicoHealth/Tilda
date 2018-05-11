define(["./parser_element", "./custom_object_collection"],
function(ParserElement, Collection){
  var readFiles = function(fileEntries, callback) {
    var that = this;
    var collection = new Collection();
    var pushElement = function(package, elementArr, _type){
      _.each(elementArr, function(value, i){
        var schemaName = package.split(".")[1];
        var objectName = value.name;
        var friendlyName = value.name.toLowerCase();
        var references = [];
        _.each(value.primaryColumns, function(column, j){
          if(column.sameas != null){
            var sameas = column.sameas.split(".");
            var reference = sameas.reverse()[1];
            if(reference != null){
              reference = reference.toLowerCase();
              if(reference != objectName && references.indexOf(reference) == -1){
                references.push(reference);
              }
            }
          }
        })
        _.each(value.columns, function(column, j){
          if(column.sameas != null){
            var sameas = column.sameas.split(".");
            var reference = sameas.reverse()[1];
            if(reference != null){
              reference = reference.toLowerCase();
              if(references.indexOf(reference) == -1){
                references.push(reference);
              }
            }
          }
        })
        var element = new ParserElement();
        element.set({
          schemaName: schemaName,
          name: objectName,
          _type: _type,
          references: references,
          friendlyName: friendlyName,
          data: {}
        })
        collection.add(element);
      })
    }

    var readFile = function(index){    
      if( index >= fileEntries.length ){
        callback(collection);
        return;
      }
      var reader = new FileReader();
      var fileEntry = fileEntries[index];
      reader.onload = function(e) {
        var package = fileEntry.name; 
        var schema = JSON.parse(event.target.result);
        pushElement(package, schema.objects, "Object")
        pushElement(package, schema.mappers, "Mapper")
        pushElement(package, schema.enumerations, "Enumeration")
        pushElement(package, schema.views, "View")

        readFile(index+1);
      }
      if(fileEntry){
        fileEntry.file(function(file){
          reader.readAsText(file);
        });
      }
    }
    readFile(0);
  }

  var X = function (fileList, callback){
    this.callback = callback;
    var that = this;
    readFiles(fileList, function(collection){
      this.collection = collection; // need to remove
      collection.each(function(element){
        var references = element.get('references');
        var refObjs = [];
        if( references != null && references.length > 0){
          _.each(references, function(ref, i){
            var refObj = collection.findWhere( {friendlyName: ref })
            if(refObj != null){
              refObjs.push(refObj)
            } else {
              console.error("Cannot find reference--> "+ref+" --> for "+element.get("name"));
            }
          })
        }
        element.set({references: refObjs});
      });
      window.collection = collection;
      callback(collection);
    })
  }
  return X;
})
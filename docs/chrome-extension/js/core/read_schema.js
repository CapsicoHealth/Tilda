define(["./parser_element", "./custom_object_collection"],
function(ParserElement, Collection){
  var readFiles = function(fileEntries, callback) {
    var that = this;
    var collection = new Collection();
    var pushElement = function(package, elementArr, _type){
      _.each(elementArr, function(value, i){
        var schemaName = package.split(".")[1];
        var objectName = value.name;
        var searchableName = schemaName+"."+value.name.toLowerCase();
        var friendlyName = value.name.toLowerCase();
        // console.error(friendlyName);
        var references = [];
        _.each(value.primaryColumns, function(column, j){
          if(column.sameas != null){
            var sameas = column.sameas.split(".").reverse();
            var reference = sameas[1];
            var schema = sameas[2];
            schema = schema || schemaName;
            if(reference != null){
              reference = reference.toLowerCase();
              reference = schema+"."+reference.toLowerCase();
              if(reference != objectName && references.indexOf(reference) == -1){
                references.push(reference);
              }
            }
          }
        })
        if(_type.toLowerCase() == "view")
        {
          _.each(value.columns, function(column, j){
            if(column.sameas != null){
              var sameas = column.sameas.split(".").reverse();
              var reference = sameas[1];
              var schema = sameas[2];
              schema = schema || schemaName;
              if(reference != null){
                reference = schema+"."+reference.toLowerCase();
                if(references.indexOf(reference) == -1){
                  references.push(reference);
                }
               }
             }
           })
        }
        else
        {
          _.each(value.foreign, function(foreign, j){
            var sameas = foreign.destObject.split(".").reverse();
            var reference = sameas[0];
            var schema = sameas[1];
            schema = schema || schemaName;
            if(reference != null){
              reference = schema+"."+reference.toLowerCase();
              if(references.indexOf(reference) == -1){
                references.push(reference);
              }
            }
          })
          _.each(value.columns, function(column, k)
          {
            if(column.mapper != null && column.mapper.destObject != null)
            {
              var sameas = column.mapper.destObject.split(".").reverse();
              var reference = sameas[0];
              var schema = sameas[1];
              schema = schema || schemaName;
              if(reference != null){
                reference = schema+"."+reference.toLowerCase();
                if(references.indexOf(reference) == -1){
                  references.push(reference);
                }
              }
            }
          });
        }
        var element = new ParserElement();
        element.set({
          schemaName: schemaName,
          searchableName: searchableName,
          name: objectName,
          _type: _type,
          references: references,
          friendlyName: friendlyName,
          inSchema: true,
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
      console.log("Reading -> "+fileEntry.name);
      reader.onload = function(e) {
        var package = fileEntry.name;
        try
        {
          var schema = JSON.parse(event.target.result);
          pushElement(package, schema.objects, "Object")
          pushElement(package, schema.mappers, "Mapper")
          pushElement(package, schema.enumerations, "Enumeration")
          pushElement(package, schema.views, "View")          
        }
        catch(e)
        {
          console.error(e.message);
          console.error(e.stack);
        }
        readFile(index+1);
      }
      if(fileEntry){
        fileEntry.file(function(file)
        {
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
            var refObj = collection.findWhere( {searchableName: ref }, {caseInsensitive: true})
            if(refObj != null){
              refObjs.push(refObj)
            } else {
              var schemaName = ref.split(".")[0];
              var searchableName = ref;
              var objectName = ref.split(".")[1];
              var _type = "Object";
              var friendlyName = objectName.toLowerCase();
              var element = new ParserElement();
              element.set({
                schemaName: schemaName,
                searchableName: searchableName,
                name: objectName,
                _type: _type,
                references: [],
                inSchema: false,
                friendlyName: friendlyName,
                data: {}
              })
              this.collection.add(element);
              refObjs.push(element);
              // console.error("Cannot find reference--> "+ref+" --> for "+element.get("name"));
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
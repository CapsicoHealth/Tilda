define(function(){
  var SCHEMA_REGEX = /\_tilda\.([A-Z][A-Za-z_0-9]+)\.json/i;
  var showFiles = function (firstEntry, runAfterCompletion) {
    var directoryReader = firstEntry.createReader();
    var files= [];
    var objectd = {};
    var counter = 0;
    var readFolder = function (entryPoint, callback) {
      counter++;
      directoryReader = entryPoint.createReader();
      directoryReader.readEntries(function (entries) {
        for (var i = 0; i < entries.length; i++) {
          var entry = entries[i];
          if (entry.isDirectory) {
            if (entry) {
              readFolder(entry, callback);
            }
          } else if (entry.isFile) {
            var fName = entry.name;
            var match = SCHEMA_REGEX.exec(fName);
            if(match){
              entry.getParent(function(e){
                console.log(e);
              }, function(error){
                console.error(error)
              })
              files.push(entry);
            }
          }
        }
        counter--;
        if (counter === 0 && callback) {
          callback(files)
        }
      }, function (error) {
        console.error(error);
      });
    };
    readFolder(firstEntry, runAfterCompletion);
  };

  var FileSearch = function(directoryEntry, callback){
    showFiles(directoryEntry, callback);
  }
  return FileSearch;
})
define(function(){
  var SCHEMA_REGEX = /\_tilda\.([A-Z][A-Za-z_0-9]+)\.json/i;
  var showFiles = function (firstEntry, excluding_regex, runAfterCompletion) {
    var directoryReader = firstEntry.createReader();
    var excluding_regex = excluding_regex;
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
            if(SCHEMA_REGEX.test(fName)){
              if(excluding_regex instanceof RegExp){
                var full_path = entry.fullPath;
                if(!excluding_regex.test(full_path)){
                  files.push(entry);
                }
              } else {
                files.push(entry);
              }
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

  var FileSearch = function(directoryEntry, excluding_regex, callback){
    showFiles(directoryEntry, excluding_regex, callback);
  }
  return FileSearch;
})
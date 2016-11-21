define(function(){
  var SCHEMA_REGEX = /\_tilda\.([A-Z][A-Za-z_0-9]+)\.json/i;
  var showFiles = function (firstEntry, excluding_regex, runAfterCompletion) {
    var directoryReader = firstEntry.createReader();
//    var excluding_regex = excluding_regex;
    var files= [];
    var objectd = {};
    var counter = 0;
    var readFolder = function (entryPoint, callback) {
      counter++;
      directoryReader = entryPoint.createReader();
      directoryReader.readEntries(function (entries) {
        for (var i = 0; i < entries.length; i++) {
          var entry = entries[i];
//          console.log("entry: ", entry.name);
          if (entry.isDirectory) {
            if (entry) {
              readFolder(entry, callback);
            }
          } else if (entry.isFile) {
            var fName = entry.name;
//            console.log("fName: ", fName);
            if(SCHEMA_REGEX.test(fName)){
              if(excluding_regex instanceof RegExp){
                var full_path = entry.fullPath;
//                console.log("full_path: ", full_path);
                if(!excluding_regex.test(full_path)){
//                  console.log("Not being excluded, so adding it!")
                  files.push(entry);
                }
                else {
//                  console.log("Being excluded, so NOT adding it!")
                }
              } else {
//                console.error("Exclusion was not a REGEX, so adding it!")
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
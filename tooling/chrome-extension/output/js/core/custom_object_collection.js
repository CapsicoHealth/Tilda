define(["lodash", "jquery"], function(_, $){

  var ObjectCollection = Backbone.Collection.extend({
    where: function(attrs, first, options){
      options = options || {};

      if (_.isEmpty(attrs)) return first ? void 0 : [];

      return this[first ? 'find' : 'filter'](function(model) {
        for (var key in attrs) {
          if (options.caseInsensitive) {
            if (attrs[key].toLowerCase() !== model.get(key).toLowerCase()) return false;
          } else {
            if (attrs[key] !== model.get(key)) return false;
          }
        }

        return true;
      });
    },

    findWhere: function(attrs, options) {
      return this.where(attrs, true, options);
    },

    getAll: function() {
      return this['filter'](function(model) {
        return true;
      })
    },

    searchableName: function(text_arr, selectedName=null) {
      if (text_arr == null || text_arr.length < 1)
        return this.getAll();

      if(typeof(selectedName) == "string")
        selectedName = selectedName.toLowerCase();
      regexStr = text_arr.join("|");

      return this['filter'](function(model) {
        let references = model.get("references")
        let ref_names = references.map(item => item.get("searchableName").toLowerCase());

        return (
          model.get("searchableName").match(new RegExp(regexStr, "i"))
          || ref_names.includes(selectedName)
          )
      })
    }
  })
  return ObjectCollection;
})
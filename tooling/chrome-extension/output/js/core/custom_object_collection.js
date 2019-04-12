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

    searchName: function(searchText) {
      if (searchText == null || searchText.length < 1)
        return this.getAll();

      return this['filter'](function(model) {
        return (
            model.get("name").match(new RegExp(searchText, "i"))
            || model.get("schemaName").match(new RegExp(searchText, "i"))
          )
      })
    }
  })
  return ObjectCollection;
})
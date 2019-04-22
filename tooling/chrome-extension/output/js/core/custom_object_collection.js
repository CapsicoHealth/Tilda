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

    searchByEntity: function(selectedEntity, selectedReferences, searchText) {
      selectedEntity      = selectedEntity.toLowerCase();
      selectedReferences  = selectedReferences.map(item => item.toLowerCase());

      return this['filter'](function(model) {
        let references = model.get("references")
        let ref_names = references.map(item => item.get("searchableName").toLowerCase());

        result = (model.get("searchableName").match(new RegExp(searchText, "i"))
                  && (selectedReferences.includes(model.get("searchableName").toLowerCase())
                      || ref_names.includes(selectedEntity))
                  )

        return result;
      })

    },

    searchByName: function(searchText) {
      if (searchText == null || searchText.length < 1)
        return this.getAll();

      return this['filter'](function(model) {
        return model.get("searchableName").match(new RegExp(searchText, "i"))
      })
    }
  })
  return ObjectCollection;
})
window.addEventListener('load', function(){
  requirejs.config({
    baseUrl: 'js',
    paths: {
      async: 'lib/require/async',
      font: 'lib/require/font',
      goog: 'lib/require/goog',
      image: 'lib/require/image',
      json: 'lib/require/json',
      noext: 'lib/require/noext',
      mdown: 'lib/require/mdown',
      propertyParser : 'lib/require/propertyParser',
      markdownConverter : 'lib/Markdown.Converter',
      text: 'lib/require/text',
      jquery: 'lib/jquery',
      lodash: 'lib/lodash',
      backbone: 'lib/backbone',
      jointjs: 'lib/joint',
      graphlib: 'lib/graphlib.core'
    },
    map: {
      '*': {
        // Backbone requires underscore. This forces requireJS to load lodash instead:
        'underscore': 'lodash',
        '../lodash' : 'lodash'
      }
    }

  });

  require(['boot'], function(boot){
    boot();
  });
});
var config, cordovaServer, path;

path = require('path');
var fs    = require('fs');

config = function(grunt) {
  grunt_config = {
    copy: {
      css: {
        files: [
          {
            expand: true,
            flatten: true,
            cwd: 'bower_components',
            src: ['jointjs/dist/joint.css'],
            dest: 'output/css/lib'
          },
          {
            expand: true,
            flatten: true,
            cwd: 'bower_components',
            src: ['bootstrap/dist/css/bootstrap.css'],
            dest: 'output/css/lib'
          }
        ]
      },
      js: {
        files: [
          {
            expand: true,
            flatten: true,
            cwd: 'bower_components',
            src: ['requirejs/require.js', 'underscore/underscore.js', 'lodash/lodash.js',
             'jointjs/dist/joint.js', 'backbone/backbone.js', 'jquery/dist/jquery.js', 'graphlib/dist/graphlib.core.js', 'strip-json-comments/index.js'],
            dest: 'output/js/lib'
          },
          {
            expand: true,
            flatten: true,
            cwd: 'bower_components',
            src: ['strip-json-comments/index.js'],
            dest: 'output/js/lib',
            rename: function(dest, src) {
                return dest+'/strip-json-comments.original.js';
            }
          },
          {
            expand: true,
            flatten: true,
            cwd: 'bower_components',
            src: ['requirejs-plugins/src/*.js'],
            dest: 'output/js/lib/require'
          },
          {
            expand: true,
            flatten: true,
            cwd: 'bower_components',
            src: ['requirejs-plugins/lib/text.js', 'requirejs-plugins/lib/Markdown.Converter.js'],
            dest: 'output/js/lib/require'
          },
          {
            expand: true,
            flatten: true,
            cwd: 'bower_components',
            src: ['bootstrap/dist/js/bootstrap.js'],
            dest: 'output/js/lib'
          }
        ]
      },
    }
  }
  return grunt_config;
};

module.exports = function(grunt) {
  grunt.initConfig(config(grunt));
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.registerTask('default', ['copy']);
};
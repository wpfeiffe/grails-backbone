var App = {};

require.config({
    baseUrl: '/grails-backbone/js',
    paths: {
        jquery: 'jquery/jquery-1.8.3',
        underscore: 'underscore',
        backbone: 'backbone',
        text: 'text',
        jqdate: 'jquery.dateFormat-1.0'
    },
    shim: {
        jquery: {
            exports: "$"
        },
        underscore: {
            exports: "_"
        },
        backbone: {
            deps: ["underscore", "jquery"],
            exports: "Backbone"
        },
        jqdate: {
            deps: ["jquery"]
        }
    }
});

require(['backbook'], function (Backbook) {
    App.backbook = new Backbook();
    console.info("Hello main.js");
});
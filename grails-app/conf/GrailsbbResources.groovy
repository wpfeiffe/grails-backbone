modules = {
    backbook {
        dependsOn 'grailsbb', 'jqueryDateFormat'
        resource url: '/js/backbook.js'
    }
    grailsbb {
        dependsOn 'jquery, underscore, backbone'

    }
    backbone {
        resource url: '/js/backbone.js'
    }
    underscore {
        resource url: '/js/underscore.js'
    }
    jqueryDateFormat {
        resource url: '/js/jquery.dateFormat-1.0.js'
    }
    requirejs {
        resource url: '/js/require.js'
    }
    requiretext {
        resource url: 'js/text.js'
        dependsOn 'requirejs'
    }
}
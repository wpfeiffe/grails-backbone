class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')

        "/booksapi" (controller: 'booksapi') {
            action = [ GET: 'list', POST: 'create' ]
        }

        "/booksapi/$id" (controller: 'booksapi') {
            action = [ GET: 'show', PUT: 'update', DELETE: 'delete' ]
        }


	}
}

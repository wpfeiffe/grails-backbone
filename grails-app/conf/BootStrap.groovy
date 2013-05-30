import grails.converters.JSON
import org.arbfile.json.BookMarshaller

class BootStrap
{

    def init = { servletContext ->
        JSON.registerObjectMarshaller(Date) {
            return it?.format("dd-MM-yyyy")
        }

        new BookMarshaller().register()
    }
    def destroy = {
    }
}

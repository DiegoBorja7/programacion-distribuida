package ec.edu.uce.programaciondistribuida.autors.web03;

import io.helidon.config.Config;
import io.helidon.dbclient.DbClient;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import jakarta.json.Json;
import jakarta.json.JsonBuilderFactory;

import java.util.Map;

public class Web03Main {
    private static DbClient dbClient;
    static JsonBuilderFactory factory = Json.createBuilderFactory(Map.of());

    public static void handleBook(ServerRequest request, ServerResponse response) {
        var books = dbClient.execute()
                .createQuery("SELECT * FROM books")
                .execute()
                .map(result -> Book.builder()
                        .title(result.column("title").getString())
                        .isbn(result.column("isbn").getString())
                        .build())
                .toList();

        books.forEach(System.out::println);

        //JSONP
//        JsonObject book = factory.createObjectBuilder()
//                .add("title", "el quijote")
//                .add("isbn", "123456789")
//                .build();
//        response.send(book);
//
//        //JSONB APLICAR ESTA OPCION ES MAS FACIL
//        var book2 = Book.builder()
//                .title("el quijote")
//                .isbn("123456789")
//                .build();

        response.send(books);
    }

    public static void main(String[] args){
        Config config = Config.create();

        var confifDb = config.get("db");
        var configHttp = config.get("server");

        dbClient = DbClient.builder()
                .config(confifDb)
                .build();

        WebServer.builder()
                .config(configHttp)
                .routing(it -> it
                .get("/book", Web03Main::handleBook)
                .post("/book", Web03Main::handleBook))
                .build()
                .start();
    }
}

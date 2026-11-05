package ec.edu.uce.programaciondistribuida.web02;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.Set;

@ApplicationPath("/api")
public class MyApplicationRest extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(
                HelloRest.class
        );
    }
}

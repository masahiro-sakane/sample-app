package sample;

import java.util.Optional;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;

@ApplicationScoped
@Path("hello")
public class HelloResource {

    // Config config = ConfigProvider.getConfig();

    @Inject
    @ConfigProperty(name = "CONFIG_VAL", defaultValue = "Hello")
    private String confString;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        // String str = config.getValue("CONFIG_VAL", String.class);
        // return str != null ? str : "Hello";
        // Optional<String> str = config.getOptionalValue("CONFIG_VAL", String.class);
        // return str.orElse("Hello");
        return confString;
    }
}

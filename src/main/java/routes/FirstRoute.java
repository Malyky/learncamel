package routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;

public class FirstRoute extends EndpointRouteBuilder {
    @Override
    public void configure() throws Exception {
        from(timer("foo?period=10000"))
                .log("test")
                .process(p-> p.getAllProperties())
                ;
    }
}

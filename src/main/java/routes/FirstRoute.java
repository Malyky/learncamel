package routes;

import io.agroal.api.AgroalDataSource;
import io.agroal.api.configuration.AgroalDataSourceConfiguration;
import io.quarkus.agroal.DataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.jms.ConnectionFactory;
import lombok.Getter;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;

@ApplicationScoped
@Getter
public class FirstRoute extends EndpointRouteBuilder {

    @Inject
    @DataSource("BAMBI")
    private AgroalDataSource dataSource;

    @Inject
    ConnectionFactory connectionFactory;
    @Override
    public void configure() throws Exception {

        from(timer("foo?period=10000"))
                .log("test")
                .process(this::getDataSource2)
                .process(p-> p.getAllProperties())
                ;
    }

    public void getDataSource2(Exchange exchange) {
        getDataSource();
    }
}

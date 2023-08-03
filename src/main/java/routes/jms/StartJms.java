package routes.jms;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.jms.ConnectionFactory;
import org.apache.activemq.artemis.core.server.embedded.EmbeddedActiveMQ;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

@ApplicationScoped
public class StartJms {

    @Produces
    ConnectionFactory produce() throws Exception {
        EmbeddedActiveMQ embedded = new EmbeddedActiveMQ();
        embedded.start();
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
                "tcp://localhost:61616",
                "admin",
                "admin");
        return activeMQConnectionFactory;
    }
}

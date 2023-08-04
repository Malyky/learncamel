For Qpid
docker run -it --rm -p 8161:8161 -p 61616:61616 -p 5672:5672 -e AMQ_USER=quarkus -e AMQ_PASSWORD=quarkus quay.io/artemiscloud/activemq-artemis-broker:0.1.4

For Artemis
docker run -e AMQ_USER=admin -e AMQ_PASSWORD=admin -p80:8161 -p61616:61616 --name artemis quay.io/artemiscloud/activemq-artemis-broker:dev.latest 
dann http://localhost/console für login
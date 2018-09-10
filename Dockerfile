FROM loooloooki/jre9:latest

MAINTAINER loki

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "gd-map.jar"]

ADD build/libs/gd-map-*.jar gd-map.jar

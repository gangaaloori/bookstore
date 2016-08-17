FROM java:8
MAINTAINER Ganga Aloori <ganga.aloori@capgemini.com>

ADD bookstore-1.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
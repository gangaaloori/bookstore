FROM java:8

MAINTAINER Ganga Aloori <ganga.aloori@capgemini.com>

ADD bookstore-*.jar bookstore.jar

RUN bash -c 'touch /bookstore.jar'

EXPOSE 9000

ENTRYPOINT ["java", "-jar", "bookstore.jar"]
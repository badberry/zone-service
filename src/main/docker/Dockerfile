FROM registry.dev/java8

RUN  mkdir /data/

ADD zone-service-0.0.1-SNAPSHOT.jar /data/app.jar

RUN mkdir /var/logs/zone/ -p

VOLUME /var/logs/

EXPOSE 8080

ENV host 127.0.0.1

ENV port 8080

WORKDIR /data/

CMD ["java","-Xmx512m","-Duser.timezone=GMT+8","-jar","app.jar"]
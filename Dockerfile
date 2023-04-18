FROM openjdk:17
COPY "./target/ExchangeCurrency-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 3030
ENTRYPOINT ["java","-jar","app.jar"]
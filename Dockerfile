FROM openjdk:17
EXPOSE 8080
ADD target/orders-api.jar orders-api.jar
ENTRYPOINT [ "java","-jar","/orders-api.jar" ]
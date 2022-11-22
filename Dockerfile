FROM amazoncorretto:18-alpine-jdk
MAINTAINER clbokea@kea.dk
COPY out/artifacts/jar_cookie_jar/jar_cookie.jar server.jar
ENTRYPOINT ["java","-jar","/server.jar"]
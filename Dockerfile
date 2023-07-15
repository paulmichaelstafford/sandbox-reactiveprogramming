#FROM openjdk:17-alpine
#VOLUME /tmp
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.oghamstone.sandbox.sandboxreactiveprogramming"]



#FROM openjdk:17-alpine
#VOLUME /tmp
#ARG JAR_FILE=build/libs/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.oghamstone.sandbox.sandboxreactiveprogramming.SandboxReactiveProgrammingApplication"]



FROM openjdk:17-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
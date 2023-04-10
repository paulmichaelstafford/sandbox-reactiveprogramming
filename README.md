Sandbox to test te performance of reactive programming compared to synchronous programming

Requirements:

java 17
gradle 7.6.1
Docker 23.0.3
docker-compose
jmeter 5.5


Commands to run:

docker-compose up -d
gradle build
docker build --build-arg JAR_FILE=build/libs/*.jar -t sandboxreactiveprogramming/sandbox-reactiveprogramming .
docker run -p 8080:8080 sandboxreactiveprogramming/sandbox-reactiveprogramming


Run performance test:

Load jemeterLoadTEx.jmx into jmeter and run
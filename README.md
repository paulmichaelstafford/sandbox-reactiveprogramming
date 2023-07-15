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
docker build --build-arg JAR_FILE=build/libs/*.jar -t sandboxreactiveprogramming/sandboxreactiveprogramming .
docker run -p 8080:8080 sandboxreactiveprogramming/sandboxreactiveprogramming


Run performance test:

Load jemeterLoadTEx.jmx into jmeter and run



mongo -udevs -ppassword --port 46453 --authenticationDatabase admin
show dbs
use cache_master_db
show collection
db.collectionName.find()
db.dropDatabase()
#!/bin/bash

VERSION=$(gradle -q printVersion)

print "******** building ********"
gradle clean build

print "******** updating helm chart ********"
cd kubernetes/sandboxreactiveprogramming
sed 's/UPDATE_WITH_POM_VERSION/'$VERSION'/g' values_template.yaml > values.yaml
cd ../../


print "******** building docker artifact ********"
docker build --build-arg JAR_FILE=build/libs/*.jar -t localhost:32000/com/oghamstone/sandbox/sandboxreactiveprogramming:$VERSION .

print "******** pushing docker artifact ********"
docker push localhost:32000/com/oghamstone/sandbox/sandboxreactiveprogramming:$VERSION

cd kubernetes

print "******** upgrading ********"
helm upgrade --install  sandboxreactiveprogramming  ./sandboxreactiveprogramming -n default



#helm uninstall  sandboxreactiveprogramming  -n default
#docker run -dp 127.0.0.1:8080:8080 localhost:32000/com/oghamstone/sandbox/sandboxreactiveprogramming:$VERSION
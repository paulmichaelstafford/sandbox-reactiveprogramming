#!/bin/bash

VERSION=$(gradle -q printVersion)

print "******** building ********"
gradle clean build

print "******** updating helm chart ********"
cd kubernetes/sandbox-reactiveprogramming
sed 's/UPDATE_WITH_POM_VERSION/'$VERSION'/g' values_template.yaml > values.yaml
cd ../../


print "******** building docker artifact ********"
docker build --build-arg JAR_FILE=build/libs/*.jar -t localhost:32000/com/oghamstone/sandbox/sandbox-reactiveprogramming:$VERSION .

print "******** pushing docker artifact ********"
docker push localhost:32000/com/oghamstone/sandbox/sandbox-reactiveprogramming:$VERSION

cd kubernetes

print "******** upgrading ********"
helm upgrade --install  sandbox-reactiveprogramming  ./sandbox-reactiveprogramming -n default



#helm uninstall  sandbox-reactiveprogramming  -n default
#docker run -dp 127.0.0.1:8080:8080 localhost:32000/com/oghamstone/sandbox/sandbox-reactiveprogramming:$VERSION
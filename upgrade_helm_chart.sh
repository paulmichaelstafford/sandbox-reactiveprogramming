#!/bin/bash

VERSION=$(gradle -q printVersion)

printf $VERSION

#mvn clean package -DskipTests=true
#docker  build -t localhost:32000/com/oghamstone/bff:$VERSION .
#docker push localhost:32000/com/oghamstone/bff:$VERSION
#
#
#cd ./kubernetes/
#
#./upgrade.sh bff $VERSION master oghamstone-master

#!/bin/bash

VERSION=$(gradle -q printVersion)

gradle build assemble
./gradlew bootBuildImage --imageName=localhost:30332/com/oghamstone/sandbox/sandboxreactiveprogramming:$VERSION
#docker  build -t localhost:30332/com/oghamstone/sandbox/sandboxreactiveprogrammin/reactiveprogramming:$VERSION .
#docker push localhost:30332/com/oghamstone/sandbox/sandboxreactiveprogrammin/reactiveprogramming:$VERSION .
#com.oghamstone.sandbox.sandboxreactiveprogrammin
#
#cd ./kubernetes/
#
#./upgrade.sh bff $VERSION master oghamstone-master


helm upgrade --install  sandboxreactiveprogramming com/oghamstone/sandbox/sandboxreactiveprogramming -n default
#!/bin/bash


source ../header_uninstall.sh



helm uninstall $serviceKubernetesFolderName  -n $serviceNamespace


#helm uninstall mongodb  -n oghamstone-develop

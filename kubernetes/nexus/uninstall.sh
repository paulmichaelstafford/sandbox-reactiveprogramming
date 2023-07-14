#!/bin/bash

source ../header_uninstall.sh

helm uninstall $serviceKubernetesFolderName  -n $serviceNamespace

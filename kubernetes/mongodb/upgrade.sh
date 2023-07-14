#!/bin/bash

source ../header_upgrade.sh
#https://artifacthub.io/packages/helm/bitnami/mongodb
helm repo add bitnami https://charts.bitnami.com/bitnami
helm repo update
helm upgrade --install $serviceKubernetesFolderName bitnami/mongodb  --wait --timeout $timeout -f ./values_$ENV.yaml --version $serviceVersion -n $serviceNamespace


#helm install mongodb bitnami/mongodb --version 13.6.0 --wait --timeout 1200s -f ./values_develop.yaml  -n oghamstone-develop
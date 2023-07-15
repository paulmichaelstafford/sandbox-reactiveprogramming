#!/bin/bash

#https://artifacthub.io/packages/helm/bitnami/mongodb
helm repo add bitnami https://charts.bitnami.com/bitnami
helm repo update
helm upgrade --install mongodb bitnami/mongodb  --wait -f ./values.yaml --version '13.6.0' -n default

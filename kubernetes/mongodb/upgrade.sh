#!/bin/bash

helm repo add bitnami https://charts.bitnami.com/bitnami
helm repo update
helm upgrade --install mongodb bitnami/mongodb  --wait -f ./values.yaml --version '13.6.0' -n default

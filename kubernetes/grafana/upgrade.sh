#!/bin/bash

helm repo add grafana https://grafana.github.io/helm-charts
helm repo update
helm upgrade --install grafana grafana/grafana --wait -f ./values.yaml --version 6.26.2 -n default






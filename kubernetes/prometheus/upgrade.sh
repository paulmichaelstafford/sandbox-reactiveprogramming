#!/bin/bash

helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo update
helm install prometheus prometheus-community/prometheus --version '15.8.1' -n default --set-file extraScrapeConfigs=extraScrapeConfigs.yaml







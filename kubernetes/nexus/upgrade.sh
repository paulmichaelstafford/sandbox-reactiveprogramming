#!/bin/bash

#https://artifacthub.io/packages/helm/sonatype/nexus-repository-manager/

helm repo add sonatype https://sonatype.github.io/helm3-charts/
helm repo update
helm install nexus sonatype/nexus-repository-manager --version v36.0.0 --wait --timeout 1200s -f ./values.yaml -n default
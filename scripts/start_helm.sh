#!/bin/bash
cd ../helm

# echo "Uninstalling..."
# helm uninstall kfje-application
# sleep 30s

echo "Applying namespace"
kubectl apply -f namespace.yml

echo "Starting services"
helm install kfje-application . --create-namespace
# helm install kfje-application . --set user-service.replicaCount=3 --set post-service.replicaCount=1

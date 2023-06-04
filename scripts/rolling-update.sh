#!/bin/bash
echo "Performing rolling update for Post Service"
cd ../k8s/service/post-service || exit
kubectl apply -f deployment.yml

sleep 10s
echo "Service updates!"
kubectl get pods -n kfje-namespace

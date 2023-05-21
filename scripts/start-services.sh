#!/bin/bash
function runResource() {
  FOLDER=$1
  NAME=$2
  CURRENT=$(pwd)

  cd $FOLDER

  echo "Starting $NAME"
  kubectl apply -f .
  sleep 3s
  echo

  cd $CURRENT
}

cd ../k8s

echo "Starting services"
runResource service/post-service post-service
runResource service/user-service user-service

kubectl get pods
sleep 10s

echo "All services started!"

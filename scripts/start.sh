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

echo "Applying namespace"
kubectl apply -f namespace.yml

echo "Starting databases"
runResource database/post-database post-database
runResource database/user-database user-database

sleep 10s
echo "Databases started!"

echo "Starting services"
runResource service/post-service post-service
runResource service/user-service user-service

sleep 10s
echo "Services started!"
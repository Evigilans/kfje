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

echo "Starting shared items"
runResource security/ security
kubectl get persistentvolume
kubectl get persistentvolumeclaim

echo "Starting database"
runResource bootstrap/database database

echo "Starting bootstrap items"
kubectl get pods
sleep 10s

echo "All services started!"

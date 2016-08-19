#!/usr/bin/env bash

docker-compose stop
docker-compose rm --all -f
cd ../../../
mvn clean package docker:build
cd src/main/docker
docker-compose up -d
docker-compose logs
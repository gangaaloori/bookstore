#!/usr/bin/env bash

# Stop and remove all the containers.
docker stop $(docker ps -aq)
docker rm $(docker ps -aq)

# Remove unwanted ‘dangling’ images.
docker rmi $(docker images -f "dangling=true" -q)

# Remove unwanted volumes
docker volume rm $(docker volume ls -qf dangling=true)

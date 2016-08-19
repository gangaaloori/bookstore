#!/usr/bin/env bash

# Don't execute this, these are the commands that have been executed in the tutorial, just as resource.
# To run the application use Docker compose.
docker run -d --name db -e MYSQL_ROOT_PASSWORD=pass123 -e MYSQL_DATABASE=bookstore -e MYSQL_USER=demo -e MYSQL_PASSWORD=demo mysql:latest
docker run -d --name web --link db:db -p 9000:9000 gangaaloori/bookstore

# Create a docker machine with proxy settings
docker-machine create -d virtualbox --engine-env HTTP_PROXY=http://galoori:galoori@10.74.242.2:3127 --engine-env HTTPS_PROXY=http://galoori:galoori@10.74.242.2:3127 default
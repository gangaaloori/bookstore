#!/usr/bin/env bash

docker-machine ssh default

# we need root access:
sudo -s

# now configure the proxy
echo "export HTTP_PROXY=http://xx:galoori@10.74.242.2:3127" >> /var/lib/boot2docker/profile
echo "export HTTPS_PROXY=http://galoori:galoori@10.74.242.2:3127" >> /var/lib/boot2docker/profile

# for verification
cat /var/lib/boot2docker/profile

# exit out of ssh session
exit
exit

# restart
docker-machine restart default
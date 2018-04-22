#!/bin/bash

DEMO_PATH=`pwd`

docker run -itd \
        --net=storm \
        -v $DEMO_PATH:/usr/src/app \
        -p 8080:8080 \
        --name storm-example \
        --hostname storm-example \
        ubuntu:17.10 &> /dev/null

docker exec -it storm-example /bin/bash

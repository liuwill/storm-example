#!/bin/bash

cd /root
source /etc/profile

if [ ! -n "$APP_HOME" ]; then
  export APP_HOME=/usr/src/app
  source $APP_HOME/script/init.sh

  echo "set env config"
fi

if [ ! -f "/tmp/VERSION" ]; then
    cp $APP_HOME/config/* /tmp/
    cp $APP_HOME/binary/* /tmp/

    echo "COPY FILES"
fi

export STORM_HOME=/usr/local/storm

if [ ! -d "$STORM_HOME" ]; then
    cp /tmp/apache-storm-1.2.1.tar.gz ./apache-storm-1.2.1.tar.gz
    tar -xzvf apache-storm-1.2.1.tar.gz && \
        mv apache-storm-1.2.1 /usr/local/storm\ && \
        rm apache-storm-1.2.1.tar.g
    echo "unpack storm done"
else
    echo "storm has been installed"
fi

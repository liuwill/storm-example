#!/bin/bash
if [ -z "$(command grep -r HADOOP_HOME /etc/profile)" ]
then
    cat /usr/src/app/.env >> /etc/profile

    echo "env has been add to profile"
fi

if [ ! -n "$APP_HOME" ]
then
    source /etc/profile
    echo "env set success"
fi

echo "set env job done"

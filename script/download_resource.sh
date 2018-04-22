#!/usr/bin/env bash

DEMO_PATH=`pwd`

if [ ! -d "$DEMO_PATH/binary" ];then
    mkdir "$DEMO_PATH/binary"
    echo "mkdir $DEMO_PATH/binary"
fi

cd "$DEMO_PATH/binary"

binaries=(
http://mirrors.hust.edu.cn/apache/storm/apache-storm-1.2.1/apache-storm-1.2.1.tar.gz
)
#https://www.apache.org/dyn/closer.lua/storm/apache-storm-1.2.1/apache-storm-1.2.1.tar.gz

if [ ! -n `which wget` ];then
    echo "please install wget first"
    exit0
fi

length=${#binaries[@]}
echo "there are ${length} files will be downloaded"

for url in ${binaries[@]}; do
    filename=${url##*/}
    if [ ! -f "${filename}" ]; then
        echo "downloading... $filename"
        wget "$url"
    else
        echo "file $filename exists"
    fi
done

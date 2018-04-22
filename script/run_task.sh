#!/bin/bash

export APP_HOME=/usr/src/app

export STORM_HOME=/usr/local/storm

$STORM_HOME/bin/storm jar $APP_HOME/build/libs/storm-example-build.jar com.liuwill.data.OrderSkuTopology

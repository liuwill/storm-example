#!/bin/bash

export APP_HOME=/usr/src/app
export STORM_HOME=/usr/local/storm

$STORM_HOME/bin/storm nimbus >> logs/nimbus.out 2>&1 &

$STORM_HOME/bin/storm ui>> logs/ui.out 2>&1 &
$STORM_HOME/bin/storm supervisor >> logs/supervisor.out 2>&1 &

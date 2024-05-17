#!/bin/sh
rfkill block all
sleep 1
rfkill unblock all
sleep 1
hciattach -n -s 115200 /dev/ttyS9 bcm43xx 1500000 &


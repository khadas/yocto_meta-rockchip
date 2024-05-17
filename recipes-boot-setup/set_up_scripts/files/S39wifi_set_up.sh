#!/bin/sh

MODULE=/lib/modules/bcmdhd_pcie.ko

if [ -e ${MODULE} ]; then
	insmod ${MODULE}
else
	echo "Can not find ${MODULE}"
fi

CONF=/etc/wpa_supplicant.conf

killall wpa_supplicant

sleep 1

wpa_supplicant -B -i wlan0 -c $CONF

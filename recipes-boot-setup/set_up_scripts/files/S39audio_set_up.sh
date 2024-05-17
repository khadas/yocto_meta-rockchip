#!/bin/sh

amixer -c 3 cset numid=28,iface=MIXER,name='ALC Capture Switch' on 1> /dev/null

amixer -c 3 cset numid=35,iface=MIXER,name='ALC Capture Noise Gate Switch' 1 1> /dev/null

amixer -c 3 cset numid=15,iface=MIXER,name='DAC Playback Volume' 192 1> /dev/null

amixer -c 3 cset numid=13,iface=MIXER,name='Headphone Mixer Volume' 11 1> /dev/null

amixer -c 3 cset numid=44,iface=MIXER,name='Left Headphone Mixer Left DAC Switch' on 1> /dev/null

amixer -c 3 cset numid=46,iface=MIXER,name='Right Headphone Mixer Right DAC Switch' on 1> /dev/null

amixer -c 3 cset numid=45,iface=MIXER,name='Right Headphone Mixer RLIN Switch' on 1> /dev/null

amixer -c 3 cset numid=18,iface=MIXER,name='DAC Notch Filter Switch' 1 1> /dev/null

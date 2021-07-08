#!/bin/bash

# ONLY TESTED ON UBUNTU 16.04
# REQUIRES SPOTIFY INSTALLED

spot_song=$(qdbus org.mpris.MediaPlayer2.spotify /org/mpris/MediaPlayer2 org.mpris.MediaPlayer2.Player.Metadata);
echo $(echo $spot_song | sed -ne 's/xesam:artist: \(.*\)$/\1/p') "-" $(echo $spot_song | sed -ne 's/xesam:title: \(.*\)$/\1/p')

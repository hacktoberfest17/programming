# httpracer [![Build Status](https://travis-ci.org/imwally/httpracer.svg?branch=master)](https://travis-ci.org/imwally/httpracer)

Time HTTP connections. Particularly useful when trying to find the fastest mirror.

## Example

```
wally@ok (~/Code/go/src/github.com/imwally/httpracer) ./httpracer $(cat mirrors.txt | tr '\n' ' ')
63.510697ms:    200     http://ftp4.usa.openbsd.org/pub/OpenBSD/
68.526813ms:    200     http://mirrors.evowise.com/pub/OpenBSD/
70.881849ms:    200     http://openbsd.delfic.org/pub/OpenBSD/
74.264556ms:    200     http://mirror.jmu.edu/pub/OpenBSD/
74.778178ms:    200     http://mirrors.mit.edu/pub/OpenBSD/
79.148467ms:    200     http://openbsd.mirrors.pair.com/
86.410349ms:    200     http://ftp5.usa.openbsd.org/pub/OpenBSD/
104.2236ms:     200     http://mirrors.gigenet.com/pub/OpenBSD/
111.458794ms:   200     http://openbsd.cs.toronto.edu/pub/OpenBSD/
123.708748ms:   200     http://mirror.esc7.net/pub/OpenBSD/
181.950913ms:   200     http://ftp3.usa.openbsd.org/pub/OpenBSD/
194.588757ms:   200     http://ftp.OpenBSD.org/pub/OpenBSD/
196.863748ms:   200     http://mirrors.ucr.ac.cr/OpenBSD/
198.644475ms:   200     http://ftp.fr.openbsd.org/pub/OpenBSD/
197.047141ms:   200     http://mirrors.sonic.net/pub/OpenBSD/
209.168894ms:   200     http://mirrors.ircam.fr/pub/OpenBSD/
212.598711ms:   200     http://mirror.bytemark.co.uk/pub/OpenBSD/
213.750406ms:   200     http://mirror.exonetric.net/pub/OpenBSD/
217.345398ms:   200     http://mirrors.dalenys.com/pub/OpenBSD/
220.383545ms:   200     http://mirror.ox.ac.uk/pub/OpenBSD/
221.159091ms:   200     http://www.mirrorservice.org/pub/OpenBSD/
234.565019ms:   200     http://mirror.meerval.net/pub/OpenBSD/
233.198461ms:   200     http://ftp2.fr.openbsd.org/pub/OpenBSD/
234.360026ms:   200     http://ftp.hostserver.de/pub/OpenBSD/
232.203513ms:   200     http://openbsd.mirrors.hoobly.com/
236.363831ms:   200     http://mirrors.syringanetworks.net/pub/OpenBSD/
238.617308ms:   200     http://anorien.csc.warwick.ac.uk/pub/OpenBSD/
243.056682ms:   200     http://ftp.bit.nl/pub/OpenBSD/
241.371041ms:   200     http://artfiles.org/openbsd/
245.816284ms:   200     http://mirrors.dotsrc.org/pub/OpenBSD/
247.549822ms:   200     http://ftp.spline.de/pub/OpenBSD/
249.261048ms:   200     http://mirror.one.com/pub/OpenBSD/
249.977511ms:   200     http://ftp.halifax.rwth-aachen.de/openbsd/
256.354888ms:   200     http://ftp.bytemine.net/pub/OpenBSD/
258.437674ms:   200     http://ftp2.eu.openbsd.org/pub/OpenBSD/
259.86084ms:    200     http://ftp.nluug.nl/pub/OpenBSD/
261.19531ms:    200     http://www.obsd.si/pub/OpenBSD/
261.988607ms:   200     http://ftp.heanet.ie/pub/OpenBSD/
280.537564ms:   200     http://openbsd.mirror.garr.it/pub/OpenBSD/
285.312924ms:   200     http://ftp.icm.edu.pl/pub/OpenBSD/
285.752305ms:   200     http://ftp.fsn.hu/pub/OpenBSD/
286.759304ms:   200     http://mirror.yandex.ru/pub/OpenBSD/
294.780859ms:   200     http://mirrors.unb.br/pub/OpenBSD/
299.026039ms:   200     http://mirror.litnet.lt/pub/OpenBSD/
298.227028ms:   200     http://ftp.aso.ee/pub/OpenBSD/
302.004234ms:   200     http://openbsd.ipacct.com/pub/OpenBSD/
301.919692ms:   200     http://mirrors.pidginhost.com/pub/OpenBSD/
326.290046ms:   200     http://ftp.cc.uoc.gr/mirrors/OpenBSD/
329.970489ms:   200     http://mirror.eject.name/pub/OpenBSD/
346.605586ms:   200     http://openbsd.c3sl.ufpr.br/pub/OpenBSD/
346.584556ms:   200     http://mirror.switch.ch/ftp/pub/OpenBSD/
348.96424ms:    200     http://ftp.eu.openbsd.org/pub/OpenBSD/
380.309406ms:   200     http://www.ftp.ne.jp/OpenBSD/
408.530761ms:   200     http://ftp.jaist.ac.jp/pub/OpenBSD/
470.651543ms:   200     http://ftp.yzu.edu.tw/pub/OpenBSD/
477.399856ms:   200     http://openbsd.hk/pub/OpenBSD/
499.733642ms:   200     http://mirror.internode.on.net/pub/OpenBSD/
499.362036ms:   200     http://piotrkosoft.net/pub/OpenBSD/
533.6638ms:     200     http://mirror.aarnet.edu.au/pub/OpenBSD/
551.998326ms:   200     http://mirror.rise.ph/pub/OpenBSD/
588.49434ms:    200     http://kartolo.sby.datautama.net.id/pub/OpenBSD/
```

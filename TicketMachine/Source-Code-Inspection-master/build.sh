#!/bin/bash

_PWD=`pwd`
CopyLibs=$_PWD/lib/org-netbeans-modules-java-j2seproject-copylibstask.jar

CLASSPATH=$CLASSPATH:$CopyLibs:
export CLASSPATH
echo "CLASSPATH:"$CLASSPATH

echo " "
echo "Compiling these projects:"
for i in * ; do
  if [ -d "$i" ] && [ ! "$i" = "lib" ] && [ ! "$i" = "glassfish3" ]; then
    cd "$i"

    if [ -f "manifest.mf" ]; then
        TARGET=jar
    else
        TARGET=dist
    fi
    TARGET=""

    echo " "
    echo "----- $i -----"
    ant -Dlibs.CopyLibs.classpath="$CopyLibs" \
		$TARGET
    RET=$?
    if [ ! "$RET" = "0" ]; then
        exit $RET
    fi
    echo " "
    cd ..
  fi
done

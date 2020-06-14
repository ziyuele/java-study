#!/usr/bin/env bash

java_bin_path=`which java`

JAVA_HOME=`echo  ${java_bin_path%/*}`
usage(){
 echo "usage:"
 echo "sh run_module.sh <module>"
}

set_class_path(){
   export PATH=$JAVA_HOME:$PATH
}

if [[ $# != 1 ]];then
    usage
fi

if [[ $# == 1 ]];then
    # check whether have java env

    if [[ "x"$JAVA_HOME = x ]];then
        echo "your java env is not set yet, set if first"
        exit -1
    fi
    set_class_path
    java com.kangjian.thriftstudy.ServerMain
fi


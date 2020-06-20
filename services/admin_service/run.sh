#!/bin/bash

THIS=$(dirname $0)
pushd . 
cd $THIS

mvn spring-boot:run
popd 

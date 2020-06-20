#!/bin/sh

THIS_DIR=$(dirname $0)

pushd .
cd $THIS_DIR

ag -l @RestController | xargs ag "@.*Mapping" > ../doc//API.txt

popd

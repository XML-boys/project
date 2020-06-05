#!/bin/sh 

export PGPASSWORD="admin"

sleep 2

psql \
    --host database --user postgres --no-password -c 'create database "XMLProject"'  -c 'grant ALL on database "XMLProject" to "postgres"'

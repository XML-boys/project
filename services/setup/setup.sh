#!/bin/sh 

export PGPASSWORD="admin"

sleep 2

psql --host database --user postgres --no-password -c 'create database "message_db"'  -c 'grant ALL on database "message_db" to "postgres"'
psql --host database --user postgres --no-password -c 'create database "order_db"'  -c 'grant ALL on database "order_db" to "postgres"'


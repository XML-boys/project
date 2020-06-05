#!/bin/sh 

export PGPASSWORD="admin"

sleep 2

psql --host database --user postgres --no-password -c 'create database "message_db"'  -c 'grant ALL on database "message_db" to "postgres"'
psql --host database --user postgres --no-password -c 'create database "order_db"'  -c 'grant ALL on database "order_db" to "postgres"'
psql --host database --user postgres --no-password -c 'create database "user_db"'  -c 'grant ALL on database "user_db" to "postgres"'
psql --host database --user postgres --no-password -c 'create database "vehicle_db"'  -c 'grant ALL on database "vehicle_db" to "postgres"'



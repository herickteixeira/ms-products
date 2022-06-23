#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE USER app_user WITH ENCRYPTED PASSWORD '1234';
	CREATE DATABASE products;
	GRANT ALL PRIVILEGES ON DATABASE products TO app_user;
EOSQL
#!/bin/sh

sleep 5s
kafka-topics --create --topic=products-event --if-not-exists --bootstrap-server=products-kafka:19092
kafka-topics --create --topic=products-dlt --if-not-exists --bootstrap-server=products-kafka:19092

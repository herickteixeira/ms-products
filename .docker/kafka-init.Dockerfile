FROM confluentinc/cp-kafka:6.0.2
USER root
WORKDIR /app
COPY .docker/kafka-init.sh kafka-init.sh
RUN chmod +x kafka-init.sh
ENTRYPOINT ./kafka-init.sh
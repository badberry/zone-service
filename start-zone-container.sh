#!/usr/bin/env bash
docker run -d -p 8080:8080 \
        -m 512m \
        -v /data/logs/zone/:/var/logs/zone/ \
        -e HostIP=${HostIP} \
        -e ListenPort=8080 \
        --name zone-service \
        registry.dev/zone-service:0.0.1-SNAPSHOT

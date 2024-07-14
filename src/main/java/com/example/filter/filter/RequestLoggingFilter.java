package com.example.filter.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;
import reactor.util.annotation.Nullable;

import java.nio.charset.StandardCharsets;

@Component
public class RequestLoggingFilter implements WebFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getURI().toString();

        // Get and log the request body
        return DataBufferUtils.join(exchange.getRequest().getBody())
                .doOnNext(buffer -> {
                    byte[] bytes = new byte[buffer.readableByteCount()];
                    buffer.read(bytes);
                    String body = new String(bytes, StandardCharsets.UTF_8);
                    logger.info("Request URL: {}", url);
                    logger.info("Request Body: {}", body);
                })
                .doOnCancel(() -> logger.debug("Request body logging cancelled"))
                .doFinally(this::logSignalType)
                .then(chain.filter(exchange));
    }

    private void logSignalType(@Nullable SignalType signalType) {
        logger.debug("Request logging signal: {}", signalType);
    }
}


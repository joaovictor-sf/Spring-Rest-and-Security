package com.joaovictor.login.domain;

import org.springframework.lang.NonNull;

public record ProductDTO(String id, @NonNull String name, @NonNull Integer price_in_cents) {
}

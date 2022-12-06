package com.alex.superhero.web;

import java.net.URI;
import java.util.UUID;

public record ResponseSuperHeroDTO(String name, UUID uuid, URI uri) {
}

package com.alex.superhero.web;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public record RequestSuperHeroDTO(@NotBlank String name) {
}

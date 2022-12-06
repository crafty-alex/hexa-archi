package com.alex.superhero.web;

import com.alex.superhero.domain.SuperHeroService;
import com.alex.superhero.domain.SuperHero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class SuperHeroController {

    private final SuperHeroService superHeroService;

    public SuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    @PostMapping("/super-heroes")
    public ResponseEntity<ResponseSuperHeroDTO> createSuperHero(@RequestBody @Valid RequestSuperHeroDTO requestSuperHeroDTO){
        SuperHero hero = superHeroService.createSuperHero(requestSuperHeroDTO.name());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hero.getUuid()).toUri();
        return new ResponseEntity<>(new ResponseSuperHeroDTO(
                hero.getName(),
                hero.getUuid(),
                uri),
                HttpStatus.CREATED);
    }
}

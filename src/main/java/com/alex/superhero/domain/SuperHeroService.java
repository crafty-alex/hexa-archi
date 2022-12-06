package com.alex.superhero.domain;

import org.springframework.stereotype.Service;

@Service
public class SuperHeroService {

    private final SuperHeroRepository superHeroRepository;

    public SuperHeroService(SuperHeroRepository SuperHeroRepository) {
        this.superHeroRepository = SuperHeroRepository;
    }

    public SuperHero createSuperHero(String name) {
        var toBeSaved = new SuperHero(name);
        return this.superHeroRepository.save(toBeSaved);
    }
}

package com.alex.superhero.dao;

import com.alex.superhero.domain.SuperHero;
import com.alex.superhero.domain.SuperHeroRepository;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface JPASuperHeroRepository extends JpaRepository<SuperHeroEntity, UUID>, SuperHeroRepository {

    @Override
    default SuperHero save(SuperHero toBeSaved){
        var hero = new SuperHeroEntity(toBeSaved.getName());
        var savedHero = saveAndFlush(hero);
        return new SuperHero(savedHero.getName(), savedHero.getCreatedAt(), savedHero.getUUID());
    }
}

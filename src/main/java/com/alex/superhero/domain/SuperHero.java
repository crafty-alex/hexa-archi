package com.alex.superhero.domain;

import com.alex.superhero.dao.SuperHeroEntity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class SuperHero {
    private String name;
    private UUID uuid;
    private LocalDateTime createdSince;

    public SuperHero(SuperHeroEntity SuperHeroEntity) {
        this(SuperHeroEntity.getName(), SuperHeroEntity.getCreatedAt());
        this.uuid = SuperHeroEntity.getUUID();
    }

    public SuperHero(String name, LocalDateTime createdSince) {
        this.name = name;
        this.createdSince = createdSince;
    }

    public SuperHero(String name, UUID randomUUID) {
        this(name, LocalDateTime.now());
        this.uuid = randomUUID;
    }

    public SuperHero(String name) {
        this(name, UUID.randomUUID());
    }

    public SuperHero(String name, LocalDateTime createdAt, UUID uuid) {

        this.name = name;
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperHero that = (SuperHero) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(uuid, that.uuid) &&
                Objects.equals(createdSince, that.createdSince);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, uuid, createdSince);
    }

    @Override
    public String toString() {
        return "MatchingHero{" +
                "name='" + name + '\'' +
                ", uuid=" + uuid +
                ", createdSince=" + createdSince +
                '}';
    }
}

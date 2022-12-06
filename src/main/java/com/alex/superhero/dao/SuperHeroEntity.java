package com.alex.superhero.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "SUPER_HERO")
public class SuperHeroEntity implements Serializable {
    @Id
    @Column(name = "UUID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID uuid ;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "CREATION_DATE", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public SuperHeroEntity() {
        //to please jpa
    }

    public SuperHeroEntity(String name) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

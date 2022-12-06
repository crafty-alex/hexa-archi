package com.alex.superhero.web;

import com.alex.superhero.domain.SuperHero;
import com.alex.superhero.domain.SuperHeroService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;

class SuperHeroApiShould extends APIsBaseComponentTest {

    @MockBean
    private SuperHeroService superHeroService;

    @Test
    void respond_with_a_201_status_when_creating_the_super_heroe() {
        SuperHero heroe = new SuperHero("Batman", UUID.fromString("98d71a00-4fb4-44c1-b3d1-84fe90e83c24"));
        Mockito.when(superHeroService.createSuperHero(anyString())).thenReturn(heroe);

        var body = this.given()
                .contentType(ContentType.JSON)
                .body("""
                        {
                        "name": "Batman"
                        }
                        """)
                .when()
                .post("/super-heroes");

        body.then().statusCode(201);

        ResponseSuperHeroDTO superheroe = body.then().extract().as(ResponseSuperHeroDTO.class);

        Assertions.assertEquals("Batman", superheroe.name());
        Assertions.assertEquals(UUID.fromString("98d71a00-4fb4-44c1-b3d1-84fe90e83c24"), superheroe.uuid());
        Assertions.assertEquals("/super-heroes/98d71a00-4fb4-44c1-b3d1-84fe90e83c24", superheroe.uri().getPath());
    }

    @Test
    void respond_with_a_400_status_when_creating_bad_super_heroe() {

        var body = this.given()
                .contentType(ContentType.JSON)
                .body("""
                        {
                        }
                        """)
                .when()
                .post("/super-heroes");

        body.then().statusCode(400);
    }
}

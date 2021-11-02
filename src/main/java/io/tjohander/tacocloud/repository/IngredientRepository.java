package io.tjohander.tacocloud.repository;


import io.tjohander.tacocloud.model.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);
}

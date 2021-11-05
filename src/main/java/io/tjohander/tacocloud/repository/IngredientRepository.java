package io.tjohander.tacocloud.repository;

import io.tjohander.tacocloud.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}

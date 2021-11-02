package io.tjohander.tacocloud.repository.jdbc;

import io.tjohander.tacocloud.model.Ingredient;
import io.tjohander.tacocloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {
     private JdbcTemplate jdbc;

     @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc) {
         this.jdbc = jdbc;
     }

     @Override
    public Iterable<Ingredient> findAll() {
         return jdbc.query("SELECT id, name, type FROM Ingredient", this::mapRowToIngredient);
     }

     @Override
    public Ingredient findOne(String id) {
         return (Ingredient) jdbc.query("SELECT id, name, type FROM Ingredient WHERE id=?", this::mapRowToIngredient);
     }

     @Override
     public Ingredient save(Ingredient ingredient) {
         jdbc.update(
                 "INSERT INTO Ingredient (id, name, type) values (?, ?, ?)",
                 ingredient.getId(),
                 ingredient.getName(),
                 ingredient.getType().toString()
         );
         return ingredient;
     }

     private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
         return new Ingredient(
                 rs.getString("id"),
                 rs.getString("name"),
                 Ingredient.Type.valueOf(rs.getString("type"))
         );
     }
}

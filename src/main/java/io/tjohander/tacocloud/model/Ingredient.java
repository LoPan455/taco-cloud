package io.tjohander.tacocloud.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Getter
@Setter
public class Ingredient {

    @Id
    private final String id;
    private final String name;

    // Enums are "funny" with JPA... <Anger>
    @Enumerated(EnumType.STRING)
    private final Type type;

    public static enum Type {
        CHEESE, PROTEIN, SAUCE, VEGGIES, WRAP
    }

}
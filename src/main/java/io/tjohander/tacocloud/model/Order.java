package io.tjohander.tacocloud.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Taco_Order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Instant placedAt;

    @NotBlank(message = "Name is Required")
    private String name;

    private String street;

    private String city;

    private String state;

    private String zip;

    @CreditCardNumber(message = "Credit Card Number is Required")
    private String ccNumber;

    private String ccExpiration;

    @NotBlank(message = "Please add your super secret CCV number")
    private String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = Instant.now();
    }
}

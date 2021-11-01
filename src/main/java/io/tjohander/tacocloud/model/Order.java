package io.tjohander.tacocloud.model;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.NotBlank;

@Data
public class Order {

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
}

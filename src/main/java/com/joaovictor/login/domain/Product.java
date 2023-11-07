package com.joaovictor.login.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "product")
@Entity(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer price_in_cents;
    private Boolean active;

    public Product(ProductDTO data) {
        this.name = data.name();
        this.price_in_cents = data.price_in_cents();
        this.active = true;
    }
}

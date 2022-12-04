package org.example.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dto.ProductBody;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "uuid-char") // Because of default type [binary(255)] findById method doesn't work
    private UUID id;

    String name;
    String code;
    LocalDateTime createdAt;

    // todo It should be replaced by MapStruct
    public Product(ProductBody productBody) {
        this.name = productBody.getName();
        this.code = productBody.getCode();
        this.createdAt = LocalDateTime.now();
    }
}

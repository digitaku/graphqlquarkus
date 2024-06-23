package com.atilas.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static com.atilas.util.UtilRepository.SCHEMA_NAME;

@Getter
@Setter
@Entity
@Table(schema = SCHEMA_NAME, name = "tb_user")
public class User extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_user")
    private Long id;
    @Column(name = "name", length = 80, nullable = false)
    private String name;
    @Column(name = "cpf",unique = true, length = 11, nullable = false)
    private String cpf;
    @Column(name = "email",length = 50)
    private String email;

}

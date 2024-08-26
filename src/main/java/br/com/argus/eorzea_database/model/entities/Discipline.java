package br.com.argus.eorzea_database.model.entities;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Discipline extends BaseEntity {
    @NotNull
    @Size(min = 15, max = 20)
    private String name;
}

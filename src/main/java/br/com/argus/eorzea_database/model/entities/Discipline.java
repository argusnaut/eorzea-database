package br.com.argus.eorzea_database.model.entities;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Discipline extends BaseEntity {
    @NotNull
    @Min(15)
    @Max(20)
    private String name;
}

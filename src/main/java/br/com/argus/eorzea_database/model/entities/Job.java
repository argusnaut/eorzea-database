package br.com.argus.eorzea_database.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Job extends BaseEntity {
    @NotNull
    @Max(25)
    private String name;

    @NotNull
    @Min(3)
    @Max(3)
    private String abbreviation;

    private String symbol;

    @NotNull
    private boolean isClass;

    // Used only for class
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "classJobId")
    private Job classJob;

    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "disciplineId")
    private Discipline discipline;
}

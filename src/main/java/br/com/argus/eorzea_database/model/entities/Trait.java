package br.com.argus.eorzea_database.model.entities;

import br.com.argus.eorzea_database.model.enums.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Trait extends BaseEntity {
    @NotNull
    private String name;
    private String effect;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer level;

    @NotNull
    private boolean questTrait;

    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "classJobId")
    private Job classJob;

    private Role role;
}

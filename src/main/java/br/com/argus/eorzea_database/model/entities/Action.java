package br.com.argus.eorzea_database.model.entities;

import br.com.argus.eorzea_database.model.enums.ActionShape;
import br.com.argus.eorzea_database.model.enums.ActionType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Action extends BaseEntity{
    @NotNull
    @Max(25)
    private String name;

    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "classJobId")
    private Job classJob;

    private boolean questAction;
    private boolean petAction;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer level;

    @NotNull
    private ActionType type;

    @NotNull
    private Float castTime;

    @NotNull
    private Float recastTime;

    @NotNull
    @Min(0)
    @Max(10000)
    private Integer mpCost;

    @NotNull
    private Integer range;

    @NotNull
    private Integer radius;

    @NotNull
    private ActionShape shape;

    @NotNull
    private String effect;
}

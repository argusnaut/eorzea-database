package br.com.argus.eorzea_database.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
public class Action {
    private ObjectId id;

    @NotBlank
    private String name;

    @Min(1)
    @Max(100)
    private int level;

    @NotNull
    private ActionType type;

    @Min(0)
    private float castTime;

    @Min(0)
    private float recastTime;

    @Min(0)
    @Max(10000)
    private int mpCost;

    @Min(0)
    private int range;

    @Min(0)
    private int radius;

    @NotNull
    private Shape shape;

    @NotBlank
    private String effect;

    @NotNull
    private ObjectId jobId;

    public enum ActionType {
        WEAPONSKILL, SPELL, ABILITY
    }

    public enum Shape {
        CIRCLE, LINE, NONE
    }
}

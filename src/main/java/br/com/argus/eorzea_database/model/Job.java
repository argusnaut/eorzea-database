package br.com.argus.eorzea_database.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import java.util.List;

@Getter
@Setter
public class Job {
    private ObjectId id;

    @NotBlank
    @Max(25)
    private String name;

    @NotBlank
    @Size(min = 3, max = 3)
    private String abbreviation;

    private String iconPath;
    private boolean isClass;
    private ObjectId evolvesTo;

    @NotNull
    private Discipline discipline;

    @NotNull
    private Role role;

    private List<Role> secondaryRoles;

    // Getters and setters
    public enum Discipline {
        DISCIPLE_OF_WAR, DISCIPLE_OF_MAGIC, DISCIPLE_OF_LAND, DISCIPLE_OF_HAND
    }

    public enum Role {
        TANK, HEALER, MELEE_DPS, PHYSICAL_RANGED_DPS, MAGICAL_RANGED_DPS
    }
}

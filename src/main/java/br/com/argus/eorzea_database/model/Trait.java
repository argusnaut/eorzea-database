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
public class Trait {
    private ObjectId id;

    @NotBlank
    private String name;

    @NotBlank
    private String effect;

    @Min(0)
    @Max(100)
    private int level;

    private boolean isQuestTrait;

    @NotNull
    private ObjectId jobId;

    @NotNull
    private Job.Role role;
}

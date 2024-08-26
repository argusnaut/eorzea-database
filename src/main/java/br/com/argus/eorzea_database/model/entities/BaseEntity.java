package br.com.argus.eorzea_database.model.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(updatable = false)
    private String createdBy;

    @NotNull
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = false)
    private String updatedBy;

    @Column(updatable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        createdBy = "System";
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
        updatedBy = "System";
    }
}

package com.waip.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "warehouse_tasks")
public class WarehouseTask {

    @Id
    private UUID id;

    @Column(name = "task_type", nullable = false, length = 30)
    private String taskType;

    @Column(name = "source_location", length = 100)
    private String sourceLocation;

    @Column(name = "destination_location", nullable = false, length = 100)
    private String destinationLocation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TaskStatus status;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected WarehouseTask() {
        // Required by JPA.
    }

    public WarehouseTask(String taskType, String sourceLocation, String destinationLocation) {
        this.taskType = taskType;
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
        this.status = TaskStatus.CREATED;
    }

    @PrePersist
    void onCreate() {
        if (id == null) {
            id = UUID.randomUUID();
        }
        Instant now = Instant.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    void onUpdate() {
        updatedAt = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public String getTaskType() {
        return taskType;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}

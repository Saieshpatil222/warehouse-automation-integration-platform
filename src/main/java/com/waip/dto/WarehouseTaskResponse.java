package com.waip.dto;

import com.waip.entity.TaskStatus;
import com.waip.entity.WarehouseTask;

import java.time.Instant;
import java.util.UUID;

public record WarehouseTaskResponse(
        UUID id,
        String taskType,
        String sourceLocation,
        String destinationLocation,
        TaskStatus status,
        Instant createdAt,
        Instant updatedAt
) {
    public static WarehouseTaskResponse from(WarehouseTask task) {
        return new WarehouseTaskResponse(
                task.getId(),
                task.getTaskType(),
                task.getSourceLocation(),
                task.getDestinationLocation(),
                task.getStatus(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }
}
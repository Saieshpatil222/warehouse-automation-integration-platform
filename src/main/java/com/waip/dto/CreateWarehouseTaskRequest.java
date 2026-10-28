package com.waip.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateWarehouseTaskRequest(

        @NotNull
        @Pattern(regexp = "PICK|PUTAWAY|MOVE|REPLENISH")
        String taskType,

        @Size(max = 100)
        String sourceLocation,

        @NotBlank
        @Size(max = 100)
        String destinationLocation
) {
}
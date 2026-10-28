package com.waip.repository;

import com.waip.entity.WarehouseTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WarehouseTaskRepository extends JpaRepository<WarehouseTask, UUID> {
    List<WarehouseTask> findAllByOrderByCreatedAtDesc();
}

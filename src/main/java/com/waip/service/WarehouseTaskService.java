package com.waip.service;

import com.waip.repository.WarehouseTaskRepository;
import org.springframework.stereotype.Service;

@Service
public class WarehouseTaskService {

    private final WarehouseTaskRepository warehouseTaskRepository;

    public WarehouseTaskService(WarehouseTaskRepository taskRepository){
        this.warehouseTaskRepository = taskRepository;
    }

}

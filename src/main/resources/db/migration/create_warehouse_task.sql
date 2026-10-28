
CREATE TABLE warehouse_tasks (
                                 id UUID PRIMARY KEY,
                                 task_type VARCHAR(30) NOT NULL,
                                 source_location VARCHAR(100),
                                 destination_location VARCHAR(100) NOT NULL,
                                 status VARCHAR(30) NOT NULL,
                                 created_at TIMESTAMPTZ NOT NULL,
                                 updated_at TIMESTAMPTZ NOT NULL,

                                 CONSTRAINT chk_warehouse_task_type
                                     CHECK (task_type IN ('PICK', 'PUTAWAY', 'MOVE', 'REPLENISH')),

                                 CONSTRAINT chk_warehouse_task_status
                                     CHECK (status IN (
                                                       'CREATED', 'ASSIGNED', 'IN_PROGRESS', 'COMPLETED', 'FAILED'
                                         ))
);

CREATE INDEX idx_warehouse_tasks_created_at
    ON warehouse_tasks (created_at DESC);

CREATE INDEX idx_warehouse_tasks_status
    ON warehouse_tasks (status);

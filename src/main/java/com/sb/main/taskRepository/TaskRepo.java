package com.sb.main.taskRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.main.taskEntity.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {
}

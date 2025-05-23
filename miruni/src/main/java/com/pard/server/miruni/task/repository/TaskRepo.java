package com.pard.server.miruni.task.repository;

import com.pard.server.miruni.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Integer> {

}

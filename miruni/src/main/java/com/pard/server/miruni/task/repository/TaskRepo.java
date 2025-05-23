package com.pard.server.miruni.task.repository;

import com.pard.server.miruni.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Integer> {
//    List<Task> findByTaskName(String task_name);
//    @Query("SELECT t FROM Task t WHERE t.task_name = :taskName")
//    List<Task> findByTask_name(@Param("taskName") String taskName);

    @Query("SELECT t FROM Task t WHERE t.task_id = :taskId")
    List<Task> findByTask_id(@Param("taskId") int taskId);
}

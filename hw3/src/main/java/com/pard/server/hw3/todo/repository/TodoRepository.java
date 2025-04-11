package com.pard.server.hw3.todo.repository;

import com.pard.server.hw3.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    public List<Todo> findByType(String type);
    public List<Todo> findByPriorityBetween(int start, int end);
    @Query("SELECT t FROM Todo t ORDER BY LENGTH(t.title) ASC")
    List<Todo> findAllOrderByTitleLength();

    @Query("SELECT t FROM Todo t ORDER BY LENGTH(t.task) DESC")
    List<Todo> findTopLongestTasks(Pageable pageable);

}

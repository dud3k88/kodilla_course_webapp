package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTest {

    @InjectMocks
    DbService dbService;

    @Mock
    TaskRepository taskRepository;

    @Test
    public void testShouldGetAllTask() {
        //when
        dbService.getAllTasks();
        //then
        verify(taskRepository, times(1)).findAll();
    }
    @Test
    public void testShouldGetTask() {
        //given
        Task task = new Task(1L, "test_title", "test_content");
        //when
        dbService.getTaskById(task.getId());
        //then
        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    public void shouldSaveTask() {
        //given
        Task task1 = new Task(1L, "test_title1", "test_content1");
        Task task2 = new Task(1L, "test_title2", "test_content2");
        //when
        dbService.saveTask(task1);
        dbService.saveTask(task2);
        //then
        verify(taskRepository, times(1)).save(task1);
        verify(taskRepository, times(1)).save(task2);
    }

    @Test
    public void shouldDeleteTask() {
        //when
        dbService.deleteTask(ArgumentMatchers.anyLong());
        //then
        verify(taskRepository, times(1)).deleteById(ArgumentMatchers.anyLong());
    }

}
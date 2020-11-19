package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTest {
    @Autowired
    TaskMapper taskMapper;

    @Test
    public void mapToTask() {
        //given
        TaskDto taskDto = new TaskDto(1L, "test_title", "test_content");
        Task task = new Task(1L, "test_title", "test_content");
        //when
        Task mappedTask = taskMapper.mapToTask(taskDto);
        //then
        assertEquals(mappedTask.getId(), task.getId());
        assertEquals(mappedTask.getTitle(), task.getTitle());
        assertEquals(mappedTask.getContent(), task.getContent());
    }

    @Test
    public void mapToTaskDto() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "test_title", "test_content");
        Task task = new Task(1L, "test_title", "test_content");
        //When
        TaskDto mappedTaskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(mappedTaskDto.getId(), task.getId());
        assertEquals(mappedTaskDto.getTitle(), task.getTitle());
        assertEquals(mappedTaskDto.getContent(), task.getContent());
    }

    @Test
    public void mapToTaskList() {
        //Given
        Task task = new Task(1L, "test_title", "test_content");
        Task task2 = new Task(2L, "test_title2", "test_content2");
        TaskDto taskDto = new TaskDto(1L, "test_title", "test_content");
        TaskDto taskDto2 = new TaskDto(2L, "test_title2", "test_content2");
        List<Task> taskList = new ArrayList<>(Arrays.asList(task, task2));
        List<TaskDto> taskListDto = new ArrayList<>(Arrays.asList(taskDto, taskDto2));

        //When
        List<TaskDto> taskMappedList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        Assert.assertEquals(taskListDto.size(), taskMappedList.size());
        Assert.assertEquals(taskListDto.get(0).getId(), taskMappedList.get(0).getId());
        Assert.assertEquals(taskListDto.get(0).getTitle(), taskMappedList.get(0).getTitle());
        Assert.assertEquals(taskListDto.get(1).getContent(), taskMappedList.get(1).getContent());


    }
}
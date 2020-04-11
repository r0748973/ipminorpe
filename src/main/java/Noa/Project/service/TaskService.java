package Noa.Project.service;

import Noa.Project.domain.SubTask;
import Noa.Project.domain.Task;
import Noa.Project.dto.SubTaskDTO;
import Noa.Project.dto.TaskDTO;

import java.util.List;
import java.util.Map;

public interface TaskService {
    Map<Long, Task> getTasks();
    void addTask(TaskDTO task);
    void editTask(Long id, TaskDTO task2);
    void addSubtask(Long id, SubTaskDTO task);
}


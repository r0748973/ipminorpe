package Noa.Project.service;

import Noa.Project.domain.SubTask;
import Noa.Project.domain.Task;
import Noa.Project.dto.SubTaskDTO;
import Noa.Project.dto.TaskDTO;
import Noa.Project.repository.TaskRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TaskServicelmpl implements TaskService {
    private final TaskRepo repository;
    @Autowired
    public TaskServicelmpl(TaskRepo repository){this.repository = repository;}


    @Override
    public Map<Long, Task> getTasks() {
        return repository.findAll().stream().collect(Collectors.toMap(Task::getId, Function.identity()));
    }

    @Override
    public void addTask(TaskDTO task) {

        Task result = new Task();
        result.setTitle(task.getTitle());
        result.setDescription(task.getDescription());
        result.setDate(task.getDate());

        repository.save(result);
        repository.flush();

    }

    @Override
    public void editTask(Long id, TaskDTO task2) {

        getTasks().get(id).setDate(task2.getDate());
        getTasks().get(id).setDescription(task2.getDescription());
        getTasks().get(id).setTitle(task2.getTitle());
        repository.save(getTasks().get(id));
        repository.flush();
    }

    @Override
    public void addSubtask(Long id, SubTaskDTO task) {
        SubTask result = new SubTask();
        result.setDescription(task.getDescription());
        result.setTitle(task.getTitle());
        System.out.println(getTasks().get(id));
        Task task1 = getTasks().get(id);
        task1.addSubTask(result);

        repository.save(task1);
        repository.flush();


    }



}

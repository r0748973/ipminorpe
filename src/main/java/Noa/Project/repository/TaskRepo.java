package Noa.Project.repository;

import Noa.Project.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TaskRepo extends JpaRepository<Task, Long> {
}

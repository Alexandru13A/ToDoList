package ro.alexandru.ToDoList.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.alexandru.ToDoList.Entity.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {
}

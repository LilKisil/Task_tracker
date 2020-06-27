package tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tracker.entity.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}

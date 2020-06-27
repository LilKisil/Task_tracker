package tracker.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tracker.entity.Task;
import tracker.repository.TaskRepository;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> findAllNotes() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteNoteById(Integer id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void saveNote(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Task getNoteById(Integer id) {
         return taskRepository.findById(id).get();
    }

    @Override
    public void updateTask(Integer id, String title, String description, String status) {
        Task updated = taskRepository.findById(id).get();
        updated.setTitle(title);
        updated.setDescription(description);
        updated.setStatus(status);
        taskRepository.save(updated);
    }
}

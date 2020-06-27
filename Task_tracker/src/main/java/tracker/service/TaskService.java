package tracker.service;

import org.springframework.stereotype.Service;
import tracker.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllNotes();
    void deleteNoteById(Integer id);
    void saveNote(Task task);
    Task getNoteById(Integer id);
    void updateTask(Integer id, String title, String description, String status);
}

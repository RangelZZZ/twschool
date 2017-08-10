package web_shell.repository;

import core.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, String> {
    Student findByStudentId(String id);

    List<Student> findAll();
}

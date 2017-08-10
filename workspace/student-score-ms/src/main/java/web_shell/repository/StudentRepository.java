package web_shell.repository;

import core.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
    Student findByStudentId(String id);
}

package web_shell.controller;

import core.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web_shell.repository.StudentRepository;


@RestController
@CrossOrigin("*")
@RequestMapping("students")
public class StudentRepositoryController {
    private StudentRepository studentRepository;

    @Autowired
    public StudentRepositoryController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> addStudent(@RequestBody Student studentInfo) {

        studentRepository.save(studentInfo);

        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }
}

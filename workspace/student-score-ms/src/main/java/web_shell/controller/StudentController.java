package web_shell.controller;

import core.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web_shell.service.StudentService;

@RestController
@CrossOrigin("*")
@RequestMapping("students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> addStudentGrade(@RequestBody Grade studentGrade) {
        if (studentService.addStudentGrade(studentGrade)) {
            return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
    }
}

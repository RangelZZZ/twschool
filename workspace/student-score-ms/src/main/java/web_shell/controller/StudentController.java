package web_shell.controller;

import core.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import web_shell.service.StudentService;

@RestController
@CrossOrigin("*")
@RequestMapping("students")
public class studentController {

    private StudentService studentService;

    @Autowired
    public studentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpStatus addStudent(@RequestBody Student student) {
        if (studentService.addStudent(student)) {
            return HttpStatus.CREATED;
        }
        return HttpStatus.CONFLICT;
    }
}

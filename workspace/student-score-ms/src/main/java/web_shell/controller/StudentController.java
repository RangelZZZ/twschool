package web_shell.controller;

import core.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import web_shell.service.StudentService;

@RestController
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

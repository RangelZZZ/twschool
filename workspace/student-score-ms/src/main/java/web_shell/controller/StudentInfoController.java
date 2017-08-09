package web_shell.controller;

import core.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web_shell.service.StudentService;

@RestController
@CrossOrigin("*")
@RequestMapping("studentInfo")
public class StudentInfoController {
    private StudentService studentService;

    @Autowired
    public StudentInfoController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> addStudentInformation(@RequestBody StudentInfo studentInfo) {

        studentService.addStudentInformation(studentInfo);

        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

}

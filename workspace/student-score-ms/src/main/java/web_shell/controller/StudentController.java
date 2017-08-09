package web_shell.controller;

import core.Grade;
import core.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web_shell.service.StudentService;

import java.util.List;

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
    public ResponseEntity<HttpStatus> addStudent(@RequestBody Student studentInfo) {

        studentService.addStudent(studentInfo);

        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List> getAllStudent() {


        return new ResponseEntity<List>((List) studentService.getAllStudents(), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
        System.out.println(id);

        return new ResponseEntity<Student>((Student) studentService.getStudentsById(id), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/grades")
    public ResponseEntity<HttpStatus> addStudentGrade(@RequestBody Grade studentGrade, @PathVariable("id") int id) {
        if (studentService.addStudentGrade(studentGrade, id)) {
            return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/grades")
    public ResponseEntity<HttpStatus> updateStudentGrade(@RequestBody Grade studentGrade, @PathVariable("id") int id) {
        if (studentService.updateStudentGrade(studentGrade, id)) {
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }


}

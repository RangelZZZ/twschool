package web_shell.controller;

import core.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import web_shell.service.ReportService;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("reports")
public class ReportController {

    private ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Report> addStudent(@PathParam("studentIds") String studentIds) {
        Report report = reportService.generateReport(studentIds);

        return new ResponseEntity<Report>(report, HttpStatus.OK);

    }
}


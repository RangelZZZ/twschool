package web_shell.controller;

import core.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import web_shell.service.ReportService;

import javax.websocket.server.PathParam;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("reports")
public class ReportController {

    private ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Map> generateReport(@PathParam("studentIds") String studentIds) {
        Map reportList = reportService.generateReport(studentIds);

        return new ResponseEntity<Map>(reportList, HttpStatus.OK);

    }
}


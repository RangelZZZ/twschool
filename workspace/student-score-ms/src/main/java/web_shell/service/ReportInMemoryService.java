package web_shell.service;

import core.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.ParseUtil;

import java.util.ArrayList;

@Service
public class ReportInMemoryService implements ReportService {

    @Autowired
    private StudentService studentService;

    @Override
    public Report generateReport(String studentIds) {
        ArrayList<String> selectedStudents = ParseUtil.extractStudentIds(studentIds);
        return new Report(studentService.getSelectStudents(selectedStudents));
    }
}

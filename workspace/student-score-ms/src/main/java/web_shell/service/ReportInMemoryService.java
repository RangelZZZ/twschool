package web_shell.service;

import core.Grade;
import core.Report;
import core.ReportItem;
import core.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.ParseUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportInMemoryService implements ReportService {

    private Report report = new Report();

    @Autowired
    private StudentService studentService;

    @Override
    public Map generateReport(String studentIds) {
        ArrayList<String> selectedStudentIds = ParseUtil.extractStudentIds(studentIds);
        List<ReportItem> reportItems = report.createItemList(studentService.selectStudents(selectedStudentIds));

        Map hashMap = new HashMap();
        hashMap.put("reportItems", reportItems);
        hashMap.put("totalScore", report.getTotalScore());
        hashMap.put("medianScore", report.getMedianScore());

        Map reportList = hashMap;

        return reportList;
    }

    @Override
    public Map getAllReportItem() {
        List<Grade> studentGrades = new ArrayList<>();

        Map hashMap = new HashMap();
        hashMap.put("reportItems",  report.getAllItems(studentGrades));
        hashMap.put("totalScore", report.getTotalScore());
        hashMap.put("medianScore", report.getMedianScore());

        Map reportList = hashMap;

        return reportList;
    }
}

package web_shell.service;

import java.util.Map;

public interface ReportService {
    Map   generateReport(String studentIds);

    Map getAllReportItem();
}

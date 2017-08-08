package core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReportBuilder {
    private List<ReportItem> reportItemList = new ArrayList<ReportItem>();
    private int totalScore = 0;

    public ReportBuilder(List<ReportItem> reportItemList) {
        this.reportItemList = reportItemList;
    }

    public int getReportTotalScore() {
        for (ReportItem reportItem : reportItemList) {
            totalScore += reportItem.getTotalScore();
        }

        return totalScore;
    }

    public int getMedianScore() {
        List<ReportItem> sortedItems = reportItemList.stream()
                .sorted((item1, item2) -> (int) (item1.getTotalScore() - item2.getTotalScore()))
                .collect(Collectors.toList());

        int medianSize = sortedItems.size() % 2;
        if (medianSize == 1) {
            return sortedItems.get(sortedItems.size() / 2).getTotalScore();
        } else {
            return (sortedItems.get(sortedItems.size() / 2 - 1).getTotalScore() +
                    sortedItems.get(sortedItems.size() / 2).getTotalScore()) / 2;
        }

    }
}

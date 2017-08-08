package core;

import java.util.List;
import java.util.stream.Collectors;

public class Report {

    private final List<ReportItem> itemList;

    public Report(List<Student> students) {
        itemList = students.stream()
                .map(student -> new ReportItem(student))
                .collect(Collectors.toList());
    }

    public List<ReportItem> getItemList() {
        return itemList;
    }

    public int getTotalScore() {
        int totalScore = 0;
        for (ReportItem reportItem : itemList) {
            totalScore += reportItem.getTotalScore();
        }

        return totalScore;
    }

    public int getMedianScore() {
        List<ReportItem> sortedItems = itemList.stream()
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

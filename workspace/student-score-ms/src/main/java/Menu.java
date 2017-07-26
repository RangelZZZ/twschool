import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

    private static String studentInputFormat = "([^，]+)，(\\w+)，数学：(\\d+)，语文：(\\d+)，英语：(\\d+)，编程：(\\d+)";

    public static void main() {
        System.out.println("hello world");
    }

    public static Boolean judgeStudentInputFormat(String studentInput) {
        return studentInput.matches(studentInputFormat);
    }


    public static Student extractStudentInformation(String studentInput) {
        Pattern pattern = Pattern.compile(studentInputFormat);
        Matcher matcher = pattern.matcher(studentInput);
        if (matcher.matches()) {
            return new Student(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3)),
                    Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        }

        return null;
    }
}


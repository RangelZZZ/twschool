public class Menu {

    public static void main() {
        System.out.println("hello world");
    }

    public static Boolean judgeStudentInputFormat(String studentInput) {
        String studentInputFormat = "([^，]+)，(\\w+)，数学：(\\d+)，语文：(\\d+)，英语：(\\d+)，编程：(\\d+)";
        if (studentInput.matches(studentInputFormat)) {
            return true;
        }
        return false;
    }


}

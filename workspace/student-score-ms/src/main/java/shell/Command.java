package shell;

import java.util.Scanner;

public class Command {

    public void getUserInput() {
        Scanner sc = new Scanner(System.in);
        handleUserInput(sc.nextInt());
    }

    private void handleUserInput(int userInput) {
        if (userInput == 1) {
            new AddStudentCommand().handleAddStudent();
        } else if (userInput == 2) {
            new PrintStudentScoreCommand().handlePrintStudentScore();
        } else if (userInput == 3) {
            System.exit(0);
        }

    }
}

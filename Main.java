import javax.swing.SwingUtilities;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        GradeManager manager = new GradeManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("===== STUDENT GRADE TRACKER =====");
        System.out.println("1. Console Mode");
        System.out.println("2. GUI Mode");
        System.out.print("Enter Choice: ");
        int choice = sc.nextInt();
        if (choice == 1) {
            StudentGradeTrackerConsole.runConsole(manager);
        } else if (choice == 2) {
            SwingUtilities.invokeLater(
                    () -> new StudentGradeTrackerGUI(manager));
        } else {
            System.out.println("Invalid Choice!");
        }
    }
}
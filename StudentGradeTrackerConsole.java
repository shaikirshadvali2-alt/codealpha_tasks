import java.util.Scanner;
public class StudentGradeTrackerConsole {
    public static void runConsole(GradeManager manager) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Student Name: ");
            String name = sc.nextLine();
            System.out.print("Grade: ");
            double grade = sc.nextDouble();
            sc.nextLine();
            manager.addStudent(name, grade);
        }
        System.out.println("\n===== STUDENT REPORT =====");
        for (Student s : manager.getStudents()) {
            System.out.println(
                    s.getName() + " : " + s.getGrade());
        }
        System.out.println("-----------------------");
        System.out.println("Average : " + manager.getAverage());
        System.out.println("Highest : " + manager.getHighest());
        System.out.println("Lowest  : " + manager.getLowest());
    }
}
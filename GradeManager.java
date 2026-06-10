import java.util.ArrayList;
public class GradeManager {
    private ArrayList<Student> students = new ArrayList<>();
    public void addStudent(String name, double grade) {
        students.add(new Student(name, grade));
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public double getAverage() {
        if (students.isEmpty()) return 0;
        double sum = 0;
        for (Student s : students) {
            sum += s.getGrade();
        }
        return sum / students.size();
    }
    public double getHighest() {
        if (students.isEmpty()) return 0;
        double highest = students.get(0).getGrade();
        for (Student s : students) {
            if (s.getGrade() > highest) {
                highest = s.getGrade();
            }
        }
        return highest;
    }
    public double getLowest() {
        if (students.isEmpty()) return 0;
        double lowest = students.get(0).getGrade();
        for (Student s : students) {
            if (s.getGrade() < lowest) {
                lowest = s.getGrade();
            }
        }
        return lowest;
    }
}
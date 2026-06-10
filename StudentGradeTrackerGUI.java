import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class StudentGradeTrackerGUI extends JFrame {
    private GradeManager manager;
    private JTextField nameField;
    private JTextField gradeField;
    private JLabel avgLabel;
    private JLabel highLabel;
    private JLabel lowLabel;
    private DefaultTableModel model;
    public StudentGradeTrackerGUI(GradeManager manager) {
        this.manager = manager;
        setTitle("Student Grade Tracker");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel topPanel = new JPanel(new GridLayout(3, 2));
        topPanel.add(new JLabel("Name"));
        nameField = new JTextField();
        topPanel.add(nameField);
        topPanel.add(new JLabel("Grade"));
        gradeField = new JTextField();
        topPanel.add(gradeField);
        JButton addBtn = new JButton("Add Student");
        JButton reportBtn = new JButton("Generate Report");
        topPanel.add(addBtn);
        topPanel.add(reportBtn);
        model = new DefaultTableModel();
        model.addColumn("Student");
        model.addColumn("Grade");
        JTable table = new JTable(model);
        avgLabel = new JLabel("Average : ");
        highLabel = new JLabel("Highest : ");
        lowLabel = new JLabel("Lowest : ");
        JPanel bottomPanel = new JPanel(new GridLayout(3,1));
        bottomPanel.add(avgLabel);
        bottomPanel.add(highLabel);
        bottomPanel.add(lowLabel);
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        addBtn.addActionListener(e -> {
            try {
                String name = nameField.getText();
                double grade =
                        Double.parseDouble(gradeField.getText());
                manager.addStudent(name, grade);
                model.addRow(
                        new Object[]{name, grade});
                nameField.setText("");
                gradeField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Input!"
                );
            }
        });
        reportBtn.addActionListener(e -> {
            avgLabel.setText(
                    "Average : " + manager.getAverage());
            highLabel.setText(
                    "Highest : " + manager.getHighest());
            lowLabel.setText(
                    "Lowest : " + manager.getLowest());
        });
        setVisible(true);
    }
}
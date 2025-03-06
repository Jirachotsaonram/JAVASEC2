import java.util.*;

class Student {
    private String stdId;
    private String name;
    private String lastName;
    private String email;
    private int section;
    private List<Grade> gradeList;

    public Student(String stdId, String name, String lastName, String email, int section) {
        this.stdId = stdId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.section = section;
        this.gradeList = new ArrayList<>();
    }

    public void addGradeData(Grade grade) {
        gradeList.add(grade);
    }

    public double getGPA() {
        double total = 0;
        for (Grade g : gradeList) {
            total += g.calGrade();
        }
        return gradeList.size() > 0 ? total / gradeList.size() : 0;
    }

    public void showGrades() {
        System.out.println("Student: " + name + " " + lastName + " (ID: " + stdId + ")");
        for (Grade g : gradeList) {
            System.out.printf("  Subject: %-20s Grade: %.2f\n", g.getSubject().getName(), g.calGrade());
        }
        System.out.printf("  GPA: %.2f\n", getGPA());
        System.out.println("------------------------");
    }
}
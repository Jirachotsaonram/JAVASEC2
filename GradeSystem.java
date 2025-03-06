import java.util.*;

class Student {
    private String stdId;
    private String name;
    private String lastName;
    private List<Grade> gradeList;

    public Student(String stdId, String name, String lastName) {
        this.stdId = stdId;
        this.name = name;
        this.lastName = lastName;
        this.gradeList = new ArrayList<>();
    }

    public void addGrade(Grade grade) {
        gradeList.add(grade);
    }

    public double getGPA() {
        if (gradeList.isEmpty()) return 0.0;
        double total = 0;
        for (Grade g : gradeList) {
            total += g.calculateGrade();
        }
        return total / gradeList.size();
    }

    public void showGrades() {
        System.out.println("Student: " + name + " " + lastName + " (ID: " + stdId + ")");
        for (Grade g : gradeList) {
            System.out.printf("  Subject: %-20s Grade: %.2f (%s)\n", 
                g.getSubject().getName(), g.calculateGrade(), g.getLetterGrade());
        }
        System.out.printf("  GPA: %.2f\n", getGPA());
        System.out.println("------------------------");
    }
}

class Teacher {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Subject {
    private String name;
    private Teacher teacher;

    public Subject(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public String getTeacherName() {
        return teacher.getName();
    }
}

class Grade {
    private double midTerm;
    private double finalExam;
    private double assignment;
    private double attendance;
    private Subject subject;

    public Grade(Subject subject, double midTerm, double finalExam, double assignment, double attendance) {
        this.subject = subject;
        this.midTerm = midTerm;
        this.finalExam = finalExam;
        this.assignment = assignment;
        this.attendance = attendance;
    }

    public double calculateGrade() {
        return (midTerm * 0.3) + (finalExam * 0.4) + (assignment * 0.2) + (attendance * 0.1);
    }

    public String getLetterGrade() {
        double score = calculateGrade();
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }

    public Subject getSubject() {
        return subject;
    }
}

public class GradeSystem {
    public static void main(String[] args) {
        // 1️⃣ สร้างอาจารย์
        Teacher teacher1 = new Teacher("Alice Smith");
        Teacher teacher2 = new Teacher("Bob Johnson");
        Teacher teacher3 = new Teacher("Charlie Brown");

        // 2️⃣ สร้างวิชา และกำหนดอาจารย์
        Subject cs = new Subject("Computer Science", teacher1);
        Subject math = new Subject("Mathematics", teacher2);
        Subject eng = new Subject("English", teacher3);

        List<Subject> subjects = Arrays.asList(cs, math, eng);

        // 3️⃣ สร้างนักเรียน 20 คน และสุ่มคะแนน
        List<Student> students = new ArrayList<>();
        Random rand = new Random();
        for (int i = 1; i <= 20; i++) {
            Student student = new Student("S" + String.format("%02d", i), "Student" + i, "Lastname" + i);
            for (Subject sub : subjects) {
                double mid = 50 + rand.nextDouble() * 50;
                double fin = 50 + rand.nextDouble() * 50;
                double assign = 50 + rand.nextDouble() * 50;
                double att = 50 + rand.nextDouble() * 50;
                student.addGrade(new Grade(sub, mid, fin, assign, att));
            }
            students.add(student);
        }

        // 4️⃣ แสดงผลเกรดของนักเรียน
        System.out.println("======= STUDENT GRADE REPORT =======");
        for (Student s : students) {
            s.showGrades();
        }

        // 5️⃣ แสดงรายชื่อวิชาและอาจารย์
        System.out.println("======= SUBJECTS & TEACHERS =======");
        for (Subject sub : subjects) {
            System.out.printf("Subject: %-20s Teacher: %s\n", sub.getName(), sub.getTeacherName());
        }
    }
}

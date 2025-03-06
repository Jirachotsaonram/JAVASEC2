package work;

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

class Teacher {
    private String teacherId;
    private String name;
    private String lastName;
    private String email;
    private String phone;

    public Teacher(String teacherId, String name, String lastName, String email, String phone) {
        this.teacherId = teacherId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name + " " + lastName;
    }
}

class Subject {
    private String subjectId;
    private String name;
    private double credit;
    private List<Teacher> teacherList;

    public Subject(String subjectId, String name, double credit) {
        this.subjectId = subjectId;
        this.name = name;
        this.credit = credit;
        this.teacherList = new ArrayList<>();
    }

    public void addNewTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }

    public String getName() {
        return name;
    }

    public String getTeachers() {
        List<String> teacherNames = new ArrayList<>();
        for (Teacher t : teacherList) {
            teacherNames.add(t.getName());
        }
        return String.join(", ", teacherNames);
    }
}

class Grade {
    private double midTermScore;
    private double finalScore;
    private double assignmentScore;
    private double attendanceScore;
    private Subject subjectData;

    public Grade(Subject subject, double midTerm, double finalExam, double assignment, double attendance) {
        this.subjectData = subject;
        this.midTermScore = midTerm;
        this.finalScore = finalExam;
        this.assignmentScore = assignment;
        this.attendanceScore = attendance;
    }

    public double calGrade() {
        return (midTermScore * 0.3) + (finalScore * 0.4) + (assignmentScore * 0.2) + (attendanceScore * 0.1);
    }

    public Subject getSubject() {
        return subjectData;
    }
}

public class GradeSystem {
    public static void main(String[] args) {
        // 🔹 สร้างอาจารย์
        Teacher teacher1 = new Teacher("T001", "Alice", "Smith", "alice@mail.com", "0812345678");
        Teacher teacher2 = new Teacher("T002", "Bob", "Johnson", "bob@mail.com", "0823456789");
        Teacher teacher3 = new Teacher("T003", "Charlie", "Brown", "charlie@mail.com", "0834567890");

        // 🔹 สร้างวิชาและเพิ่มอาจารย์
        Subject cs = new Subject("CS101", "Computer Science", 3);
        cs.addNewTeacher(teacher1);

        Subject math = new Subject("MATH201", "Mathematics", 3);
        math.addNewTeacher(teacher2);

        Subject eng = new Subject("ENG102", "English", 2);
        eng.addNewTeacher(teacher3);

        List<Subject> subjects = Arrays.asList(cs, math, eng);

        // 🔹 สร้างนักเรียน 20 คน
        List<Student> students = new ArrayList<>();
        Random rand = new Random();
        for (int i = 1; i <= 20; i++) {
            Student student = new Student("S" + String.format("%02d", i), "Student" + i, "Lastname" + i, "student" + i + "@mail.com", rand.nextInt(3) + 1);
            for (Subject sub : subjects) {
                student.addGradeData(new Grade(sub, rand.nextDouble() * 100, rand.nextDouble() * 100, rand.nextDouble() * 100, rand.nextDouble() * 100));
            }
            students.add(student);
        }

        // 🔹 แสดงข้อมูลนักเรียนพร้อมเกรด
        System.out.println("======= STUDENT GRADE REPORT =======");
        for (Student s : students) {
            s.showGrades();
        }

        // 🔹 แสดงรายวิชาและอาจารย์
        System.out.println("======= SUBJECTS & TEACHERS =======");
        for (Subject sub : subjects) {
            System.out.printf("Subject: %-20s Teachers: %s\n", sub.getName(), sub.getTeachers());
        }
    }
}

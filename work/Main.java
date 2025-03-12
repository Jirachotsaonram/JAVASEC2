package work;
import java.util.ArrayList;
import java.util.List;

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
    
    public String getTeacherId() { return teacherId; }
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
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
    
    public void removeTeacher(Teacher teacher) {
        teacherList.remove(teacher);
    }
}

class Grade {
    private double midTermScore;
    private double assignmentScore;
    private double attendanceScore;
    private Subject subjectData;

    public Grade(double midTermScore, double assignmentScore, double attendanceScore, Subject subjectData) {
        this.midTermScore = midTermScore;
        this.assignmentScore = assignmentScore;
        this.attendanceScore = attendanceScore;
        this.subjectData = subjectData;
    }

    public double calGrade() {
        return (midTermScore * 0.4) + (assignmentScore * 0.4) + (attendanceScore * 0.2);
    }
}

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
        return gradeList.isEmpty() ? 0 : total / gradeList.size();
    }
    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("T01", "John", "Doe", "john.doe@example.com", "123-456-7890");
        Subject subject1 = new Subject("S01", "Mathematics", 3);
        subject1.addNewTeacher(teacher1);
        
        Subject subject2 = new Subject("S02", "Physics", 4);
        subject2.addNewTeacher(teacher1);

        Grade grade1 = new Grade(85, 90, 80, subject1);
        Grade grade2 = new Grade(78, 85, 90, subject2);

        Student student1 = new Student("ST01", "Alice", "Smith", "alice.smith@example.com", 1);
        student1.addGradeData(grade1);
        student1.addGradeData(grade2);
        
        System.out.println("Student: " + student1.getName() + " GPA: " + student1.getGPA());
    }
}

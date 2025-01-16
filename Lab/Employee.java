package Lab;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Employee {
    private String id;
    private String name;
    private double hourlyRate;
    private int totalHours;
    private LocalTime clockInTime;

    // Constructor
    public Employee(String id, String name, double hourlyRate) {
        this.id = id;
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.totalHours = 0; // เริ่มต้นที่ 0 ชั่วโมง
    }

    // Method for clocking in
    public void clockIn(String time) {
        this.clockInTime = LocalTime.parse(time); // แปลง String เป็น LocalTime
    }

    // Method for clocking out
    public void clockOut(String time) {
        LocalTime clockOutTime = LocalTime.parse(time);
        long minutesWorked = ChronoUnit.MINUTES.between(clockInTime, clockOutTime);
        int roundedHours = roundMinutesToHours((int) minutesWorked);
        this.totalHours += roundedHours; // เพิ่มชั่วโมงการทำงานรวม
    }

    // Rounding minutes to hours
    private int roundMinutesToHours(int minutes) {
        if (minutes % 60 < 30) {
            return minutes / 60; // ตัดเศษทิ้ง
        } else {
            return (minutes / 60) + 1; // ปัดขึ้น
        }
    }

    // Calculate total pay
    public double calculatePay() {
        return totalHours * hourlyRate;
    }

    // Display employee details
    public void displayInfo() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Total Hours: " + totalHours);
        System.out.println("Total Pay: " + calculatePay());
    }

    public static void main(String[] args) {
        // สร้างออบเจกต์ Employee
        Employee emp1 = new Employee("E001", "John Doe", 65);

        // บันทึกเวลาเข้า-ออกงาน
        emp1.clockIn("09:15");
        emp1.clockOut("17:45"); // รวม 8 ชั่วโมง 30 นาที (ปัดเป็น 9 ชั่วโมง)

        // คำนวณเงินเดือนและแสดงผล
        emp1.displayInfo();
    }
}

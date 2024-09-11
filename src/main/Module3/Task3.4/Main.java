import java.io.*;
class Student implements Serializable {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Course implements Serializable {
    private String courseCode;
    private String courseName;
    private String instructor;

    public Course(String courseCode, String courseName, String instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}

class Enrollment implements Serializable {
    private Student student;
    private Course course;
    private String enrollmentDate;

    public Enrollment(Student student, Course course, String enrollmentDate) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "John Doe", 20);
        Course course = new Course("CS101", "Introduction to Java", "Dr. Smith");
        Enrollment enrollment = new Enrollment(student, course, "2023-11-17");

        serializeEnrollment(enrollment);

        Enrollment deserializedEnrollment = deserializeEnrollment();
        System.out.println("Deserialized Enrollment:");
        System.out.println("Student: " + deserializedEnrollment.getStudent().getName());
        System.out.println("Course: " + deserializedEnrollment.getCourse().getCourseName());
        System.out.println("Enrollment Date: " + deserializedEnrollment.getEnrollmentDate());
    }

    private static void serializeEnrollment(Enrollment enrollment) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("enrollments.ser"))) {
            oos.writeObject(enrollment);
            System.out.println("Enrollment serialized and saved to enrollments.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Enrollment deserializeEnrollment() {
        Enrollment enrollment = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("enrollments.ser"))) {
            enrollment = (Enrollment) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return enrollment;
    }
}
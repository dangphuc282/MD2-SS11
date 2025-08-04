import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    public String getName() {
        return name;
    }
    public double getGrade() {
        return grade;
    }

    public void display() {
        System.out.printf(  "| name : %20s | age : %5d | grade : %5f.2 |\n",name,age,grade);
    }
}
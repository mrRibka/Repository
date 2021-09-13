package org.example;
import java.util.Objects;

public final class Student {
    String name;
    int age;
    String group;

    public Student(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Override
    public boolean equals(Object object) {
        if (this ==object) return true;

        if (object instanceof Student){
            Student student = (Student) object;
            return (this.age == student.age &&
                    this.group.equals(student.group) &&
                    this.name.equals(student.name));
        }
        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, group);
    }

    public static void main(String[] args) {
        Student student1 = new Student("Egor",18,"KA-04");
        Student student2 = new Student("Egor",18,"KA-04");
        System.out.println(student1.equals(student2));
    }
}
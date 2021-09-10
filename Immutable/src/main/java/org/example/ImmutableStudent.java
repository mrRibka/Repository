package org.example;
import java.util.Date;

public final class ImmutableStudent {
    private final int age;
    private final String name;
    private final Date date;

    public ImmutableStudent(int age, String name, Date date) {
        this.age = age;
        this.name = name;
        this.date = date;
    }
    public int getAge(){
        return age;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return (Date)date.clone();
    }
}

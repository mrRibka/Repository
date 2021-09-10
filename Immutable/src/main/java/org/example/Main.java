package org.example;

import java.util.Date;

public class Main
{
    public static void main( String[] args )
    {
        ImmutableStudent student = new ImmutableStudent(18, "Egor", new Date());
        int i = student.getAge();
        String s = student.getName();
        Date d = student.getDate();
        i = 1;
        s = "Mike";
        d.setTime(0);
        System.out.println(student.getAge());
        System.out.println(student.getName());
        System.out.println(student.getDate());
    }
}

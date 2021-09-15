package org.example.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String firstName;
    private String lastName;
    private String patronymic;
    private Date dateOfBirth;
    private Date dateOfEmployment;
    private Department department;
    private Long salary;

    public String toString(){
        return "Name: " + this.lastName + " " +
                this.firstName + " " + this.patronymic
                + "/n Department: " + this.department + "/n";
    }
}

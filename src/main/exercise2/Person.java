package exercise2;

import java.time.LocalDate;

public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    public Person(String name, LocalDate birthday, int age, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.age = age;
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    int age;

    public int getAge() {
        return age;
    }

    public Sex getGender(){
        return gender;
    }

    public void printPerson() {
        System.out.println("Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                ", age=" + age +
                '}');
    }
}

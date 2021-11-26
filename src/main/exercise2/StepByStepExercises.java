package exercise2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StepByStepExercises {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(  "John", LocalDate.of(1980,1,1), 40, Person.Sex.MALE,  "john@xb.com" ));
        personList.add(new Person(  "Harold", LocalDate.of(1974,1,1), 47, Person.Sex.MALE,  "harold@xb.com" ));
        personList.add(new Person(  "Joss", LocalDate.of(1980,1,1), 39, Person.Sex.FEMALE,  "joss@xb.com" ));

        //printPersonsOlderThan(personList, 40);
        //printPersons(personList, p-> p.getAge() >= 39 && p.getGender().equals(Person.Sex.FEMALE) );
        printPersonsWithPredicate(personList, p-> p.getAge() >= 39 && p.getGender().equals(Person.Sex.FEMALE) );

    }

    public static void printPersonsOlderThan(List<Person> personList, int age) {
        for (Person p : personList) {
            if(p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    private static void printPersons(List<Person> personList, CheckPerson tester) {
        for (Person p : personList) {
            if(tester.test(p)) {
                p.printPerson();
            }
        }
    }

    private static void printPersonsWithPredicate(List<Person> personList, Predicate<Person> tester) {
        for (Person p : personList) {
            if(tester.test(p)) {
                p.printPerson();
            }
        }
    }



}

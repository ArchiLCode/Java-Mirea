package practice2;

import java.time.LocalDate;

public class Human {
    private String firstName;
    private String lastName;
    private int age;
    private int weight;
    private LocalDate birthDate;

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
        this.birthDate = birthDate;
        this.age = age;
    }

    public String getName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", birthDate=" + birthDate +
                '}';
    }
}

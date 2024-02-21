package practice2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Human> input = new ArrayList<>(); // Объявили пустой список студентов
        input.add(new Human(10, "Artem", "Logvinov", LocalDate.now(), 73));
        input.add(new Human(19, "Mark", "Solonchev", LocalDate.now(), 65));
        input.add(new Human(17, "Andrew", "Skalka", LocalDate.now(), 80));
        input.add(new Human(5, "Tyler", "Durden", LocalDate.now(), 78));
        input.add(new Human(40, "Robert", "Paulson", LocalDate.now(), 150)); // Добавили в список объекты класса Student

        input = input.stream()
                .sorted(Comparator.comparingInt(Human::getAge)) // Сортировка по возрасту
                .filter(student -> student.getAge() < 20) // Фильтрация по возрасту < 20
                .filter(student -> student.getName().contains("e"))
                .toList(); // Фильтрация по содержанию буквы "е" в имени

        input.forEach(System.out::println);

        String result = input.stream()
                .map(student -> String.valueOf(student.getName().charAt(0))) // Получаем первую букву имени каждого студента
                .collect(Collectors.joining("")); // Соединяем буквы в строку

        System.out.println("Конкатенация первых букв имён: " + result);
    }
}

//Реализуйте структуру телефонной книги с помощью HashMap.
//        Программа также должна учитывать,
//        что в во входной структуре будут
//        повторяющиеся имена с разными телефонами,
//        их необходимо считать, как одного человека с разными телефонами.
//        Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class phoneBook {
    public static void main(String[] args) {

        HashMap<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Иван", "123456789");
        addContact(phoneBook, "Иван", "111222333");
        addContact(phoneBook, "Иван", "987654321");
        addContact(phoneBook, "Петр", "444555666");
        addContact(phoneBook, "Александр", "555555555");
        addContact(phoneBook, "Александр", "777888999");

        printBook(phoneBook);
    }

    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phone) {
        List<String> phones = phoneBook.getOrDefault(name, new ArrayList<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public static void printBook(HashMap<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> sortBook = new ArrayList<>(phoneBook.entrySet());
        sortBook.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

        for (Map.Entry<String, List<String>> entry : sortBook) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
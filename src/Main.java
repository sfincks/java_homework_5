import java.util.*;

public class Main {
    //Реализовать консольное приложение - телефонный справочник.
    //У одной фамилии может быть несколько номеров.
    //Пользователь может вводить команды:
    //1. ADD Ivanov 8 800 555 35 35 - добавить в справочник новое значение. Первый аргумент - фамилия, второй - номер телефона
    //2. GET Ivanov - получить список всех номеров по фамилии
    //3. REMOVE Ivanov - удалить все номера по фамилии
    //4. LIST - Посмотреть все записи
    //5. EXIT - Завершить программу
    //Если при GET или REMOVE нужной фамилии нет, вывести информацию об этом
    //
    //Пример взаимодействия (=> - это вывод на консоль):
    //ADD Ivanov 8 800 555 35 35
    //ADD Ivanov 8 800 100 10 10
    //GET Ivanov => [8 800 555 35 35, 8 800 100 10 10]
    //ADD Petrov 8 555 12 34
    //LIST => Ivanov = [8 800 5553535, 8 800 100 10 10], Petrov = [8 555 12 34]
    //REMOVE Ivanov
    //LIST => Petrov = [8 555 12 34]
    //GET NoName => Не найдена запись с фамилией "NoName"
    //REMOVE NoName => Не найдена запись с фамилией "NoName"
    public static void main(String[] args) {
        HashMap<String, List<String>> phonebook = new HashMap<>();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.contains("ADD")) {
                String[] contact = command.split("\\s++", 3);
                String name = contact[1];
                String number = contact[2];
//                System.out.println(name + " " + number);
                if (!phonebook.containsKey(name)) {
                    phonebook.put(name, new ArrayList<>(Arrays.asList(number)));
                    System.out.println("Контакт " + name + " - " + number + " был добавлен");
                } else {
                    List<String> value = phonebook.get(name);
                    value.add(number);
                    phonebook.put(name, value);
                    System.out.println("Номер " + number + " был добавлен в контакт " + name);
                }
            } else if (command.contains("GET")) {
                String[] getcontact = command.split(" ");
                if (!phonebook.containsKey(getcontact[1])) {
                    System.out.println("Не найдена запись с фамилией " + getcontact[1]);
                } else {
                    System.out.println(phonebook.get(getcontact[1]));
                }
            } else if (command.contains("REMOVE")) {
                String[] removecontact = command.split(" ");
                if (!phonebook.containsKey(removecontact[1])) {
                    System.out.println("Не найдена запись с фамилией " + removecontact[1]);
                }else {
                    phonebook.remove(removecontact[1]);
                    System.out.println("Контакт " + removecontact[1] + " был удалён");
                }
            } else if (command.contains("LIST")) {
                System.out.println(phonebook);
//                Set<Map.Entry<String, String>> entries = phonebook.entrySet();
//                for (Map.Entry<String, String> entry : entries) {
//                    String key = entry.getKey();
//                    String value = entry.getValue();
            } else if ("EXIT".equals(command)) {
                System.exit(0);
            } else {
                System.out.println("Введена неверная команда");
            }

        }

    }
}

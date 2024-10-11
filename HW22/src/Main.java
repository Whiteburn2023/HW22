import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<String> todos = new ArrayList<>();
    private static String input = "";
    private static int index = -1;
    private static String todo = "";

    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите команду и дело для записи: ");
            System.out.println("Добавить \n" + "Печать \n" + "Изменить \n" + "Удалить \n");
            input = new Scanner(System.in).nextLine().trim();
            index = -1;
            todo = "";

            String[] words1 = input.split(" ");
            String command = words1[0];
                if ((words1.length > 1) && containsDigit(words1[1])) {
                    index = Integer.parseInt(words1[1]);
                    //todo = input.substring(input.indexOf(' '));
                    for (int i = 2; i < words1.length; i++) {
                        todo += words1[i] + " ";
                    }
                } else {
                    //todo = input.substring(input.indexOf(' ')).trim();
                    for (int i = 1; i < words1.length; i++) {
                        todo += words1[i] + " ";
                    }
                }

                switch (command) {
                    case "Добавить" -> {
                        if (index > -1) {
                            add(index, todo);
                        } else {
                            add(todo);
                        }
                    }
                    case "Печать" -> printAll();
                    case "Изменить" -> change(index, todo);
                    case "Удалить" -> delete(index);
                }
        }
    }

        public static boolean containsDigit (String str){
            return str.matches(".*\\d.*");
        }

        private static void change (Integer index, String sub){
            todos.set(index, sub);
        }
        //todo для выполнения дз создавать классы не нужно. Просто создавайте
        // необходимые вам методы и переменные. Основная логика программы будет в методе main
        //1. Добавление дела в конец списка дел.
        //2. Добавление дела на указанное место в списке.
        // Если такого места нет (допустим в списке 3 дела, а хотим добавить на 10)
        // то дело должно быть добавлено в конец списка.
        //3. Удаление дела по его номеру. Если такого номера в списке нет, ничего не удалять.
        //4. Изменение дела по заданному номеру.
        //5. Печать всех дел.

        public static void add (String todo){
            if (todos.contains(todo)) {
                System.out.println("Дело " + todo + " уже есть в списке");
                return;
            }
            todos.add(todo);
            System.out.println("Дело " + todo + " успешно добавлено");
        }

        public static void add (Integer index, String todo){
            if (todos.contains(todo)) {
                System.out.println("Дело " + todo + " уже есть в списке");
                return;
            }
            if (index > todos.size()){
                todos.add(todo);
                System.out.println("Нет места под номером " + index);
                System.out.println("Дело " + todo + " добавлено в конец списка");
                return;
            }
            todos.add(index, todo);
            System.out.println("Дело " + todo + " успешно добавлено");
        }

        public static void delete (Integer index){
            if (!checkIndex(index)) {
                System.out.println("Нет такого индекса");
                return;
            }
            String todo = todos.get(index);
            todos.remove(todo);
            System.out.println("Дело - " + todo + " - успешно удалено");
        }

        private static boolean checkIndex (Integer index){
            return todos.size() > index;
        }

        public static void printAll () {
            for (String todo : todos) {
                System.out.println(todo);
            }
        }

        public static void printByIndex (Integer index){
            if (!checkIndex(index)) {
                System.out.println("Нет такого индекса");
                return;

            }
            System.out.println("Дело под индексом " + index + ": " + todos.get(index) + " успешно добавлено");


        }


    }

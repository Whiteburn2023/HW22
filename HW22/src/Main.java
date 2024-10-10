import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<String> todos = new ArrayList<>();

    public static void main(String[] args) {
        //while(true) {
            //System.out.println("Введите дело для записи: ");
            //String todo = new Scanner(System.in).nextLine().trim();
            todos.add("купить молока");
            todos.add("купить колбасы");
            todos.add("купить курсы джава у инфоцыган");
            todos.add("купить кирпич");
            todos.add("купить апельсин");

            add("что-то сделать");
            //delete(3);
            //printByIndex(3);
            printAll();


            //add(todo);
            //todo

        //}
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




        public static void add(String todo) {
            if (todos.contains(todo))  {
                System.out.println("Дело " + todo + " уже есть в списке");
                return;
            }
            todos.add(todo);
            System.out.println("Дело " + todo + " успешно добавлено");
        }

        public static void delete(Integer index){
            if (!checkIndex(index)) {
                System.out.println("Нет такого индекса");
                return;
            }
            String todo = todos.get(index);
            todos.remove(todo);
            System.out.println("Дело - " + todo + " - успешно удалено");
        }

        private static boolean checkIndex(Integer index) {
            return todos.size() > index;
        }

    public static void printAll(){
            for (String todo : todos) {
                System.out.println(todo);
            }
        }

        public static void printByIndex(Integer index){
            if (!checkIndex(index)) {
                System.out.println("Нет такого индекса");
                return;

            }
            System.out.println("Дело под индексом " + index + ": " + todos.get(index)+ " успешно добавлено");


        }



}
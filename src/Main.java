import java.security.AlgorithmParameterGenerator;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        task123();
        task4();
        task5();
        task6();
        task7();
    }

    public static void task123() {
        //Задание 1
        String firstName = "Ivan";
        String middleName = "Ivanovich";
        String lastName = "Ivanov";
        String fullName = lastName + " " + firstName + " " + middleName;
        System.out.println("ФИО сотрудника — " + fullName);

        //Задание 2
        fullName = fullName.toUpperCase();
        System.out.println("Данные ФИО сотрудника для заполнения отчета — " + fullName);

        //Задание 3
        fullName = "Иванов Семён Семёнович";
        fullName = fullName.replace("ё", "е");
        System.out.println("Данные ФИО сотрудника — " + fullName);

    }

    public static void task4() {
        /*

        К нам снова обратились за помощью, но теперь уже для того, чтобы написать алгоритм,
        разбивающий одну строку с Ф. И. О. на три — на фамилию, имя и отчество.
        В качестве исходных данных используйте:
        Ф. И. О. сотрудника: “Ivanov Ivan Ivanovich”;
        строка fullName — для хранения Ф. И. О. сотрудника в формате фамилия - имя - отчество;
        переменная firstName — для хранения имени;
        переменная middleName — для хранения отчества;
        переменная lastName — для хранения фамилии.
        Решите задание с помощью метода substring().
        Результат программы выведите в формате:
        “Имя сотрудника — …”
        “Фамилия сотрудника — …”
        “Отчество сотрудника — ...”
         */
        String fullName = "Ivanov Ivan Ivanovich";
        int positionFirstSpace = fullName.indexOf(" "); //позиция первого пробела
        int positionLastSpace = fullName.lastIndexOf(" "); //позиция второго пробела

        String lastName = fullName.substring(0, positionFirstSpace);
        String firstName = fullName.substring(positionFirstSpace+1, positionLastSpace);
        String middleName = fullName.substring(positionLastSpace+1, fullName.length());

        System.out.println("Имя сотрудника - " + firstName);
        System.out.println("Фамилия сотрудника — " + lastName);
        System.out.println("Отчество сотрудника — " + middleName);

    }

    public static void task5() {
    /*
    Периодически данные в наших регистрах заполняются неверно, и
     Ф. И. О. сотрудников записывают со строчных букв.
    Такую оплошность нужно исправить, написав программу,
    которая преобразует написанное со строчных букв Ф. И. О. в правильный формат.
    В качестве исходных данных используйте строку fullName c
    данными “ivanov ivan ivanovich“, которые нужно преобразовать в “Ivanov Ivan Ivanovich”.
    Выведите результат программы в консоль в формате: “Верное написание Ф. И. О. сотрудника с заглавных букв — …”
    :sos: Подсказка 1
    Метод toCharArray() может быть полезен.
    :sos: Подсказка 2
    Для преобразования символа в верхний регистр следует использовать метод Character.toUpperCase(c), где c — символ.
     */
        String fullName = "ivanov ivan ivanovich";

        int positionFirstSpace = fullName.indexOf(" "); //позиция первого пробела
        int positionLastSpace = fullName.lastIndexOf(" "); //позиция второго пробела

        String lastName = fullName.substring(0, positionFirstSpace);
        String firstName = fullName.substring(positionFirstSpace+1, positionLastSpace);
        String middleName = fullName.substring(positionLastSpace+1, fullName.length());
        lastName = ConvertFirstSymbol(lastName);
        firstName = ConvertFirstSymbol(firstName);
        middleName = ConvertFirstSymbol(middleName);

        System.out.printf("Верное написание Ф. И. О. сотрудника с заглавных букв — %s %s %s ",lastName, firstName, middleName  );
        System.out.println("");
    }

    public static void task6() {
    /*
    Имеется две строки.
    Первая: "135"
    Вторая: "246"
    Соберите из двух строк одну, содержащую данные "123456".
    Использовать сортировку нельзя.
    Набор чисел задан для понимания позиций, которые они должны занять в итоговой строке.
    Выведите результат в консоль в формате: “Данные строки — ….”
    :sos: Подсказка
    Следует использовать StringBuilder.
    Критерии оценки
    – Применен метод, меняющий написание данных строки.
    – При изменении содержания строки результат программы выполняется.
    – Результат программы выведен в консоль согласно условиям задачи.
     */
        StringBuilder firstString = new StringBuilder("135");

        StringBuilder secondString = new StringBuilder("246");
        int position = 1;
        for (int i = 0; i < secondString.length(); i++) {
             char c = secondString.charAt(i);
             firstString.insert(position, c);
             position+=2;
        }
        System.out.println(firstString);
    }

    public static void task7() {
        /*
        Дана строка из букв английского алфавита "aabccddefgghiijjkk".
        Нужно найти и напечатать буквы, которые дублируются в строке.
        Обратите внимание, что строка отсортирована, т. е. дубли идут друг за другом.
        В итоге в консоль должен быть выведен результат программы: "acdgijk".
         */
        String Alphabet = "aabccddefgghiijjkk";
        char lastSymbol = Alphabet.charAt(0);
        for (int i = 1; i < Alphabet.length(); i++) {
          char symbol = Alphabet.charAt(i);
            if (lastSymbol == symbol) {
                System.out.print(symbol);
            }
            lastSymbol = symbol;
        }


    }

    public static String ConvertFirstSymbol(String partName) {
        char[] c = partName.toCharArray();
        c[0] = Character.toUpperCase(c[0]);
        partName = Arrays.toString(c);
        partName = partName.replace(",", "");
        partName = partName.replace("[", "");
        partName = partName.replace("]", "");
        partName = partName.replace(" ", "");
       // System.out.println("lastName = " + partName);
        return partName;
    }

}
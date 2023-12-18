package src.Lab04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Exercise1();
        Exercise2();
        Exercise3();
        Exercise4();
        Exercise5();
    }

    private static void Exercise1(){
        Scanner scanner = new Scanner(System.in);
        int res = 0;//Номер самой длинной стоки
        String[] str = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.printf("Упражнение 1. Введите строку №%d: ", i+1);
            str[i] = scanner.nextLine();
            if (str[res].length() < str[i].length()) res = i;
        }
        System.out.printf("Самая длинная строка под номером: %d\n", res + 1);
    }
    private static void Exercise2(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Упражнение 2. Введите слово: ");
        String word = scanner.nextLine();
        //Создаем StringBuilder и переворачиваем слово
        StringBuilder sb = new StringBuilder(word);
        sb.reverse();
        if (word.equals(sb.toString())) System.out.printf("Слово \"%s\" полиндром!\n", word);
        else System.out.printf("Слово \"%s\" не полиндром.\n", word);
    }
    private static void Exercise3(){
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Упражнение 3. Введите строку: ");
        String str = scanner.nextLine();
        //Создаем из строки массив слов
        String[] arrayWord = str.split(" ");
        //Перебираем слова в массиве
        for (String word : arrayWord) {
            //Если нашли запретное слово заменяем его и добавляем в StringBuilder
            if(word.equals("бяка")  || word.equals("Бяка")) sb.append(" [вырезано цензурой]");
                //Иначе копируем слова из массива без изменений
            else sb.append(String.format(" %s", word));
        }
        //Если слово было замено в начале то убираем пробел
        System.out.println(sb.replace(0,1,""));
    }
    private static void Exercise4(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Упражнение 4. Введите основную строку: ");
        String str = scanner.nextLine();
        System.out.print("Введите подстроку для поиска: ");
        String subStr = scanner.nextLine();

        //Создаем массив символов из исходной строки
        char[] strChar = str.toCharArray();
        //Строка сравнения
        String strComparison;
        int count = 0;

        //Идем по символам
        for (int i = 0; i < strChar.length; i++) {
            //Сравнивая каждый с первым символом подстроки
            if(strChar[i] == subStr.charAt(0)) {
                //Если находим похожий символ то записываем в строку сравнения подстроку из исходной строки
                strComparison = str.substring(i, i + subStr.length());
                //Сравниваем строку сравнения с искомой подстрокой и прибавляем счетчик
                if (strComparison.equals(subStr)) count++;
            }
        }
        System.out.printf("В веденной Вами строке найдено вхождений: %d\n", count);

    }
    private static void Exercise5(){
        //Создаем вспомогательный StringBuilder
        StringBuilder sbRevers = new StringBuilder();
        StringBuilder finalWordSB = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Упражнение 5. Введите строку: ");
        String str = scanner.nextLine();
        //Создаем массив слов из строки
        String[] arrayWord = str.split(" ");
        for (String word : arrayWord) {
            //Очищаем StringBuilder
            sbRevers.setLength(0);
            //Добавляем в финальный StringBuilder слово перевернутое с помощью метода вспомогательного StringBuilder-ра
            finalWordSB.append(String.format(" %s",sbRevers.append(word).reverse()));
        }
        System.out.println(finalWordSB.replace(0,1,""));
    }
}

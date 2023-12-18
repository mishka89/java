package src.Lab01;

import java.util.Scanner;

public class Main {

    private static boolean flag = false;

    public static void main(String[] args) {
        Exercise1();
        Exercise2();
        Exercise3();
        Exercise4();
        Exercise5();
        Exercise6();
        flag = true;
        Repeat();
    }

    private static void Exercise1() {
        System.out.println("Я");
        System.out.println("хорошо");
        System.out.println("знаю");
        System.out.println("Java.");
    }

    private static void Exercise2() {
        double res1 =(46+10) * 10/3.0;
        int res2 = 29 * 4 * (-15);
        System.out.printf("Упражнение 2:\n");
        System.out.printf("Результат первого выражения: %.3f\n", res1);
        System.out.printf("Результат второго выражения: %d\n", res2);
    }

    private static void Exercise3() {
        int number = 10500;
        System.out.printf("Упражнение 3: %d\n",(number / 10) / 10);
    }

    private static void Exercise4() {
        double x = 3.6, y = 4.1, z = 5.9;
        System.out.printf("Упражнение 4. Результат: %f\n",x*y*z);
    }

    private static void Exercise5() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Упражнение 5. Введите число: ");
        int number = scanner.nextInt();

        System.out.println("Спасибо! Вы ввели число " + number);

        if(flag) Repeat();
    }

    private static void Exercise6() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Упражнение 6. Введите число: ");
        int b = scanner.nextInt();
        if (b%2==0) {
            if (b>100)System.out.println("Выход за пределы диапазона");
            else System.out.println("Вы ввели четное число");
        }
        else System.out.println("Вы ввели нечетное число");

        if(flag) Repeat();
    }

    private static void Repeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число 5 или 6 чтобы вызвать соответствующие задание (Для выхода введите 0): ");
        int number = scanner.nextInt();
        switch (number) {
            case 5: Exercise5(); break;
            case 6: Exercise6(); break;
            case 0: System.exit(0);
            default: Repeat();
        }
    }
}
package src.Lab02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Exercise1();
        Exercise2();
        Exercise3();
        Exercise4();
        Exercise5();
        Exercise6();
    }

    private static int GetNumber(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void Exercise1() {
        System.out.println("Упражнение 1:");
        for (int i = 1; i < 100; i++) {
            if(i%2!=0) System.out.print(" " + i);
        }
        System.out.println("");
    }

    private static void Exercise2() {
        System.out.println("Упражнение 2:");
        //Создаем 3 листа
        List<Integer> divided3 = new ArrayList<>();
        List<Integer> divided5 = new ArrayList<>();
        List<Integer> divided3And5 = new ArrayList<>();
        for (int i = 1; i <= 100 ; i++) {
            //Проверяем и записываем в соответствующие листы
            if (i%3 == 0) divided3.add(i);
            if (i%5 == 0) divided5.add(i);
            if (i%3 == 0 && i%5==0) divided3And5.add(i);
        }
        //Выводим в консоль
        System.out.print("Делится на 3: \t\t ");
        for (Object i : divided3) {
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.print("Делится на 5: \t\t ");
        for (Object i : divided5) {
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.print("Делится на 3 и на 5: ");
        for (Object i : divided3And5) {
            System.out.print(" " + i);
        }
        System.out.println("");
    }

    private static void Exercise3() {
        System.out.println("Упражнение 3:");
        System.out.print("Введите первое число: ");
        int numberOne = GetNumber();
        System.out.print("Введите второе число: ");
        int numberTwo = GetNumber();
        System.out.print("Введите третье число: ");
        int numberThree = GetNumber();

        if (numberOne + numberTwo == numberThree) System.out.println("Сумма первых двух чисел равна третьему.");
        else System.out.println("Сумма первых двух чисел НЕ равна третьему.");
    }

    private static void Exercise4(){
        System.out.print("Упражнение 4. Введите первое число: ");
        int numberOne = GetNumber();
        System.out.print("Введите второе число: ");
        int numberTwo = GetNumber();
        System.out.print("Введите третье число: ");
        int numberThree = GetNumber();

        boolean res = false;
        if(numberOne < numberTwo && numberTwo < numberThree) res = true;

        System.out.println("Результат: " + res);
    }

    private static void Exercise5() {
        int[] array = new int[5];
        boolean res = false;
        System.out.println("Упражнение 5. Пожалуйста, заполните массив 5-ю цифрами:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Число " + (i+1) + ": ");
            array[i] = GetNumber();
        }
        if (array[0] == 3 || array[4] == 3) res = true;

        System.out.println("Результат: " + res);
    }

    private static void Exercise6() {
        int[] array = new int[5];
        boolean res = false;
        System.out.println("Упражнение 6. Пожалуйста, заполните массив 5-ю цифрами:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Число " + (i+1) + ": ");
            array[i] = GetNumber();
        }
        for (int i: array) {
            if (i == 1 || i == 3) res = true;
        }

        System.out.println("Результат: " + res);
    }
}
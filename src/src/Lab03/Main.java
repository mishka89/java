package src.Lab03;

import java.util.Arrays;
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

    private static int[] GetArray(int size){
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[size];
        System.out.println(String.format("Пожалуйста, заполните массив %d цифрами:", size));
        for (int i = 0; i < size; i++) {
            System.out.print("Число " + (i+1) + ": ");
            array[i] = scanner.nextInt();
        }
        return array;
    }
    //Метод сортировки
    public static int[] SortMerge(int[] array) {
        //Массив для перемещения массивов местами
        int[] arrayTemp;
        //Массив источник
        int[] arraySource = array;
        //Массив приемник
        int[] arrayContainer = new int[array.length];

        //Размер сливаемых подмассивов
        int size = 1;

        //Пока размер сливаемых подмассивов меньше чем размер самого сортируемого массива
        //Алгоритм проходит с помощью цикла по парам масивов состоящих из подмасивов сортируемого массива
        //и вызываем метод merge который сравнивает и сливает подмассивы
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                Merge(arraySource, i, arraySource, i + size, arrayContainer, i, size);
            }
            //Меняем местами массив Приемник и массив Источник
            arrayTemp = arraySource;
            arraySource  = arrayContainer;
            arrayContainer = arrayTemp;
            //Умножаем размер подмассива. Увеличиваем в степень двойки.
            size *= 2;
            //System.out.println("Подмасивы размером: " + size);
            //System.out.println(Arrays.toString(arraySource));
        }
        return arraySource;
    }
    //Метод слияния
    //partArrayX - первый массив для слияния || arrayXindexStart, arrayYindexStart - индекс элемента массива с которого нужно начинать слияние
    //partArrayY - Второй массив для слияния || arrayContainer - массив приемник || size - размеры подмассивов
    private static void Merge(int[] partArrayX, int arrayXindexStart, int[] partArrayY, int arrayYindexStart, int[] arrayContainer, int arrayCindexStart, int size) {
        int indexX = arrayXindexStart;
        int indexY = arrayYindexStart;
        //Вычесляем размер подмассива находящегося в Основном массиве
        int arrayXindexEnd= Math.min(arrayXindexStart + size, partArrayX.length);
        int arrayYindexEnd = Math.min(arrayYindexStart + size, partArrayY.length);

        //Закидываем в массив приемник хвосты
        if (arrayXindexStart + size > partArrayX.length) {
            for (int i = arrayXindexStart; i < arrayXindexEnd; i++) {
                arrayContainer[i] = partArrayX[i];
            }
            return;
        }

        int iterationCount = arrayXindexEnd - arrayXindexStart + arrayYindexEnd - arrayYindexStart;

        for (int i = arrayCindexStart; i < arrayCindexStart + iterationCount; i++) {
            //(Если массив Х не закончился и (массив У закончился или элемент массива Х меньше элемента в массиве У))
            // то записываем элемент в массив приемник
            //Иначе записываем элемент У в массив приемник
            if (indexX < arrayXindexEnd && (indexY >= arrayYindexEnd || partArrayX[indexX] < partArrayY[indexY])) {
                arrayContainer[i] = partArrayX[indexX];
                indexX++;
            } else {
                arrayContainer[i] = partArrayY[indexY];
                indexY++;
            }
        }
    }

    private static void Exercise1() {
        Scanner scanner = new Scanner(System.in);
        int sizeArray;
        System.out.print("Упражнение 1. Введите размер массива: ");
        sizeArray = scanner.nextInt();
        int[] array =  GetArray(sizeArray);
        //Клонируем массив для дальнейшей сортировки и сравнения
        int[] arraySort = array.clone();

        if(Arrays.equals(array,SortMerge(arraySort))) System.out.println("Ваш массив в отсартированном виде!");
        else System.out.println("Ваш массив НЕ в отсартированном виде!");
    }

    private static void Exercise2() {
        Scanner scanner = new Scanner(System.in);
        int sizeArray;
        System.out.print("Упражнение 2. Введите размер массива: ");
        sizeArray = scanner.nextInt();
        System.out.println("У вас получился массив: " + Arrays.toString(GetArray(sizeArray)));
    }

    private static void Exercise3() {
        int[] arrayA = {1, 21, 43, 12, 84, 62};
        System.out.println("Упражнение 3. Имеется массив A: " + Arrays.toString(arrayA));
        //Создаем массив Б с вычесляемым размером зависимым от размера массива А
        int[] arrayB = new int[arrayA.length];
        //Меняем местами первый и последний элемент массива
        arrayB[0] = arrayA[arrayA.length-1];
        arrayB[arrayB.length-1] = arrayA[0];
        //Заполняем оставшиеся элементы массива
        System.arraycopy(arrayA, 1, arrayB, 1, arrayB.length - 1 - 1);
        System.out.println("Из которого мы получаем массив B: " + Arrays.toString(arrayB));
    }

    private static void Exercise4() {
        Scanner scanner = new Scanner(System.in);
        int sizeArray;
        System.out.print("Упражнение 4. Введите размер массива: ");
        sizeArray = scanner.nextInt();
        int[] array = GetArray(sizeArray).clone();
        System.out.print("Уникальное число в массива: ");
        for (int i = 0; i < array.length; i++) {
            int count = 0; //Счетчик кол-ва повторений числа в массиве
            //Берем число в массиве. Далее проходимся по массиву и сравниваем его с другими числами. Не беря в учет позицию этого числа.
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] && j!=i) count++;
            }//Если число найдено завершаем работу метода
            if(count<1){
                System.out.print(array[i] + "\n");
                return;
            }
        }
        System.out.print("Не найдено!\n");
    }

    private static void Exercise5() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Упражнение 5. Введите число n: ");
        int n = scanner.nextInt();
        int res, n0 = 0, n1 = 1;
        if (n < 0) System.out.println("Число Фибоначи: Не рассчитано!");
        else {
            if (n == 0) System.out.printf("Число Фибоначи: %d", n0);
            else System.out.printf("Число Фибоначи: %d, %d", n0, n1);
            for (int i = 2; i <= n; i++) {
                //Складываем два придыдущих числа
                res = n0 + n1;
                //Присваиваем Fₙ₋₂
                n0 = n1;
                //Присваиваем Fₙ₋₁
                n1 = res;
                System.out.printf(", %d", res);
            }
            System.out.println();
        }
    }

    private static void Exercise6() {
        Scanner scanner = new Scanner(System.in);
        int sizeArray;
        System.out.print("Упражнение 6. Введите размер массива: ");
        sizeArray = scanner.nextInt();
        System.out.println("Получаем отсортированный массив: " + Arrays.toString(SortMerge(GetArray(sizeArray))));
    }
}
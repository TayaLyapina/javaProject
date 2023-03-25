package lesson1.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;




/*
1. Задать одномерный массив и найти в нем минимальный и максимальный элементы
.

2. Дан массив nums = [3,2,2,3] и число val = 3.
Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.
.

3*. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
"Доброе утро, <Имя>!", если время от 05:00 до 11:59
"Добрый день, <Имя>!", если время от 12:00 до 17:59;
"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
"Доброй ночи, <Имя>!", если время от 23:00 до 4:59
 */
public class MainClassFromHomeworkLessonOne {
    public static void main(String[] args)  {
        MinMaxFromArray(10);
        sortArrValThree();
        greetingDependingOnTheTimeOfDay();
    }

    private static void MinMaxFromArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(101); // 0-100
        }
        int maxNumber = 0;
        int minNumber = 100;
        for (int num : arr) {
            if (num < minNumber) {
                minNumber = num;
            } else if (num > maxNumber) {
                maxNumber = num;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.printf("Максимальный элемент = %s%n", maxNumber);
        System.out.printf("Минимальный элемент = %s%n", minNumber);
    }

    private static void sortArrValThree() {
        int[] nums = new int[] {3,2,2,3};
        int val = 3;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[right] == val)
                right--;
            if (nums[left] == val){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            left++;
        }
        System.out.println(Arrays.toString(nums));

    }

    private static void greetingDependingOnTheTimeOfDay() {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        java.time.LocalTime time = java.time.LocalTime.now();
        java.time.LocalTime five = java.time.LocalTime.of(5, 0);
        java.time.LocalTime twelve = java.time.LocalTime.of(12, 0);
        java.time.LocalTime eighteen = java.time.LocalTime.of(18, 0);
        java.time.LocalTime twentyThree = java.time.LocalTime.of(23, 0);


        if (time.isAfter(five) && time.isBefore(twelve)) {
            System.out.printf("Доброе утро, %s%n", name);
        } else if (time.isAfter(twelve) && time.isBefore(eighteen)) {
            System.out.printf("Добрый день, %s%n", name);
        } else if (time.isAfter(eighteen) && time.isBefore(twentyThree)) {
            System.out.printf("Добрый вечер, %s%n", name);
        } else {
            System.out.printf("Доброй ночи, %s%n", name);
        }
    }
}


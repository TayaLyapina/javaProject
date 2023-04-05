package lesson4.homework4;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;

public class MainClassFromHomeworkLessonFour {
    /*1. Реализовать консольное приложение, которое:
Принимает от пользователя и “запоминает” строки.
Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
Если введено revert, удаляет предыдущую введенную строку из памяти.

2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
     */

    public static void main(String[] args) {
        //consoleApplication();
        //reverseLinkedList();
        consoleApplicationCatsVarTwo();
    }

    private static void reverseLinkedList() {
        LinkedList<String> wordsList = new LinkedList<>();
        Collections.addAll(wordsList, "apple", "orange", "banana", "tomato", "strawberry", "melon");
        System.out.println("LinkedList:" + wordsList);
        for (int i = wordsList.size()-1; i >= 0; i--) {
            System.out.printf("%s%n", wordsList.get(i));
        }
    }

    private static void consoleApplication() {
        Scanner in = new Scanner(System.in);
        Stack<String> nameCats = new Stack<>();
        Collections.addAll(nameCats, "пушок", "клёпа", "басёна", "люська");
        

        while (true) {
            System.out.println();
            System.out.print("Введите строку(имя котика): ");
            String inputName = in.nextLine();
            if (inputName.length() == 0) {
                System.out.println("Строка не должна быть пустой");
                continue;
            }
            if (inputName.equalsIgnoreCase("киска брысь")) {
                break;
            }

            if (inputName.equals("print")) {
                printAllCats(nameCats);
                continue;
            }
            if (inputName.equals("revert")) {
                try {
                    System.out.println("Отпускаем: " + nameCats.pop());
                } catch (Exception e) {
                    System.out.println("Нет котиков");
                    continue;
                }
            }
            if (!inputName.equals("revert") || inputName.equals("print")) {
                nameCats.add(inputName);
            }
        }

    }
    private static void printAllCats(Stack<String> nameCats) {
        if (nameCats.size() > 0){
            for (int i = 0; i < nameCats.size(); i++) {
                System.out.printf("%s%n", nameCats.get(i));
            }
        } else {
            System.out.println("Нет котиков");
        }

    }

    private static void consoleApplicationCatsVarTwo() {
        Scanner in = new Scanner(System.in);
        LinkedList<String> nameCats = new LinkedList<>();
        Collections.addAll(nameCats, "пушок", "клёпа", "басёна", "люська");
        while (true) {
            System.out.println();
            System.out.print("Введите строку(имя котика): ");
            String inputName = in.nextLine();
            if (inputName.length() == 0) {
                System.out.println("Строка не должна быть пустой");
                continue;
            }
            if (inputName.equalsIgnoreCase("киска брысь")) {
                break;
            }

            if (inputName.equals("print")) {
                printAllCatsNew(nameCats);
                continue;
            }
            if (inputName.equals("revert")) {
                try {
                    System.out.println("Отпускаем: " + nameCats.pop()); //nameCats.remove(nameCats.get(nameCats.size()-1))
                } catch (Exception e) {
                    System.out.println("Нет котиков");
                    continue;
                }
            }
            if (!inputName.equals("revert") || inputName.equals("print")) {
                nameCats.push(inputName);
            }
        }
    }
    private static void printAllCatsNew(LinkedList<String> nameCats) {
        if (nameCats.size() > 0){
            for (int i = nameCats.size()-1; i >= 0; i--) {
                System.out.printf("%s%n", nameCats.get(i));
            }
        } else {
            System.out.println("Нет котиков");
        }

    }
}



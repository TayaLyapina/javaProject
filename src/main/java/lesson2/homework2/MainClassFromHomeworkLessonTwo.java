package lesson2.homework2;


/*
1. Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает
boolean значение).

2. Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод, который запишет эту
строку в простой текстовый файл, обработайте исключения.

3*.Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида:
        1 Расширение файла: txt
        2 Расширение файла: pdf
        3 Расширение файла:
        4 Расширение файла: jpg
 */

import java.io.*;
import java.util.Scanner;

public class MainClassFromHomeworkLessonTwo {
        public static void main(String[] args) {
                //Palindrome();
                //oneHundredRepetitionsTest("C:\\Users\\user\\Desktop\\GB\\java\\project\\src\\main\\resources\\files\\test.txt");
                getTypeOfFiles("C:\\Users\\user\\Desktop\\GB\\java\\project\\.idea");
        }


        public static void Palindrome() {
                Scanner scanner = new Scanner(System.in);
                String str = scanner.nextLine().replaceAll("[^a-za-я0-9]", "");
                System.out.println(isPalindrome(str));}
        private static boolean isPalindrome(String str) {
                for (int i = 0; i < str.length() / 2; ++i) {
                        if (str.toLowerCase().charAt(i) != str.toLowerCase().charAt(str.length() - i - 1)) {
                                return false;
                        }
                }
                return true;
        }

        public static void oneHundredRepetitionsTest(String pathDir) {
                String t = "TEST";
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < 100; i++) {
                        res.append(t).append(System.lineSeparator());
                }
                try(PrintWriter pw = new PrintWriter("C:\\Users\\user\\Desktop\\GB\\java\\project\\src\\main\\resources\\files\\test.txt");) {
                        pw.print(res);
                } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                }
        }

        public static void getTypeOfFiles(String pathDir) {
                File file = new File(pathDir);
                if (!file.isDirectory()) return;

                String [] dirListNames = file.list();
                StringBuilder sb = new StringBuilder();
                int count = 0;
                for (String fileName : dirListNames) {
                        count ++;
                        sb.append(count).append(" Расширение файла: ");
                        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
                                sb.append(fileName.substring(fileName.lastIndexOf(".")+1)).append(System.lineSeparator());
                        else sb.append("").append(System.lineSeparator());
                }
                System.out.println(String.valueOf(sb));

        }

}

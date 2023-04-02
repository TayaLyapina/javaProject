package lesson3.homework3;

/*1. Пусть дан произвольный список целых чисел, удалить из него четные числа (в языке уже есть что-то
готовое для этого)

2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.

3. Доделать начатое на семинаре. Пройтись по списку из задания 2 и удалить повторяющиеся элементы.

4*. Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа.
Пройти по списку, найти и удалить целые числа. */

import java.util.ConcurrentModificationException;
import java.util.*;
import java.util.stream.Collectors;

public class MainClassFromHomeworkLessonThree {
    public static void main(String[] args) {
        //removeEvenNumbers();
        //getMinMaxAverFromList();
        //ex2();  // Доделать начатое на семинаре.
        //removeWholeNumbers();
        removeWholeNumbersVarTwo();

    }

    private static void removeEvenNumbers() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            list.add(random.nextInt(20));
        }
        System.out.println(list);

        List<Integer> listWithoutEven = list.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());

        System.out.println(listWithoutEven);

    }

    private static void getMinMaxAverFromList() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            list.add(random.nextInt(20));
        }

        System.out.println(list);
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));

        double avg = list.stream().mapToInt(a -> a).average().orElse(0);
        System.out.println(avg);

    } public static void ex2() {
        List<String> list = new ArrayList<>();
        Random random = new Random();
        String [] planet = new String[] {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptun", "Pluto"};
        for (int i = 0; i < 30; i++) {
            list.add(planet[random.nextInt(9)]);
        }

        System.out.println(list);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        StringBuilder res = new StringBuilder();

        int count = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            if(list.get(i).equals(list.get(i+1))) {
                count++;
            } else {
                res.append(list.get(i)).append(" : ").append(count).append("; ");
                count = 1;
            }
        }

        res.append(list.get(list.size() - 1)).append(" : ").append(count).append(".");
        System.out.println(res);

        List<String> listWithoutDuplicates = list.stream()
                .collect(Collectors.toSet())
                .stream()
                .collect(Collectors.toList());

        System.out.println(listWithoutDuplicates);
    }

    private static void removeWholeNumbers() {
        List<String> list = new ArrayList<>(Arrays.asList("b", "15", "s", "w", "6", "0", "a"));
        StringBuilder res = new StringBuilder();

        for (String s : list) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                res.append(s).append(" ");
            }
        }
        System.out.println(res);

    }
    private static void removeWholeNumbersVarTwo() {
        List<String> list = new ArrayList<>(Arrays.asList("b", "15", "s", "w", "6", "0", "a"));
        List<String> listWithoutNumbers = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            try {
                Integer.parseInt(list.get(i));
            } catch (NumberFormatException e) {
                listWithoutNumbers.add(list.get(i));
            }
        }
        System.out.println(listWithoutNumbers);

    }
}

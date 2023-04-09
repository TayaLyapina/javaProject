package lesson5.homework5;
import java.util.Map;
import java.util.HashMap;
import java.util.*;
import java.util.Comparator;

public class MainClassFromHomeworkLessonFive {
    public static void main(String[] args) {
        makePhoneBookStructure();
        //sortDuplicateNames();
        //fromArabicToRoman();
    }

    private static void fromArabicToRoman() {
        /*3***. Написать метод, который переведёт данное целое число в римский формат.*/
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String roman = intToRoman(num);
        System.out.println(roman);
    }
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int times = 0;
        String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L",
                "XC", "C", "CD", "D", "CM", "M" };
        int[] ints = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,
                900, 1000 };
        for (int i = ints.length - 1; i >= 0; i--) {
            times = num / ints[i];
            num %= ints[i];
            while (times > 0) {
                sb.append(romans[i]);
                times--;
            }
        }
        return sb.toString();
    }

    private static void sortDuplicateNames() {
        /*
        2. Пусть дан список сотрудников:
        Иван Иванов
        Светлана Петрова
        Кристина Белова
        Анна Мусина
        Анна Крутова
        Иван Юрин
        Петр Лыков
        Павел Чернов
        Петр Чернышов
        Мария Федорова
        Марина Светлова
        Мария Савина
        Мария Рыкова
        Марина Лугова
        Анна Владимирова
        Иван Мечников
        Петр Петин
        Иван Ежов
        Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
        Отсортировать по убыванию популярности.
        */
        String [] emploees = new String[] {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
                "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова",
                "Иван Мечников", "Петр Петин", "Иван Ежов"};

        ArrayList<String> nameList = new ArrayList<>();
        for (String s : emploees) {
            emploees = s.split(" ");
            nameList.add(emploees[0]);
        }

        Map<String, Integer> mapName = new HashMap<>();
        for (int i = 0; i < nameList.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < nameList.size(); j++) {
                if(nameList.get(i).equals(nameList.get(j))) {
                    count += 1;
                }
            }
            if (mapName.containsKey(nameList.get(i)) == false) mapName.put(nameList.get(i), count);
        }

        mapName.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);

    }

    private static void makePhoneBookStructure() {
        /*1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
        что 1 человек может иметь несколько телефонов.*/

        Map<String, List<? extends String>> personMap = new HashMap<>();
        personMap.put("Иванова Мария", Arrays.asList("+79879875555", "+78316155555"));
        personMap.put("Иванов Антон", Arrays.asList("+79879875522", "+78316151155"));

        for(String person : personMap.keySet()){
            System.out.println(person + ":");
            for (String pet : personMap.get(person)){
                System.out.println("  " + pet);
            }
        }

    }
}

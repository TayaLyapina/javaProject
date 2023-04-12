package lesson6.homework6;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainClassFromHomeworkLessonSix {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.id = 1;
        l1.model = "Xiaomi RedmiBook 15 JYU4525RU";
        l1.screenDiagonal = 15;
        l1. screenResolution = "1920x1080";
        l1.cpu = "Intel Core i3 1115G4 3.0 ГГц";
        l1.ram = 8;
        l1.graficsController = "Intel UHD Graphics";
        l1.volumeSSD = 256;
        l1.operatingSystem = "Windows 11 Home";
        l1.batteryOperation = 9;
        l1.weight = 2;
        l1.price = 39999;

        Laptop l2 = new Laptop();
        l2.id = 10;
        l2.model = "ASUS TUF Gaming A15 FA506IHR-US51 90NR07G6-M004F0";
        l2.screenDiagonal = 15;
        l2. screenResolution = "1920x1080";
        l2.cpu = "AMD Ryzen 5 4600H 3.0 ГГц";
        l2.ram = 8;
        l2.graficsController = "GeForce GTX 1650 4GB";
        l2.volumeSSD = 512;
        l2.operatingSystem = "Windows 11 Home";
        l2.batteryOperation = 5;
        l2.weight = 3;
        l2.price = 59999;

        Laptop l3 = new Laptop();
        l3.id = 12;
        l3.model = "HUAWEI MateBook D16 RLEF-X i5/16GB/512GB Space Gray";
        l3.screenDiagonal = 16;
        l3. screenResolution = "1920x1200";
        l3.cpu = "Intel Core i5 12450H 2.0 ГГц";
        l3.ram = 16;
        l3.graficsController = "Intel UHD Graphics";
        l3.volumeSSD = 512;
        l3.operatingSystem = "Windows 11 Home";
        l3.batteryOperation = 7;
        l3.weight = 2;
        l3.price = 69999;

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);

        System.out.println(l1.equals(l3));

        var laptops = new HashSet<Laptop>(Arrays.asList(l1, l2, l3));
        System.out.println(laptops.contains(l2));


        Scanner in = new Scanner(System.in);

        while(true) {
            //System.out.println();
            System.out.print("Введите параметр для фильтрации: (screenDiagonal/ram/volumeSSD/price) ");
            String inputParameter = in.nextLine();

            if (!inputParameter.equalsIgnoreCase("screenDiagonal") &&
                    !inputParameter.equalsIgnoreCase("ram") &&
                    !inputParameter.equalsIgnoreCase("volumeSSD") &&
                    !inputParameter.equalsIgnoreCase("price") &&
                    !inputParameter.equalsIgnoreCase("end")) {
                System.out.println
                        ("Задан некорректный параметр для фильтрации. " +
                                "Введите параметр для фильтрации: (screenDiagonal/ram/volumeSSD/price)");
                continue;
            }

            if (inputParameter.equalsIgnoreCase("end")) {
                break;
            }

            if (inputParameter.equalsIgnoreCase("screenDiagonal")) {
                System.out.println();
                System.out.print("Введите размер диагонали (число): ");
                Integer inputDiagonal = in.nextInt();

                Stream<Laptop> laptopStream = Stream.of(l1, l2, l3);
                laptopStream.filter(s->s.getScreenDiagonal() == inputDiagonal)
                        .forEach(p->System.out.println(p.getModel()));
            }

            if (inputParameter.equalsIgnoreCase("ram")) {
                System.out.println();
                System.out.print("Введите размер оперативной памяти (число): ");
                Integer inputRam = in.nextInt();

                Stream<Laptop> laptopStream = Stream.of(l1, l2, l3);
                laptopStream.filter(r->r.getRam() == inputRam)
                        .forEach(p->System.out.println(p.getModel()));
            }

            if (inputParameter.equalsIgnoreCase("volumeSSD")) {
                System.out.println();
                System.out.print("Введите объем жесткого диска (число): ");
                Integer inputSSD = in.nextInt();

                Stream<Laptop> laptopStream = Stream.of(l1, l2, l3);
                laptopStream.filter(v->v.getVolumeSSD() == inputSSD)
                        .forEach(p->System.out.println(p.getModel()));
            }

            if (inputParameter.equalsIgnoreCase("price")) {
                System.out.println();
                System.out.print("Введите максимальную стоимость (число): ");
                Integer inputPrice = in.nextInt();

                Stream<Laptop> laptopStream = Stream.of(l1, l2, l3);
                laptopStream.filter(p->p.getPrice() < inputPrice)
                        .forEach(p->System.out.println(p.getModel()));
            }
        }
    }
}

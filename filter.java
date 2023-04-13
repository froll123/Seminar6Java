package Seminar6Java;

import java.util.*;
import java.util.ArrayList;
import java.util.HashSet;


public class filter {
    public static void main(String[] args) {

        ArrayList<Laptop> laptop = getLaptopList();
        HashMap<Integer, String> sortingValues = getSortingMap();
        HashMap<String, ArrayList<String>> allStr = getStringChoices(sortingValues, laptop);
        Scanner sc = new Scanner(System.in);
        int firstChoice = filterCriteria(sortingValues, sc);
        int secondChoice = filterSelection(sortingValues, laptop, allStr, sc, firstChoice);
        filterLoptop(firstChoice, secondChoice, allStr, laptop);
        sc.close();
}

public static void filterLoptop(int first, int second, HashMap<String, 
ArrayList<String>> strMap, ArrayList<Laptop> al) {
    ArrayList<Laptop> matching = new ArrayList<>();
    switch (first) {
        case 1:
            for (Laptop el: al)
                if (el.ramSize >= second)
                    matching.add(el);
            break;
        case 2:
            for (Laptop el: al)
                if (el.ssdSize >= second)
                    matching.add(el);
            break;
        case 3:
            if (strMap.get("Операционная система").size() <= second - 1 || second < 1) {
                System.out.println("Данных нету");
                break;
            }
            for (Laptop el: al)
                if (strMap.get("Операционная система").get(second - 1).equals(el.osName))
                    matching.add(el);
            break;
        case 4:
            if (strMap.get("Цвет").size() <= second - 1 || second < 1) {
                System.out.println("Данных нету");
                break;
            }
            for (Laptop el: al)
                if (strMap.get("Цвет").get(second - 1).equals(el.colorName))
                    matching.add(el);
            break;
        default:
            break;
    }

    if (matching.size() < 1) System.out.println("Подходящих вариантов нету");
    else {
        System.out.println("\n---- Все подходящие варианты ----\n");
        for (Laptop el: matching) el.getInfo();
        System.out.println("\n---------------------------------\n");
    }
}

public static int filterSelection(HashMap<Integer, String> hm, ArrayList<Laptop> al, 
HashMap<String, ArrayList<String>> strMap, Scanner sc, int firstChoice) {
    int choice = -1;
    if (firstChoice > 0 && firstChoice < 3) {
        System.out.println("Укажите минимальное кол-во памяти которое Вам нужно(" + hm.get(firstChoice) + ").");
        System.out.print("Количество памяти (ГБ): ");
        choice = sc.nextInt();
        sc.nextLine();
    }

    else if (firstChoice > 2 && firstChoice < 5) {
        ArrayList<String> strChoices = strMap.get(hm.get(firstChoice));
        System.out.println("Выберите вариант который Вам подходит" + hm.get(firstChoice) + "):");
        for (int i = 0; i < strChoices.size(); i++) {
            System.out.println((i + 1) + ". " + strChoices.get(i));
            }
        System.out.print("\nВаш выбор: ");
        choice = sc.nextInt();
        sc.nextLine();
    }

    else {
        System.out.println("Данных нету");
        }
    return choice;
}

public static HashMap<String, ArrayList<String>> getStringChoices(HashMap<Integer, 
String> hm, ArrayList<Laptop> al) {
    HashMap<String, ArrayList<String>> strMap = new HashMap<>();
    HashSet<String> oses = new HashSet<>();
    HashSet<String> colors = new HashSet<>();
    ArrayList<String> osList = new ArrayList<>();
    ArrayList<String> colorList = new ArrayList<>();
    for (Laptop el: al) {
        oses.add(el.osName);
        colors.add(el.colorName);
    }
    osList.addAll(oses);
    colorList.addAll(colors);
    strMap.put(hm.get(3), osList);
    strMap.put(hm.get(4), colorList);
    return strMap;
}

public static HashMap<Integer, String> getSortingMap() {
    HashMap<Integer, String> hm = new HashMap<>();
    hm.put(1, "ОЗУ");
    hm.put(2, "Объем ЖД");
    hm.put(3, "Операционная система");
    hm.put(4, "Цвет");
    return hm;
}


public static int filterCriteria(HashMap<Integer, String> hm, Scanner sc) {
    System.out.println("Выберите цифру, соответствующую необходимым критериям:");
    for (var el: hm.entrySet()) System.out.println(el.getKey() + ". " + el.getValue());
    System.out.print("\nВаш выбор: ");
    int choice = sc.nextInt();
    sc.nextLine();
    return choice;
}

public static ArrayList<Laptop> getLaptopList() {
    ArrayList<Laptop> al = new ArrayList<>();
    Laptop xiaomi = new Laptop("Xiaomi Pro X 15", "White", 16, 512, "DOS");
    Laptop asus = new Laptop("Asus", "Silver", 8, 256, "Windows 10 Pro");
    Laptop irbis = new Laptop("IRBIS NB80", "Black", 2, 32, "Windows 10 Home");
    Laptop hpLaptop = new Laptop("hp 255 g9 5Y3X5EA", "Dark gray", 16, 512, "FreeDOS");
    Laptop acer = new Laptop("Ноутбук Acer Nitro 5", "Black", 16, 512, "DOS");
    Laptop lenova = new Laptop("Lenovo IdeaPad Gaming 3", "Graphite", 8, 512, "DOS");
    Laptop macbook = new Laptop("Apple Macbook Pro 14", "White", 16, 512, "MacOS");


    al.add(acer);
    al.add(hpLaptop);
    al.add(irbis);
    al.add(asus);
    al.add(xiaomi);
    al.add(lenova);
    al.add(macbook);
    return al;
}
}
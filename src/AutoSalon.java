import java.util.ArrayList;
import java.util.Scanner;

public class AutoSalon {

    /**
     Задание:
     Написать классы Car, Track, AutoSalon.
     class Car{String number; String color; Track track;}
     class Track{String number; Car car;}
     class AutoSalon{ArrayList<Car> cars;ArrayList<Track> tracks; String[] menuList;}
     class MainAutoSalon{}
     Требованию к закреплению и откреплению:
     1. Если прицеп закреплен за другим авто, то нельзя его закрепить для текущего.
     2. Если прицеп не прикреплен к текущему авто, то нельзя его открепить от этого авто.
     3. Методы закрпеления и открепления должны быть в классе Car
     и другие правила, которые должны быть соблюдены, для того, чтобы была корректность ссылок
     Меню операций:
     1. Добавить новый автомобиль
     2. Добавить новый прицеп
     3. Закрепить к авто прицеп(запрос индексов авто и прицепов)
     4. Открепить от авто прицеп(запрос индекса авто).
     5. Отобразить список авто.
     6. Отобразить список прицепов.
     7. Отобразить закрепления авто за прицепами.
     8*. Вызвать метод start для авто (запрос индекса авто).
     9*. Вызвать метод move для авто (запрос индекса авто).
     10*. Вызвать метод stop для авто (запрос индекса авто).
     11**. Отобразить список всех авто и прицепов с закреплениями и состояниями авто и прицепов.
     12. Выход
     Задания *: связать методы класса Car (move, stop) с методами класса Track(roll,stop).
     При попытке вызвать метод move для авто, вызвается метод roll для прицепа.
     При попытке вызвать метод stop для авто, вызвается метод stop для прицепа.
     */

        public static void main (String ... args)
        {
            AutoSalon autoSalon = new AutoSalon();
            autoSalon.start();
        }

        private ArrayList<Car> carList = new ArrayList<Car>();
        private ArrayList<Track> trackList = new ArrayList<Track>();


        public  void printMenu()
        {
            String[] menuList = {
                    "1. Добавить новый автомобиль",
                    "2. Добавить новый прицеп",
                    "3. Закрепить к авто прицеп(запрос индексов авто и прицепов)",
                    "4. Открепить от авто прицеп(запрос индекса авто)",
                    "5. Отобразить список авто",
                    "6. Отобразить список прицепов",
                    "7. Отобразить закрепления авто за прицепами",
                    "8*. Вызвать метод start для авто (запрос индекса авто)",
                    "9*. Вызвать метод move для авто (запрос индекса авто)",
                    "10*. Вызвать метод stop для авто (запрос индекса авто)",
                    "11**. Отобразить список всех авто и прицепов с закреплениями и состояниями авто и прицепов",
                    "12. Выход"};
            for(String elem: menuList)
                System.out.println(elem);
        }

        //Запуск автосалона
        public void start() {
            Scanner scan = new Scanner(System.in);
            boolean runWhile = true;
            while(runWhile){
                printMenu();
                System.out.println("Выберите операцию:");
                int k = scan.nextInt();
                switch (k){
                    case 1: addCars(carList); break;
                    case 2: addTracks(trackList); break;
                    case 3: addTrackToTheCar(trackList, carList); break;
                    case 4: removeTrackFromTheCar(carList); break;
                    case 5: printCarsList(carList); break;
                    case 6: printTracksList(trackList); break;
                    case 7: printCarsWithTracks(carList, trackList); break;
                    case 8:
                        try
                        {
                            System.out.println("Введите индекс машины: ");
                            int carIndex = scan.nextInt();
                            carList.get(carIndex).start();
                        } catch (IndexOutOfBoundsException e){
                            System.out.println("Под этим индексом нету машины");
                        }
                        break;
                    case 9:
                        try
                        {
                            System.out.println("Введите индекс машины: ");
                            int carIndex1 = scan.nextInt();
                            carList.get(carIndex1).move();
                        }catch (IndexOutOfBoundsException e){
                            System.out.println("Под этим индексом нету машины");
                        }
                        break;
                    case 10:
                        try
                        {
                            System.out.println("Введите индекс машины: ");
                            int carIndex2 = scan.nextInt();
                            carList.get(carIndex2).stop();
                        }catch (IndexOutOfBoundsException e){
                            System.out.println("Под этим индексом нету машины");
                        }
                        break;
                    case 11: printAllSituation(carList, trackList); break;
                    case 12: runWhile = false;
                }
            }

        }

        //методы открепления и закрепления
        // Добавить автомобиль в список автомобилей
        public  void addCars(ArrayList<Car> list){    // 1
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите номер машины в формате <AA0000>:  ");
            String name = scan.next();
            System.out.println("Введите цвет машины");
            String color = scan.next();
            list.add(new Car(name, color));
            System.out.println("Машина добавлена в список");
        }
        // Добавить прицеп в список прицепов
        public  void addTracks(ArrayList<Track> list){    //2
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите номер прицепа в формате <AA0000>:  ");
            String number = scan.next();
            list.add(new Track(number));
            System.out.println("Прицеп добавлен в список");
            for (int i = 0; i < list.size(); i++){
                System.out.println(list.get(i));
                System.out.println(list.size());
            }

        }
        // Печать списка авто
        public  void printCarsList(ArrayList<Car> list){
            System.out.println("Список машин в автосалоне по номерам: ");
            for (int i = 0; i < list.size(); i++)
                System.out.println(list.get(i).getNumber());

        }
        // Печать списка прицепов
        public  void printTracksList(ArrayList<Track> list){
            System.out.println("Список прицепов в автосалоне по номерам: ");
            for (int i = 0; i < list.size(); i++)
                System.out.println(list.get(i).getNumber());
        }
        // Закрепить к авто прицеп(запрос индексов авто и прицепов)
        public  void addTrackToTheCar(ArrayList<Track> listTrack, ArrayList<Car> listCar){
            Scanner scanner = new Scanner(System.in);
            try
            {
                System.out.println("Введите индекс машины: ");
                int indexCar = scanner.nextInt();
                System.out.println("Введите индекс прицепа: ");
                int indexTrack = scanner.nextInt();
                // scanner.close();
                /*if (indexCar < 0 || indexTrack < 0)
                    System.out.println("Exception");
                if (indexCar > listCar.size() || indexTrack > listTrack.size())
                    System.out.println("Exception");*/
                listCar.get(indexCar).setTrack(listTrack.get(indexTrack));
                listTrack.get(indexTrack).setCar(listCar.get(indexCar));
                System.out.println("Прицеп прикреплен к машине");
            }catch (Exception e)
            {
                System.out.println("Под этим индексом нету транспорта");
            }
        }
        // Открепить от авто прицеп(запрос индекса авто)
        public  void removeTrackFromTheCar(ArrayList<Car> list){
            Scanner scanner = new Scanner(System.in);
            try
            {
                System.out.println("Введите индекс машины: ");
                int indexCar = scanner.nextInt();
                list.get(indexCar).unSetTrack();
                System.out.println("Прицеп откреплен от машины");
            }catch (Exception e){
                System.out.println("Под этим индексом нету транспорта");
            }
        }

        // Отобразить закрепления авто за прицепами
        public  void printCarsWithTracks(ArrayList<Car> list, ArrayList<Track> list2){
            // проверяет за какими машинами закреплен прицеп
            for (int i = 0; i < list.size(); i++){
                if(list.get(i).getTrack() != null)
                    System.out.println("Авто с номером: " + list.get(i).getNumber() + " имеет прицеп");
                else  System.out.println("Авто с номером: " + list.get(i).getNumber() + " не имеет прицепа");
            }
            // проверяет за какими прицепами закреплена машина
            for (int i = 0; i < list2.size(); i++){
                if(list2.get(i).getCar() != null)
                    System.out.println("Прицеп с номером: " + list2.get(i).getNumber() + " прикреплен к авто");
                else  System.out.println("Прицеп с номером: " + list2.get(i).getNumber() + " не прикреплен");
            }
        }
        // Отобразить список всех авто и прицепов с закреплениями и состояниями авто и прицепов
        public  void printAllSituation(ArrayList<Car> list, ArrayList<Track> list2){
            // проверяет за какими машинами закреплен прицеп и состояние машин
            for (int i = 0; i < list.size(); i++){
                if(list.get(i).getTrack() != null)
                {
                    System.out.print("Авто с номером: " + list.get(i).getNumber() + " имеет прицеп. ");
                    if (list.get(i).getStatus() == 0)
                        System.out.println("Состояние - стоит");
                    else if (list.get(i).getStatus() == 1)
                        System.out.println("Состояние - заведена");
                    else
                        System.out.println("Состояние - едет");
                }else{  System.out.print("Авто с номером: " + list.get(i).getNumber() + " не имеет прицепа. ");
                    if (list.get(i).getStatus() == 0)
                        System.out.println("Состояние - стоит");
                    else if (list.get(i).getStatus() == 1)
                        System.out.println("Состояние - заведена");
                    else
                        System.out.println("Состояние - едет");
                }
            }
            // проверяет за какими прицепами закреплена машина и состояние прицепов
            for (int i = 0; i < list2.size(); i++){
                if(list2.get(i).getCar() != null)
                {
                    System.out.print("Прицеп с номером: " + list2.get(i).getNumber() + " прикреплен к авто. ");
                    if (list2.get(i).getStatus() == 0)
                        System.out.println("Состояние - стоит");
                    else
                        System.out.println("Состояние - катится");
                }else  {System.out.print("Прицеп с номером: " + list2.get(i).getNumber() + " не прикреплен. ");
                    if (list2.get(i).getStatus() == 0)
                        System.out.println("Состояние - стоит");
                    else
                        System.out.println("Состояние - катится");
                }
            }
        }
    }

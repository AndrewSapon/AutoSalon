/**
 * Created by Andrew on 24.01.2016.
 */
public class AutoSalon {
    import java.util.ArrayList;
    import java.util.Scanner;

    /**
     * 1. �������� ����� ����������
     2. �������� ����� ������
     3. ��������� � ���� ������(������ �������� ���� � ��������)
     4. ��������� �� ���� ������(������ ������� ����).
     5. ���������� ������ ����.
     6. ���������� ������ ��������.
     7. ���������� ����������� ���� �� ���������.
     8*. ������� ����� start ��� ���� (������ ������� ����).
     9*. ������� ����� move ��� ���� (������ ������� ����).
     10*. ������� ����� stop ��� ���� (������ ������� ����).
     11**. ���������� ������ ���� ���� � �������� � ������������� � ����������� ���� � ��������.
     12. �����
     public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
     boolean runWhile = true;
     while(runWhile){
     printMenu();
     System.out.println("�������� ��������:");
     int k = scan.nextInt();
     switch (k){
     case 1: f1();break;
     case 2: f2();break;
     case 3: f3();break;
     case 4: runWhile = false;
     }
     }
     }
     public static void f1(){
     System.out.println("Method1");
     }
     public static void f2(){
     System.out.println("Method2");
     }
     public static void f3(){
     System.out.println("Method3");
     }

     }
     */

    public  class AutoSalon
    {
        public static void main (String ... args)
        {
            AutoSalon autoSalon = new AutoSalon();
            autoSalon.start();
        }
        // ���� ������� ��� ���� public, �� � ��� ����� ����� �������� ���������� �� ������� ������ �������
        public ArrayList<Car> carList = new ArrayList<Car>();
        public ArrayList<Track> trackList = new ArrayList<Track>();


        public  void printMenu()
        {
            String[] menuList = {
                    "1. �������� ����� ����������",
                    "2. �������� ����� ������",
                    "3. ��������� � ���� ������(������ �������� ���� � ��������)",
                    "4. ��������� �� ���� ������(������ ������� ����)",
                    "5. ���������� ������ ����",
                    "6. ���������� ������ ��������",
                    "7. ���������� ����������� ���� �� ���������",
                    "8*. ������� ����� start ��� ���� (������ ������� ����)",
                    "9*. ������� ����� move ��� ���� (������ ������� ����)",
                    "10*. ������� ����� stop ��� ���� (������ ������� ����)",
                    "11**. ���������� ������ ���� ���� � �������� � ������������� � ����������� ���� � ��������",
                    "12. �����"};
            for(String elem: menuList)
                System.out.println(elem);
        }


        public void start() {
            // ������� ����� �� ���� (�����)   �������� ������ ������ �� �� ������  C������ ������ ���������� � � ���� �������� ��� ������  (autoSalon.addCars.)
            Scanner scan = new Scanner(System.in);
            boolean runWhile = true;
            while(runWhile){
                printMenu();
                System.out.println("�������� ��������:");
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
                            System.out.println("������� ������ ������: ");
                            int carIndex = scan.nextInt();
                            carList.get(carIndex).start();
                        } catch (IndexOutOfBoundsException e){
                            System.out.println("��� ���� �������� ���� ������");
                        }
                        break;
                    case 9:
                        try
                        {
                            System.out.println("������� ������ ������: ");
                            int carIndex1 = scan.nextInt();
                            carList.get(carIndex1).move();
                        }catch (IndexOutOfBoundsException e){
                            System.out.println("��� ���� �������� ���� ������");
                        }
                        break;
                    case 10:
                        try
                        {
                            System.out.println("������� ������ ������: ");
                            int carIndex2 = scan.nextInt();
                            carList.get(carIndex2).stop();
                        }catch (IndexOutOfBoundsException e){
                            System.out.println("��� ���� �������� ���� ������");
                        }
                        break;
                    case 11: printAllSituation(carList, trackList); break;
                    case 12: runWhile = false;
                }
            }

        }
        //***********************************************************************************************************************************************************
//������ ����������� � �����������
        public  void addCars(ArrayList<Car> list){    // 1
            Scanner scan = new Scanner(System.in);
            System.out.println("������� ����� ������ � ������� <AA0000>:  ");
            String name = scan.next();
            System.out.println("������� ���� ������");
            String color = scan.next();
            list.add(new Car(name, color));
            System.out.println("������ ��������� � ������");
        }

        public  void addTracks(ArrayList<Track> list){    //2
            Scanner scan = new Scanner(System.in);
            System.out.println("������� ����� ������� � ������� <AA0000>:  ");
            String number = scan.next();
            list.add(new Track(number));
            System.out.println("������ �������� � ������");
            for (int i = 0; i < list.size(); i++){
                System.out.println(list.get(i));
                System.out.println(list.size());
            }

        }

        public  void printCarsList(ArrayList<Car> list){
            System.out.println("������ ����� � ���������� �� �������: ");
            for (int i = 0; i < list.size(); i++)
                System.out.println(list.get(i).getNumber());

        }
        public  void printTracksList(ArrayList<Track> list){
            System.out.println("������ �������� � ���������� �� �������: ");
            for (int i = 0; i < list.size(); i++)
                System.out.println(list.get(i).getNumber());
        }
        public  void addTrackToTheCar(ArrayList<Track> listTrack, ArrayList<Car> listCar){
            Scanner scanner = new Scanner(System.in);
            try
            {
                System.out.println("������� ������ ������: ");
                int indexCar = scanner.nextInt();
                System.out.println("������� ������ �������: ");
                int indexTrack = scanner.nextInt();
                // scanner.close();
                /*if (indexCar < 0 || indexTrack < 0)
                    System.out.println("Exception");
                if (indexCar > listCar.size() || indexTrack > listTrack.size())
                    System.out.println("Exception");*/
                listCar.get(indexCar).setTrack(listTrack.get(indexTrack));
                listTrack.get(indexTrack).setCar(listCar.get(indexCar));
                System.out.println("������ ���������� � ������");
            }catch (Exception e)
            {
                System.out.println("��� ���� �������� ���� ����������");
            }
        }

        public  void removeTrackFromTheCar(ArrayList<Car> list){
            Scanner scanner = new Scanner(System.in);
            try
            {
                System.out.println("������� ������ ������: ");
                int indexCar = scanner.nextInt();
                list.get(indexCar).unSetTrack();
                System.out.println("������ ��������� �� ������");
            }catch (Exception e){
                System.out.println("��� ���� �������� ���� ����������");
            }
        }


        public  void printCarsWithTracks(ArrayList<Car> list, ArrayList<Track> list2){
            // ��������� �� ������ �������� ��������� ������
            for (int i = 0; i < list.size(); i++){
                if(list.get(i).getTrack() != null)
                    System.out.println("���� � �������: " + list.get(i).getNumber() + " ����� ������");
                else  System.out.println("���� � �������: " + list.get(i).getNumber() + " �� ����� �������");
            }
            // ��������� �� ������ ��������� ���������� ������
            for (int i = 0; i < list2.size(); i++){
                if(list2.get(i).getCar() != null)
                    System.out.println("������ � �������: " + list2.get(i).getNumber() + " ���������� � ����");
                else  System.out.println("������ � �������: " + list2.get(i).getNumber() + " �� ����������");
            }
        }

        public  void printAllSituation(ArrayList<Car> list, ArrayList<Track> list2){
            // ��������� �� ������ �������� ��������� ������ � ��������� �����
            for (int i = 0; i < list.size(); i++){
                if(list.get(i).getTrack() != null)
                {
                    System.out.print("���� � �������: " + list.get(i).getNumber() + " ����� ������. ");
                    if (list.get(i).getStatus() == 0)
                        System.out.println("��������� - �����");
                    else if (list.get(i).getStatus() == 1)
                        System.out.println("��������� - ��������");
                    else
                        System.out.println("��������� - ����");
                }else{  System.out.print("���� � �������: " + list.get(i).getNumber() + " �� ����� �������. ");
                    if (list.get(i).getStatus() == 0)
                        System.out.println("��������� - �����");
                    else if (list.get(i).getStatus() == 1)
                        System.out.println("��������� - ��������");
                    else
                        System.out.println("��������� - ����");
                }
            }
            // ��������� �� ������ ��������� ���������� ������ � ��������� ��������
            for (int i = 0; i < list2.size(); i++){
                if(list2.get(i).getCar() != null)
                {
                    System.out.print("������ � �������: " + list2.get(i).getNumber() + " ���������� � ����. ");
                    if (list2.get(i).getStatus() == 0)
                        System.out.println("��������� - �����");
                    else
                        System.out.println("��������� - �������");
                }else  {System.out.print("������ � �������: " + list2.get(i).getNumber() + " �� ����������. ");
                    if (list2.get(i).getStatus() == 0)
                        System.out.println("��������� - �����");
                    else
                        System.out.println("��������� - �������");
                }
            }
        }

        //***********************************************************************************************************************************************************
    }
/*
public  class AutoSalon
{
    // ���� ������� ��� ���� public, �� � ��� ����� ����� �������� ���������� �� ������� ������ �������
    static ArrayList<Car> carList = new ArrayList<Car>();
      static ArrayList<Track> trackList = new ArrayList<Track>();


    public static void printMenu()
    {
        String[] menuList = {
                "1. �������� ����� ����������",
                "2. �������� ����� ������",
                "3. ��������� � ���� ������(������ �������� ���� � ��������)",
                "4. ��������� �� ���� ������(������ ������� ����)",
                "5. ���������� ������ ����",
                "6. ���������� ������ ��������",
                "7. ���������� ����������� ���� �� ���������",
                "8*. ������� ����� start ��� ���� (������ ������� ����)",
                "9*. ������� ����� move ��� ���� (������ ������� ����)",
                "10*. ������� ����� stop ��� ���� (������ ������� ����)",
                "11**. ���������� ������ ���� ���� � �������� � ������������� � ����������� ���� � ��������",
                "12. �����"};
        for(String elem: menuList)
            System.out.println(elem);
    }
    public static void main(String[] args) {
        // ������� ����� �� ���� (�����)   �������� ������ ������ �� �� ������  C������ ������ ���������� � � ���� �������� ��� ������  (autoSalon.addCars.)
        AutoSalon autoSalon = new AutoSalon();
        Scanner scan = new Scanner(System.in);
        boolean runWhile = true;
        while(runWhile){
            printMenu();
            System.out.println("�������� ��������:");
            int k = scan.nextInt();
            switch (k){
                case 1:Car.addCars(carList); break;
                case 2:Car.addTracks(trackList); break;
                case 3: Car.addTrackToTheCar(trackList, carList); break;
                case 4:Car.removeTrackFromTheCar(carList); break;
                case 5:Car.printCarsList(carList); break;
                case 6:Car.printTracksList(trackList); break;
                case 7:Car.printCarsWithTracks(carList, trackList); break;
                case 8:
                    try
                    {
                        System.out.println("������� ������ ������: ");
                        int carIndex = scan.nextInt();
                        carList.get(carIndex).start();
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("��� ���� �������� ���� ������");
                    }
                    break;
                case 9:
                    try
                    {
                        System.out.println("������� ������ ������: ");
                        int carIndex1 = scan.nextInt();
                        carList.get(carIndex1).move();
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("��� ���� �������� ���� ������");
                    }
                    break;
                case 10:
                    try
                    {
                        System.out.println("������� ������ ������: ");
                        int carIndex2 = scan.nextInt();
                        carList.get(carIndex2).stop();
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("��� ���� �������� ���� ������");
                    }
                    break;
                case 11:Car.printAllSituation(carList, trackList); break;
                case 12: runWhile = false;
            }
        }
    }


}

*/
}

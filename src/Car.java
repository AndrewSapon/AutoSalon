/**
 * Created by Andrew on 24.01.2016.
 */
public class Car {
    /**
     * Created by Andrew on 27.12.2015.
     */
    public class Car
    {
        private Track track = null;



        //����� ������������ � �������  - ��������� �������� �� ��� ������ � ������-�� ����������
    /*�������� ���� �� � ������ ������
    * car x
    * if (car x.getTreck) == null)
    * S.o.p("free")
    * else sop ������
    *
    * ��������� ��������� �� ������ �� ������ � �������� � �������� ������ �� ���������� � ����������
    *  car1, track1
    *  if(car1.getTrack() == track1 && track1.getCar() == car1)
    *  ���� ��� ������ null �� ����� ���������
    *  � ������ ������ �������� ���������� � �������
    *  ���� ���� �������, ������ ������� ���� ��������
    * */
        public  void setTrack(Track tr)
        {
            if (this.track == null && tr.getCar() == null)
                this.track = tr;
            else
                System.out.println("� ������ ��� ������� ��� ���� ��������");
        }

        // ����� ����������� �������
        public void unSetTrack()
        {
            if(track.getCar() != null && this.getTrack() != null)
                track.setCar(null);
            //this.setTrack(null);
            this.track = null;
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


        public void printCarsWithTracks(ArrayList<Car> list, ArrayList<Track> list2){
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
        private String number;
        int countHuman =0;

        public Track getTrack()
        {
            return track;
        }
        public Car() {}
        public Car(String number, String color)
        {
            this.number = number;
            this.color = color;
        }



        public int add(int a){
            if (countHuman > 0 )
            {
                countHuman = countHuman + a;
            } else {
                countHuman = countHuman - (-a);
            }
            return countHuman;
        }

        public void setNumber(String number)
        {
            this.number = number;
        }

        public void setColor(String color)
        {
            this.color = color;
        }

        public String getNumber()
        {
            return number;
        }

        public String getColor()
        {
            return color;
        }

        public int getStatus() {return status;}

        private String color;

        int status;
        // 0 - �����
        // 1 - �������
        // 2 - ����
        String s;
        public void start()
        {
            if (status == 0){
                status = 1;
                s = "� ���� � �������: " + this.number +" ������� ��������";
                System.out.println(s);
            }
            else if (status == 1){
                s = "� ���� � �������: " + this.number +" �� ���� ���������, ��� ��� ��� ��������";
                System.out.println(s);
            }
            else
            {
                s = ("� ���� � �������: " + this.number + " �� ���� ��������� ��������, ��� ��� ��� ���");
                System.out.println(s);
            }

        }
        public void move()
        {
            if (status == 0)
            {
                s = "� ���� � �������: " + this.number + " �� ���� �����, ��� ��� �� ��������";
                System.out.println(s);
            }else if (status == 1){
                status = 2;
                s = "� ���� � �������: " + this.number + " ������� �������";
                System.out.println(s);
                try{
                    if(track.getCar() != null && this.getTrack() != null)
                    {
                        this.track.roll();                 //******************************************************************************************************************
                    }
                }catch (NullPointerException e){

                }
            } else {
                s = "� ���� � �������: " + this.number + " �� ���� �������, ��� ��� ��� ���";
                System.out.println(s);
            }
        }

        public void stop()
        {
            if (status == 0)
            {
                s = "� ���� � �������: " + this.number + " �� ���� ������������, ��� ��� � ��� ����";
                System.out.println(s);
            }else if (status == 1){
                s = "� ���� � �������: " + this.number + " �� ���� ������������, ��� ��� �������� �� ��� ����";
                System.out.println(s);
            } else {
                status = 0;
                s = "� ���� � �������: " + this.number + " ������� ������������";
                System.out.println(s);
                try{
                    if(track.getCar() != null && this.getTrack() != null)
                    {
                        this.track.stop();                 //******************************************************************************************************************
                    }
                }catch (NullPointerException e){

                }
            }
        }
        public  void printAboutMe(){
            //  System.out.print(number + " " + color+" " + countHuman + " �����");
            String [] operationNames = {"0: �������", "1: �����", "2: ������������" };
            for (String elem: operationNames)
                System.out.println(elem);

            if (status == 0) System.out.println("������� ������ - ����");
            else if (status == 1) System.out.println("������� ������ - ��������");
            else System.out.println("������� ������ - ���");
        }


    }



/* public class Car
{
   private Track track = null;
*/


//����� ������������ � �������  - ��������� �������� �� ��� ������ � ������-�� ����������
    /*�������� ���� �� � ������ ������
    * car x
    * if (car x.getTreck) == null)
    * S.o.p("free")
    * else sop ������
    *
    * ��������� ��������� �� ������ �� ������ � �������� � �������� ������ �� ���������� � ����������
    *  car1, track1
    *  if(car1.getTrack() == track1 && track1.getCar() == car1)
    *  ���� ��� ������ null �� ����� ���������
    *  � ������ ������ �������� ���������� � �������
    *  ���� ���� �������, ������ ������� ���� ��������
    * */

/*
    public  void setTrack(Track tr)
    {
        if (this.track == null && tr.getCar() == null)
            this.track = tr;
        else
            System.out.println("� ������ ��� ������� ��� ���� ��������");
    }

    // ����� ����������� �������
    public void unSetTrack()
    {
       if(track.getCar() != null && this.getTrack() != null)
         track.setCar(null);
         //this.setTrack(null);
           this.track = null;
    }

//#############################################################################################################################################
//������ ����������� � �����������
public static void addCars(ArrayList<Car> list){    // 1
    Scanner scan = new Scanner(System.in);
    System.out.println("������� ����� ������ � ������� <AA0000>:  ");
    String name = scan.next();
    System.out.println("������� ���� ������");
    String color = scan.next();
    list.add(new Car(name, color));
    System.out.println("������ ��������� � ������");
}

    public static void addTracks(ArrayList<Track> list){    //2
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

    public static void printCarsList(ArrayList<Car> list){
        System.out.println("������ ����� � ���������� �� �������: ");
        for (int i = 0; i < list.size(); i++)
        System.out.println(list.get(i).getNumber());

    }
    public static void printTracksList(ArrayList<Track> list){
        System.out.println("������ �������� � ���������� �� �������: ");
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).getNumber());
    }
        public static void addTrackToTheCar(ArrayList<Track> listTrack, ArrayList<Car> listCar){
           Scanner scanner = new Scanner(System.in);
            try
            {
                System.out.println("������� ������ ������: ");
                int indexCar = scanner.nextInt();
                System.out.println("������� ������ �������: ");
                int indexTrack = scanner.nextInt();
                // scanner.close();
               //if (indexCar < 0 || indexTrack < 0)
                 //   System.out.println("Exception");
                //if (indexCar > listCar.size() || indexTrack > listTrack.size())
                  //  System.out.println("Exception");
                listCar.get(indexCar).setTrack(listTrack.get(indexTrack));
                listTrack.get(indexTrack).setCar(listCar.get(indexCar));
                System.out.println("������ ���������� � ������");
            }catch (Exception e)
            {
                System.out.println("��� ���� �������� ���� ����������");
            }
    }

    public static void removeTrackFromTheCar(ArrayList<Car> list){
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


    public static void printCarsWithTracks(ArrayList<Car> list, ArrayList<Track> list2){
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

    public static void printAllSituation(ArrayList<Car> list, ArrayList<Track> list2){
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

//################################################################################################################################
    private String number;
    int countHuman =0;

    public Track getTrack()
    {
        return track;
    }
    public Car() {}
    public Car(String number, String color)
    {
        this.number = number;
        this.color = color;
    }



    public int add(int a){
        if (countHuman > 0 )
        {
            countHuman = countHuman + a;
        } else {
            countHuman = countHuman - (-a);
        }
        return countHuman;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getNumber()
    {
        return number;
    }

    public String getColor()
    {
        return color;
    }

    public int getStatus() {return status;}

    private String color;

    int status;
    // 0 - �����
    // 1 - �������
    // 2 - ����
    String s;
    public void start()
    {
            if (status == 0){
                status = 1;
                s = "� ���� � �������: " + this.number +" ������� ��������";
                System.out.println(s);
            }
        else if (status == 1){
              s = "� ���� � �������: " + this.number +" �� ���� ���������, ��� ��� ��� ��������";
                System.out.println(s);
            }
        else
            {
                s = ("� ���� � �������: " + this.number + " �� ���� ��������� ��������, ��� ��� ��� ���");
                System.out.println(s);
            }

    }
    public void move()
    {
        if (status == 0)
        {
            s = "� ���� � �������: " + this.number + " �� ���� �����, ��� ��� �� ��������";
            System.out.println(s);
        }else if (status == 1){
            status = 2;
            s = "� ���� � �������: " + this.number + " ������� �������";
            System.out.println(s);
            try{
            if(track.getCar() != null && this.getTrack() != null)
            {
                this.track.roll();                 //#######################################################################################
            }
            }catch (NullPointerException e){

            }
        } else {
            s = "� ���� � �������: " + this.number + " �� ���� �������, ��� ��� ��� ���";
            System.out.println(s);
        }
    }

    public void stop()
    {
        if (status == 0)
        {
            s = "� ���� � �������: " + this.number + " �� ���� ������������, ��� ��� � ��� ����";
            System.out.println(s);
        }else if (status == 1){
            s = "� ���� � �������: " + this.number + " �� ���� ������������, ��� ��� �������� �� ��� ����";
            System.out.println(s);
        } else {
            status = 0;
            s = "� ���� � �������: " + this.number + " ������� ������������";
            System.out.println(s);
            try{
                if(track.getCar() != null && this.getTrack() != null)
                {
                    this.track.stop();                 //################################################################################333
                }
            }catch (NullPointerException e){

            }
        }
    }
    public  void printAboutMe(){
     //  System.out.print(number + " " + color+" " + countHuman + " �����");
         String [] operationNames = {"0: �������", "1: �����", "2: ������������" };
        for (String elem: operationNames)
        System.out.println(elem);

       if (status == 0) System.out.println("������� ������ - ����");
       else if (status == 1) System.out.println("������� ������ - ��������");
        else System.out.println("������� ������ - ���");
    }

}

*/

}

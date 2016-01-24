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



        //метод прикрепления к прицепу  - проверить привязан ли наш прицеп к какому-то автомобилю
    /*проверка есть ли у машины прицеп
    * car x
    * if (car x.getTreck) == null)
    * S.o.p("free")
    * else sop Занято
    *
    * Проверить совпадает ли ссылка на прицеп с прицепом и сопадает ссылка на автомобиль с автомоилем
    *  car1, track1
    *  if(car1.getTrack() == track1 && track1.getCar() == car1)
    *  если обе ссылки null мы можем прицепить
    *  в списке просто хранятся автомобили и прицепы
    *  если авто поехало, статус прицепа тоже меняется
    * */
        public  void setTrack(Track tr)
        {
            if (this.track == null && tr.getCar() == null)
                this.track = tr;
            else
                System.out.println("У машины или прицепа уже есть владелец");
        }

        // метод открепления прицепа
        public void unSetTrack()
        {
            if(track.getCar() != null && this.getTrack() != null)
                track.setCar(null);
            //this.setTrack(null);
            this.track = null;
        }

        //***********************************************************************************************************************************************************
//методы открепления и закрепления
        public  void addCars(ArrayList<Car> list){    // 1
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите номер машины в формате <AA0000>:  ");
            String name = scan.next();
            System.out.println("Введите цвет машины");
            String color = scan.next();
            list.add(new Car(name, color));
            System.out.println("Машина добавлена в список");
        }

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

        public  void printCarsList(ArrayList<Car> list){
            System.out.println("Список машин в автосалоне по номерам: ");
            for (int i = 0; i < list.size(); i++)
                System.out.println(list.get(i).getNumber());

        }
        public  void printTracksList(ArrayList<Track> list){
            System.out.println("Список прицепов в автосалоне по номерам: ");
            for (int i = 0; i < list.size(); i++)
                System.out.println(list.get(i).getNumber());
        }
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


        public void printCarsWithTracks(ArrayList<Car> list, ArrayList<Track> list2){
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
        // 0 - стоит
        // 1 - заведен
        // 2 - едет
        String s;
        public void start()
        {
            if (status == 0){
                status = 1;
                s = "Я авто с номером: " + this.number +" успещно завелось";
                System.out.println(s);
            }
            else if (status == 1){
                s = "Я авто с номером: " + this.number +" Не могу завестись, так как уже заведено";
                System.out.println(s);
            }
            else
            {
                s = ("Я авто с номером: " + this.number + " не могу завестись повтроно, так как уже еду");
                System.out.println(s);
            }

        }
        public void move()
        {
            if (status == 0)
            {
                s = "Я авто с номером: " + this.number + " не могу ехать, так как не завелось";
                System.out.println(s);
            }else if (status == 1){
                status = 2;
                s = "Я авто с номером: " + this.number + " успещно поехало";
                System.out.println(s);
                try{
                    if(track.getCar() != null && this.getTrack() != null)
                    {
                        this.track.roll();                 //******************************************************************************************************************
                    }
                }catch (NullPointerException e){

                }
            } else {
                s = "Я авто с номером: " + this.number + " не могу поехать, так как уже еду";
                System.out.println(s);
            }
        }

        public void stop()
        {
            if (status == 0)
            {
                s = "Я авто с номером: " + this.number + " не могу остановиться, так как и так стою";
                System.out.println(s);
            }else if (status == 1){
                s = "Я авто с номером: " + this.number + " не могу остановиться, так как завелось но еще стою";
                System.out.println(s);
            } else {
                status = 0;
                s = "Я авто с номером: " + this.number + " успешно остановилось";
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
            //  System.out.print(number + " " + color+" " + countHuman + " людей");
            String [] operationNames = {"0: Завести", "1: Ехать", "2: Остановиться" };
            for (String elem: operationNames)
                System.out.println(elem);

            if (status == 0) System.out.println("Текущий статус - стою");
            else if (status == 1) System.out.println("Текущий статус - заведена");
            else System.out.println("Текущий статус - еду");
        }


    }



/* public class Car
{
   private Track track = null;
*/


//метод прикрепления к прицепу  - проверить привязан ли наш прицеп к какому-то автомобилю
    /*проверка есть ли у машины прицеп
    * car x
    * if (car x.getTreck) == null)
    * S.o.p("free")
    * else sop Занято
    *
    * Проверить совпадает ли ссылка на прицеп с прицепом и сопадает ссылка на автомобиль с автомоилем
    *  car1, track1
    *  if(car1.getTrack() == track1 && track1.getCar() == car1)
    *  если обе ссылки null мы можем прицепить
    *  в списке просто хранятся автомобили и прицепы
    *  если авто поехало, статус прицепа тоже меняется
    * */

/*
    public  void setTrack(Track tr)
    {
        if (this.track == null && tr.getCar() == null)
            this.track = tr;
        else
            System.out.println("У машины или прицепа уже есть владелец");
    }

    // метод открепления прицепа
    public void unSetTrack()
    {
       if(track.getCar() != null && this.getTrack() != null)
         track.setCar(null);
         //this.setTrack(null);
           this.track = null;
    }

//#############################################################################################################################################
//методы открепления и закрепления
public static void addCars(ArrayList<Car> list){    // 1
    Scanner scan = new Scanner(System.in);
    System.out.println("Введите номер машины в формате <AA0000>:  ");
    String name = scan.next();
    System.out.println("Введите цвет машины");
    String color = scan.next();
    list.add(new Car(name, color));
    System.out.println("Машина добавлена в список");
}

    public static void addTracks(ArrayList<Track> list){    //2
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

    public static void printCarsList(ArrayList<Car> list){
        System.out.println("Список машин в автосалоне по номерам: ");
        for (int i = 0; i < list.size(); i++)
        System.out.println(list.get(i).getNumber());

    }
    public static void printTracksList(ArrayList<Track> list){
        System.out.println("Список прицепов в автосалоне по номерам: ");
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).getNumber());
    }
        public static void addTrackToTheCar(ArrayList<Track> listTrack, ArrayList<Car> listCar){
           Scanner scanner = new Scanner(System.in);
            try
            {
                System.out.println("Введите индекс машины: ");
                int indexCar = scanner.nextInt();
                System.out.println("Введите индекс прицепа: ");
                int indexTrack = scanner.nextInt();
                // scanner.close();
               //if (indexCar < 0 || indexTrack < 0)
                 //   System.out.println("Exception");
                //if (indexCar > listCar.size() || indexTrack > listTrack.size())
                  //  System.out.println("Exception");
                listCar.get(indexCar).setTrack(listTrack.get(indexTrack));
                listTrack.get(indexTrack).setCar(listCar.get(indexCar));
                System.out.println("Прицеп прикреплен к машине");
            }catch (Exception e)
            {
                System.out.println("Под этим индексом нету транспорта");
            }
    }

    public static void removeTrackFromTheCar(ArrayList<Car> list){
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


    public static void printCarsWithTracks(ArrayList<Car> list, ArrayList<Track> list2){
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

    public static void printAllSituation(ArrayList<Car> list, ArrayList<Track> list2){
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
    // 0 - стоит
    // 1 - заведен
    // 2 - едет
    String s;
    public void start()
    {
            if (status == 0){
                status = 1;
                s = "Я авто с номером: " + this.number +" успещно завелось";
                System.out.println(s);
            }
        else if (status == 1){
              s = "Я авто с номером: " + this.number +" Не могу завестись, так как уже заведено";
                System.out.println(s);
            }
        else
            {
                s = ("Я авто с номером: " + this.number + " не могу завестись повтроно, так как уже еду");
                System.out.println(s);
            }

    }
    public void move()
    {
        if (status == 0)
        {
            s = "Я авто с номером: " + this.number + " не могу ехать, так как не завелось";
            System.out.println(s);
        }else if (status == 1){
            status = 2;
            s = "Я авто с номером: " + this.number + " успещно поехало";
            System.out.println(s);
            try{
            if(track.getCar() != null && this.getTrack() != null)
            {
                this.track.roll();                 //#######################################################################################
            }
            }catch (NullPointerException e){

            }
        } else {
            s = "Я авто с номером: " + this.number + " не могу поехать, так как уже еду";
            System.out.println(s);
        }
    }

    public void stop()
    {
        if (status == 0)
        {
            s = "Я авто с номером: " + this.number + " не могу остановиться, так как и так стою";
            System.out.println(s);
        }else if (status == 1){
            s = "Я авто с номером: " + this.number + " не могу остановиться, так как завелось но еще стою";
            System.out.println(s);
        } else {
            status = 0;
            s = "Я авто с номером: " + this.number + " успешно остановилось";
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
     //  System.out.print(number + " " + color+" " + countHuman + " людей");
         String [] operationNames = {"0: Завести", "1: Ехать", "2: Остановиться" };
        for (String elem: operationNames)
        System.out.println(elem);

       if (status == 0) System.out.println("Текущий статус - стою");
       else if (status == 1) System.out.println("Текущий статус - заведена");
        else System.out.println("Текущий статус - еду");
    }

}

*/

}

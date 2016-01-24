

public class Car {

        private Track track = null;

        public Track getTrack() {return track;}
       // метод прикрепления прицепа
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
                this.track = null;
        }

        private String number;
        int countHuman =0;
        private String color;
        int status; // статус машины
        // 0 - стоит
        // 1 - заведен
        // 2 - едет
        String s;

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

        public void setNumber(String number) {this.number = number;}
        public void setColor(String color) {this.color = color;}
        public String getNumber() {return number;}
        public String getColor() {return color;}
        public int getStatus() {return status;}




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
                        this.track.roll();
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
                        this.track.stop();
                    }
                }catch (NullPointerException e){

                }
            }
        }

    }






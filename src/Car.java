

public class Car {

        private Track track = null;

        public Track getTrack() {return track;}
       // ����� ������������ �������
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
                this.track = null;
        }

        private String number;
        int countHuman =0;
        private String color;
        int status; // ������ ������
        // 0 - �����
        // 1 - �������
        // 2 - ����
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
                        this.track.roll();
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
                        this.track.stop();
                    }
                }catch (NullPointerException e){

                }
            }
        }

    }






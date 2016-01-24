
public class Track {
    /**
     * Created by Andrew on 17.01.2016.
     */
        private  Car car = null;
        private String number;
        private int status = 0;
        // 0 - ����  1 - ������

        public Car getCar()
        {
            return car;
        }

        public void setCar(Car car)
        {
            this.car = car;
        }

        public Track() {}
        public Track(String number)
        {
            this.number = number;
        }
        public Track(int status, String number) {this.status = status;this.number = number;}


        public String getNumber()
        {
            return number;
        }
        public int getStatus()
        {
            return status;
        }


        public void setNumber(String number)
        {
            this.number = number;
        }
        public void setStatus(int status)
        {
            this.status = status;
        }


        public void stop()
        {
            if (status == 1)
            {
                System.out.println("� ������, ����� " + this.getNumber() + " �����������");
                status = 0;
            } else
                System.out.println("� ������, ����� " + this.getNumber() + " �� ���� ������������, ��� ��� � ��� ����");
        }
        public void roll()
        {
            if (status == 0)
            {
                System.out.println("� ������, ����� " + this.getNumber() + " ������");
                status = 1;
            } else
                System.out.println("� ������, ����� " + this.getNumber() + " �� ��� ����������, ��� ��� � ��� ��������");
        }
    }



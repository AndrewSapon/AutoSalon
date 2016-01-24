
public class Track {
    /**
     * Created by Andrew on 17.01.2016.
     */
        private  Car car = null;
        private String number;
        private int status = 0;
        // 0 - стою  1 - качусь

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
                System.out.println("Я прицеп, номер " + this.getNumber() + " остановился");
                status = 0;
            } else
                System.out.println("Я прицеп, номер " + this.getNumber() + " не могу остановиться, так как и так стою");
        }
        public void roll()
        {
            if (status == 0)
            {
                System.out.println("Я прицеп, номер " + this.getNumber() + " качусь");
                status = 1;
            } else
                System.out.println("Я прицеп, номер " + this.getNumber() + " не мог покатиться, так как и так двигаюсь");
        }
    }



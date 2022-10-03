import Models.Car;
import Models.TaxiDriver;

import java.sql.SQLOutput;
import java.util.*;

public class Main {

    private static Car[] cars =  {
            new Car("toyota", 2, 4),
            new Car("ferarri", 5, 10),
            new Car("BMW", 3, 6),
            new Car("volga", 2, 5),
            new Car("mersedes", 4, 8)
    };

    private static final int TAXI_DRIVER_COUNT = 20;
    private static final int CAR_COUNT = cars.length;
    public static int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }


    public static void main(String[] args) {
        System.out.println("Меню:");
        System.out.println("[1] Ввести дату самому.");
        System.out.println("[2] Рандомная дата.");
        System.out.println("[0] Выход.");

        Calendar date1 = null;
        Calendar date2 = null;

        int choice = Helper.getIntInDiapason(0, 2);
        switch(choice) {
            case 1:

                Boolean isExit = false;
                while(!isExit) {
                    date1 = Helper.getCalendar();
                    date2 = Helper.getCalendar();

                    if (date2.before(date1)) {
                        System.out.println("Первая дата должна быть раньше!");
                    }
                    else {
                        isExit = true;
                    }
                }
                break;

            case 2:

                Random rnd = new Random();
                date1 = new GregorianCalendar(rnd.nextInt(1981, 2022), rnd.nextInt(1, 12), rnd.nextInt(1, 31));
                date2 = new GregorianCalendar(rnd.nextInt(1981, 2022), rnd.nextInt(1, 12), rnd.nextInt(1, 31));
                if(date1.after(date2)) {
                    Calendar date3 = date1;
                    date1 = date2;
                    date2 = date3;
                }
                break;

            default:
        }

        System.out.println("Запустить программу в режиме:");
        System.out.println("[1] Сравнение производительности.");
        System.out.println("[2] Отображение расхода топлива.");
        choice = Helper.getIntInDiapason(1, 2);
        switch(choice) {
            case 1:
                Calendar dateCopy1 = new GregorianCalendar(date1.get(Calendar.YEAR), date1.get(Calendar.MONTH), date1.get(Calendar.DAY_OF_MONTH));
                Calendar dateCopy2 = new GregorianCalendar(date2.get(Calendar.YEAR), date2.get(Calendar.MONTH), date2.get(Calendar.DAY_OF_MONTH));
                System.out.println("Связный список:");
                task(new LinkedList<>(), date1, date2, false);
                System.out.println("Массив:");
                task(new ArrayList<>(), dateCopy1, dateCopy2, false);
                break;
            case 2:
                task(new ArrayList<>(), date1, date2, true);
                break;
        }
    }

    public static void task(List<List<Double>> arr, Calendar date1, Calendar date2, Boolean showСonsumption)
    {
        TaxiDriver[] drivers = new TaxiDriver[TAXI_DRIVER_COUNT];
        for (int i = 0; i < TAXI_DRIVER_COUNT; i++) {
            drivers[i] = new TaxiDriver("Водительно номер " + (i + 1), cars[(int)(Math.random() * CAR_COUNT - 1)]);
        }

        int days = daysBetween(date1.getTime(), date2.getTime());

        long time = System.currentTimeMillis();

        Date date = date1.getTime();
        for (int i = 0; i < days; i++) {

            arr.add(new ArrayList<>());
            double thisDay = 0;

            for (int j = 0; j < TAXI_DRIVER_COUNT; j++) {
                arr.get(i).add(drivers[j].getFuelConsumption());
                thisDay += arr.get(i).get(j);
            }

            if(showСonsumption) {
                System.out.println(date + " : " + thisDay);
            }

            date1.add(Calendar.DATE, 1);
            date = date1.getTime();
        }


       for (int i = 0; i < TAXI_DRIVER_COUNT; i++) {
            double thisDriver = 0;
            for (int j = 0; j < days; j++) {
                thisDriver += arr.get(j).get(i);
            }
            if(showСonsumption) {
                System.out.println(drivers[i].name + " всего потратитл топлива: " + thisDriver);
            }
        }

        System.out.println(System.currentTimeMillis() - time + " милисекунд выполнялся данный код");
    }


}
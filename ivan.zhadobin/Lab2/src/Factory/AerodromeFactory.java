package Factory;

import Enum.AerodromeTypes;
import Models.Aerodrome;
import Models.CivilAerodrome;
import Models.FieldAerodrome;
import Models.MilitaryAerodrome;
import Service.ConsoleWork;

public class AerodromeFactory {
    public static Aerodrome createAirport(AerodromeTypes type) {
        Aerodrome aerodrome = null;
        switch (type) {
            case CIVIL_AERODROME -> aerodrome = createCivilAerodrome();
            case FIELD_AERODROME -> aerodrome = createFieldAerodrome();
            case MILITARY_AERODROME -> aerodrome = createMilitaryAerodrome();
        }
        ;
        return aerodrome;
    }

    private static Aerodrome createCivilAerodrome() {
        System.out.println("Введите количество ангаров: ");
        int countGarage = ConsoleWork.inputIntBetween(0, 100);
        System.out.println("Введите длину ВПП: ");
        int lengthStrip = ConsoleWork.inputIntBetween(0, 100);
        System.out.println("Введите количество топлива: ");
        int countFuel = ConsoleWork.inputIntBetween(0, 3000);
        System.out.println("Введите количество полетов:");
        int countFlights = ConsoleWork.inputIntBetween(0, 10000);
        System.out.println("Введите название самолета:");
        String model = ConsoleWork.inputString();
        return new CivilAerodrome(countGarage, lengthStrip, countFuel, countFlights, model);
    }

    private static Aerodrome createFieldAerodrome() {
        System.out.println("Введите количество ангаров: ");
        int countGarage = ConsoleWork.inputIntBetween(0, 100);
        System.out.println("Введите длину ВПП: ");
        int lengthStrip = ConsoleWork.inputIntBetween(0, 100);
        System.out.println("Введите количество пилотов:");
        int countPilot = ConsoleWork.inputIntBetween(0, 10000);
        System.out.println("Введите объем бака для воды:");
        int water = ConsoleWork.inputIntBetween(0, 100);
        return new FieldAerodrome(countGarage, lengthStrip, countPilot, water);
    }

    private static Aerodrome createMilitaryAerodrome() {
        System.out.println("Введите количество ангаров: ");
        int countGarage = ConsoleWork.inputIntBetween(0, 100);
        System.out.println("Введите длину ВПП: ");
        int lengthStrip = ConsoleWork.inputIntBetween(0, 100);
        System.out.println("Введите количество бомб:");
        int countBomb = ConsoleWork.inputIntBetween(0, 1000);
        System.out.println("Введите кол-во истребителей:");
        int fighterJet = ConsoleWork.inputIntBetween(0, 1000);
        return new MilitaryAerodrome(countGarage, lengthStrip, countBomb, fighterJet);
    }
}

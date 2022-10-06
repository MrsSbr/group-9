import Classes.MaritimeSatellite;
import Classes.MedicalSatellite;
import Classes.MilitarySatellite;
import Classes.Satellite;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Satellite medical1 = new MedicalSatellite(60, "Земля", 100, "Здоровье+",
                "Вылечить планету", 100, 1000);
        Satellite medical2 = new MedicalSatellite(80, "Марс", 1, "Атлас+",
                "Вылечить того кто лечит планету", 0, 1);
        Satellite mart1 = new MaritimeSatellite(200, "planet1", 100, "Сокол1",
                "Убить всех на свете в воде", 2);
        Satellite mart2 = new MaritimeSatellite(300, "planet2", 120, "Сокол2+",
                "Убить того кто хочет убить всех на свете в воде", 1);
        Satellite military1 = new MilitarySatellite(400, "Марс", 100, "Имя1",
                "Убить всех своих", 1);
        Satellite military2 = new MilitarySatellite(500, "Юпитер", 150, "Имя2",
                "Убить того кто хочет убить всех своих", 5);

        List<Satellite> satellites = new ArrayList<>();
        satellites.add(medical1);
        satellites.add(medical2);
        satellites.add(mart1);
        satellites.add(mart2);
        satellites.add(military1);
        satellites.add(military2);
        for (Satellite s : satellites) {
            s.show();
            System.out.println();
        }
        for (Satellite s : satellites) {
            if (s instanceof MedicalSatellite) {
                ((MedicalSatellite) s).editLive(100);
                ((MedicalSatellite) s).printLive();
            }
            if (s instanceof MaritimeSatellite) {
                ((MaritimeSatellite) s).editImmersionDepth(100);
                ((MaritimeSatellite) s).printImmersionDepth();
            }
            if (s instanceof MilitarySatellite) {
                ((MilitarySatellite) s).editCountOfTask(3);
                ((MilitarySatellite) s).printCountOfTask();
            }
        }
    }
}
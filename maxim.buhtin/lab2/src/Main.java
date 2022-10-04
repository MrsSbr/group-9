import Classes.MaritimeSatellite;
import Classes.MedicalSatellite;
import Classes.MilitarySatellite;
import Classes.Satellite;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Satellite medical1=new MedicalSatellite(60,"Земля",100,"Здоровье+","Вылечить планету",100,1000);
        Satellite medical2=new MedicalSatellite(80,"Марс",1,"Атлас+","Вылечить того кто лечит планету",0,1);
        Satellite mart1=new MaritimeSatellite(200,"planet1",100,"Сокол1","Убить всех на свете в воде",100,2);
        Satellite mart2=new MaritimeSatellite(300,"planet2",120,"Сокол2+","Убить того кто хочет убить всех на свете в воде",20,1);
        Satellite military1=new MilitarySatellite(400,"Марс",100,"Имя1","Убить всех своих",1);
        Satellite military2=new MilitarySatellite(500,"Юпитер",150,"Имя2","Убить того кто хочет убить всех своих",1);

        List<Satellite> list=new ArrayList<>();
        list.add(medical1);
        list.add(medical2);
        list.add(mart1);
        list.add(mart2);
        list.add(military1);
        list.add(military2);
        for(Satellite s:list){
            s.show();
            System.out.println();
        }
    }
}
package Classes;

import Interface.Satellitable;

public abstract class Satellite implements Satellitable {
    protected int speed;
    protected int life;
    protected String planet;

    protected String name;
    public  Satellite(int speed,String planet,int life,String name){
        this.speed=speed;
        this.planet=planet;
        this.life=life;
        this.name=name;
    }
    public abstract void show();
    public String getPlanet(){
        return planet;
    }
    public int getSpeed(){
        return speed;
    }
}

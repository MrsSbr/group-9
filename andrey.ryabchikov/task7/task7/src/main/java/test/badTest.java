package test;

public class badTest implements Service{
    @Override
    public void counter() {
        int a = 1/0;
    }
}

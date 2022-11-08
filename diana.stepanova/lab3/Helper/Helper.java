package Helper;

import java.util.Scanner;

public class Helper {
    public  static int input(int left,int right ){
        Scanner in=new Scanner(System.in);
        int choice=0;
        do{
            System.out.println("Введите пункт меню: ");
            try{
                choice=Integer.parseInt(in.next());
            }catch (NumberFormatException e){
                System.out.println("Ошибка ввода!");
                e.printStackTrace();
            }
        }while(choice>right||choice<left);
        return choice;
    }
    public  static String input2(){
        Scanner in=new Scanner(System.in);
        String regex="\\d+";
        String num="";
        do{
            System.out.println("Введите номер пользователя: ");
            num=in.nextLine();
            if(num.length() != 5 || !num.matches(regex)){
                System.out.println("Ошибка ввода!");
            }

        }while(num.length() != 5 || !num.matches(regex));

        return num;
    }

}

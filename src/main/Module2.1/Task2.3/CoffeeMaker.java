///Tämä voi kooda paljon paremmin. Jne, mutta ei ole aikaa korjaa mitään. Niin tämä toimii miten toimii :D



import java.util.Scanner;

public class CoffeeMaker {

    public static void main(String[] args){

        while(true){
            CMachine cm = new CMachine();

            Scanner user = new Scanner(System.in);


            do{
                System.out.println("1 Normal coffee \n2 Espresso");
                cm.chooseDrink(user.nextLine());
            }while(!cm.isDrinkExist());

            do{
                System.out.println("Choose amount \n10-80ml");
                cm.chooseAmount(user.nextLine());
            }while(!cm.isAmountExist());

            System.out.printf("Here we go! %d ml of %s", cm.getAmount(), cm.getDrink());
            System.out.println(" ");


        }
    }
}
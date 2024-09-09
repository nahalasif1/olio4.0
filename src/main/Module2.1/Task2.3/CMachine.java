public class CMachine {

    private boolean pow = false;
    private String drink;
    private boolean drinkExist = false;

    private int amount;
    private boolean amountExist =false;

    public void powerOn(){
        pow = !pow;
    }
    public boolean getPower(){
        return pow;
    }

    public String getDrink() {
        return drink;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isAmountExist() {
        return amountExist;
    }

    public boolean isDrinkExist() {
        return drinkExist;
    }

    public void selectD(String i){

        switch (Integer.parseInt(i)){
            case 1:
                this.drink = "Coffee";
                this.drinkExist = true;
                break;

            case 2:
                this.drink = "Espresso";
                this.drinkExist = true;
                break;
        };
    };

    public void turnOn(){
        while (!getPower()){

        }
    }
    public void  chooseDrink(String i){
        if ("IO".equals(i)){
            powerOn();
            this.drink = "e";
            return;

        }

        if (getPower()){
            ;
            if(Integer.parseInt(i) == 1){
                selectD(i);
            }
            else if (Integer.parseInt(i) == 2){
                selectD(i);
            }
            else{
                System.out.println("Invalid input");
            }
        }
        else{
            System.out.println("Coffee Machine is off. IO to turn it on");
            this.drink ="e";
        }
    }

    public void  chooseAmount(String i){
        if ("IO".equals(i)){
            powerOn();
            return;
        }

        if (getPower()){

            if(Integer.parseInt(i) >= 80){
                this.amount = 80;
                this.amountExist = true;
            }
            else if (Integer.parseInt(i) <= 10){
                this.amount = 10;
                this.amountExist = true;
            }
            else{
                this.amount = Integer.parseInt(i);
                this.amountExist = true;
            }
        }
        else{
            System.out.println("Coffee Machine is off. IO to turn it on");
        }
    }
}
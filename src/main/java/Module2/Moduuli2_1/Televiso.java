package Module2.Moduuli2_1;

public class Televiso {
    //Channel atm
    int channel = 0;

    //Is it on or off?
    boolean state = true;

    // returns current channel
    int getChannel(){
        return channel;
    }
    //Sets channel. if it goes over 10, it will go to 1. So basically tv have only 10 channels.
    void setChannel(int i) {
        if( i > 10){
            channel = 1;
        }
        else{
            channel = i;}

    }

    //returns tv state.
    boolean isOn(){
        return state;
    }

    //Updates Tv state from on to off or from off to on.
    void pressOnOff(){
        state = !state;

    }

}
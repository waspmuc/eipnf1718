/**
 * Created by mkirsch on 21.12.17.
 */
public class Ball {

    int x_position = 7;
    int y_position = 35;
    int durchmesser = 10;


    //Konstruktor
    public Ball() {
        System.out.println("Der Konstruktor wurde aufgerufen");
        x_position = 99;
    }

    public void printXPosition(){
        System.out.println("X-Position ist: " + x_position);
    }

}

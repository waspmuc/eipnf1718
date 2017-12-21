/**
 * Created by mkirsch on 21.12.17.
 */
public class BallFactory {

    public static void main(String[] args) {

        Ball ball1 = new Ball();
        Ball ball2 = new Ball();

        int blabla = 0;

        ball1.x_position = -42;
        ball2.x_position = 50;

        System.out.println("X-Position Ball 1: " + ball1.x_position);
        System.out.println("X-Position Ball 2: " + ball2.x_position);

        ball1.printXPosition();

    }

}

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        for (int i = 0; i < 10; i++) {
            System.out.println("Schleifedurchlauf " + i);
        }

        boolean wahrheitswert = true;
        while (wahrheitswert) {
            System.out.println("Der Wahrheitswert ist " + wahrheitswert);
            wahrheitswert = false;
        }
    }
}

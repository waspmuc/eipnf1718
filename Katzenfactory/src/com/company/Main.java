package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("Das ist meine Katzenfabrik :)");

        Katze katzenObjekt1 = new Katze();
        Katze katzenObjekt2 = new Katze();

        katzenObjekt1.vorname = "Mietz";
        katzenObjekt2.vorname = "Grumpy Cat";

        katzenObjekt1.sayName();
        katzenObjekt2.sayName();

        katzenObjekt1.vorname = "Elsa";
        katzenObjekt1.sayName();
        katzenObjekt1.sayName();

//        for (int i = 0; i < 100; i++) {
//            katzenObjekt1.sayName();
//        }

    }
}

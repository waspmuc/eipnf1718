public class Main {

    public static void main(String[] args) {

        Schnabeltier enton; // Deklarierung
        enton = new Schnabeltier(); // instanzierung

        // Schnabeltier enton = new Schnabeltier(); // Alternativ in einer Zeile

        System.out.println("Name des Tieres: " + enton.name); //Wird von Klasse Schnabeltier überschrieben
        System.out.println("Alter des Tieres: " + enton.alter); //Wird von Klasse Saugetier definiert und nicht von Schnabeltier überschrieben
        System.out.println("Geschlecht des Tieres: " + enton.geschlecht); //Wird von Klasse Schnabeltier überschrieben

    }
}

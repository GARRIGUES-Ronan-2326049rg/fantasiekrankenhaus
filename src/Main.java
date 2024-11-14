import modele.monstre.*;
import modele.Maladie;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        Monstre Ronan = new Monstre();

        Ronan.setNom("Bob");

        Ronan.setSexe('M');

        Ronan.setPoids((short) 100);

        Ronan.setTaille((short) 200);

        Ronan.setAge(10);

        Ronan.setIndicateurMoral((byte) 100);

        Ronan.setListeMaladie(new ArrayList<Maladie>());

        Ronan.attendre();

        System.out.println(Ronan.hurler());
    }
}

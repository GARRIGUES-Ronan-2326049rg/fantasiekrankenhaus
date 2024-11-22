import java.util.ArrayList;
import modele.monstre.Monstre;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Monstre Ronan = new Monstre("Ronan");
        Ronan.setNom("Bob");
        Ronan.setSexe('M');
        Ronan.setPoids((short)100);
        Ronan.setTaille((short)200);
        Ronan.setAge(10);
        Ronan.setIndicateurMoral((byte)100);
        Ronan.setListeMaladie(new ArrayList());
        Ronan.attendre();
        System.out.println(Ronan.hurler());
    }
}

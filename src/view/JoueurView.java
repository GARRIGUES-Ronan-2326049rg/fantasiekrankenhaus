package view;

import modele.monstre.Monstre;
import modele.Medecin;
import modele.service.ServiceMedical;

import java.util.ArrayList;

public class JoueurView {

    public String presentationJeu() {
        return "✨ Bienvenue, Directeur de l'Hôpital des Monstres ! ✨\n" +
                "Votre mission : gérer un hôpital hors du commun où les patients sont... des créatures monstrueuses !\n" +
                "📋 Organisez vos services, 🩺 soignez vos patients et 🚨 gérez les crises pour éviter la catastrophe.\n" +
                "🎯 Objectif : faites preuve de sagesse et de stratégie. Chaque décision aura des conséquences.\n" +
                "Bonne chance, Directeur ! 🏥\n";
    }

    public void demandeChoix() {
        System.out.println("🤔 Que voulez-vous faire ?\n" +
                "   👉 *Agir sur les médecins* : tapez **'agir'**\n" +
                "   👉 *Mettre fin à la partie* : tapez **'finir'**\n");
    }

    public void demandeChoixMedecin(ArrayList<Medecin> listeMedecin) {
        StringBuilder message = new StringBuilder("👨‍⚕️ Voici les médecins encore disponibles pour agir :\n");
        for (int i = 0; i < listeMedecin.size(); ++i) {
            if (listeMedecin.get(i).getActionPossible() > 0) {
                message.append("   ").append(i).append(" - ").append(listeMedecin.get(i).getNom())
                        .append(" (Actions restantes : ").append(listeMedecin.get(i).getActionPossible()).append(")\n");
            }
        }
        System.out.println(message.toString());
    }

    public void demandeAction() {
        System.out.println("⚙️ Actions disponibles pour ce médecin :\n" +
                "   🧐 *Examiner un service* (ne consomme pas d'action) : tapez **Examiner**\n" +
                "   🩺 *Soigner un patient* : tapez **Soigner**\n" +
                "   💰 *Réviser le budget* : tapez **Reviser**\n" +
                "   🔄 *Transférer un patient* : tapez **Transferer**\n");
    }

    public void choisirService(ArrayList<ServiceMedical> listeService) {
        System.out.println("🏢 Sur quel service voulez-vous intervenir ?\n");
        for (ServiceMedical serviceMedical : listeService) {
            System.out.println("   🏥 " + serviceMedical.getNom());
        }
    }

    public void choisirMonstre(ArrayList<Monstre> listeCreature) {
        System.out.println("👾 Sur quel monstre voulez-vous intervenir ?\n");
        for (Monstre monstre : listeCreature) {
            System.out.println("   👹 " + monstre.getNom());
        }
    }

    public void demandeBudget() {
        System.out.println("💰 Combien voulez-vous allouer au budget ? Entrez une valeur : ");
    }
}

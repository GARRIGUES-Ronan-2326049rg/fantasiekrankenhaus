package sounds;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {

    /**
     * Méthode permettant de jouer un son
     * @param cheminFichier
     */
    public static void jouerSon(String cheminFichier) {
        try {
            File fichierAudio = new File(cheminFichier);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(fichierAudio);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Erreur lors de la lecture du fichier audio : " + e.getMessage());
        }
    }
}

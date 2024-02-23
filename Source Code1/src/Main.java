import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.*;

public class Main extends JFrame {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);

        window.setLayout(new FlowLayout());
        JLabel label = new JLabel("Merhaba, Dünya!");
        label.setBackground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 150));
        window.add(label);

        window.setResizable(false);
        window.setTitle("OTONOM HAZİNE AVCISI");
        window.setSize(1600, 1000);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        try {
            File soundFile = new File("C:\\BEN\\Kodlar\\Proje\\Proje_9_Uni_ProLab2_1\\Source Code\\mp3\\karayip.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}

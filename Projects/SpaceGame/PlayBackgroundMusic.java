package SpaceGame;

import java.io.*;
import javax.sound.sampled.*;

//thread to play music and explosion sound in the background
public class PlayBackgroundMusic extends Thread {
    boolean play;

    public void run() {
        try {
            AudioInputStream audioInputStream;
            
            File file = new File("\\SpaceGame\\background.wav"); //add music file
            File file2 = new File("\\SpaceGame\\explosion.wav"); //add explosion file
            
            Clip line;
            Clip line2;

            audioInputStream = AudioSystem.getAudioInputStream(file);
            line = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioInputStream.getFormat()));
            line.open(audioInputStream);
            
            //create a second audio stream for the explosion
            audioInputStream = AudioSystem.getAudioInputStream(file2);
            line2 = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioInputStream.getFormat()));
            line2.open(audioInputStream);

            while (true) {
                if (play) { //only play music if no collision has occurred
                    line.start();
                    if (!line.isRunning())
                        line.setFramePosition(0); //loop condition (music loops until collision)
                } else {
                    line.stop(); //stops playback but does not rewind
                    line.setFramePosition(0); //restore playback position for music

                    line2.start(); //play explosion sound once on collision
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
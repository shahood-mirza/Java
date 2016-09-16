package SpaceGame;

import java.io.*;
import javax.sound.sampled.*;

//play engine noises when the spacecraft accelerates
public class PlayContinuousRumble extends Thread {
    boolean engineOn;

    public void run() {
        try {
            AudioInputStream audioInputStream;
            
            File file = new File("\\SpaceGame\\engine2.wav"); //add engine sound file
            
            Clip line;
            
            audioInputStream = AudioSystem.getAudioInputStream(file);
            line = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioInputStream.getFormat()));
            line.open(audioInputStream);

            while (true) {
                if (engineOn) { //only play engine sounds when the spacecraft is accelerating
                    line.start();
                    if (!line.isRunning())
                        line.setFramePosition(0); //loop condition
                } else {
                    line.stop(); //stops playback but does not rewind
                    line.setFramePosition(0); //restore playback position for engine sound
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
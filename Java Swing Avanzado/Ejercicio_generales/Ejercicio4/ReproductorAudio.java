
package Ejercicio4;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;

public class ReproductorAudio {

    private Clip clip;
    private long posicionPausa;
    private boolean pausado;

    public ReproductorAudio() {
        clip = null;
        posicionPausa = 0;
        pausado = false;
    }

    public void reproducir(String ruta) {
        try {
            detener();

            File archivo = new File(ruta);

            if (!archivo.isFile()) {
                throw new IOException("No se encontró el archivo: "
                        + archivo.getAbsolutePath());
            }

            try (AudioInputStream audio =
                    AudioSystem.getAudioInputStream(archivo)) {

                clip = AudioSystem.getClip();
                clip.open(audio);
            }

            posicionPausa = 0;
            pausado = false;

            clip.setFramePosition(0);
            clip.start();

        } catch (Exception e) {
            System.err.println("Error al reproducir: " + e.getMessage());
            cerrarClip();
            posicionPausa = 0;
            pausado = false;
        }
    }

    public void pausar() {
        if (clip != null && clip.isOpen() && clip.isRunning()) {
            posicionPausa = clip.getMicrosecondPosition();
            clip.stop();
            pausado = true;
        }
    }

    public void reanudar() {
        if (clip != null && clip.isOpen() && pausado) {
            if (posicionPausa >= clip.getMicrosecondLength()) {
                posicionPausa = 0;
            }

            clip.setMicrosecondPosition(posicionPausa);
            clip.start();
            pausado = false;
        }
    }

    public void detener() {
        if (clip != null) {
            if (clip.isRunning()) {
                clip.stop();
            }

            cerrarClip();
        }

        posicionPausa = 0;
        pausado = false;
    }

    public boolean estaReproduciendo() {
        return clip != null && clip.isOpen() && clip.isRunning();
    }

    public boolean estaPausado() {
        return clip != null && clip.isOpen() && pausado;
    }

    private void cerrarClip() {
        if (clip != null) {
            if (clip.isOpen()) {
                clip.close();
            }

            clip = null;
        }
    }
}


package Ejercicio3;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
public class ReproductorSonido {
    private Clip clip;
    // Método para reproducir un sonido WAV
    public boolean reproducir(String ruta) {
        try {
            // Detener el sonido anterior
            detener();
            // Obtener el archivo de sonido
            File archivo = new File(ruta);
            // Comprobar si existe el archivo
            if (!archivo.exists()) {
                System.out.println("No se encontró el archivo: " + ruta);

               return false;
            }

            // Cargar el archivo WAV
            AudioInputStream audio = AudioSystem.getAudioInputStream(archivo);

            // Crear el reproductor Clip
            clip = AudioSystem.getClip();

            // Abrir el archivo de sonido
            clip.open(audio);

            // Reproducir el sonido
            clip.start();

            // Cerrar el flujo cuando termine la reproducción
            clip.addLineListener(event -> {

                if (event.getType() ==
                        javax.sound.sampled.LineEvent.Type.STOP) {

                    clip.close();
                    try {
						audio.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

                }

            });

        } catch (Exception e) {

            System.out.println("Error al reproducir el sonido: "
                    + e.getMessage());

        }
		return false;
    }

    // Método para detener la reproducción
    public void detener() {

        if (clip != null && clip.isOpen()) {

            clip.stop();
            clip.close();

            clip = null;
        }
    }
}

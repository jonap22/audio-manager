/* Libraries */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings({"unused","SpellCheckingInspection"})

public class Explorador {

    /* Variables */
    private String directorio = "C:/Users/Rafa/IdeaProjects/ProyectoAudio/audioLibrary";
    private final File files = new File(directorio);
    private final File[] listado = files.listFiles();
    File pistaDeAudio = null;

    /* Método que permite validar si la ruta especificada es válida */
    private boolean validarRuta(String ruta) {
        return Files.exists(Path.of(ruta));
    }

    /* Método que permite modificar el directorio actual */
    public void cambiarRutaActual(String ruta) {
        if (validarRuta(ruta)) {
            directorio = ruta;
        }
    }

    /* Método que despliega el listado de archivos del directorio actual */
    public void mostrarListado() {
        // Preordenado inicial de la lista de archivos de audio
        if (listado != null) {
            Arrays.sort(listado);
            // Bucle para recorrer la lista de archivos
            for (File file : listado) {
                System.out.println(file.getName());
            }
        }
    }

    /* Método que obtiene la pista especificada desde el directorio actual */
    public void obtenerPista(String nombre) throws IOException {
        List<Path> result;
        try (Stream<Path> walk = Files.walk(Path.of(directorio))) {
            result = walk
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().equalsIgnoreCase(nombre))
                    .collect(Collectors.toList());
        }

        pistaDeAudio = new File(String.valueOf(result.get(0)));
    }

    /* Método que permite reproducir la pista de audio */
    public void reproducirPistaDeAudio() {
        throw new UnsupportedOperationException();
    }

    /* Método que permite trasnformar el formato de la pista de audio */
    public void convertirPistaDeAudio(String formato) {
        throw new UnsupportedOperationException();
    }

    /* Método para eliminar una pista dentro del reproductor */
    public void eliminarPista(String nombre) {
        throw new UnsupportedOperationException();
    }

    /* Método para guardar una pista de sonido */
    public void guardarPista(File pista, String ruta) {
        throw new UnsupportedOperationException();
    }

    /* Método que permite mover las pista a un nuevo directorio */
    public void moverPista(String nombre, String ruta) {
        throw new UnsupportedOperationException();
    }

}
package EjercicioMuevo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Buscapalabra {

    public static void main(String[] args) throws IOException {
        String nomFichero = args[0]; 
        String palabra = args[1];

        String ruta = "EjercicioMuevo/Ficheros/" + nomFichero + ".txt";

        Stream<String> lineas = Files.lines(Paths.get(ruta));

        var repeticiones = lineas.map(l -> l.toLowerCase())
        .filter(l -> l.contains(palabra))
        .count();

        System.out.println("La palabra se repite " + repeticiones);
    }
}

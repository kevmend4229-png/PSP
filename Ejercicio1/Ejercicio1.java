import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dame un numero");

        int numero = sc.nextInt();

        List<Process> proceso = new ArrayList<>();

        ProcessBuilder constructor = new ProcessBuilder("notepad.exe");

        for (int i = 0; i < numero; i++) {
            proceso.add(constructor.start());

            System.out.println("Calculadora abierta, PID: " + proceso.get(i).pid());

        }

        while (true) {
            int contador = numero;
            if (proceso.size() < numero) {
                for (int i = 0; i < numero; i++) {
                    if (!proceso.get(i).isAlive()) {
                        Long codigoSalida = proceso.get(i).pid();
                        System.out.println("Se cerró el proceso " + codigoSalida);
                    }
                }
            }
            if (proceso.size() == 0) {
                break;
            }

        }

        // int codigoSalida = proceso.waitFor();
        // System.out.println("La calculadora se cerró con código " + codigoSalida);

    }

}
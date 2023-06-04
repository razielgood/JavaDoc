package partidaAjedrezReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * La clase PartidaAjedrezReader se encarga de leer información de partidas de ajedrez desde un archivo CSV.
 */
public class PartidaAjedrezReader {
    private String filePath; // Ruta del archivo de partidas de ajedrez

    /**
     * Constructor de la clase PartidaAjedrezReader.
     *
     * @param filePath la ruta del archivo de partidas de ajedrez
     */
    public PartidaAjedrezReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Método privado para mostrar un campo y su valor.
     *
     * @param etiqueta la etiqueta del campo
     * @param valor    el valor del campo
     */
    private void mostrarCampo(String etiqueta, String valor) {
        System.out.println(etiqueta + ": " + valor);
    }

    /**
     * Método privado para mostrar una fecha en un formato entendible.
     *
     * @param fechaUTC la fecha en formato UTC (timestamp)
     */
    private void mostrarFechaEntendible(String fechaUTC) {
        try {
            long timestamp = (long) Double.parseDouble(fechaUTC);
            Date fecha = new Date(timestamp);
            SimpleDateFormat formatoEntendible = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            String fechaEntendible = formatoEntendible.format(fecha);
            mostrarCampo("Fecha", fechaEntendible);
        } catch (NumberFormatException e) {
            System.out.println("Error al parsear la fecha.");
        }
    }

    /**
     * Método para mostrar la información de una partida de ajedrez específica.
     *
     * @param numeroLinea el número de línea correspondiente a la partida en el archivo
     */
    public void mostrarInformacionPartida(int numeroLinea) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/partidaAjedrezReader/partidas_ajedrez.csv"));
            String linea = br.readLine();
            int contadorLinea = 1;

            while (linea != null) {
                if (contadorLinea == numeroLinea) {
                    String[] campos = linea.split(",");
                    mostrarCampo("ID", campos[0]);
                    mostrarCampo("Rated", campos[1]);
                    mostrarFechaEntendible(campos[2]);
                    mostrarCampo("Turns", campos[3]);
                    mostrarCampo("Victory Status", campos[4]);
                    mostrarCampo("Winner", campos[5]);
                    mostrarCampo("Increment", campos[6]);
                    mostrarCampo("White id", campos[7]);
                    mostrarCampo("white rating", campos[8]);
                    mostrarCampo("black id", campos[9]);
                    mostrarCampo("black rating", campos[10]);
                    mostrarCampo("moves", campos[11]);
                    mostrarCampo("opening_eco", campos[12]);
                    mostrarCampo("opening_name", campos[13]);
                    mostrarCampo("opening_ply", campos[14]);
                    System.out.println("----------------------");
                    break;
                }
                contadorLinea++;
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


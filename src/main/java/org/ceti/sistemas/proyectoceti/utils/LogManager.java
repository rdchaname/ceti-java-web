package org.ceti.sistemas.proyectoceti.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Finalidad de esta clase es guardar los eventos de mi 
 * aplicación
 * @author Dario
 */
public class LogManager {

    private final static Logger LOGGER_PRINCIPAL = Logger.getLogger("proyecto");
    private final static String UBICACION_LOG = "./logger.log";

    public static void registrarEvento(Exception error, String nivel) {
        try {
            // SEVERE => es un nivel de error alto
            // INFO => es un mensaje de información
            // WARNING => advertencia de un posible error
            // true => agregar información al final del archivo
            // false => reemplazar todo el archivo.
            Handler fileHandler = new FileHandler(UBICACION_LOG, true);
            // formatear el error en texto
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            fileHandler.setLevel(Level.ALL);
            // LOGGER_PRINCIPAL asignarle su handler
            LOGGER_PRINCIPAL.addHandler(fileHandler);
            
            Level nivelEvento = Level.SEVERE;
            switch(nivel){
                case "SEVERE":
                    nivelEvento = Level.SEVERE;
                    break;
                case "WARNING":
                    nivelEvento = Level.WARNING;
                    break;
                case "INFO":
                    nivelEvento = Level.INFO;
                    break;
                default:
                    nivelEvento = Level.SEVERE;
                    break;
            }
            LOGGER_PRINCIPAL.log(nivelEvento, LogManager.convertirExceptionString(error));
        } catch (IOException | SecurityException err) {
            System.out.println(err.getMessage());
        }

    }
    
    /**
     * convertir Exception a string
     * @return 
     */
    public static String convertirExceptionString(Exception error){
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        // imprimir en consola
        error.printStackTrace(pWriter);
        return sWriter.toString();
    }
}

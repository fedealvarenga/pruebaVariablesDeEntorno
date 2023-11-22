package org.example;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ActualizadorXML {
  public static void actualizarXMLConVariablesEntorno(String rutaArchivoXML, Dotenv dotenv) {
    try {
      // Leer contenido del archivo XML
      String contenidoXML = new String(Files.readAllBytes(Paths.get(rutaArchivoXML)));

      // Reemplazar valores con variables de entorno
      contenidoXML = reemplazarValoresConVariablesEntorno(contenidoXML, dotenv);

      // Escribir el contenido actualizado de vuelta al archivo XML
      Files.write(Paths.get(rutaArchivoXML), contenidoXML.getBytes());

      System.out.println("Archivo XML actualizado con variables de entorno.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String reemplazarValoresConVariablesEntorno(String contenidoXML, Dotenv dotenv) {
    // Reemplazar valores con las variables de entorno
    contenidoXML = contenidoXML.replace("${DATABASE_URL}", dotenv.get("DATABASE_URL"));
    contenidoXML = contenidoXML.replace("${DATABASE_USER}", dotenv.get("DATABASE_USER"));
    contenidoXML = contenidoXML.replace("${DATABASE_PASSWORD}", dotenv.get("DATABASE_PASSWORD"));

    return contenidoXML;
  }
}
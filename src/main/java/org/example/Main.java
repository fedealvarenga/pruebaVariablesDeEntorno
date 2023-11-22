package org.example;

import io.github.cdimascio.dotenv.Dotenv;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    Dotenv dotenv = Dotenv.load();
    String dbConnectionString = dotenv.get("DB_CONNECTION_STRING");
    System.out.println("DB_CONNECTION_STRING: " + dbConnectionString);
    ActualizadorXML.actualizarXMLConVariablesEntorno("C:/Users/fede/Desktop/ACELERADORA/pruebaEnv/src/main/resources/prueba.xml", dotenv);
  }
}
import io.github.cdimascio.dotenv.Dotenv;
import org.example.ActualizadorXML;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class ActualizadorXMLTest {

  @Test
  public void testReemplazoVariablesEntornoEnXML() {
    // Configuración para el entorno de prueba
    String rutaArchivoXML = "C:/Users/fede/Desktop/ACELERADORA/pruebaEnv/src/main/resources/prueba.xml";
    Dotenv dotenv = Dotenv.load();

    // Realizar el reemplazo en el XML
    ActualizadorXML.actualizarXMLConVariablesEntorno(rutaArchivoXML, dotenv);

    // Verificar que el archivo XML tiene las variables reemplazadas
    assertVariablesReemplazadas(rutaArchivoXML, dotenv);
  }

  private void assertVariablesReemplazadas(String rutaArchivoXML, Dotenv dotenv) {
    try {
      // Leer contenido del archivo XML
      String contenidoXML = new String(Files.readAllBytes(Paths.get(rutaArchivoXML)));

      // Verificar que las variables de entorno están reemplazadas correctamente
      assertTrue(contenidoXML.contains(dotenv.get("DATABASE_URL")));
      assertTrue(contenidoXML.contains(dotenv.get("DATABASE_USER")));
      assertTrue(contenidoXML.contains(dotenv.get("DATABASE_PASSWORD")));
    } catch (Exception e) {
      fail("Error al leer el archivo XML: " + e.getMessage());
    }
  }
}
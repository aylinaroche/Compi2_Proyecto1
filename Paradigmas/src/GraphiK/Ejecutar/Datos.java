package Graphik.Ejecutar;

/**
 *
 * @author Aylin
 */
public class Datos {
    
    public static String[][] aDatos = new String[10][10];
    
    public static void main(String[] args) throws Exception {
        guardarDatos("[\"Departamento\"], [\"medida1\"], [\"medida2\"]\n"
                + "{\"Guatemala\"}, {15678}, {10264},\n"
                + "{\"El progreso\"}, {3196}, {2345}");
    }
    
    public static void guardarDatos(String texto) {
        String fila[] = texto.split("\n");
        
        for (int i = 0; i < fila.length; i++) {
            String datos = fila[i].replace("]", "").replace("[", "").replace("\"", "").replace(" ", "");
            
            String columna[] = datos.split(",");
            for (int j = 0; j < columna.length; j++) {
                String dato = columna[j].replace("{", "").replace("}", "").replace(" ", "");
                aDatos[i][j] = dato;
                System.out.println(i + "," + j + "=" + dato);
            }
            
        }
    }
}

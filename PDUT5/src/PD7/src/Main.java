import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        TArbolTrieTelefonos trieAbonados = new TArbolTrieTelefonos();

        String[] lineas = ManejadorArchivosGenerico1.leerArchivo("src\\abonados.txt");
        for (String linea : lineas) {
            String[] partes = linea.split(",");
            if (partes.length == 2) {
                String nombre = partes[1].trim();
                String telefono = partes[0].trim();
                TAbonado abonado = new TAbonado(nombre, telefono);
                trieAbonados.insertar(abonado);
            }
        }

        // 2. BUSCAR ABONADOS QUE EMPIECEN CON EL CÓDIGO DE PAÍS Y ÁREA
        String[] codigos = ManejadorArchivosGenerico1.leerArchivo("src\\codigos1.txt");
        String[] codigoPais1 = codigos[0].split(":");
        String[] codigoArea1 = codigos[1].split(":");
        String codigoPais = codigoPais1[1].trim();
        String codigoArea = codigoArea1[1].trim();

        LinkedList<TAbonado> lista = trieAbonados.buscarTelefonos(codigoPais, codigoArea);

        // 3. ORDENAR LA LISTA POR NOMBRE
        Collections.sort(lista);

        // 4. CONVERTIR A FORMATO DE TEXTO PARA GUARDAR
        String[] salida = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            TAbonado a = lista.get(i);
            salida[i] = a.getNombre() + " - " + a.getTelefono();
        }

        // 5. ESCRIBIR EN SALIDA.TXT
        ManejadorArchivosGenerico1.escribirArchivo("salida.txt", salida);
        trieAbonados.imprimir();
        System.out.println("Se generó 'salida.txt'.");
    }
    
}

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class TArbolTrieTelefonosTest {

    private TArbolTrieTelefonos trie;

    @BeforeEach
    public void setUp() {
        trie = new TArbolTrieTelefonos();
        String[] lineas = ManejadorArchivosGenerico1.leerArchivo("src\\abonados.txt");
        for (String linea : lineas) {
            String[] partes = linea.split(",");
            if (partes.length == 2) {
                String nombre = partes[1].trim();
                String telefono = partes[0].trim();
                TAbonado abonado = new TAbonado(nombre, telefono);
                trie.insertar(abonado);
            }
        }
    }

    @AfterEach
    public void tearDown() {
        trie = null;
    }

    @Test
    public void buscarTelefonos() {
       LinkedList<TAbonado> lsita = trie.buscarTelefonos("598", "99");
       Assertions.assertNotNull(lsita);
       Assertions.assertFalse(lsita.isEmpty());
    }
    @Test

    public void buscarTelefonosRegionFalsa() {
        LinkedList<TAbonado> lsita = trie.buscarTelefonos("689", "99");
        Assertions.assertNotNull(lsita);
        Assertions.assertTrue(lsita.isEmpty());
    }

    @Test
    public void buscarTelefonosAreaFalsa() {
        LinkedList<TAbonado> lsita = trie.buscarTelefonos("598", "10");
        Assertions.assertNotNull(lsita);
        Assertions.assertTrue(lsita.isEmpty());
    }

    @Test
    public void InsertarTelefono() {
        TAbonado abonado = new TAbonado("Facundo", "05490145702");
        trie.insertar(abonado);
        Assertions.assertNotNull(trie.getRaiz());
        TAbonado abonado2 = new TAbonado("Thiago", "05490127153");
        trie.insertar(abonado2);
        TNodoTrieTelefonos[] a = trie.getHijos();
        LinkedList<TNodoTrieTelefonos> ll = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            ll.add(a[i]);
        }
        Assertions.assertFalse(ll.isEmpty());
    }
    @Test
    public void InsertarTelefonoInvalido() {
        TAbonado abonado = new TAbonado("Facundo", "1a2");
        trie.insertar(abonado);
        Assertions.assertNotNull(trie.getRaiz());
        Assertions.assertNotNull(trie.getAbonados());
        Assertions.assertTrue(trie.getAbonados().isEmpty());

    }

}
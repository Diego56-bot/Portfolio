package PD2;

public interface IHash<K, V> {

    /**
     * Busca un valor asociado a una clave en la tabla hash.
     * Si la clave no existe, devuelve null.
     *
     * @param unaClave la clave a buscar en la tabla hash.
     * @return el valor asociado a la clave, o null si no existe.
     */
    public V buscar(K unaClave);

    /**
     * Inserta un valor asociado a una clave en la tabla hash.
     * Si la clave ya existe, se actualiza el valor.
     *
     * @param unValor el valor a insertar en la tabla hash.
     * @return true si la inserción fue exitosa, false si hubo un error.
     */
    public boolean insertar(K clave,V unValor);
}

package PD1;
public class TElementoAG<T> implements IElementoAG<T> {

    private Comparable etiqueta;
    private TElementoAG<T> primerhijo;
    private TElementoAG<T> hermano;

    public Comparable getEtiqueta() {return etiqueta;}
    public void setEtiqueta(Comparable etiqueta) {
        this.etiqueta = etiqueta;
    }

    public TElementoAG<T> getPrimerHijo() {return primerhijo;}
    public void setPrimerHijo(TElementoAG<T> primerhijo) {
        this.primerhijo = primerhijo;
    }

    public TElementoAG<T> getHermano() {return hermano;}
    public void setHermano(TElementoAG<T> hermano) {
        this.hermano = hermano;
    }

    public TElementoAG(Comparable etiqueta){
        this.etiqueta = etiqueta;
    }


    private TElementoAG<T> getUltimoHijo() {
        TElementoAG<T> hijoActual = getPrimerHijo();
        if (hijoActual == null) return null;

        while (hijoActual.getHermano() != null) {
            hijoActual = hijoActual.getHermano();
        }

        return hijoActual;
    }

    @Override
    public TElementoAG<T> buscar(Comparable etiquetabuscada) {
        if(this.getPrimerHijo().getEtiqueta() == etiquetabuscada){
            return this.getPrimerHijo();
        }
        TElementoAG<T> resultado = primerhijo.buscar(etiquetabuscada);

        if (resultado != null){
            return resultado;
        }
        TElementoAG<T> hermanoactual = primerhijo.getHermano();

        while (hermanoactual != null){
            if (hermanoactual.getEtiqueta() == etiquetabuscada){
                return hermanoactual;
            }
            resultado = hermano.buscar(etiquetabuscada);
            if (resultado != null){
                return resultado;
            }
            hermanoactual = hermano.getHermano();
        }
        return null;
    }

    public boolean insertar(Comparable etiquetabuscada, Comparable etiquetaPadre) {
        TElementoAG<T> nuevo = new TElementoAG<T>(etiquetabuscada);

        if (etiquetaPadre == ""){
            TElementoAG<T> hijoUltimo = getUltimoHijo();
            if (hijoUltimo != null){
                hijoUltimo.setHermano(nuevo);
            }
            else {
                this.setPrimerHijo(nuevo);
            }
            return true;
        }
        TElementoAG<T> nodoPadre = buscar(etiquetaPadre);
        /* Padre encontrado, se procede a insertar como el ultimo de sus hijos*/
        if (nodoPadre != null){
            TElementoAG ultimoHijo = nodoPadre.getUltimoHijo();
            if (ultimoHijo != null){
                ultimoHijo.setHermano(nuevo);
            }
            else {
                nodoPadre.setPrimerHijo(nuevo);
            }
            return true;
        }
        return false;
    }
}

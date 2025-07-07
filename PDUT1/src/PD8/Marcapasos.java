package PD8;

public class Marcapasos {

    short presionSanguinea;

    short frecuenciaCardiaca;

    short nivelAzucar;

    long maximaFuerza;

    float minimoTiempoEntreLatidos;

    float bateriaRestante;

    char[] codigoFabricante = new char[8];
}

/*Se usa "short" porque en Java ocupa 2 bytes y
puede almacenar valores desde -32,768 hasta 32,767, que cubre perfectamente
los rangos de los datos pequeños
*/
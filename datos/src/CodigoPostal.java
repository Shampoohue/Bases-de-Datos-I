public class CodigoPostal {
    String codigo; // aqui se guarda el codigo postal en si
    int n_localidades; // y aqui se guarda el numero de localidades asignadas a cada codigo postal

    // el constructor de la clase
    public CodigoPostal(String codigo, int n_localidades){
        this.codigo = codigo;
        this.n_localidades = n_localidades;
    }

    // el metodo para imprimir los datos de cada codigo postal que utilizaremos en el forloop final
    public void datosCp(){
        System.out.println("Codigo Postal: " + codigo + " - Número de asentamientos: " + n_localidades);
    }
}

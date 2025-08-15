import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/codigos_postales_hmo.csv")); // el scanner dedicado a leer el archivo que va a extraer la informacion del .csv
        // scanner.useDelimiter(",");

        int num_datos = 2133; // el numero de lineas en bruto que hay en el archivo
        int num_cp = 358; // el numero de codigos postales distintos que hay en el archivo

        // esto un arreglo para guardar los codigos postales en bruto
        String cp_raw[] = new String[num_datos+1];
        cp_raw[num_datos] = "fin";

        // esto otro es un arreglo de un objeto "CodigoPostal" que se compone del codigo y el numero de localidades
        CodigoPostal cp[] = new CodigoPostal[num_cp+1];


        int n = 1; // el contador principal. Este contador es el que se encarga de dar seguimiento al numero de asentamientos por cada codigo postal de turno
        int j = 0; // un contador independiente que utilizo mas adelante para no sobrepasar el limite del arreglo que guarda los codigos postales ya 'refinados'

        // esto captura todas las filas de datos y las llena en el arreglo de codigos postales en crudo
        for (int i = 0; i < num_datos; i++){
            cp_raw[i]= scanner.nextLine().substring(0,5); // tomamos los primeros 5 caracteres, pues estos corresponden al codigo postal

        }
        // aca se compara cada indice con su antecesor directo para contar repeticiones
        for (int i = 1; i < num_datos+1; i++){
            if(cp_raw[i].equals(cp_raw[i-1])){
                n++;
            }
            else{ // de no haber mas del mismo codigo, aca se guardan los datos en el objeto y reseteamos el contador n
                cp[j] = new CodigoPostal(cp_raw[i-1], n);
                j++; // indice independiente para no exceder el limite del array
                n = 1;
            }
        }
        // esta linea guarda el último indice del array
        cp[j] = new CodigoPostal(cp_raw[num_datos-1], n);

        // finalmente esto imprime el array de codigos con sus cantidades de localidades guardadas
        for (int i = 0; i < j; i++){
            cp[i].datosCp();
        }

        scanner.close(); // cerramos el scanner por eficiencia
    }
}

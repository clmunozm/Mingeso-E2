package Mingeso.ejercicio4;

public class Refactoring {

    public boolean[] tabla_num_enteros(int l){
        boolean[] tabla = new  boolean[l];
        for (int i=0; i<l; i++)
            tabla[i] = true;
        return tabla;
    }

    public boolean[] elim_mult_de_dos(boolean[] tabla, int l){
        for (int i=2; i<Math.sqrt(l)+1; i++) {
            if (tabla[i]) {
                for (int j=2*i; j<l; j+=i)
                    tabla[j] = false;
            }
        }
        return tabla;
    }

    public int[] obtener_numeros(boolean[] tabla, int l){
        int cuenta = 0;
        for (int i=0; i<l; i++) {
            if (tabla[i])
                cuenta++;
        }
        int[] n_prim = new int[cuenta];
        for (int i=0, j=0; i<l; i++) {
            if (tabla[i])
                n_prim[j++] = i;
        }
        return n_prim;
    }

    public int[] num_primos (int n) {
        if (n >= 2) {
            // Declaraciones
            int largo = n + 1; // Largo de la tabla con los números
            boolean[] tabla = tabla_num_enteros(largo); // // Tabla con los números
            tabla[0] = tabla[1] = false;
            tabla = elim_mult_de_dos(tabla, largo);
            int[] n_primos = obtener_numeros(tabla, largo);
            return n_primos;
        } else {
            return new int[0];
        }
    }
}

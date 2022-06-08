package Mingeso.ejercicio4;

public class Algoritmo
{

    public int[] num_p (int n)
    {
        int i,j,k;
        int n_list, p_datos;
        if (n >= 2) {
            // Declaraciones
            int d = n + 1;
            boolean[] tabla = new  boolean[d];
            for (i=0; i<d; i++)
                tabla[i] = true;
            tabla[0] = tabla[1] = false;
            for (i=2; i<Math.sqrt(d)+1; i++) {
                if (tabla[i]) {
                    for (j=2*i; j<d; j+=i)
                        tabla[j] = false;
                }
            }
            int cuenta = 0;
            for (i=0; i<d; i++) {
                if (tabla[i])
                    cuenta++;
            }
            int[] n_prim = new int[cuenta];
            for (i=0, j=0; i<d; i++) {
                if (tabla[i])
                    n_prim[j++] = i;
            }
            return n_prim;
        } else {
            return new int[0];
        }
    }
}

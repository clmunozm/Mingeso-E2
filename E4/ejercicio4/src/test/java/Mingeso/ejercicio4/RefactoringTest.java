package Mingeso.ejercicio4;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RefactoringTest {
    Algoritmo algoritmo = new Algoritmo();
    Refactoring refactoring = new Refactoring();

    @Test
    public void num_primoTest1(){
        int n = 1;
        int[] numeros_primos = refactoring.num_primos(n);
        int[] esperado = algoritmo.num_p(n);
        assertArrayEquals(esperado, numeros_primos);
    }

    @Test
    public void num_primoTest3(){
        int n = 3;
        int[] numeros_primos = refactoring.num_primos(n);
        int[] esperado = algoritmo.num_p(n);
        assertArrayEquals(esperado, numeros_primos);
    }

    @Test
    public void num_primoTest7(){
        int n = 7;
        int[] numeros_primos = refactoring.num_primos(n);
        int[] esperado = algoritmo.num_p(n);
        assertArrayEquals(esperado, numeros_primos);
    }
}

package com.aprog;
import java.util.*;

public class Ex27 {
    public static void main(String[] args) {
        int N;
        Scanner ler = new Scanner(System.in);
        N = ler.nextInt();

        for (int i = 0; i < N; i++) {
            int result = verificarArmstrong(i);
            if (result == 1) {
                System.out.println(i);
            }
        }
    }

    public static int verificarArmstrong(int num) {
        int alg1, alg2, soma = 0, count = 0;
        int copia = num;
        while (copia > 0) {
            alg1 = copia % 10;
            copia /= 10;
            count++;
        }
        
        copia = num;
        while (copia > 0) {
            alg2 = copia % 10;
            copia /= 10;
            soma += Math.pow(alg2, count);
        }

        if (num == soma) {
            return 1;
        } else {
            return 0;
        }
    }
}

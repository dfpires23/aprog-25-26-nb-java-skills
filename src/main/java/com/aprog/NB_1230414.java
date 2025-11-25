package com.aprog;

import java.util.Scanner;

// NB_1230414 Daniel Ferreira Pires

public class NB_1230414 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int qntFichas = 0;
        int qntViagens = 0;
        int qntViagensManha = 0;
        int qntViagensTarde = 0;
        int tempoTotal = 0;
        int lucro = 0;
        int lucroManha = 0; 
        int lucroTarde = 0;
        int pista = 0;
        int tipoFicha = 0;
        int tempo = 0;

        qntFichas = ler.nextInt();
        while (verificarLimites(qntFichas, 1, 20) == 0) {
            qntFichas = ler.nextInt();
        }

        for (int i = 0; i < qntFichas; i++) {
            pista = ler.nextInt();
            while (verificarLimites(pista, 1, 8) == 0) {
                pista = ler.nextInt();
            }
            
            tipoFicha = ler.nextInt();
            while (verificarLimites(tipoFicha, 1, 2) == 0) {
                tipoFicha = ler.nextInt();
            }
            
            tempo = calcularTempo(tipoFicha);
            
            tempoTotal += tempo;
            qntViagens++;

            lucro = calcularLucro(tipoFicha);

            if (pista == 1 || pista == 3 || pista == 5 || pista == 7) {
                lucroManha += lucro;
                qntViagensManha++;
            } else {
                lucroTarde += lucro;
                qntViagensTarde++;
            }
        }

        float tempoMedio = (float) tempoTotal / qntViagens;
        System.out.printf("O tempo médio das viagens foi de %.1f minutos\n", tempoMedio);

        int lucroTotal = lucroManha + lucroTarde;
        float percentagemManha = (float) lucroManha / lucroTotal * 100;
        float percentagemTarde = (float) lucroTarde / lucroTotal * 100;
        System.out.printf("O lucro foi: manha=%.1f%% e tarde=%.1f%%\n", percentagemManha, percentagemTarde);

        imprimirViagens(qntViagensManha, qntViagensTarde);
    }

    public static int verificarLimites(int valor, int limInferior, int limSuperior) {
        if (valor >= limInferior && valor <= limSuperior) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int calcularLucro(int tipoFicha) {
        int lucro = 0;
        switch (tipoFicha) {
            case 1:
                lucro = 3;
                break;
            case 2:
                lucro = 5;
                break;
        }
        return lucro;
    }

    public static int calcularTempo(int tipoFicha) {
        int tempo = 0;
        switch (tipoFicha) {
            case 1:
                tempo = 1;
                break;
            case 2:
                tempo = 2;
                break;
        }
        return tempo;
    }

    public static void imprimirViagens(int qntViagensManha, int qntViagensTarde) {
        if (qntViagensManha > qntViagensTarde) {
            System.out.println("O período da manha teve mais viagens");
        } else if (qntViagensTarde > qntViagensManha) {
            System.out.println("O período da tarde teve mais viagens");
        } else {
            System.out.println("Os períodos tiveram a mesma quantidade de viagens");
        }
    }
}

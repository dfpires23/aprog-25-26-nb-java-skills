package com.aprog;

import java.util.Scanner;

public class Ex45 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String[][] predio = new String[3][4];
        lerPropietarios(predio, ler);
        String proprietario = ler.nextLine();
        encontrarApartamento(predio, proprietario);
    }

    public static void lerPropietarios(String[][] predio, Scanner ler) {
        for (int i = 0; i < predio.length; i++) {
            for (int j = 0; j < predio[i].length; j++) {
                predio[i][j] = ler.nextLine();
            }
        }
    }

    public static void encontrarApartamento(String[][] predio, String proprietario) {
        int count = 0;
        for (int i = 0; i < predio.length; i++) {
            for (int j = 0; j < predio[i].length; j++) {
                if (predio[i][j].equals(proprietario)) {
                    System.out.println("name=" + proprietario);
                    System.out.println("entrance=" + (i));
                    System.out.println("floor=" + (j));
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Do not live in the building");
        }
    }
}

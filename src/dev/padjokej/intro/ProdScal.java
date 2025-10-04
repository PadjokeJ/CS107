package dev.padjokej.intro;

import java.util.Scanner;

public class ProdScal {
    public static void main(String[] args) {
        int nMax = 10;
        int[] vect1 = new int[nMax];
        int[] vect2 = new int[nMax];

        Scanner scanner = new Scanner(System.in);

        int n = 0;
        do {
            System.out.println("What is the desired effective size of your vectors?");
            n = scanner.nextInt();
        } while (n > nMax);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Give the component v"+ (i+1) + "_" + j + " of the vector");
                switch (i) {
                    case 0 -> vect1[j] = scanner.nextInt();
                    case 1 -> vect2[j] = scanner.nextInt();
                    default -> System.out.println("An error occured during the loop");
                }
            }
        }

        int prod = 0;

        for (int i = 0; i < nMax; i++) {
            prod += vect1[i] * vect2[i];
        }

        System.out.println("The scalar product of v1 and v2 is " + prod);

    }
}

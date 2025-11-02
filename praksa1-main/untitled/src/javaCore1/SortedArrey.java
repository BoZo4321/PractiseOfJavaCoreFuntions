package javaCore1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SortedArrey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesi duzinu niza:");

        //provera da li je unos pravilan tj int
        int duzinaNiza = 0;
        if (scanner.hasNextInt()) {
            duzinaNiza = scanner.nextInt();
        } else {
            System.out.println("Greska ne moze biti nista osim brojeva duzina niza");
            return;
        }

        //provera da li je duzina veca od 1
        if(duzinaNiza < 1 ){
            System.out.println("Greska ne moze duzina niza biti manja od 1");
            return;}

        int[] nizBrojeva = new int[duzinaNiza];

        System.out.println("Unesi brojeve za niz");
        //ucitavamo samo prvi element da bi imali s kim da ga uporedjujemo
        nizBrojeva[0] = scanner.nextInt();

        for (int i = 1; i < duzinaNiza; i++) {

            // testiranje da li je sadrzaj niza samo int
            if (scanner.hasNextInt()) {
                nizBrojeva[i] = scanner.nextInt();

                if (nizBrojeva[i - 1] > nizBrojeva[i]) {
                    System.out.println("false");
                    break;
                }

                if (i == duzinaNiza - 1) {
                    System.out.println("True");
                }
            } else {
                System.out.println("Greska ne moze biti nista osim brojeva u nizu");
                break;
            }
        }
        scanner.close();
    }
}
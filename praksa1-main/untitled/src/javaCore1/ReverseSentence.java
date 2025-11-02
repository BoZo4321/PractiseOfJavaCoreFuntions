package javaCore1;

import java.util.Scanner;

public class ReverseSentence {
    public static void main(String[] args) {
        System.out.println("Unesi recenicu:");

        Scanner scanner = new Scanner(System.in);
        String recenica = scanner.nextLine();

        if(recenica.isEmpty()){
            System.out.println("ne moze prazan sting da bude");
            return;
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder sbDrugiNacin = new StringBuilder(recenica);
        String recenicaString = "";

        for (int i = recenica.length(); i > 0; i--) {
            //preko stringBuildera 1. nacin
            sb.append(recenica.charAt(i - 1));

            //stampanje karakter po karakter 2. nacin
            System.out.print(recenica.charAt(i - 1));

            //Skupljanjem u jedan String konkatanacijom 3. nacin
            recenicaString = recenicaString + recenica.charAt(i - 1);
        }
        //dodavanje jednog praznog reda zbog 2.nacina
        System.out.println();

        //rekurzivna metoda za okretanje stringa 4. nacin
        String rekurzivnaRecenica = rekurzijaOkretanjaString(recenica);

        System.out.println(recenicaString);
        System.out.println(sb);
        System.out.println(rekurzivnaRecenica);

        //StringBuiler integrisana metoda 5. nacin
        System.out.println(sbDrugiNacin.reverse());
    }

    static String rekurzijaOkretanjaString(String unos){
        if(unos.length() == 1)
            return unos;
        return rekurzijaOkretanjaString(unos.substring(1)) + unos.charAt(0);
    }
}

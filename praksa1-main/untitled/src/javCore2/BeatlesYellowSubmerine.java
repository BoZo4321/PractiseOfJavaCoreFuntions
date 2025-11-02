package javCore2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class BeatlesYellowSubmerine {

    public static void main(String[] args) throws IOException {

        String tekstPesme = "";
        try {
            tekstPesme = Files.readString(Paths.get("pesmaYellowSubmerine.txt"));
        } catch (IOException e) {
            System.out.println("fajl nije pronadjen " + e.getMessage());
        }

        //PART 1
        //tacka 3, ostavljeno u slucaju da treba cela pesma da se koristi
        StringBuilder preradjenaPesma = uklanjanjeZarezaIRedova(tekstPesme);
        System.out.println(preradjenaPesma + "\n");

        //Uklanjanje interpunkcijskih znakova radi brojanja reci
        preradjenaPesma = uklanjanjeInterpunkcijskihZnakova(preradjenaPesma);
        String reciPesme = preradjenaPesma.toString();

        //pravljenje niza koristeci razmak izmedju reci(
        System.out.println(preradjenaPesma + "\n");
        String[] nizReciPesme = reciPesme.split(" ");

        //koriscenje HashMape za implementaciju mape sa recima pesme kao key value
        //stampanje reci, moglo je i kroz petlju da se stavi zbog lepse preglednosti
        Map<String, Integer> brojReci = brojanjeReci(nizReciPesme);
        System.out.println(brojReci + "\n");

        //PART 2
        //Stavljanje reci pesme u List (Collection)
        List<String> pesmaLista = new ArrayList<>(Arrays.asList(nizReciPesme));

        //Pesma bez dublikata u listi
        List<String> pesmaBezDuplikata = pesmaLista.stream().distinct().toList();
        System.out.println(pesmaBezDuplikata + "\n");

        List<String> poredjanoPoDuzini = pesmaBezDuplikata.stream().sorted((a,b) -> Integer.compare(a.length(),b.length())).toList();
        System.out.println(poredjanoPoDuzini + "\n");

        //PART 3
        //Uklanjanje reci yellow i submarine
        List<String> reciBezYellowISubmerine = new LinkedList<>(pesmaLista);

        for (int i = pesmaLista.size()-1 ; i >= 0 ; i--) {
            if (pesmaLista.get(i).equals("yellow") || pesmaLista.get(i).equals("submarine")) {
                reciBezYellowISubmerine.remove(i);
            }
        }
        System.out.println(reciBezYellowISubmerine);

        //PART 4
        //Pravljenje fajla sa recima pesme
        try {
            Files.write(Paths.get("IzmenjenaPesmaYellowSubmerine.txt"),  Collections.singletonList(preradjenaPesma), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("fajl nije pravilno upisan u txt" + e.getMessage());
        }

        //Provera da li se neki string nalazi u pesmi
        try {
            slucajniStringUPesmi(tekstPesme,"Show must go on!");
        } catch (BeatlesException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

    private static Map<String, Integer> brojanjeReci(String[] nizReciPesme) {
        Map<String, Integer> brojReci = new HashMap<>();

        for(String rec : nizReciPesme){
            brojReci.put(rec, brojReci.getOrDefault(rec, 0) + 1);
        }

        return brojReci;
    }

    private static StringBuilder uklanjanjeInterpunkcijskihZnakova(StringBuilder preradjenaPesma) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < preradjenaPesma.length(); i++) {

            if(Character.isLetter(preradjenaPesma.charAt(i)) || Character.isWhitespace(preradjenaPesma.charAt(i)) )
                sb.append(preradjenaPesma.charAt(i));
        }

        return sb;
    }

    private static StringBuilder uklanjanjeZarezaIRedova(String tekst) {
        StringBuilder sb = new StringBuilder();

        tekst = tekst.toLowerCase();
        tekst = tekst.replace('\n', ' ');
        tekst = tekst.replace("\r", "");
        tekst = tekst.replace(",", "");

        for (int i = 0; i < tekst.length(); i++) {
            sb.append(tekst.charAt(i));
        }
        return sb;
    }

    //Metoda za proveru da li se neki string nalazi u tekstu
    private static void slucajniStringUPesmi(String pesma, String deoPesme) throws BeatlesException {
        if(pesma == null || deoPesme == null){
            System.out.println("Trazeni string je ili null ili je pesma null");
            return ;}
        try {
            if(!pesma.contains(deoPesme)){
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) {
            throw new BeatlesException(e);
        }
    }

}

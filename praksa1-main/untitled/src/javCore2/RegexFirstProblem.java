package javCore2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFirstProblem {

    public static void main(String[] args) {
        String tekst = "app=edi_adapter_converter wingtipsTrace=8faeae6709355291 INFO  OrderCreateClient - action=EDIOrderSent originalFilename=Integration_test_Contract customerName=0005084863 orderUUID=d34149d8-88ab-4791-bb0a-46c96e034200 poNum=Test_TS5155079515 lineCount=3";
        String mail = "test 2667843 (test_email@griddynamics.com) test 67483 some string";
        String successfullP = "app=edi_adapter_splitter wingtipsTrace=225debfbe6e5fac7 poiFileName=Integration_test_Contract INFO  LogUtils - POI file name: [Integration_test_Contract], total number of orders successfully processed: [28]";

        //One more way to do regeks
        boolean isThereOrderUUID = tekst.matches(".*orderUUID=[a-zA-Z0-9\\-].*");
        System.out.println(isThereOrderUUID);

        //way of doing this
        String[] parts = tekst.split(" ");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].matches("orderUUID=[a-zA-Z0-9\\-]{36}")) {
                System.out.println(true);
                break;
            }
        }

        //3. way of doing this
        boolean textSecond = containsOrder(tekst);
        System.out.println(textSecond);

        System.out.println();
        //Regeks part1
        System.out.println(containsOrderUUID(tekst));
        //Regeks part2
        printingOrderUUID(tekst);
        //Regeks part3
        findingEmail(mail);
        //Regeks part4
        successfullProcessed(successfullP);
    }

    //other way of doing regeks
    private static boolean containsOrder(String text) {
        Pattern patern = Pattern.compile("orderUUID=[\\w*\\-]");
        Matcher mecer = patern.matcher(text);
        return mecer.find();
    }

    //true false method for finding OrderUUID
    private static boolean containsOrderUUID(String text) {
        Pattern patern = Pattern.compile("\\w*orderUUID=[a-zA-Z0-9\\-]{36}");
        Matcher mecer = patern.matcher(text);
        return mecer.find();
    }

    //printing OrderUUID
    private static void printingOrderUUID(String text) {
        Pattern patern = Pattern.compile("orderUUID=[a-zA-Z0-9-]{36}");
        Matcher mecer = patern.matcher(text);
        while (mecer.find())
            System.out.println(mecer.group());
    }

    //searching for e-mail
    private static void findingEmail(String text) {
        Pattern patern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}");
        Matcher mecer = patern.matcher(text);
        while (mecer.find())
            System.out.println(mecer.group());
    }

    //serching for a number of successfull Processed
    private static void successfullProcessed(String text) {
        Pattern patern = Pattern.compile("total number of orders successfully processed:\\s*\\[([\\d]+)");
        Matcher mecer = patern.matcher(text);
        while (mecer.find()) {
            String broj = mecer.group(1);
            System.out.println(broj);
        }
    }
}
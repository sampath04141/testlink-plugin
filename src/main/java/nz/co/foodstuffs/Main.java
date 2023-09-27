package nz.co.foodstuffs;

public class Main {
    public static void main(String[] args) {
        XlsOperation readXls= new XlsOperation();
        readXls.read();;
        readXls.writeXml();
    }



}
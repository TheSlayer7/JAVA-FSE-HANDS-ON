 interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() { System.out.println("Opening Word Document..."); }
}

class PdfDocument implements Document {
    public void open() { System.out.println("Opening PDF Document..."); }
}

class ExcelDocument implements Document {
    public void open() { System.out.println("Opening Excel Document..."); }
}

 abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordFactory extends DocumentFactory {
    public Document createDocument() { return new WordDocument(); }
}

class PdfFactory extends DocumentFactory {
    public Document createDocument() { return new PdfDocument(); }
}

class ExcelFactory extends DocumentFactory {
    public Document createDocument() { return new ExcelDocument(); }
}

public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordFactory();
        Document doc1 = wordFactory.createDocument();
        doc1.open();

        DocumentFactory pdfFactory = new PdfFactory();
        Document doc2 = pdfFactory.createDocument();
        doc2.open();
    }
}
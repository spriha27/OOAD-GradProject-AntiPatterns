package java.code.goldenhammer.oopoveruse;

public class PDFDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document");
    }
}
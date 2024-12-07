package java.code.goldenhammer.oopoveruse;

public class DocumentViewer {
    public void viewDocument(Document document) {
        document.open();
    }

    public static void main(String[] args) {
        Document textDoc = new TextDocument();
        Document pdfDoc = new PDFDocument();
        DocumentViewer viewer = new DocumentViewer();

        viewer.viewDocument(textDoc);
        viewer.viewDocument(pdfDoc);
    }
}
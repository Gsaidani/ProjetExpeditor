//package fr.eniecole.bean;
//
//import java.io.FileOutputStream;
//
//import com.itextpdf.kernel.geom.PageSize;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//
//public class CreatePDF {
//	public static void main(String[] args) {
//
//	    Document document = new Document(PageSize.A4);
//	    try {
//	      PdfWriter.getInstance(document,
//	          new FileOutputStream("c:/test.pdf"));
//	      document.open();
//	      document.add(new Paragraph("Hello World"));
//	    } catch (Exception de) {
//	      de.printStackTrace();
//
//	    }
//
//	    document.close();
//	  }
//}

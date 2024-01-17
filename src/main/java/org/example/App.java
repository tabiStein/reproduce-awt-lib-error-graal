package org.example;

import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;

public class App {

  // Comments below are WRT the native image.
  public static void main(String[] args) {
    try {
      File inputPdf = new File("TestPdf.pdf");

      /* Usually, this line throws "java.lang.UnsatisfiedLinkError: no awt in java.library.path" in the native image */
      PDDocument document = PDDocument.load(inputPdf);
    } catch (Throwable t) {
      // ...But, the output is truncated, so we can't see/verify the exception.
//      System.out.println(t.getMessage());
      Throwable cause = t.getCause();
      while (cause != null) {
        System.out.println(cause);
        cause = cause.getCause();
      }
//      System.out.println(t.getStackTrace().length);
//      t.printStackTrace(System.out);
    }
    // This never prints
    System.out.println("After catch block");
  }

}

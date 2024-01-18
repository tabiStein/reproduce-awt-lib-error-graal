package org.example;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

  public static void main(String[] args) throws IOException {
    SpringApplication.run(App.class, args);
    File inputPdf = new File("TestPdf.pdf");

    /* In the native image, this line throws "java.lang.UnsatisfiedLinkError: no awt in java.library.path" */
    PDDocument document = PDDocument.load(inputPdf);
  }

}

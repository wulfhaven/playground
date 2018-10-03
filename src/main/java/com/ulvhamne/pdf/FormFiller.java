package com.ulvhamne.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class FormFiller {
    public static void fillForm(Map<String, String> sourceFields, String file) throws IOException {
        try(PDDocument document = PDDocument.load(new File(file))) {
            PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
            for(PDField f: acroForm.getFields())  {
                String fieldName = f.getFullyQualifiedName();
                String wantedValue = sourceFields.get(fieldName);
                if(wantedValue != null) {
                    f.setValue(wantedValue);
                }
            }
            document.save("target/output.pdf");
        } catch (IOException t) {
            System.err.println("Something went awry when filling out form." + t);
            throw t;
        }
    }

    public static void renderAsImage(String file) throws IOException {
        List<BufferedImage> images = new ArrayList<>();
        try (PDDocument document = PDDocument.load(new File(file))){
            PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
            acroForm.setNeedAppearances(true);
            acroForm.refreshAppearances();
            PDFRenderer renderer = new PDFRenderer(document);
            for(int i = 0; i < document.getNumberOfPages(); ++i) {
                BufferedImage bufferedImage = renderer.renderImage(i, 1.0f, ImageType.GRAY);
                images.add(bufferedImage);
                ImageIO.write(bufferedImage, "TIFF", new File("target/output"+i+".tiff"));
            }
        } catch (IOException e) {
            System.err.println("Something went converting pages to images." + e);
            throw e;
        }

        ImageWriter writer = ImageIO.getImageWritersByFormatName("TIFF").next();
        OutputStream stream = new FileOutputStream("target/output.tiff");
        try(ImageOutputStream outputStream = ImageIO.createImageOutputStream(stream)) {
            writer.setOutput(outputStream);
            ImageWriteParam param = writer.getDefaultWriteParam();
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            writer.prepareWriteSequence(null);
            for(BufferedImage image: images) {
                param.setCompressionType("PackBits");
                writer.writeToSequence(new IIOImage(image, null, null), param);
            }
            writer.endWriteSequence();


        } catch (IOException e) {
            System.err.println("Something went creating multipage tiff." + e);
            throw e;
        }
    }
}

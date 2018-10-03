package com.ulvhamne.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Map;

import static org.junit.Assert.*;

public class FormFillerTest {
    private static final String TARGET_OUTPUT_PDF = "target/output.pdf";

    private static final Map<String, String> FIELD_VALUES = Map.of(
            "applicationReason", "The Reason!",
            "name", "John Doe",
            "phoneNumber", "555-5555-555",
            "applicationType","Serious type of application",
            "adressCity", "VIMMERBY 59895",
            "adressStreet", "Kyrkogatan 1",
            "adressCountry", "SWEDEN",
            "checkBox", "Yes");
    @Test
    public void fillForm() throws Exception {
        @SuppressWarnings("ConstantConditions")
        String file = this.getClass().getClassLoader().getResource("form.pdf").getFile();
        FormFiller.fillForm(FIELD_VALUES, file);
        try(PDDocument document = PDDocument.load(new File(TARGET_OUTPUT_PDF))) {
            PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
            for (Map.Entry<String, String> kvp: FIELD_VALUES.entrySet()) {
                PDField field = acroForm.getField(kvp.getKey());
                assertNotNull(kvp.getKey() + " is missing in the document", field);
                assertEquals(kvp.getKey() + " has an incorrect value in document", kvp.getValue(), field.getValueAsString());
            }
        } catch (Throwable t) {
            Assert.fail("Exception was throw." + t);
        }
    }

    @Test
    public void renderAsImage() throws Exception {
        @SuppressWarnings("ConstantConditions")
        String file = this.getClass().getClassLoader().getResource("filled.pdf").getFile();
        FormFiller.renderAsImage(file);
    }
}
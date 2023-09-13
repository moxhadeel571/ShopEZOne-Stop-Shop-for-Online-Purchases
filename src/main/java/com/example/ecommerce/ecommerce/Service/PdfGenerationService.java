package com.example.ecommerce.ecommerce.Service;

import com.example.ecommerce.ecommerce.Entity.checkOut;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Service
public class PdfGenerationService {

    private final TemplateEngine templateEngine;

    @Autowired
    public PdfGenerationService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public byte[] generatePdf(Map<String, Object> dataMap) {
        String html = generateHtmlFromTemplate("bill_template", dataMap);
        return generatePdfFromHtml(html);
    }

    private String generateHtmlFromTemplate(String templateName, Map<String, Object> dataMap) {
        Context context = new Context();
        context.setVariables(dataMap);
        return templateEngine.process(templateName, context);
    }

    private byte[] generatePdfFromHtml(String html) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(outputStream);
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error generating PDF", e);
        }
    }
}

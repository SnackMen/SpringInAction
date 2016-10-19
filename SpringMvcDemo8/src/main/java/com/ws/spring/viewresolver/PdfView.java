package com.ws.spring.viewresolver;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.ws.spring.model.Pizza;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.Color;
import java.util.Map;

/**
 * Created by laowang on 16-10-19.
 */
public class PdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Pizza pizza = (Pizza) model.get("pizza");

        PdfPTable table = new PdfPTable(3);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.getDefaultCell().setBackgroundColor(Color.lightGray);

        table.addCell("Name");
        table.addCell("Flavor");
        table.addCell("Toppings");

        table.addCell(pizza.getName());
        table.addCell(pizza.getFlavor());

        StringBuilder toppings = new StringBuilder("");
        for (String topping : pizza.getToppings()) {
            toppings.append(topping);
            toppings.append(" ");
        }
        table.addCell(toppings.toString());
        document.add(table);
    }
}

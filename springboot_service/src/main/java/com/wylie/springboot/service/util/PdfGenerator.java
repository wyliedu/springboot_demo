package com.wylie.springboot.service.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.pdf.BaseFont;


/**
 * Report generator
 * 
 * @author Kevin GUO Jul 14, 2016
 */
public class PdfGenerator {
	/**
	 * Generate report
	 * 
	 * @param htmlContent
	 *           html content
	 * @param outputFilePath
	 *           output path
	 * @throws Exception
	 * @author Kevin GUO
	 */
	public static void generatePdf(String htmlContent, String outputFilePath) throws Exception {
		OutputStream out = null;

		ITextRenderer iTextRenderer = new ITextRenderer();

		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = builder.parse(new ByteArrayInputStream(htmlContent.getBytes("UTF-8")));
		File f = new File(outputFilePath);
		if (f != null && !f.getParentFile().exists()) {
			f.getParentFile().mkdir();
		}
		out = new FileOutputStream(outputFilePath);
		final ITextFontResolver fontResolver = iTextRenderer.getFontResolver();
		fontResolver.addFont("ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		iTextRenderer.setDocument(doc, null);
		iTextRenderer.layout();
		iTextRenderer.createPDF(out);

		out.close();
	}
}

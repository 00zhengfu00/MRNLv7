package doc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import log.ModelLogger;

import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.graphics.text.PageText;

import sth.Alert;

public class PdfDoc extends Doc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void extract(String path) {
		// TODO Auto-generated method stub
		// open the url
		Document document = new Document();
		

		try {
			document.setFile(path);
		Text = "";
		for (int pageNumber = 0, max = document.getNumberOfPages(); pageNumber < max; pageNumber++) {
			PageText pageText = null;
			try {
				pageText = document.getPageText(pageNumber);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				ModelLogger.getLogger().error(e.getMessage().toString());
			}
			// Alert.Msg("Extracting page text: " + pageNumber);
			if (pageText != null && pageText.getPageLines() != null) {
				Text += (pageText.toString()+"\n");
			}
		}
		// clean up resources
		document.dispose();
		} catch (PDFException ex) {
			ModelLogger.getLogger().error(ex.getMessage().toString());
		} catch (PDFSecurityException ex) {
			ModelLogger.getLogger().error(ex.getMessage().toString());
		} catch (FileNotFoundException ex) {
			ModelLogger.getLogger().error(ex.getMessage().toString());
		} catch (Exception ex) {
			ModelLogger.getLogger().error(ex.getMessage().toString());
		}
		getInfo(path);
		From="pdf://"+From;
		
	}

}

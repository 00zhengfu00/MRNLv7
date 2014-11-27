package doc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.POIXMLProperties.CoreProperties;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Word2007Doc extends Doc {

	@Override
	public void extract(String path) {
		// TODO Auto-generated method stub

		InputStream is;
		try {
			is = new FileInputStream(path);

			XWPFDocument doc = new XWPFDocument(is);
			XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
			String text = extractor.getText();
			Text=text;
			getInfo(path);
			From =  "docx://"+From;
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

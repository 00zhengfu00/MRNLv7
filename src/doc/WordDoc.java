package doc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import log.ModelLogger;

import org.apache.poi.hwpf.extractor.Word6Extractor;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class WordDoc extends Doc {

	@Override
	public void extract(String path) {
		// TODO Auto-generated method stub
		
		FileInputStream in;
		try {
			getInfo(path);
			From="doc://"+From;
			in = new FileInputStream(path);
			WordExtractor extractor = new WordExtractor(in);
			Text = extractor.getText();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ModelLogger.getLogger().error(e.getLocalizedMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ModelLogger.getLogger().error(e.getLocalizedMessage());
		}
	}

}

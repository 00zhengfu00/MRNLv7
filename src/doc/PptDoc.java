package doc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import log.ModelLogger;

import org.apache.lucene.document.Document;
import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.model.TextRun;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.usermodel.SlideShow;

public class PptDoc extends Doc {

	@Override
	public void extract(String path) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(path));
			Text = getPPTStr(fis).toString();
			getInfo(path);
			From = "ppt://" + From;
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			ModelLogger.getLogger().error(e.getMessage().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ModelLogger.getLogger().error(e.getMessage().toString());
		}
	}

	public StringBuffer getPPTStr(InputStream is) {
		StringBuffer content = new StringBuffer("");
		try {
			SlideShow ss = new SlideShow(new HSLFSlideShow(is));// is
																// 为文件的InputStream，建立SlideShow
			Slide[] slides = ss.getSlides();// 获得每一张幻灯片
			for (int i = 0; i < slides.length; i++) {
				TextRun[] t = slides[i].getTextRuns();// 为了取得幻灯片的文字内容，建立TextRun
				for (int j = 0; j < t.length; j++) {
					content.append(t[j].getText()+"\n");// 这里会将文字内容加到content中去
				}
				content.append(slides[i].getTitle()+"\n");
			}
			return content;
		} catch (Exception e) {
			ModelLogger.getLogger().error(e.getLocalizedMessage().toString());
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// new PptDoc().getDocument(fis);
	}

}

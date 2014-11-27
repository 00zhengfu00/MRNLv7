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
																// Ϊ�ļ���InputStream������SlideShow
			Slide[] slides = ss.getSlides();// ���ÿһ�Żõ�Ƭ
			for (int i = 0; i < slides.length; i++) {
				TextRun[] t = slides[i].getTextRuns();// Ϊ��ȡ�ûõ�Ƭ���������ݣ�����TextRun
				for (int j = 0; j < t.length; j++) {
					content.append(t[j].getText()+"\n");// ����Ὣ�������ݼӵ�content��ȥ
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

package doc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.xslf.XSLFSlideShow;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;

public class PptxDoc extends Doc {

	@Override
	public void extract(String path) {
		XMLSlideShow xmlSlideShow = null;
		try {
			xmlSlideShow = new XMLSlideShow(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSLFSlide[] slides = xmlSlideShow.getSlides();
		StringBuilder sb = new StringBuilder();
		for (XSLFSlide slide : slides) {
			CTSlide rawSlide = slide.getXmlObject();
			CTGroupShape gs = rawSlide.getCSld().getSpTree();
			CTShape[] shapes = gs.getSpArray();
			for (CTShape shape : shapes) {
				CTTextBody tb = shape.getTxBody();
				if (null == tb)
					continue;
				CTTextParagraph[] paras = tb.getPArray();
				for (CTTextParagraph textParagraph : paras) {
					CTRegularTextRun[] textRuns = textParagraph.getRArray();
					for (CTRegularTextRun textRun : textRuns) {
						sb.append(textRun.getT());
					}
					sb.append("\n");
				}
			}
		}
		Text = sb.toString();
		getInfo(path);
		From = "pptx://" + From;
		// System.out.println(sb);
	}

	public static void main(String[] args) {
		new PptxDoc().extract("E:\\test.pptx");
	}
}

package doc;

import java.io.File;

import com.ocr.OCRUtil;

public class OCRpic extends Doc{

	private String format_=null;
	public OCRpic(String format)
	{
		format_=format;
	}
	@Override
	public void extract(String path) {
		// TODO Auto-generated method stub
		Text = new OCRUtil()
		.recognizeText(new File(path), format_);
		Text=Text.replaceAll("\\\\", "\n");
		getInfo(path);
		From=format_+"://"+From;
	}

}

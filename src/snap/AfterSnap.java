package snap;

import java.io.File;

import helper.VMainHelper;
import doc.Doc;
import doc.OCRpic;

public class AfterSnap extends Thread{

	private String path=null;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Doc doc=new OCRpic("jpg");
        doc.extract(path);
        VMainHelper.jta.setText(VMainHelper.jta.getText()+"\n"+doc.getText());
        new File(path).delete();
	}

}

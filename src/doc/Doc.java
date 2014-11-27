package doc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import log.ModelLogger;
import lucene.Configure;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.mozilla.intl.chardet.CharsetDetector;
import org.mozilla.intl.chardet.nsPSMDetector;

public abstract class Doc {
	protected String From = "";
	protected String Author = "";
	protected String Time = "";
	protected String Text = "";
	protected org.apache.lucene.document.Document docu = new org.apache.lucene.document.Document();

	public String getFrom() {
		return From;
	}

	public void setFrom(String from) {
		From = from;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	protected String Title = "";

	public abstract void extract(String path);
	// 复制文件
    private static void copyFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        } finally {
            // 关闭流
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }
    }
	protected void getInfo(String file) {
		File f = new File(file);
		
		if (!f.exists())
			return;
		Title = f.getName().substring(f.getName().lastIndexOf("\\") + 1,
				f.getName().lastIndexOf(".") + 1);
		From = f.getName().substring(f.getName().lastIndexOf("\\") + 1,
				f.getName().length());;
		try {
			copyFile(f, new File((String) Configure.get("DocPath")+From));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ModelLogger.getLogger().error(e.getLocalizedMessage());
		}
		Time = ((Long)new Date().getTime()).toString();
		Author = "anonynous";
	}

	public Document getDocument() {
		MakeWell();
		docu.add(new Field("title", Title.toLowerCase(), Store.YES,
				Index.ANALYZED));
		docu.add(new Field("text", Text.toLowerCase(), Store.YES,
				Index.ANALYZED));
		docu.add(new Field("addtime", Time, Store.YES, Index.ANALYZED_NO_NORMS));
		docu.add(new Field("author", Author, Store.YES, Index.ANALYZED));
		docu.add(new Field("from", From, Store.YES, Index.ANALYZED));
		return docu;
	}

	public static Doc getDoc(String path) {
		File f = new File(path);
		if (!f.exists() || !f.isFile())
			return null;
		String fileType = path.substring(path.lastIndexOf(".") + 1,
				path.length()).trim().toLowerCase();
		if (fileType.equals("pdf")) {
			return new PdfDoc();
		}
		if (fileType.equals("doc")) {
			return new WordDoc();
		}
		if (fileType.equals("docx")) {
			return new Word2007Doc();
		}
		if (fileType.equals("txt")) {
			return new TxtDoc();
		}
		if (fileType.equals("ppt")) {
			return new PptDoc();
		}
		if (fileType.equals("pptx")) {
			return new PptxDoc();
		}
		if (fileType.equals("jpg")) {
			return new OCRpic("jpg");
		}
		if (fileType.equals("png")) {
			return new OCRpic("png");
		}
		if (fileType.equals("gif")) {
			return new OCRpic("gif");
		}
		if (fileType.equals("tiff")) {
			return new OCRpic("tiff");
		}
		if (fileType.equals("html")||fileType.equals("htm")) {
			return new HtmlDoc();
		}
		return null;
	}

	protected String transCharset(String str) {
		String ret = str;
		String charset = CharsetDetector.Check(str, nsPSMDetector.CHINESE);
		System.out.println(charset);
		if(charset.equals("ISO-2022-CN"))
			charset="GB18030";
		if(charset.equals("GB18030")||charset.equals("GB2312"))
		{
			try {
				
				String t = new String(str.getBytes(charset), "UTF-8");
				ret = t;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				ModelLogger.getLogger().error(e.getLocalizedMessage().toString());
			}
		}
		String ret2 = "";
		for (int i = 0; i < ret.length(); i++) {
			if ((ret.charAt(i) >= 128 && (ret.charAt(i) < '\u4E00'))) {
				ret2 += " ";
			} else if (((ret.charAt(i) >= 32||ret.charAt(i)==10||ret.charAt(i)==13) && ret.charAt(i) <= 126)
					|| (ret.charAt(i) >= '\u4E00' && ret.charAt(i) <= '\u9FFF')) {
				ret2 += ret.charAt(i);
			}
		}
		return ret2;
	}

	public void MakeWell() {
		Title = transCharset(Title);
		Text = transCharset(Text);
		Author = transCharset(Author);
		From = transCharset(From);
	}
}

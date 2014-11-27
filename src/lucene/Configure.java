package lucene;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;

public class Configure {
	private static Map<String, Object> map = new HashMap<String, Object>();

	public static Object get(String key) {
		return map.get(key);
	}

	static {
		map.put("IndexPath", "./index/");// every document must have 4 fields
		map.put("DocPath", "./doc/");							// :title,addtime,from,author
		File file = new File((String) map.get("IndexPath"));
		if (file.mkdirs()) {
			try {
				String time = ((Long) System.currentTimeMillis()).toString();
				Document document = new Document();
				document.add(new Field("title", "欢迎来到我的参考库", Store.YES,
						Index.ANALYZED));
				document.add(new Field("text", "这是一个方便记录知识的软件，可以收藏文章，导入文档等。",
						Store.YES, Index.ANALYZED));
				document.add(new Field("addtime", time, Store.YES, Index.ANALYZED_NO_NORMS));
				document.add(new Field("author", "admin", Store.YES,
						Index.ANALYZED));
				document.add(new Field("from", "a guide..", Store.YES,
						Index.ANALYZED));

				lucene.Index.Open(true);
				lucene.Index.AddBatch(document);
				lucene.Index.EndBatch();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "error occured.");
			}
			
		}
		File file2 = new File((String) map.get("DocPath"));
		if (file2.mkdirs()) {
			
		}
	}
}

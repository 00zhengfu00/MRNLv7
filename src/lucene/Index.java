package lucene;

import java.io.File;
import java.io.IOException;

import log.ModelLogger;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.util.Version;

@SuppressWarnings("deprecation")
public class Index {
	static Directory d = null;
	static Analyzer a = new SmartChineseAnalyzer(Version.LUCENE_CURRENT);
	static IndexWriter iWriter = null;

	public static void Open(boolean create) throws IOException {
		d = FSDirectory.open(new File((String) Configure.get("IndexPath")));
		iWriter = new IndexWriter(d, a, create, MaxFieldLength.UNLIMITED);
	}

	public static void AddBatch(Document document)
			throws CorruptIndexException, LockObtainFailedException,
			IOException {
		iWriter.addDocument(document);
	}

	public static void EndBatch() throws CorruptIndexException, IOException {
		iWriter.optimize();
		iWriter.close();
	}

	public static  boolean Delete(String field, String querystr) {
		try {
			Query q = new TermQuery(new Term(field, querystr));
			Document[] docs=Search.search(q);
			for(Document d:docs)
			{
				//delete file
				String filename=d.get("from");
				filename=filename.substring(filename.lastIndexOf("://")+3, filename.length());
				//System.out.println(filename);
				filename=Configure.get("DocPath").toString()+filename;
				new File(filename).delete();
			}
			Open(false);
			
			iWriter.deleteDocuments(q);
			iWriter.close();
			
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ModelLogger.getLogger().error(e.getLocalizedMessage().toString());
			return false;
		} 
	}
}

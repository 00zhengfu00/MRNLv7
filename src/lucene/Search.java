package lucene;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import log.ModelLogger;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class Search {

	/**
	 * @param args
	 */
	public static Document[] search(String keyword,int limit) {
		Directory directory;
		List<Document> retList=new ArrayList<Document>();
		try {
			//System.out.println(new File((String) Configure.get("IndexPath")).getAbsolutePath().toString());
			directory = FSDirectory.open(new File((String) Configure.get("IndexPath")));
			@SuppressWarnings("deprecation")
			IndexSearcher searcher = new IndexSearcher(directory);
			@SuppressWarnings("deprecation")
			Analyzer analyzer=new SmartChineseAnalyzer(Version.LUCENE_CURRENT); 
			@SuppressWarnings("deprecation")
			MultiFieldQueryParser parser=new MultiFieldQueryParser(Version.LUCENE_CURRENT, new String[]{"title","text","author","from"},analyzer);
			
			Query query = parser.parse(keyword);
			SimpleHTMLFormatter formatter=new SimpleHTMLFormatter("<span style='color:red;'>","</span>");
			QueryScorer scorer=new QueryScorer(query);
			org.apache.lucene.search.highlight.Highlighter highlighter=new Highlighter(formatter,scorer);
			highlighter.setTextFragmenter(new SimpleSpanFragmenter(scorer));
			
			//System.out.println(query);
			if(searcher.maxDoc()==0)
				return null;
			TopDocs hits = searcher.search(query,searcher.maxDoc());
			ScoreDoc[] scoreDocs=hits.scoreDocs;
			for(int i=0;i<scoreDocs.length&&i<limit;i++)
			{
				Document document = null;
				document = searcher.doc(scoreDocs[i].doc);
				retList.add(document);
				String title=document.get("title");
				TokenStream tokenStream=analyzer.tokenStream("", new StringReader(title));
				try {
					title=highlighter.getBestFragments(tokenStream, title,3,"...");
				} catch (InvalidTokenOffsetsException e) {
					// TODO Auto-generated catch block
					return null;
				}
			}
			searcher.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			ModelLogger.getLogger().error(e.getLocalizedMessage().toString());
			return null;
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			ModelLogger.getLogger().error(e1.getLocalizedMessage().toString());
			return null;
		}
		Document[] documents=new Document[retList.size()];
		retList.toArray(documents);
		return documents;
	}
	public static Document[] search(Query q) {
		Directory directory;
		List<Document> retList=new ArrayList<Document>();
		try {
			//System.out.println(new File((String) Configure.get("IndexPath")).getAbsolutePath().toString());
			directory = FSDirectory.open(new File((String) Configure.get("IndexPath")));
			@SuppressWarnings("deprecation")
			IndexSearcher searcher = new IndexSearcher(directory);
			@SuppressWarnings("deprecation")
			Analyzer analyzer=new SmartChineseAnalyzer(Version.LUCENE_CURRENT); 
			Query query = q;
			SimpleHTMLFormatter formatter=new SimpleHTMLFormatter("<span style='color:red;'>","</span>");
			QueryScorer scorer=new QueryScorer(query);
			org.apache.lucene.search.highlight.Highlighter highlighter=new Highlighter(formatter,scorer);
			highlighter.setTextFragmenter(new SimpleSpanFragmenter(scorer));
			
			//System.out.println(query);
			if(searcher.maxDoc()==0)
				return null;
			TopDocs hits = searcher.search(query,searcher.maxDoc());
			ScoreDoc[] scoreDocs=hits.scoreDocs;
			for(int i=0;i<scoreDocs.length;i++)
			{
				Document document = null;
				document = searcher.doc(scoreDocs[i].doc);
				retList.add(document);
				String title=document.get("title");
				TokenStream tokenStream=analyzer.tokenStream("", new StringReader(title));
				try {
					title=highlighter.getBestFragments(tokenStream, title,3,"...");
				} catch (InvalidTokenOffsetsException e) {
					// TODO Auto-generated catch block
					return null;
				}
			}
			searcher.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			ModelLogger.getLogger().error(e.getLocalizedMessage().toString());
			return null;
		}
		Document[] documents=new Document[retList.size()];
		retList.toArray(documents);
		return documents;
	}

}

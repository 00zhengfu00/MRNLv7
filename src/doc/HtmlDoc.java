package doc;

import log.ModelLogger;

import org.htmlparser.Parser;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.TextExtractingVisitor;


public class HtmlDoc extends TxtDoc {

	private String stripHtml(String content) throws ParserException{ 
		String string=content
						.replaceAll("(<script.*?>.*?</script>)", "")
							.replaceAll("(<style.*?>.*?</style>)", "")
							.replaceAll("(<title.*?>.*?</title>)", "");
		Parser parser=Parser.createParser(string,"UTF-8");
		 TextExtractingVisitor visitor = new TextExtractingVisitor();
         parser.visitAllNodesWith(visitor);
         String textInPage = visitor.getExtractedText();
         textInPage=textInPage.replace(" ", "");
		return textInPage; 
}
	@Override
	public void extract(String path) {
		// TODO Auto-generated method stub
		super.extract(path);
		try {
			Text=stripHtml(Text);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ModelLogger.getLogger().error(e.getMessage().toString());
		}

	}

}

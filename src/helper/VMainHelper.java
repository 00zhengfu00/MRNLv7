package helper;
import hotkey.Hotkey;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.synth.SynthLookAndFeel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import log.ModelLogger;
import lucene.Search;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.Fieldable;

import doc.Doc;


public class VMainHelper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Document[] documents = null;
	public static DefaultTableModel tableModel=null;
	public static String se=null;
	public static Doc fileDoc=null;
	public static VMain vmain=null;
	public static JTextArea jta=null;
	public static void ReList(JTable jt)
	{
		
		((DefaultTableModel)jt.getModel()).setRowCount(0);
		if(documents==null)
		{
			return;
		}
		int index=0;
		for (Document docment : documents) {
			tableModel.addRow(new String[] {index+"", docment.get("title"),
					docment.get("from"), new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss").format(Long.parseLong(docment.get("addtime"))),
					docment.get("author") });
			index++;
		}
		jt.invalidate();
	}
	public static void reSearch(JTable jt)
	{
		documents = Search.search(se.toLowerCase(), 50);
		ReList(jt);
	}
	public static void setVMain(final VMain vmain) {
		// TODO Auto-generated method stub
		Hotkey m = new Hotkey();
		m.init();
		VMainHelper.vmain=vmain;
		jta=vmain.getQuickInsertTextArea();
		jta.setLineWrap(true);
		vmain.getDetail().setLineWrap(true);
		vmain.getInsertFromFileContent().setLineWrap(true);
		Font font=new Font("宋体",Font.PLAIN,25);
		vmain.getDetail().setFont(font);
		//vmain.getDetail().setText("<span style='color:#8b8b8b'>sssss</span>");
		final JTextField searchBox = vmain.getSearchBox();
		final JTable jTable = vmain.getResultTable();
		tableModel = (DefaultTableModel) jTable
				.getModel();
		tableModel.setRowCount(0);
		Map<String, Integer> columnMap = new HashMap<String, Integer>();
		columnMap.put(new String("ID"), new Integer(0));
		columnMap.put(new String("标题"), new Integer(1));
		columnMap.put(new String("来源"), new Integer(2));
		columnMap.put(new String("添加时间"), new Integer(3));
		columnMap.put(new String("作者"), new Integer(4));
		tableModel
				.setColumnIdentifiers(new String[] {"ID", "标题", "来源", "添加时间", "作者" });
		TableColumn firsetColumn = jTable.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(40);
		firsetColumn.setMaxWidth(40);
		firsetColumn.setMinWidth(40);
		firsetColumn = jTable.getColumnModel().getColumn(1);
		firsetColumn.setPreferredWidth(200);
		firsetColumn.setMaxWidth(200);
		firsetColumn.setMinWidth(200);
		firsetColumn = jTable.getColumnModel().getColumn(2);
		firsetColumn.setPreferredWidth(60);
		firsetColumn.setMaxWidth(60);
		firsetColumn.setMinWidth(60);
		jTable.invalidate();
		vmain.getSearchOk().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try
				{
				se=searchBox.getText().toLowerCase();
				if(se.trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "you must input keyword.");
					return;
				}
				documents = Search.search(searchBox.getText().toLowerCase(), 200);
				ReList(jTable);
				if (documents == null)
				{
					JOptionPane.showMessageDialog(null, "no result.");
					return;
				}
				
				
				vmain.getJTabbedPane1().setSelectedComponent(vmain.getJPanel2());;
				vmain.getJTabbedPane1().updateUI();
				}
				catch(Exception e)
				{}
			}
		});
		vmain.getQuickInsertOk().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String title = vmain.getQuickInsertTitle().getText();
				String text = vmain.getQuickInsertTextArea().getText();
				if(title.trim().equals("")||text.trim().equals(""))
				{
					return;
				}
				String time = "";
				//SimpleDateFormat sdf = new SimpleDateFormat(
					//	"yyyy年MM月dd日   HH:mm:ss");
				Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
				time = ((Long)System.currentTimeMillis()).toString();
				String author = "quick man";
				Document document=new Document();
				document.add(new Field("title", title.toLowerCase(), Store.YES, Index.ANALYZED));
				document.add(new Field("text", text.toLowerCase(), Store.YES, Index.ANALYZED));
				document.add(new Field("addtime", time, Store.YES, Index.ANALYZED_NO_NORMS));
				document.add(new Field("author", author, Store.YES, Index.ANALYZED));
				document.add(new Field("from", "the quick app.", Store.YES, Index.ANALYZED));
				try {
					lucene.Index.Open(false);
					lucene.Index.AddBatch(document);
					lucene.Index.EndBatch();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					ModelLogger.getLogger().error(e.getLocalizedMessage().toString());
				}
				vmain.getQuickInsertTitle().setText("");
				vmain.getQuickInsertTextArea().setText("");
			}
		});

	}
	public static void display(JTextArea detail, Document docu) {
		// TODO Auto-generated method stub
		List<Fieldable> fs=docu.getFields();
		Fieldable[] fss=new Field[fs.size()];
		fs.toArray(fss);
		String result="";
		for(Fieldable f:fss)
		{
			String name="{["+f.name()+"]}";
			String updown="";
			String space="";
			for(int i=0;i<100-name.length()/2;i++)space+=" ";
			for(int i=0;i<92;i++)updown+="_";
			result+=updown+"\n";
			result+=name;
			result+="\n"+updown+"\n";;
			result+=f.stringValue()+"\n";
		}
		detail.setText(result);
		vmain.getJTabbedPane1().setSelectedComponent(vmain.getJPanel7());;
		vmain.getJTabbedPane1().updateUI();
	}

}

package helper;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.store.LockObtainFailedException;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.*;

import snap.SnapUtil;
import sth.Alert;
import doc.Doc;
import log.ModelLogger;
import lucene.Index;
import lucene.Search;

/**
 * 
 * @author __USER__
 */
public class VMain extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates new form VMain */
	public VMain() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		jPopupMenu1 = new javax.swing.JPopupMenu();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		SearchBox = new javax.swing.JTextField();
		SearchOk = new javax.swing.JButton();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTextArea2 = new javax.swing.JTextArea();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		ResultTable = new javax.swing.JTable();
		jPanel7 = new javax.swing.JPanel();
		jScrollPane4 = new javax.swing.JScrollPane();
		Detail = new javax.swing.JTextArea();
		jPanel3 = new javax.swing.JPanel();
		InsertFromFileTitle = new javax.swing.JTextField();
		InsertFileOk = new javax.swing.JButton();
		jScrollPane5 = new javax.swing.JScrollPane();
		InsertFromFileContent = new javax.swing.JTextArea();
		InsertFileOk1 = new javax.swing.JButton();
		jPanel5 = new javax.swing.JPanel();
		QuickInsertTitle = new javax.swing.JTextField();
		QuickInsertOk = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		QuickInsertTextArea = new javax.swing.JTextArea();
		SnapStart = new javax.swing.JButton();
		jPanel4 = new javax.swing.JPanel();
		selectDirectBatch = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		FromDirectoryOk = new javax.swing.JButton();
		FromDirectory = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		FromDBFile = new javax.swing.JTextField();
		FromDBFileOk = new javax.swing.JButton();
		FromDBFileSelect = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		FromDBServer = new javax.swing.JTextField();
		FromServerOk = new javax.swing.JButton();
		jLabel6 = new javax.swing.JLabel();
		jTextField4 = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		jLabel8 = new javax.swing.JLabel();
		jTextField5 = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		jTextField6 = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jLabel13 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		jPanel6 = new javax.swing.JPanel();
		ToolsChooseBlog = new javax.swing.JComboBox();
		jLabel1 = new javax.swing.JLabel();
		ToolsBlogUsername = new javax.swing.JTextField();
		ToolsBlogOk = new javax.swing.JButton();
		jProgressBar1 = new javax.swing.JProgressBar();
		jLabel2 = new javax.swing.JLabel();
		IEEEOk = new javax.swing.JButton();
		IEEEKeywords = new javax.swing.JTextField();
		jProgressBar2 = new javax.swing.JProgressBar();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenu3 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();
		jLabel14 = new javax.swing.JLabel();
		jMenuBar2 = new javax.swing.JMenuBar();
		jMenu5 = new javax.swing.JMenu();
		jMenuItem5 = new javax.swing.JMenuItem();
		jMenuItem6 = new javax.swing.JMenuItem();
		jMenu6 = new javax.swing.JMenu();
		jMenu7 = new javax.swing.JMenu();
		jMenu8 = new javax.swing.JMenu();

		jMenuItem3.setText("\u67e5\u770b");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				popMenuSeeDetail(evt);
			}
		});
		jPopupMenu1.add(jMenuItem3);

		jMenuItem4.setText("\u5220\u9664");
		jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				popMenuDelete(evt);
			}
		});
		jPopupMenu1.add(jMenuItem4);

		setTitle("\u6211\u7684\u53c2\u8003\u5e93 - 7.0 - by \u9648\u4e00\u6734");
		setDefaultCloseOperation(3);
		setResizable(false);

		jTabbedPane1.setMinimumSize(new java.awt.Dimension(300, 250));

		jPanel1.setLayout(null);

		SearchBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SearchBoxActionPerformed(evt);
			}
		});
		SearchBox.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				SearchBoxKeyPressed(evt);
			}

			public void keyTyped(java.awt.event.KeyEvent evt) {
				SearchKeyTyped(evt);
			}
		});
		jPanel1.add(SearchBox);
		SearchBox.setBounds(90, 40, 360, 30);

		SearchOk.setText("\u641c\u7d22");
		SearchOk.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SearchOkActionPerformed(evt);
			}
		});
		jPanel1.add(SearchOk);
		SearchOk.setBounds(470, 40, 90, 30);

		jTextArea2.setColumns(20);
		jTextArea2.setRows(5);
		jTextArea2
				.setText("                                               \u4f7f\u7528\u987b\u77e5 License\n1,\u672c\u8f6f\u4ef6\u4f7f\u7528Lucene\u5efa\u7acb\u7d22\u5f15\u548c\u68c0\u7d22\uff0c\u6240\u6709\u76f8\u5173\u6280\u672f\u6309\u7167Lucene\u4f7f\u7528\u8bc1\u4e66\u3002\n2,\u672c\u8f6f\u4ef6\u65e8\u5728\u6574\u5408\u7b14\u8bb0\u3001\u6587\u732e\u3001\u5b66\u672f\u8bba\u6587\u3002");
		jTextArea2.setAutoscrolls(false);
		jTextArea2.setFont(new java.awt.Font("Courier", 0, 18));
		jScrollPane3.setViewportView(jTextArea2);

		jPanel1.add(jScrollPane3);
		jScrollPane3.setBounds(10, 80, 640, 270);

		jTabbedPane1.addTab("\u641c\u7d22\u9875", jPanel1);

		ResultTable.setBorder(javax.swing.BorderFactory.createCompoundBorder());
		ResultTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		ResultTable.setShowGrid(true);
		ResultTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				popMenu(evt);
			}
		});
		jScrollPane1.setViewportView(ResultTable);

		org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(
				org.jdesktop.layout.GroupLayout.TRAILING,
				jPanel2Layout.createSequentialGroup().add(jScrollPane1,
						org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 644,
						Short.MAX_VALUE).addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(
				jPanel2Layout.createSequentialGroup().add(jScrollPane1,
						org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 337,
						Short.MAX_VALUE).addContainerGap()));

		jTabbedPane1.addTab("\u7ed3\u679c\u9875", jPanel2);

		Detail.setColumns(20);
		Detail.setRows(5);
		jScrollPane4.setViewportView(Detail);

		org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(
				jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(jScrollPane4,
				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 656,
				Short.MAX_VALUE));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(jScrollPane4,
				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 351,
				Short.MAX_VALUE));

		jTabbedPane1.addTab("\u8be6\u7ec6\u9875\u9762", jPanel7);

		InsertFileOk.setText("\u6dfb\u52a0");
		InsertFileOk.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				InsertFileOkActionPerformed(evt);
			}
		});

		InsertFromFileContent.setColumns(20);
		InsertFromFileContent.setRows(5);
		jScrollPane5.setViewportView(InsertFromFileContent);

		InsertFileOk1.setText("\u9009\u62e9\u6587\u4ef6");
		InsertFileOk1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				InsertFileOk1ActionPerformed(evt);
			}
		});

		org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												jPanel3Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																jScrollPane5,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																636,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																jPanel3Layout
																		.createSequentialGroup()
																		.add(
																				InsertFromFileTitle,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				479,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.UNRELATED)
																		.add(
																				InsertFileOk1)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				InsertFileOk)))
										.addContainerGap()));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel3Layout
										.createSequentialGroup()
										.add(
												jPanel3Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																InsertFileOk,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																32,
																Short.MAX_VALUE)
														.add(
																InsertFileOk1,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																32,
																Short.MAX_VALUE)
														.add(
																InsertFromFileTitle,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																32,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jScrollPane5,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												305,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.add(45, 45, 45)));

		jTabbedPane1.addTab("1)\u6dfb\u52a0\u6587\u6863", jPanel3);

		QuickInsertOk.setText("\u6dfb\u52a0");

		QuickInsertTextArea.setColumns(20);
		QuickInsertTextArea.setRows(5);
		jScrollPane2.setViewportView(QuickInsertTextArea);

		SnapStart
				.setText("\u4e0d\u80fd\u590d\u5236\uff1f\u5c4f\u5e55\u53d6\u6587");
		SnapStart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SnapStartActionPerformed(evt);
			}
		});

		org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout
				.setHorizontalGroup(jPanel5Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel5Layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												jPanel5Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																jScrollPane2,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																632,
																Short.MAX_VALUE)
														.add(
																jPanel5Layout
																		.createSequentialGroup()
																		.add(
																				QuickInsertTitle,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				417,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				QuickInsertOk)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				SnapStart)))
										.addContainerGap()));
		jPanel5Layout
				.setVerticalGroup(jPanel5Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel5Layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												jPanel5Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																QuickInsertTitle,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																31,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																QuickInsertOk,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																31,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																SnapStart,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																29,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jScrollPane2,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												284, Short.MAX_VALUE)
										.addContainerGap()));

		jTabbedPane1.addTab(
				"2)\u6211\u5df2\u590d\u5236-\u5feb\u901f\u6dfb\u52a0", jPanel5);

		selectDirectBatch.setText("\u76ee\u5f55");
		selectDirectBatch
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						selectDirectBatchActionPerformed(evt);
					}
				});

		jLabel3.setText("1.\u4ece\u6587\u4ef6\u5939");

		FromDirectoryOk.setText("\u6279\u91cf\u6dfb\u52a0");
		FromDirectoryOk.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				FromDirectoryOkActionPerformed(evt);
			}
		});

		jLabel4.setText("2.\u4ece\u6570\u636e\u5e93\u6587\u4ef6");

		FromDBFileOk.setText("\u6279\u91cf\u6dfb\u52a0");

		FromDBFileSelect.setText("\u6570\u636e\u5e93");

		jLabel5.setText("3.\u4ece\u6570\u636e\u5e93\u670d\u52a1\u5668");

		FromServerOk.setText("\u6279\u91cf\u6dfb\u52a0");

		jLabel6.setText("Sever:");

		jLabel7.setText("\u9009\u62e9\u670d\u52a1\u5668\u7c7b\u522b");

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));

		jLabel8.setText("\u7528\u6237\u540d");

		jLabel9.setText("\u5bc6\u7801");

		jLabel10.setText("2,3 SQL\u8bed\u53e5:");

		jLabel11.setText("4.\u4ece\u722c\u866b");

		jLabel12.setText("Start URL:");

		jTextField2.setText("http://");

		jButton1.setText("\u6dfb\u52a0/\u5f00\u59cb");

		jLabel13
				.setText("State :\u6587\u6863/\u961f\u5217:1/203 \u8fd0\u884c\u65f6\u95f4:16:00:07 Url:http://www.baidu.com");

		jButton2.setText("\u505c\u6b62");

		org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel4Layout
										.createSequentialGroup()
										.add(26, 26, 26)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																jPanel4Layout
																		.createSequentialGroup()
																		.add(
																				jLabel13,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				427,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.add(
																				18,
																				18,
																				18)
																		.add(
																				jButton2,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				183,
																				Short.MAX_VALUE)
																		.add(
																				98,
																				98,
																				98))
														.add(
																jPanel4Layout
																		.createSequentialGroup()
																		.add(
																				jLabel11)
																		.addContainerGap())
														.add(
																jPanel4Layout
																		.createSequentialGroup()
																		.add(
																				jLabel5)
																		.addContainerGap())
														.add(
																jPanel4Layout
																		.createSequentialGroup()
																		.add(
																				jLabel4)
																		.addContainerGap())
														.add(
																jPanel4Layout
																		.createSequentialGroup()
																		.add(
																				jLabel3)
																		.addContainerGap(
																				586,
																				Short.MAX_VALUE))
														.add(
																org.jdesktop.layout.GroupLayout.TRAILING,
																jPanel4Layout
																		.createSequentialGroup()
																		.add(
																				jPanel4Layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.TRAILING)
																						.add(
																								org.jdesktop.layout.GroupLayout.LEADING,
																								jPanel4Layout
																										.createSequentialGroup()
																										.add(
																												jLabel8)
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.RELATED)
																										.add(
																												jTextField5,
																												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																												309,
																												Short.MAX_VALUE)
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.RELATED)
																										.add(
																												jLabel9)
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.RELATED)
																										.add(
																												jTextField6,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																												245,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																						.add(
																								org.jdesktop.layout.GroupLayout.LEADING,
																								jPanel4Layout
																										.createSequentialGroup()
																										.add(
																												jLabel7)
																										.add(
																												7,
																												7,
																												7)
																										.add(
																												jComboBox1,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.UNRELATED)
																										.add(
																												jLabel6)
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.RELATED)
																										.add(
																												jTextField4,
																												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																												421,
																												Short.MAX_VALUE))
																						.add(
																								jPanel4Layout
																										.createSequentialGroup()
																										.add(
																												jPanel4Layout
																														.createParallelGroup(
																																org.jdesktop.layout.GroupLayout.TRAILING)
																														.add(
																																FromDBServer,
																																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																460,
																																Short.MAX_VALUE)
																														.add(
																																org.jdesktop.layout.GroupLayout.LEADING,
																																jPanel4Layout
																																		.createSequentialGroup()
																																		.addPreferredGap(
																																				org.jdesktop.layout.LayoutStyle.RELATED)
																																		.add(
																																				jPanel4Layout
																																						.createParallelGroup(
																																								org.jdesktop.layout.GroupLayout.LEADING)
																																						.add(
																																								FromDirectory,
																																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																								460,
																																								Short.MAX_VALUE)
																																						.add(
																																								FromDBFile,
																																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																								460,
																																								Short.MAX_VALUE))))
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.RELATED)
																										.add(
																												jPanel4Layout
																														.createParallelGroup(
																																org.jdesktop.layout.GroupLayout.LEADING)
																														.add(
																																org.jdesktop.layout.GroupLayout.TRAILING,
																																FromDBFileSelect,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																74,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																														.add(
																																selectDirectBatch,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																74,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.RELATED)
																										.add(
																												jPanel4Layout
																														.createParallelGroup(
																																org.jdesktop.layout.GroupLayout.LEADING)
																														.add(
																																FromServerOk,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																81,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																														.add(
																																jPanel4Layout
																																		.createParallelGroup(
																																				org.jdesktop.layout.GroupLayout.LEADING,
																																				false)
																																		.add(
																																				FromDBFileOk,
																																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																				Short.MAX_VALUE)
																																		.add(
																																				FromDirectoryOk,
																																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																				Short.MAX_VALUE))))
																						.add(
																								org.jdesktop.layout.GroupLayout.LEADING,
																								jPanel4Layout
																										.createSequentialGroup()
																										.add(
																												jPanel4Layout
																														.createParallelGroup(
																																org.jdesktop.layout.GroupLayout.LEADING)
																														.add(
																																jLabel10)
																														.add(
																																jLabel12))
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.RELATED)
																										.add(
																												jPanel4Layout
																														.createParallelGroup(
																																org.jdesktop.layout.GroupLayout.LEADING)
																														.add(
																																jPanel4Layout
																																		.createSequentialGroup()
																																		.add(
																																				jTextField2,
																																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																				360,
																																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				org.jdesktop.layout.LayoutStyle.UNRELATED)
																																		.add(
																																				jButton1,
																																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																				181,
																																				Short.MAX_VALUE))
																														.add(
																																jTextField1,
																																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																553,
																																Short.MAX_VALUE))))
																		.add(
																				97,
																				97,
																				97)))));
		jPanel4Layout
				.setVerticalGroup(jPanel4Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel4Layout
										.createSequentialGroup()
										.add(17, 17, 17)
										.add(jLabel3)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																selectDirectBatch,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																25,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(FromDirectoryOk)
														.add(
																FromDirectory,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(jLabel4)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																FromDBFile,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																FromDBFileSelect,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																25,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(FromDBFileOk))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jLabel5,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												15,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																FromDBServer,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																FromServerOk,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																25,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(jLabel6)
														.add(jLabel7)
														.add(
																jComboBox1,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																jTextField4,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																jLabel8,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																15,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																jTextField6,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(jLabel9)
														.add(
																jTextField5,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(jLabel10)
														.add(
																jTextField1,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(jLabel11)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(jLabel12)
														.add(
																jTextField2,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(jButton1))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																jLabel13,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																15,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(jButton2))
										.addContainerGap(
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jTabbedPane1.addTab("3)\u6279\u91cf\u6dfb\u52a0", jPanel4);

		ToolsChooseBlog.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		jLabel1
				.setText("1.\u5bfc\u5165\u535a\u5ba2\u6587\u7ae0 (\u9009\u62e9\u535a\u5ba2\u7f51\u7ad9 \u8f93\u5165\u535a\u4e3bid)");

		ToolsBlogOk.setText("\u5bfc\u5165");

		jLabel2
				.setText("2.\u4e00\u952e\u641c\u7d22\u5bfc\u5165IEEE\u8bba\u6587(\u8f93\u5165 \u641c\u7d22\u8bcd \u6ce8\u610f\uff1a\u4fdd\u8bc1IEEE\u80fd\u6709\u6548\u8bbf\u95ee)");

		IEEEOk.setText("\u5bfc\u5165");

		org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(
				jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout
				.setHorizontalGroup(jPanel6Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel6Layout
										.createSequentialGroup()
										.add(36, 36, 36)
										.add(
												jPanel6Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.TRAILING)
														.add(
																org.jdesktop.layout.GroupLayout.LEADING,
																jProgressBar2,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																581,
																Short.MAX_VALUE)
														.add(
																org.jdesktop.layout.GroupLayout.LEADING,
																jPanel6Layout
																		.createParallelGroup(
																				org.jdesktop.layout.GroupLayout.TRAILING,
																				false)
																		.add(
																				org.jdesktop.layout.GroupLayout.LEADING,
																				IEEEKeywords)
																		.add(
																				org.jdesktop.layout.GroupLayout.LEADING,
																				jPanel6Layout
																						.createSequentialGroup()
																						.add(
																								jLabel2,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								368,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								org.jdesktop.layout.LayoutStyle.UNRELATED)
																						.add(
																								IEEEOk,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.add(
																				org.jdesktop.layout.GroupLayout.LEADING,
																				jProgressBar1,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.add(
																				org.jdesktop.layout.GroupLayout.LEADING,
																				jPanel6Layout
																						.createSequentialGroup()
																						.addPreferredGap(
																								org.jdesktop.layout.LayoutStyle.RELATED)
																						.add(
																								ToolsChooseBlog,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								202,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																						.add(
																								18,
																								18,
																								18)
																						.add(
																								ToolsBlogUsername))
																		.add(
																				org.jdesktop.layout.GroupLayout.LEADING,
																				jPanel6Layout
																						.createSequentialGroup()
																						.add(
																								jLabel1,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								372,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								org.jdesktop.layout.LayoutStyle.RELATED)
																						.add(
																								ToolsBlogOk,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								204,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(39, Short.MAX_VALUE)));
		jPanel6Layout
				.setVerticalGroup(jPanel6Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel6Layout
										.createSequentialGroup()
										.add(29, 29, 29)
										.add(
												jPanel6Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																jLabel1,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																27,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(ToolsBlogOk))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel6Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																ToolsChooseBlog,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																ToolsBlogUsername,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																23,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jProgressBar1,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												22,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.UNRELATED)
										.add(
												jPanel6Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(jLabel2).add(
																IEEEOk))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												IEEEKeywords,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jProgressBar2,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												23,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(133, Short.MAX_VALUE)));

		jTabbedPane1.addTab("\u5de5\u5177", jPanel6);

		jMenu1.setText("\u6dfb\u52a0");

		jMenuItem1
				.setText("\u6587\u4ef6\u6dfb\u52a0(\u652f\u6301word,pdf,txt)");
		jMenu1.add(jMenuItem1);

		jMenuItem2
				.setText("\u5feb\u901f\u6dfb\u52a0(\u590d\u5236-\u7c98\u8d34\u6a21\u5f0f)");
		jMenu1.add(jMenuItem2);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("\u68c0\u7d22");
		jMenuBar1.add(jMenu2);

		jMenu3.setText("\u53cd\u9988");

		jMenu4.setText("\u53d1\u9001\u4e00\u5c01\u90ae\u4ef6");
		jMenu3.add(jMenu4);

		jMenuBar1.add(jMenu3);

		jLabel14.setFont(new java.awt.Font("微软雅黑", 0, 36));
		jLabel14
				.setText("\u4e3a\u4eba\u5de5\u667a\u80fd\u7684\u8fdb\u6b65\u800c\u4e0d\u61c8\u594b\u6597\u3002");

		jMenu5.setText("\u6dfb\u52a0");

		jMenuItem5
				.setText("\u6587\u4ef6\u6dfb\u52a0(\u652f\u6301doc,docx,ppt,pptx, \u56fe\u7247,html,pdf,txt)");
		jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem5ActionPerformed(evt);
			}
		});
		jMenu5.add(jMenuItem5);

		jMenuItem6
				.setText("\u5feb\u901f\u6dfb\u52a0(\u590d\u5236-\u7c98\u8d34\u6a21\u5f0f)");
		jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem6ActionPerformed(evt);
			}
		});
		jMenu5.add(jMenuItem6);

		jMenuBar2.add(jMenu5);

		jMenu6.setText("\u68c0\u7d22");
		jMenu6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu6ActionPerformed(evt);
			}
		});
		jMenuBar2.add(jMenu6);

		jMenu7.setText("\u53cd\u9988");

		jMenu8.setText("\u53d1\u9001\u4e00\u5c01\u90ae\u4ef6");
		jMenu7.add(jMenu8);

		jMenuBar2.add(jMenu7);

		setJMenuBar(jMenuBar2);

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(
				org.jdesktop.layout.GroupLayout.TRAILING,
				layout.createSequentialGroup().addContainerGap().add(
						layout.createParallelGroup(
								org.jdesktop.layout.GroupLayout.TRAILING).add(
								org.jdesktop.layout.GroupLayout.LEADING,
								jLabel14,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								661, Short.MAX_VALUE).add(
								org.jdesktop.layout.GroupLayout.LEADING,
								jTabbedPane1,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								661, Short.MAX_VALUE)).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(
				org.jdesktop.layout.GroupLayout.TRAILING,
				layout.createSequentialGroup().addContainerGap().add(jLabel14,
						org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
						org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE).addPreferredGap(
						org.jdesktop.layout.LayoutStyle.UNRELATED).add(
						jTabbedPane1,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 382,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void FromDirectoryOkActionPerformed(java.awt.event.ActionEvent evt) {
		//from mulu do it
		// TODO add your handling code here:
	}

	private void FromDirectoryActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		//getJTabbedPane1().setSelectedComponent(getJPanel1());
	}

	private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		getJTabbedPane1().setSelectedComponent(getJPanel5());
	}

	private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		getJTabbedPane1().setSelectedComponent(getJPanel3());
	}

	private void selectDirectBatchActionPerformed(java.awt.event.ActionEvent evt) {//from mulu
		// TODO add your handling code here:
		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);
		int returnVal = chooser.showOpenDialog(this.selectDirectBatch);
		if (returnVal == JFileChooser.FILES_ONLY) {
			File[] selectPath = chooser.getSelectedFiles();
			chooser.hide();
			for (int i = 0; i < selectPath.length; i++) {
				Doc doc = Doc.getDoc(selectPath[i].getAbsolutePath());
				VMainHelper.fileDoc = doc;

				if (doc == null) {
					Alert.Msg("不支持的格式.");
				} else {
					doc.extract(selectPath[i].getAbsolutePath());
					try {
						lucene.Index.Open(false);
						lucene.Index
								.AddBatch(VMainHelper.fileDoc.getDocument());
						lucene.Index.EndBatch();
					} catch (CorruptIndexException e) {
						// TODO Auto-generated catch block
						ModelLogger.getLogger().error(
								e.getLocalizedMessage().toString());
					} catch (LockObtainFailedException e) {
						// TODO Auto-generated catch block
						ModelLogger.getLogger().error(
								e.getLocalizedMessage().toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						ModelLogger.getLogger().error(
								e.getLocalizedMessage().toString());
					}

					VMainHelper.fileDoc = null;
				}
			}
		}
	}

	private void SnapStartActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Alert.Msg("双击或者空格结束截屏,右键取消，ctrl+alt+a 可以快速截屏");
		SnapUtil rd = new SnapUtil();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		gd.setFullScreenWindow(rd);
	}

	private void SearchKeyTyped(java.awt.event.KeyEvent evt) {
		// TODO add your handling code here:

	}

	public javax.swing.JTextField getFromDBFile() {
		return FromDBFile;
	}

	public void setFromDBFile(javax.swing.JTextField fromDBFile) {
		FromDBFile = fromDBFile;
	}

	public javax.swing.JButton getFromDBFileOk() {
		return FromDBFileOk;
	}

	public void setFromDBFileOk(javax.swing.JButton fromDBFileOk) {
		FromDBFileOk = fromDBFileOk;
	}

	public javax.swing.JButton getFromDBFileSelect() {
		return FromDBFileSelect;
	}

	public void setFromDBFileSelect(javax.swing.JButton fromDBFileSelect) {
		FromDBFileSelect = fromDBFileSelect;
	}

	public javax.swing.JTextField getFromDBServer() {
		return FromDBServer;
	}

	public void setFromDBServer(javax.swing.JTextField fromDBServer) {
		FromDBServer = fromDBServer;
	}

	public javax.swing.JTextField getFromDirectory() {
		return FromDirectory;
	}

	public void setFromDirectory(javax.swing.JTextField fromDirectory) {
		FromDirectory = fromDirectory;
	}

	public javax.swing.JButton getFromDirectoryOk() {
		return FromDirectoryOk;
	}

	public void setFromDirectoryOk(javax.swing.JButton fromDirectoryOk) {
		FromDirectoryOk = fromDirectoryOk;
	}

	public javax.swing.JButton getFromServerOk() {
		return FromServerOk;
	}

	public void setFromServerOk(javax.swing.JButton fromServerOk) {
		FromServerOk = fromServerOk;
	}

	public javax.swing.JButton getInsertFileOk1() {
		return InsertFileOk1;
	}

	public void setInsertFileOk1(javax.swing.JButton insertFileOk1) {
		InsertFileOk1 = insertFileOk1;
	}

	public javax.swing.JButton getJButton1() {
		return jButton1;
	}

	public void setJButton1(javax.swing.JButton button1) {
		jButton1 = button1;
	}

	public javax.swing.JButton getJButton2() {
		return jButton2;
	}

	public void setJButton2(javax.swing.JButton button2) {
		jButton2 = button2;
	}

	public javax.swing.JComboBox getJComboBox1() {
		return jComboBox1;
	}

	public void setJComboBox1(javax.swing.JComboBox comboBox1) {
		jComboBox1 = comboBox1;
	}

	public javax.swing.JLabel getJLabel10() {
		return jLabel10;
	}

	public void setJLabel10(javax.swing.JLabel label10) {
		jLabel10 = label10;
	}

	public javax.swing.JLabel getJLabel11() {
		return jLabel11;
	}

	public void setJLabel11(javax.swing.JLabel label11) {
		jLabel11 = label11;
	}

	public javax.swing.JLabel getJLabel12() {
		return jLabel12;
	}

	public void setJLabel12(javax.swing.JLabel label12) {
		jLabel12 = label12;
	}

	public javax.swing.JLabel getJLabel13() {
		return jLabel13;
	}

	public void setJLabel13(javax.swing.JLabel label13) {
		jLabel13 = label13;
	}

	public javax.swing.JLabel getJLabel3() {
		return jLabel3;
	}

	public void setJLabel3(javax.swing.JLabel label3) {
		jLabel3 = label3;
	}

	public javax.swing.JLabel getJLabel4() {
		return jLabel4;
	}

	public void setJLabel4(javax.swing.JLabel label4) {
		jLabel4 = label4;
	}

	public javax.swing.JLabel getJLabel5() {
		return jLabel5;
	}

	public void setJLabel5(javax.swing.JLabel label5) {
		jLabel5 = label5;
	}

	public javax.swing.JLabel getJLabel6() {
		return jLabel6;
	}

	public void setJLabel6(javax.swing.JLabel label6) {
		jLabel6 = label6;
	}

	public javax.swing.JLabel getJLabel7() {
		return jLabel7;
	}

	public void setJLabel7(javax.swing.JLabel label7) {
		jLabel7 = label7;
	}

	public javax.swing.JLabel getJLabel8() {
		return jLabel8;
	}

	public void setJLabel8(javax.swing.JLabel label8) {
		jLabel8 = label8;
	}

	public javax.swing.JLabel getJLabel9() {
		return jLabel9;
	}

	public void setJLabel9(javax.swing.JLabel label9) {
		jLabel9 = label9;
	}

	public javax.swing.JMenu getJMenu4() {
		return jMenu4;
	}

	public void setJMenu4(javax.swing.JMenu menu4) {
		jMenu4 = menu4;
	}

	public javax.swing.JMenuItem getJMenuItem3() {
		return jMenuItem3;
	}

	public void setJMenuItem3(javax.swing.JMenuItem menuItem3) {
		jMenuItem3 = menuItem3;
	}

	public javax.swing.JMenuItem getJMenuItem4() {
		return jMenuItem4;
	}

	public void setJMenuItem4(javax.swing.JMenuItem menuItem4) {
		jMenuItem4 = menuItem4;
	}

	public javax.swing.JPanel getJPanel4() {
		return jPanel4;
	}

	public void setJPanel4(javax.swing.JPanel panel4) {
		jPanel4 = panel4;
	}

	public javax.swing.JPopupMenu getJPopupMenu1() {
		return jPopupMenu1;
	}

	public void setJPopupMenu1(javax.swing.JPopupMenu popupMenu1) {
		jPopupMenu1 = popupMenu1;
	}

	public javax.swing.JTextField getJTextField1() {
		return jTextField1;
	}

	public void setJTextField1(javax.swing.JTextField textField1) {
		jTextField1 = textField1;
	}

	public javax.swing.JTextField getJTextField2() {
		return jTextField2;
	}

	public void setJTextField2(javax.swing.JTextField textField2) {
		jTextField2 = textField2;
	}

	public javax.swing.JTextField getJTextField4() {
		return jTextField4;
	}

	public void setJTextField4(javax.swing.JTextField textField4) {
		jTextField4 = textField4;
	}

	public javax.swing.JTextField getJTextField5() {
		return jTextField5;
	}

	public void setJTextField5(javax.swing.JTextField textField5) {
		jTextField5 = textField5;
	}

	public javax.swing.JTextField getJTextField6() {
		return jTextField6;
	}

	public void setJTextField6(javax.swing.JTextField textField6) {
		jTextField6 = textField6;
	}

	public javax.swing.JButton getSelectDirectBatch() {
		return selectDirectBatch;
	}

	public void setSelectDirectBatch(javax.swing.JButton selectDirectBatch) {
		this.selectDirectBatch = selectDirectBatch;
	}

	private void SearchBoxKeyPressed(java.awt.event.KeyEvent evt) {
		// TODO add your handling code here:
		try {
			if (evt.getKeyCode() != 13 && evt.getKeyCode() != 10) {
				return;
			}
			VMainHelper.se = this.SearchBox.getText().toLowerCase();
			if (VMainHelper.se.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "you must input keyword.");
				return;
			}
			VMainHelper.documents = Search.search(this.SearchBox.getText()
					.toLowerCase(), 50);
			VMainHelper.ReList(this.ResultTable);
			if (VMainHelper.documents == null) {
				JOptionPane.showMessageDialog(null, "no result.");
				return;
			}

			this.getJTabbedPane1().setSelectedComponent(this.getJPanel2());
			;
			this.getJTabbedPane1().updateUI();
		} catch (Exception e) {
			ModelLogger.getLogger().error(e.getLocalizedMessage().toString());
		}
	}

	private void InsertFileOk1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		JFileChooser chooser = new JFileChooser();

		int returnVal = chooser.showOpenDialog(this.InsertFileOk1);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String selectPath = chooser.getSelectedFile().getPath();
			chooser.hide();
			Doc doc = Doc.getDoc(selectPath);
			VMainHelper.fileDoc = doc;

			if (doc == null) {
				Alert.Msg("不支持的格式.");
			} else {
				doc.extract(selectPath);
				getInsertFromFileTitle().setText(doc.getTitle());
				getInsertFromFileContent().setText(doc.getText());
			}
		}
	}

	private void InsertFileOkActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (VMainHelper.fileDoc == null) {
			Alert.Msg("先选择一个文件");
			return;
		}

		try {
			lucene.Index.Open(false);
			if (getInsertFromFileTitle().getText().trim().equals("")
					|| getInsertFromFileContent().getText().trim().equals("")) {
				Alert.Msg("标题和文章不能为空");
				return;
			}
			VMainHelper.fileDoc.setTitle(getInsertFromFileTitle().getText());
			VMainHelper.fileDoc.setText(getInsertFromFileContent().getText());
			getInsertFromFileTitle().setText("");
			getInsertFromFileContent().setText("");
			lucene.Index.AddBatch(VMainHelper.fileDoc.getDocument());
			lucene.Index.EndBatch();
		} catch (CorruptIndexException e) {
			// TODO Auto-generated catch block
			ModelLogger.getLogger().error(e.getLocalizedMessage().toString());
		} catch (LockObtainFailedException e) {
			// TODO Auto-generated catch block
			ModelLogger.getLogger().error(e.getLocalizedMessage().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ModelLogger.getLogger().error(e.getLocalizedMessage().toString());
		}

		VMainHelper.fileDoc = null;
	}

	private void SearchBoxActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void SearchOkActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		// LABEL 搜索
	}

	private void popMenu(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int mod = evt.getModifiers();
		if ((mod & InputEvent.BUTTON3_MASK) != 0) {
			jPopupMenu1.show(this.ResultTable, evt.getX(), evt.getY());
		}
	}

	private void popMenuDelete(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		int[] index = null;
		if ((index = this.getResultTable().getSelectedRows()) != null) {
			if ((JOptionPane.YES_OPTION) == JOptionPane.showConfirmDialog(
					jPopupMenu1, "are you sure to delete these Documents?",
					"CONFIRM", 0)) {
				for (int i : index) {
					String time = VMainHelper.documents[i].get("addtime");
					// System.out.println(time);
					Index.Delete("addtime", time);
					VMainHelper.reSearch(this.ResultTable);
				}
			}
		}
	}

	private void popMenuSeeDetail(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		int[] index = null;
		if ((index = this.getResultTable().getSelectedRows()) != null
				&& index.length >= 1) {
			int i = index[0];
			Document docu = VMainHelper.documents[i];
			VMainHelper.display(this.Detail, docu);
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {

		JFrame.setDefaultLookAndFeelDecorated(true); // 加上此语句连同窗体外框也改变
		JDialog.setDefaultLookAndFeelDecorated(true); // 加上此语句会使弹出的对话框也改变
		try {
			File file = new File("./skinChange.txt");
			//System.out.println(file.getAbsolutePath());
			String skins = "Autumn";
			if (!file.exists()) {
				UIManager.setLookAndFeel(new SubstanceAutumnLookAndFeel());
				SubstanceSkin skin = new AutumnSkin();
			} else {
				int r = (int) (Math.random() * 18);
				//System.out.println(r);
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file));// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				String ret = "";
				int i = 0;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (i == r)
						ret = (lineTxt).trim();
					i++;
				}
				//System.out.println(ret);
				SubstanceSkin skin = new CremeSkin();
				if (ret.trim().equals("OfficeBlue2007")) {
					UIManager
							.setLookAndFeel(new SubstanceOfficeBlue2007LookAndFeel());
					skin = new OfficeBlue2007Skin();
				} else if (ret.trim().equals("BusinessBlackSteel")) {
					UIManager
							.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());
					skin = new BusinessBlackSteelSkin();
				} else if (ret.trim().equals("BusinessBlueSteel")) {
					UIManager
							.setLookAndFeel(new SubstanceBusinessBlueSteelLookAndFeel());
					skin = new BusinessBlueSteelSkin();
				} else if (ret.trim().equals("Business")) {
					UIManager
							.setLookAndFeel(new SubstanceBusinessLookAndFeel());
					skin = new BusinessSkin();
				} else if (ret.trim().equals("ChallengerDeep")) {
					UIManager
							.setLookAndFeel(new SubstanceChallengerDeepLookAndFeel());
					skin = new ChallengerDeepSkin();
				} else if (ret.trim().equals("EmeraldDusk")) {
					UIManager
							.setLookAndFeel(new SubstanceEmeraldDuskLookAndFeel());
					skin = new EmeraldDuskSkin();
				} else if (ret.trim().equals("Magma")) {
					UIManager.setLookAndFeel(new SubstanceMagmaLookAndFeel());
					skin = new MagmaSkin();
				} else if (ret.trim().equals("MistAqua")) {
					UIManager
							.setLookAndFeel(new SubstanceMistAquaLookAndFeel());
					skin = new MistAquaSkin();
				} else if (ret.trim().equals("MistSilver")) {
					UIManager
							.setLookAndFeel(new SubstanceMistSilverLookAndFeel());
					skin = new MistSilverSkin();
				} else if (ret.trim().equals("Moderate")) {
					UIManager
							.setLookAndFeel(new SubstanceModerateLookAndFeel());
					skin = new ModerateSkin();
				} else if (ret.trim().equals("NebulaBrickWall")) {
					UIManager
							.setLookAndFeel(new SubstanceNebulaBrickWallLookAndFeel());
					skin = new NebulaBrickWallSkin();
				} else if (ret.trim().equals("Nebula")) {
					UIManager.setLookAndFeel(new SubstanceNebulaLookAndFeel());
					skin = new NebulaSkin();
				} else if (ret.trim().equals("OfficeBlue2007")) {
					UIManager
							.setLookAndFeel(new SubstanceOfficeBlue2007LookAndFeel());
					skin = new OfficeBlue2007Skin();
				} else if (ret.trim().equals("OfficeSilver2007")) {
					UIManager
							.setLookAndFeel(new SubstanceOfficeSilver2007LookAndFeel());
					skin = new OfficeSilver2007Skin();
				} else if (ret.trim().equals("RavenGraphiteGlass")) {
					UIManager
							.setLookAndFeel(new SubstanceRavenGraphiteGlassLookAndFeel());
					skin = new RavenGraphiteGlassSkin();
				} else if (ret.trim().equals("RavenGraphite")) {
					UIManager
							.setLookAndFeel(new SubstanceRavenGraphiteLookAndFeel());
					skin = new RavenGraphiteSkin();
				} else if (ret.trim().equals("Raven")) {
					UIManager.setLookAndFeel(new SubstanceRavenLookAndFeel());
					skin = new RavenSkin();
				} else if (ret.trim().equals("Sahara")) {
					UIManager.setLookAndFeel(new SubstanceSaharaLookAndFeel());
					skin = new SaharaSkin();
				}
				// UIManager.setLookAndFeel(new SubstanceCremeLookAndFeel());

				// 可根据根据外观类型，设置相应的皮肤，实践证实不一定需要一一对应
				// SubstanceSkin skin = new OfficeBlue2007Skin();

				// 此语句设置外观
				SubstanceLookAndFeel.setSkin(skin);
			}
		} catch (UnsupportedLookAndFeelException ex) {

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

				VMain vmain = new VMain();
				vmain.setVisible(true);
				VMainHelper.setVMain(vmain);

			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextArea Detail;
	private javax.swing.JTextField FromDBFile;
	private javax.swing.JButton FromDBFileOk;
	private javax.swing.JButton FromDBFileSelect;
	private javax.swing.JTextField FromDBServer;
	private javax.swing.JTextField FromDirectory;
	private javax.swing.JButton FromDirectoryOk;
	private javax.swing.JButton FromServerOk;
	private javax.swing.JTextField IEEEKeywords;
	private javax.swing.JButton IEEEOk;
	private javax.swing.JButton InsertFileOk;
	private javax.swing.JButton InsertFileOk1;
	private javax.swing.JTextArea InsertFromFileContent;
	private javax.swing.JTextField InsertFromFileTitle;
	private javax.swing.JButton QuickInsertOk;
	private javax.swing.JTextArea QuickInsertTextArea;
	private javax.swing.JTextField QuickInsertTitle;
	private javax.swing.JTable ResultTable;
	private javax.swing.JTextField SearchBox;
	private javax.swing.JButton SearchOk;
	private javax.swing.JButton SnapStart;
	private javax.swing.JButton ToolsBlogOk;
	private javax.swing.JTextField ToolsBlogUsername;
	private javax.swing.JComboBox ToolsChooseBlog;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenu jMenu5;
	private javax.swing.JMenu jMenu6;
	private javax.swing.JMenu jMenu7;
	private javax.swing.JMenu jMenu8;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuBar jMenuBar2;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPopupMenu jPopupMenu1;
	private javax.swing.JProgressBar jProgressBar1;
	private javax.swing.JProgressBar jProgressBar2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTextArea jTextArea2;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JButton selectDirectBatch;

	// End of variables declaration//GEN-END:variables
	public javax.swing.JTextArea getDetail() {
		return Detail;
	}

	public void setDetail(javax.swing.JTextArea detail) {
		Detail = detail;
	}

	public javax.swing.JTextField getIEEEKeywords() {
		return IEEEKeywords;
	}

	public void setIEEEKeywords(javax.swing.JTextField keywords) {
		IEEEKeywords = keywords;
	}

	public javax.swing.JButton getIEEEOk() {
		return IEEEOk;
	}

	public void setIEEEOk(javax.swing.JButton ok) {
		IEEEOk = ok;
	}

	public javax.swing.JButton getInsertFileOk() {
		return InsertFileOk;
	}

	public void setInsertFileOk(javax.swing.JButton insertFileOk) {
		InsertFileOk = insertFileOk;
	}

	public javax.swing.JTextArea getInsertFromFileContent() {
		return InsertFromFileContent;
	}

	public void setInsertFromFileContent(
			javax.swing.JTextArea insertFromFileContent) {
		InsertFromFileContent = insertFromFileContent;
	}

	public javax.swing.JTextField getInsertFromFileTitle() {
		return InsertFromFileTitle;
	}

	public void setInsertFromFileTitle(
			javax.swing.JTextField insertFromFileTitle) {
		InsertFromFileTitle = insertFromFileTitle;
	}

	public javax.swing.JButton getQuickInsertOk() {
		return QuickInsertOk;
	}

	public void setQuickInsertOk(javax.swing.JButton quickInsertOk) {
		QuickInsertOk = quickInsertOk;
	}

	public javax.swing.JTextArea getQuickInsertTextArea() {
		return QuickInsertTextArea;
	}

	public void setQuickInsertTextArea(javax.swing.JTextArea quickInsertTextArea) {
		QuickInsertTextArea = quickInsertTextArea;
	}

	public javax.swing.JTextField getQuickInsertTitle() {
		return QuickInsertTitle;
	}

	public void setQuickInsertTitle(javax.swing.JTextField quickInsertTitle) {
		QuickInsertTitle = quickInsertTitle;
	}

	public javax.swing.JTable getResultTable() {
		return ResultTable;
	}

	public void setResultTable(javax.swing.JTable resultTable) {
		ResultTable = resultTable;
	}

	public javax.swing.JTextField getSearchBox() {
		return SearchBox;
	}

	public void setSearchBox(javax.swing.JTextField searchBox) {
		SearchBox = searchBox;
	}

	public javax.swing.JButton getSearchOk() {
		return SearchOk;
	}

	public void setSearchOk(javax.swing.JButton searchOk) {
		SearchOk = searchOk;
	}

	public javax.swing.JButton getToolsBlogOk() {
		return ToolsBlogOk;
	}

	public void setToolsBlogOk(javax.swing.JButton toolsBlogOk) {
		ToolsBlogOk = toolsBlogOk;
	}

	public javax.swing.JTextField getToolsBlogUsername() {
		return ToolsBlogUsername;
	}

	public void setToolsBlogUsername(javax.swing.JTextField toolsBlogUsername) {
		ToolsBlogUsername = toolsBlogUsername;
	}

	public javax.swing.JComboBox getToolsChooseBlog() {
		return ToolsChooseBlog;
	}

	public void setToolsChooseBlog(javax.swing.JComboBox toolsChooseBlog) {
		ToolsChooseBlog = toolsChooseBlog;
	}

	public javax.swing.ButtonGroup getButtonGroup1() {
		return buttonGroup1;
	}

	public void setButtonGroup1(javax.swing.ButtonGroup buttonGroup1) {
		this.buttonGroup1 = buttonGroup1;
	}

	public javax.swing.JLabel getJLabel1() {
		return jLabel1;
	}

	public void setJLabel1(javax.swing.JLabel label1) {
		jLabel1 = label1;
	}

	public javax.swing.JLabel getJLabel2() {
		return jLabel2;
	}

	public void setJLabel2(javax.swing.JLabel label2) {
		jLabel2 = label2;
	}

	public javax.swing.JMenu getJMenu1() {
		return jMenu1;
	}

	public void setJMenu1(javax.swing.JMenu menu1) {
		jMenu1 = menu1;
	}

	public javax.swing.JMenu getJMenu2() {
		return jMenu2;
	}

	public void setJMenu2(javax.swing.JMenu menu2) {
		jMenu2 = menu2;
	}

	public javax.swing.JMenu getJMenu3() {
		return jMenu3;
	}

	public void setJMenu3(javax.swing.JMenu menu3) {
		jMenu3 = menu3;
	}

	public javax.swing.JMenuBar getJMenuBar1() {
		return jMenuBar1;
	}

	public void setJMenuBar1(javax.swing.JMenuBar menuBar1) {
		jMenuBar1 = menuBar1;
	}

	public javax.swing.JMenuItem getJMenuItem1() {
		return jMenuItem1;
	}

	public void setJMenuItem1(javax.swing.JMenuItem menuItem1) {
		jMenuItem1 = menuItem1;
	}

	public javax.swing.JMenuItem getJMenuItem2() {
		return jMenuItem2;
	}

	public void setJMenuItem2(javax.swing.JMenuItem menuItem2) {
		jMenuItem2 = menuItem2;
	}

	public javax.swing.JPanel getJPanel1() {
		return jPanel1;
	}

	public void setJPanel1(javax.swing.JPanel panel1) {
		jPanel1 = panel1;
	}

	public javax.swing.JPanel getJPanel2() {
		return jPanel2;
	}

	public void setJPanel2(javax.swing.JPanel panel2) {
		jPanel2 = panel2;
	}

	public javax.swing.JPanel getJPanel3() {
		return jPanel3;
	}

	public void setJPanel3(javax.swing.JPanel panel3) {
		jPanel3 = panel3;
	}

	public javax.swing.JPanel getJPanel5() {
		return jPanel5;
	}

	public void setJPanel5(javax.swing.JPanel panel5) {
		jPanel5 = panel5;
	}

	public javax.swing.JPanel getJPanel6() {
		return jPanel6;
	}

	public void setJPanel6(javax.swing.JPanel panel6) {
		jPanel6 = panel6;
	}

	public javax.swing.JPanel getJPanel7() {
		return jPanel7;
	}

	public void setJPanel7(javax.swing.JPanel panel7) {
		jPanel7 = panel7;
	}

	public javax.swing.JProgressBar getJProgressBar1() {
		return jProgressBar1;
	}

	public void setJProgressBar1(javax.swing.JProgressBar progressBar1) {
		jProgressBar1 = progressBar1;
	}

	public javax.swing.JProgressBar getJProgressBar2() {
		return jProgressBar2;
	}

	public void setJProgressBar2(javax.swing.JProgressBar progressBar2) {
		jProgressBar2 = progressBar2;
	}

	public javax.swing.JScrollPane getJScrollPane1() {
		return jScrollPane1;
	}

	public void setJScrollPane1(javax.swing.JScrollPane scrollPane1) {
		jScrollPane1 = scrollPane1;
	}

	public javax.swing.JScrollPane getJScrollPane2() {
		return jScrollPane2;
	}

	public void setJScrollPane2(javax.swing.JScrollPane scrollPane2) {
		jScrollPane2 = scrollPane2;
	}

	public javax.swing.JScrollPane getJScrollPane3() {
		return jScrollPane3;
	}

	public void setJScrollPane3(javax.swing.JScrollPane scrollPane3) {
		jScrollPane3 = scrollPane3;
	}

	public javax.swing.JScrollPane getJScrollPane4() {
		return jScrollPane4;
	}

	public void setJScrollPane4(javax.swing.JScrollPane scrollPane4) {
		jScrollPane4 = scrollPane4;
	}

	public javax.swing.JScrollPane getJScrollPane5() {
		return jScrollPane5;
	}

	public void setJScrollPane5(javax.swing.JScrollPane scrollPane5) {
		jScrollPane5 = scrollPane5;
	}

	public javax.swing.JTabbedPane getJTabbedPane1() {
		return jTabbedPane1;
	}

	public void setJTabbedPane1(javax.swing.JTabbedPane tabbedPane1) {
		jTabbedPane1 = tabbedPane1;
	}

	public javax.swing.JTextArea getJTextArea2() {
		return jTextArea2;
	}

	public void setJTextArea2(javax.swing.JTextArea textArea2) {
		jTextArea2 = textArea2;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}
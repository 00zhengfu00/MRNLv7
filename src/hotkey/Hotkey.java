package hotkey;

import java.awt.Event;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;

import snap.SnapUtil;
import sth.Alert;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.IntellitypeListener;
import com.melloware.jintellitype.JIntellitype;

/**
 * 
 */
public class Hotkey{

	
	private JIntellitype jinstance;
	private int running=0;
	/**
	 * ȫ���ȼ��ĳ�ʼ��ע��
	 */
	public void init() {
		// �赱ǰ����Ŀ¼Ϊ"e:\\java\\JIntellitype"
		// Ҫ���ص�dll�ļ���Ϊ"JIntellitype64.dll",λ�ڵ�ǰĿ¼��".\\com"Ŀ¼��
		 //System.load("e:\\java\\JIntellitype\\com\\JIntellitype64.dll");
		 //JIntellitype.setLibraryLocation("com\\JIntellitype64.dll");

		if (!JIntellitype.isJIntellitypeSupported()) {// �����ȷ������ϵͳ��windows�����ҵ�32λ��64λ��dll֧��,����dll֧��
			Alert.Msg("��ϵͳΪwin7 x64����ݼ�δע��ɹ���");
			return;
		}

		jinstance = JIntellitype.getInstance();// ������jni���λ�ú󣬼���jni�⣬��ȡ������jintellitype����ʵ��

		// �����ȼ�������
		jinstance.addHotKeyListener(new HotkeyListener() {
			public void onHotKey(int identifier) {
				//System.out.println("�������ȼ���Ψһ��ʾID:" + identifier + "��������һ");
				if(identifier==5&&running==0)
				{
					running=1;
					SnapUtil rd =new  SnapUtil();
			        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
			                .getDefaultScreenDevice();
			        gd.setFullScreenWindow(rd);
			        running=0;
				}

			}
		});
		// ����ý���������
		jinstance.addIntellitypeListener(new IntellitypeListener() {
			@Override
			public void onIntellitype(int command) {
				//System.out.println("������ý�����Ψһ��ʾID:" + command);
							}
		});

		// ����ȼ�
//		jinstance.registerHotKey(1, 0, (int) 'Z');// ����Ϊintǿ��ת���Ĵ�д��ĸ
//		jinstance.registerHotKey(2, Event.CTRL_MASK + Event.SHIFT_MASK,
//				(int) 'Z');
//		jinstance.registerHotKey(3,
//				JIntellitype.MOD_WIN + JIntellitype.MOD_ALT, (int) 'A');
//		jinstance.registerHotKey(4, "a");
		jinstance.registerHotKey(5, "shift+ctrl+a");
	}
	/**
	 * ע��ȫ���ȼ���������Դ
	 */
	public void exit() {
        JIntellitype.getInstance().cleanUp();
        System.exit(0);
	}

}

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
	 * 全局热键的初始化注册
	 */
	public void init() {
		// 设当前工作目录为"e:\\java\\JIntellitype"
		// 要加载的dll文件名为"JIntellitype64.dll",位于当前目录的".\\com"目录下
		 //System.load("e:\\java\\JIntellitype\\com\\JIntellitype64.dll");
		 //JIntellitype.setLibraryLocation("com\\JIntellitype64.dll");

		if (!JIntellitype.isJIntellitypeSupported()) {// 检查以确保操作系统是windows且能找到32位和64位的dll支持,加载dll支持
			Alert.Msg("该系统为win7 x64，快捷键未注册成功。");
			return;
		}

		jinstance = JIntellitype.getInstance();// 在设置jni库的位置后，加载jni库，获取单例的jintellitype对象实例

		// 设置热键处理方法
		jinstance.addHotKeyListener(new HotkeyListener() {
			public void onHotKey(int identifier) {
				//System.out.println("触发的热键的唯一标示ID:" + identifier + "，处理方法一");
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
		// 设置媒体键处理方法
		jinstance.addIntellitypeListener(new IntellitypeListener() {
			@Override
			public void onIntellitype(int command) {
				//System.out.println("触发的媒体键的唯一标示ID:" + command);
							}
		});

		// 添加热键
//		jinstance.registerHotKey(1, 0, (int) 'Z');// 参数为int强制转换的大写字母
//		jinstance.registerHotKey(2, Event.CTRL_MASK + Event.SHIFT_MASK,
//				(int) 'Z');
//		jinstance.registerHotKey(3,
//				JIntellitype.MOD_WIN + JIntellitype.MOD_ALT, (int) 'A');
//		jinstance.registerHotKey(4, "a");
		jinstance.registerHotKey(5, "shift+ctrl+a");
	}
	/**
	 * 注销全局热键、清理资源
	 */
	public void exit() {
        JIntellitype.getInstance().cleanUp();
        System.exit(0);
	}

}

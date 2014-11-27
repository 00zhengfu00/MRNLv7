package doc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import log.ModelLogger;

public class TxtDoc extends Doc {

	@Override
	public void extract(String path) {
		// TODO Auto-generated method stub
		try {
			File file = new File(path);
			if (file.isFile() && file.exists()) { // 判断文件是否存在

				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file));// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				String ret = "";
				while ((lineTxt = bufferedReader.readLine()) != null) {
					ret += (lineTxt)+"\n";
				}
				//System.out.println(ret);
				read.close();
				Text = ret;
				getInfo(path);
				From = "txt://" + From;
			} else {
				ModelLogger.getLogger().error("没有找到指定的文件");
			}
		} catch (Exception e) {
			ModelLogger.getLogger().error(e.getLocalizedMessage().toString());
		}
	}

}

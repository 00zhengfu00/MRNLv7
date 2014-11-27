package log;
/**
 * �ýӿ��ṩ����־ģ��Ĺ淶��
 * ��־ģ�齫��־��Ϣ����Ϊ���ּ���
 * ���岻ͬ�������־�ļ�¼�ĸ�ʽ����¼��ʽ�������о���ʵ������������
 * 
 * @author chenyp
 * @version 1.0 2013-3-19
 */
public interface Logger{
	/**
	 * ��¼<tt>Debug</tt>�������־
	 * @param msg ��Ҫ��¼����־��Ϣ
	 */
	public abstract  void debug(String msg);
	/**
	 * ��¼<tt>Info</tt>�������־
	 * @param msg ��Ҫ��¼����־��Ϣ
	 */
	public abstract void info(String msg);
	/**
	 * ��¼<tt>Warn</tt>�������־
	 * @param msg ��Ҫ��¼����־��Ϣ
	 */
	public abstract void warn(String msg);
	/**
	 * ��¼<tt>Error</tt>�������־
	 * @param msg ��Ҫ��¼����־��Ϣ
	 */
	public abstract void error(String msg);
	/**
	 * ��¼<tt>Fatal</tt>�������־
	 * @param msg ��Ҫ��¼����־��Ϣ
	 */
	public abstract void fatal(String msg);
}

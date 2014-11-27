package log;
/**
 * 该接口提供了日志模块的规范。
 * 日志模块将日志信息划分为五种级别，
 * 具体不同级别的日志的记录的格式、记录方式等内容有具体实现类来决定。
 * 
 * @author chenyp
 * @version 1.0 2013-3-19
 */
public interface Logger{
	/**
	 * 记录<tt>Debug</tt>级别的日志
	 * @param msg 需要记录的日志信息
	 */
	public abstract  void debug(String msg);
	/**
	 * 记录<tt>Info</tt>级别的日志
	 * @param msg 需要记录的日志信息
	 */
	public abstract void info(String msg);
	/**
	 * 记录<tt>Warn</tt>级别的日志
	 * @param msg 需要记录的日志信息
	 */
	public abstract void warn(String msg);
	/**
	 * 记录<tt>Error</tt>级别的日志
	 * @param msg 需要记录的日志信息
	 */
	public abstract void error(String msg);
	/**
	 * 记录<tt>Fatal</tt>级别的日志
	 * @param msg 需要记录的日志信息
	 */
	public abstract void fatal(String msg);
}

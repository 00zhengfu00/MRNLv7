package log;

import javax.swing.JOptionPane;

import org.apache.log4j.PropertyConfigurator;



public class ModelLogger implements Logger{

	private ModelLogger()
	{
		 PropertyConfigurator.configure( "./log4j.properties" );
	}
	private static Logger m_logger=new ModelLogger();
	//private static org.apache.log4j.Logger rootlogger=org.apache.log4j.Logger.getRootLogger();
	private static org.apache.log4j.Logger logger=org.apache.log4j.Logger.getLogger(ModelLogger.class);
	//private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(log4jtest.class);
	public static Logger getLogger()
	{
		return m_logger;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = ModelLogger.getLogger();
		logger.info("ddddddddd");
		logger.debug("ddddddddd");
		logger.warn("ddddddddd");
	}

	@Override
	public void debug(String msg) {
		// TODO Auto-generated method stub
		logger.debug(msg);
	}

	@Override
	public void info(String msg) {
		// TODO Auto-generated method stub
		logger.info(msg);
	}

	@Override
	public void warn(String msg) {
		// TODO Auto-generated method stub
		logger.warn(msg);
	}

	@Override
	public void error(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "error occured.");
		logger.error(msg);
	}

	@Override
	public void fatal(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "fatal error occured.");
		logger.fatal(msg);
	}

}

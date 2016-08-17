package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jUtils {
	public static <T> void getLog(Class<T> clazz,String meg){
		Logger log = LogManager.getLogger(clazz);
		log.info(meg);
	}
}

package web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import service.FileRecSer;

public class FileRecSerLis implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("��ʼ���ɹ���");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

}

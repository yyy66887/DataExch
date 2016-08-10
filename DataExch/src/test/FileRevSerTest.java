package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import service.FileRecSer;

public class FileRevSerTest {

	@Test
	public void testFileRec() {
		try {
			FileRecSer frs = new FileRecSer();
			InputStream in = FileRecSer.class.getClassLoader().getResourceAsStream("serconfig.properties");
			Properties pros = new Properties();
			pros.load(in);
			frs.fileRec(pros.getProperty("svPath"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

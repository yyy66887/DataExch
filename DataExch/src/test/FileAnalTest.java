package test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import domain.ExchData;
import service.FileAnal;

public class FileAnalTest {

	private FileAnal fa = new FileAnal();
	@Test
	public void testAnalysis() {
		List<ExchData> list = fa.analysis(new File("C:/Users/charmyyy/Desktop/test.txt"));
		for(ExchData ed:list){
			System.out.println(ed);
		}
	}

}

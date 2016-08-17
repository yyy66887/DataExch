package test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

import org.junit.Test;

import service.FileAnal;
import domain.ExchData;
import domain.State;

public class FileAnalTest {

	private FileAnal fa = new FileAnal();

	@Test
	public void testGetEtnd() throws IOException {
		State s = new State();
		s.setPath("G:/out/127.0.0.1/test.txt");
		s.setSz((long) 10000);
		List<String[]> list = fa.getEtnd(s);
		for (String[] st : list) {
			for(String ss:st){
				System.out.print(ss);
			}
			System.out.println();
		}
	}

	@Test
	public void testAnalysis() {
		List<ExchData> list = fa.analysis(new File(
				"C:/Users/charmyyy/Desktop/test.txt"));
		for (ExchData ed : list) {
			System.out.println(ed);
		}
	}

}

package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.ExchData;

public class FileAnal {
	/**
	 * 解析文本文件 
	 * @param file
	 * @return 返回ExchData的列表
	 */
	public List<ExchData> analysis(File file) {
		BufferedReader br = null;
		List<ExchData> list = null;
		try {
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = null;
			list = new ArrayList<ExchData>();
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				String[] strs = line.split(",");
				ExchData ed = new ExchData();
				ed.setYear(Integer.parseInt(strs[0]));
				ed.setDay(Integer.parseInt(strs[1]));
				ed.setFlow(Float.parseFloat(strs[2]));
				ed.setRainfall(Float.parseFloat(strs[3]));
				ed.setVoltage(Float.parseFloat(strs[4]));
				list.add(ed);
			}
			return list;
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

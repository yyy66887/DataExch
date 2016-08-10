package domain;

import java.io.Serializable;

public class FilePro implements Serializable {
	private String filenm;// 文件名+文件后缀
	private String md5;// 文件内容

	public FilePro(String filenm, String md5) {
		super();
		this.filenm = filenm;
		this.md5 = md5;
	}

	public String getFilenm() {
		return filenm;
	}

	public void setFilenm(String filenm) {
		this.filenm = filenm;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	@Override
	public String toString() {
		return "FilePro [filenm=" + filenm + ", md5=" + md5 + "]";
	}

}

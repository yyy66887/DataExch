package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Md5Utils {
	public static String encoding(File file) {
		// 缓冲区大小（这个可以抽出�?��参数�?
		int bufferSize = 256 * 1024;
		FileInputStream fileInputStream = null;
		DigestInputStream digestInputStream = null;
		try {
			// 拿到�?��MD5转换器（同样，这里可以换成SHA1�?
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			// 使用DigestInputStream
			fileInputStream = new FileInputStream(file);
			digestInputStream = new DigestInputStream(fileInputStream,
					messageDigest);
			// read的过程中进行MD5处理，直到读完文�?
			byte[] buffer = new byte[bufferSize];
			while (digestInputStream.read(buffer) > 0)
				;
			// 获取�?��的MessageDigest
			messageDigest = digestInputStream.getMessageDigest();
			// 拿到结果，也是字节数组，包含16个元�?
			byte[] resultByteArray = messageDigest.digest();
			// 同样，把字节数组转换成字符串
			return new BASE64Encoder().encode(resultByteArray);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				digestInputStream.close();
			} catch (Exception e) {
			}
			try {
				fileInputStream.close();
			} catch (Exception e) {
			}
		}
	}
}
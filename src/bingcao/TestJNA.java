package bingcao;

import java.io.*;

import com.sun.jna.*;

/**
 * @author troy 2017-08-22 下午19:28
 *
 */
public class TestJNA {

	public interface nativeDLL extends Library {

		// /当前路径是在项目下，而不是bin输出目录下。
		nativeDLL INSTANCE = (nativeDLL) Native
				.loadLibrary(
						"D:/documents/visual studio 2013/Projects/nativeDLL/x64/Debug/nativeDLL",
						nativeDLL.class);

		public double Java_bingcao_TestJNI_nativeMethod();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int countRun = 0;
		FileOutputStream fs = new FileOutputStream(
				new File("D:\\myFileJNA.txt"));
		PrintStream printToFile = new PrintStream(fs);

		while (countRun < 10) {
			
			System.out.print("start " + countRun + " test..." );
			//printToFile.print(countRun+" test: ");
			
			long startTime = System.currentTimeMillis(); // 获取开始时间

			double result = nativeDLL.INSTANCE
					.Java_bingcao_TestJNI_nativeMethod();
			System.out.println(result);

			System.out.println("JNA success call dll！！！");
			long endTime = System.currentTimeMillis(); // 获取结束时间
			System.out.println("Program run time： " + (endTime - startTime)
					+ "ms");

			printToFile.println(endTime - startTime);
			countRun++;
		}
		printToFile.close();

	}

}

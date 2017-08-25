package bingcao;

import java.io.*;

import com.sun.jna.*;

/**
 * @author troy 2017-08-22 ����19:28
 *
 */
public class TestJNA {

	public interface nativeDLL extends Library {

		// /��ǰ·��������Ŀ�£�������bin���Ŀ¼�¡�
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
			
			long startTime = System.currentTimeMillis(); // ��ȡ��ʼʱ��

			double result = nativeDLL.INSTANCE
					.Java_bingcao_TestJNI_nativeMethod();
			System.out.println(result);

			System.out.println("JNA success call dll������");
			long endTime = System.currentTimeMillis(); // ��ȡ����ʱ��
			System.out.println("Program run time�� " + (endTime - startTime)
					+ "ms");

			printToFile.println(endTime - startTime);
			countRun++;
		}
		printToFile.close();

	}

}

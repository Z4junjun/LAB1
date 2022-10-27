package lab1_2;

public class Test {

	public static void main(String[] args) {
		Examination.start();
		Extract e = new Extract();
		e.answer("C:\\Users\\Apple\\Desktop\\c_testfile.txt",4);			
		Examination.end();
	}

}

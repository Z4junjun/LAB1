package lab1_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Extract {
	private int level;
	private int total;
	private String pre;
	private String now;
	private int keyNum;
	private int switchNum;
	private int cNum;
	private int else_block;
	private int elseif_block;
	private List<Integer> caseNum=new ArrayList<Integer>();
	private Stack<Boolean> stack=new Stack<Boolean>();
	private Stack<String> stack1=new Stack<String>();
	
	public Extract() {
		
	}
	public String answer(String path,int level) {
		String temp;
		File txt = new File(path);
		try {
			BufferedReader br = new BufferedReader(new FileReader(txt));
			while ((temp = br.readLine()) != null) {
				switch(level) {
				case 4:
				case 3:
					level_3_4_optimization(temp);
				case 2:
					level_2(temp);
				case 1:
					level_1(temp);
					break;
				default:
					return "LEVEL is not choiced";
				}
			}
			br.close();
			return output(level);
		} catch (FileNotFoundException e) {
			return "file path is wrong";
		} catch (IOException e) {
			return "file path is wrong";
		}
	}
	
	public void level_1(String s) {
		//the keywords defined in the table
		String[] keyword={"auto","break","case","char","const","continue","default","do ",//distinguish do and doble
		"double","else","enum","extern","float","for","goto","if","int","long","register",
		"return","short","signed","sizeof","static","struct","switch","typedef","union",
		"unsigned","void","volatile","whlie","inline","restrict","_Bool","_Complex","_Imaginary",
		"_Alignas","_Alignof","_Atomic","_Static_assert","_Noreturn","_Thread_local","_Generic"};
		
		for(int i = 0;i<keyword.length;i++) if(s.contains(keyword[i])) keyNum++;
	}
	
	public void level_2(String s) {
		if(s.contains("switch")) {
			caseNum.add(cNum);
			cNum=0;
			switchNum++;
		}
		if(s.contains("case")) cNum++;
	}
	
	public void level_3_4(String s) {
		if(!s.contains("else if")) {
			if(s.contains("if")) {
				stack.add(false);
			}
			if(s.contains("else")) {
				if(!stack.pop()) {
					else_block++;
				}else {
					elseif_block++;
				}
			}
		}else {
			stack.pop();
			stack.add(true);
		}
	}
	public void level_3_4_optimization(String s) {
		//keyword detect
		if(!s.contains("else if")) {
			if(s.contains("if")) {
				//increase the level
				stack1.add("if"+level++);
			}
			if(s.contains("else")) {
				stack1.add("else"+level++);
			}
		}else {
				stack1.add("elseif"+level++);
		}
		if(s.contains("main")||s.contains("switch")) {
			stack1.add("anotherwords"+level++);
		}
		if(s.contains("}")){
			now = stack1.pop();
			if(now.contains("elseif")) {
				if(!now.equals(pre)) {
					elseif_block++;
				}
			}else if(now.contains("if")) {
				total++;
			}
			level--;
			pre = now;
		}
		else_block=total-elseif_block;
	}
	public String output(int level) {
		String ans="";
		switch(level) {
		case 4:
			ans="\nif-elseif-else num: "+elseif_block+ans;
		case 3:
			ans="\nif-else num: "+else_block+ans;
		case 2:
			ans=(" "+cNum)+ans;
			for(int i=caseNum.size()-1;i>0;i--) {
				ans=(" "+caseNum.get(i))+ans;
			}
			ans=("\ncase num:")+ans;
			ans="\nswitch num: "+switchNum+ans;
		case 1:
			ans=("Total num: "+keyNum)+ans;
		}
		return ans;
	}
}

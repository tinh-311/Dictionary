package dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class hashTable {
	public LINKEDLIST[] list = new LINKEDLIST[28];
	
	static String xuLyTen(String s) {
		String temp = "/=(";
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == temp.charAt(0) && s.charAt(i - 1) == ' ' || s.charAt(i) == temp.charAt(1) || s.charAt(i) == temp.charAt(2)) {
				return s.substring(0, i - 1);
			}
		}
		return s;
	}
	
	public word find(String s) {
		int temp = hash(s.charAt(0));
				
		for(Node i = this.list[temp].first; i != null ; i = i.link) {
			String k = xuLyTen(i.data.getTuTA());
			if(s.equalsIgnoreCase(k)) {
				return i.data;
			}
		}
		
		return null;
	}

	static int hash(char k) {
		if (k >= 65 && k <= 90) {
			return k % 65;
		}
		else if (k >= 97 && k <= 122) {
			return (k % 65) - 32;
		}
		else if (k >= 48 && k <= 57) {
			return 26;
		}
		else
			return 27;
	}
	
	public void insert(word x) {
		char temp = x.getTuTA().charAt(0);
		int k = hash(temp);
		list[k].insertLast(x);
	}
	
	public void xoa(String s) {
		for(int k = 0; k < 28; k++) {
			for(Node i = list[k].first; i != null; i = i.link) {
				if(i.data.getTuTA() == s) {
					
				}
			}
		}
	}
	
	public void docFile() {
		File fileDirs = new File("data.txt");
		String s;
		try {
			BufferedReader in = new BufferedReader(
			new InputStreamReader(new FileInputStream(fileDirs), "UTF-8"));
			s = in.readLine();
			while(s != null) {
				word x = new word();
				
				if(s.charAt(0) == '@') {
					String s1[] = s.split("@");
					x.setTuTA(s1[1]);
				}
				
				String c;
				while((c = in.readLine()) != null) {
					if(c.charAt(0) == '@') {
						break;
					}
					x.nghia.add(c);
				}

				int k = hash(s.charAt(1));
				s=c;
				
				list[k].insertLast(x);
			}

			in.close();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ghiFile() {
		try {
			File fileDir = new File("data.txt");
 
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(fileDir), "UTF8"));
 
			for(int k = 0; k < 28; k++) {
				for(Node i = list[k].first; i != null; i = i.link) {
					out.append("@" + i.data.getTuTA()).append("\r\n");
					for(int j = 0; j < i.data.nghia.size(); j++) {
						out.append(i.data.nghia.get(j)).append("\r\n");
					}
					
				}
			}
 
			out.flush();
			out.close();
 
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}

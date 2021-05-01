package dictionary;

import java.util.ArrayList;

public class word {
	public String tuTA;
	public ArrayList<String> nghia = new ArrayList<String>();
	
	public word() {
	}
	
	public String getTuTA() {
		return tuTA;
	}

	public void setTuTA(String tuTA) {
		this.tuTA = tuTA;
	}

	public void xuat() {
		System.out.println(this.tuTA);
		for(int i = 0; i < nghia.size(); i++) {
			System.out.println(nghia.get(i));
		}
	}
}

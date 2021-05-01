package dictionary;

public class LINKEDLIST {
	Node first;
	Node last;
	public LINKEDLIST() {
		this.first = this.last = null;
	}
	
	public void insertLast(word x) {
		Node p = new Node(x);
		
		if(this.first == null) {
			this.first = this.last = p;
		}
		else {
			this.last.link = p;
			this.last = p;
		}	
	}
	
	public Boolean xoa(String s) {
		Node temp = first, prev = null;
		
		if(temp != null && temp.data.tuTA.equalsIgnoreCase(s) ) {
			first = temp.link;
			return true;
		}
		
		while(temp != null && ! temp.data.getTuTA().equalsIgnoreCase(s)) {
			prev = temp;
			temp = temp.link;
		}
		
		if(temp != null) {
			if(temp == last) {
				prev.link = null;
				last = prev;
				return true;
			}
			else {
				prev.link = temp.link;
				return true;
			}
		}
		
		return false;
	}
	
	public void xuat() {
		for(Node i = this.first; i != null; i = i.link) {
			i.data.xuat();
		}
	}
}

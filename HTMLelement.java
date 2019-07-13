import java.util.ArrayList;

class HTMLelement{

	private String tag;
	private ArrayList<HTMLelement> children = new ArrayList<HTMLelement>();
	private HTMLelement parent;	

	public HTMLelement(String tag,HTMLelement parent){
		this.tag = tag;
		this.parent = parent;
	}

	public HTMLelement(String tag){
		this.tag = tag;
	}

	public void addChild(HTMLelement e){
		this.children.add(e);
	}

	public void printChildren(){
		for(HTMLelement h : this.children){
			System.out.println(h);
		}
	}

	public HTMLelement parent(){
		return this.parent;
	}

	@Override
	public String toString(){
		return this.tag;
	}

	public static void main(String[] args){
	HTMLelement h = new HTMLelement("kappa");
	h.addChild(new HTMLelement("ss",h));
	h.printChildren();
	

	}
}


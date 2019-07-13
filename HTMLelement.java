import java.util.ArrayList;
import java.util.HashMap;

public class HTMLelement{

	private String tag;
	private ArrayList<HTMLelement> children = new ArrayList<HTMLelement>();
	private HTMLelement parent;	
	private HashMap<String,String> attrib = new HashMap<>();

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
}


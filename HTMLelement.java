import java.util.ArrayList;
import java.util.HashMap;

public class HTMLelement{

	private String tag;
	private ArrayList<HTMLelement> children = new ArrayList<HTMLelement>();
	private HTMLelement parent;	
	private HashMap<String,String> attrib = new HashMap<>();
	private String data="";

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

	public ArrayList<HTMLelement> getChildren(){
		return this.children;
	}

	public void setData(String data){
		this.data = data;
	}

	public String getData(){
		return this.data;
	}

	public HTMLelement parent(){
		return this.parent;
	}

	public void setAttrib(String key,String value){
		this.attrib.put(key,value);
	}

	public HashMap<String,String> getAttrib(){
		return this.attrib;
	}

	@Override
	public String toString(){
		return this.tag;
	}
}


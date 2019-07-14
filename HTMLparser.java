import java.util.Stack;
import java.util.HashMap;
import java.lang.StringBuilder;

public class HTMLparser{

	public HTMLparser(){

	}

	public HTMLelement parse(String html){
		int n = html.length();
		int index = 0;
		HTMLelement root = new HTMLelement("ROOT");
		Stack<HTMLelement> stack = new Stack<HTMLelement>();
		stack.push(root);
		StringBuilder data = new StringBuilder();
		HashMap<String,String> attrib = new HashMap<>();
		while(index<n){
			char c = html.charAt(index);
			System.out.println(c);
			
			if (c=='<'){
				if (data.length()>0){
					//System.out.println(data.toString());
					stack.peek().setData(data.toString());
					data= new StringBuilder();
				}
				char next = html.charAt(++index);
				Boolean endtag = false;
				if(next=='/'){
					endtag= true;
					next = html.charAt(++index);
				}
				StringBuilder tag = new StringBuilder();
				
				while(index<n && next!=' ' && next!='>'){
					//System.out.println(next);
					tag.append(next);
					next = html.charAt(++index);
	
				}
				if(next==' '){
					System.out.println("parsess");
					next =  html.charAt(++index);
					StringBuilder tmp = new StringBuilder();
					while (next !='>'){
						if(next!=' '){
							tmp.append(next);
						}
						else{
							String s = tmp.toString();
							System.out.println("parsing "+s);
							tmp = new StringBuilder();
							String [] split = s.split("=");
							attrib.put(split[0],split[1]);
						}

						next =  html.charAt(++index);
						if (next=='>'){
							String s = tmp.toString();
							System.out.println("parsing "+s);
							tmp = new StringBuilder();
							String [] split = s.split("=");
							attrib.put(split[0],split[1]);
						}

					}
				}
				if(endtag){
					stack.pop();
				}
				else{
					
					System.out.println("parent " + stack.peek()+" child " +tag.toString());

					HTMLelement curr= new HTMLelement(tag.toString(),stack.peek());
					for (String i : attrib.keySet()) {
						curr.setAttrib(i,attrib.get(i));
					}
					attrib.clear();
					stack.peek().addChild(curr);
					stack.push(curr);

				}
				System.out.println( tag.toString());
			}
			else{
				data.append(c);

			}
			index+=1;
		}
		return  root;
	}

	public static void traverse(HTMLelement e,int depth){
		for(int i=0;i<depth;++i)System.out.print(" ");
		System.out.println(e);
		if(e.getData().length()>0)System.out.println(e.getData());
		System.out.println(e.getAttrib());
		for(HTMLelement h:e.getChildren()){
			traverse(h,depth*2);
		}
	}
	public static void main(String[] args){
		HTMLparser p = new HTMLparser();
		traverse(p.parse("<html><head kkkk=kappa><title>Test</title></head><body blabla=hi xxx=vvv><h1>Parse me!</h1></body></html>"),1);

	}

}
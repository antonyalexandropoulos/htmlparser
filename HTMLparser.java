import java.util.Stack;
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
		while(index<n){
			char c = html.charAt(index);
			System.out.println(c);
			if (c=='<'){
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
				if(endtag){
					stack.pop();
				}
				else{
					
					System.out.println("parent " + stack.peek()+" child " +tag.toString());
					stack.push(new HTMLelement(tag.toString(),stack.peek()));

				}
				System.out.println( tag.toString());
			}
			index+=1;
		}
		return  root;
	}


	public static void main(String[] args){
		HTMLparser p = new HTMLparser();
		p.parse("<html><head><title>Test</title></head><body><h1>Parse me!</h1></body></html>");

	}

}
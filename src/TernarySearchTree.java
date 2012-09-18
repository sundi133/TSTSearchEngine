class Node
{
     char m_char;
     Node m_left, m_center, m_right;
     boolean m_wordEnd;

    public Node(char ch, boolean wordEnd)
    {
        m_char = ch;
        m_wordEnd = wordEnd;
    }
    
    public Node()
    {
        m_wordEnd = false;
    }

}

public class TernarySearchTree {

	private Node m_root = null;


    
    public void TernarySearchTree(){
        m_root =null;
    }
    
	private Node Add(String s, int pos, Node node)
    {
    	
        if (node == null) 
        { 
        	node = new Node(s.charAt(pos), false);
        	System.out.println(node.m_char);
        	
        }

        if (s.charAt(pos) < node.m_char) 
        {
        	
        	Add(s, pos, node.m_left); 
        	
        }
        else if (s.charAt(pos) > node.m_char) 
        { 
        	Add(s, pos, node.m_right); 
        	
        }
        else
        {
            if (pos + 1 == s.length()) 
            {
            	
            	node.m_wordEnd = true; 
            	
            }
            else {
            	try{
            	Add(s, pos + 1, node.m_center);
            	}catch (Exception e) {
					// TODO: handle exception
            		e.printStackTrace();
				}
            	}
        }
        return node;
    }

    public void printTSTTree(Node root){
    	//System.out.println(root);
    	printTree(root);
    }
    
    public void printTree(Node root){
    	if(root==null){
    		return;
    	}else{
    		System.out.println(root.m_char);
    		printTree(root.m_left);
    		printTree(root.m_center);
    		printTree(root.m_right);
    	}
    	
    }
    public void Add(String s,Node root) throws Exception
    {
        if (s == null || s == "") throw new Exception();

        Add(s, 0, root);
        //m_root=root;
    }

    public boolean Contains(String s) throws Exception
    {
        if (s == null || s == "") 
        	throw new Exception();

        int pos = 0;
        Node node = m_root;
        while (node != null)
        {
            int cmp = s.codePointAt(pos) - node.m_char;
            if (s.codePointAt(pos) < node.m_char) { node = node.m_left; }
            else if (s.codePointAt(pos) > node.m_char) { node = node.m_right; }
            else
            {
                if (++pos == s.length()) return node.m_wordEnd;
                node = node.m_center;
            }
        }

        return false;
    }

    public static void main(String[] args) {
    	
    	try{
    		
    	TernarySearchTree tst=new TernarySearchTree();
    	Node root = null;
    	tst.Add("to",0,root);
    	tst.printTSTTree(root);
    	//tst.Add("too",root);
    	//tst.Add("tot",root);
    	//tst.printTSTTree(root);

  
    	System.out.println(tst.Contains("too"));
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    }
}


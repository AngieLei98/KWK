import java.util.ArrayList;
import java.util.Collections;

public class AllPaths {
	ArrayList<String> finalPath;
        public String[] paths(TreeNode t) {
            finalPath = new ArrayList<String>(); //need to initialize
        	String path = "";
            helper(t, path);
            Collections.sort(finalPath); //sort always sorts with ascii values increasing a-->b etc.
            return  finalPath.toArray(new String[0]); //cast it passing toArray
            
        }
        
        public void helper(TreeNode t , String path) {
        	if(t==null) {return;}
        	else if(t.left ==null && t.right==null) {
        		path+= t.info;
        		finalPath.add(path);
        		return;
        	}
        	path+= t.info + "->";
        	helper(t.left, path);
        	helper(t.right,path);
        }
    }


public class LevelCount {
int count;
public int count(TreeNode t, int level) {
    count=0;
	helper(t, level);
    return count;
}
public void helper(TreeNode t, int level) {
	if(t==null) {return;}
	else if(level==0) {
		count+=1;
		return;
	}
	helper(t.left, level-1);
	helper(t.right, level-1); //say you want the nodes at level 2 in a tree with height 2
	                          //so you want the leaves, if level goes down by 1 each time, by the time
	                          //you reach 0 you must've reached the leaves!
}
}


    public class LeafSum {
    	 int sum; //make it instance var to be accessible everywhere so doesn't replaced every time
        public int sum(TreeNode t) {
            sum= 0; //for APTs make sure re set it
        	helper(t, sum);     //makes recursive calls to traverse trees 
            
            return sum;
        }
        //need helper method that is recursive to be called by sum bc don't want sum to be recursive
        public void helper(TreeNode current, int sum) {
        	if(current == null) { //if there's nothing just stop
        		return;
        	}
        	
        	if(current.left==null && current.right==null) {//they're leaves! //base case
        		this.sum+=current.info; //need to store it in this.sum the instance variable.
        		return; //void
        	}
        	//recursive call for rest of tree
        	
        	helper(current.left, this.sum); //will run with '2' in example bc can point to null but will give error
        	                           //once try calling current.left on a null value on next call. reaches base case 1
        	helper(current.right, this.sum); //returns to the node that current.left stopped at coming down from head node
            return; //void
        }
    }

public class TreeTighten {

	public TreeNode tighten(TreeNode t) {
		return helper(t);

	}
	private TreeNode helper(TreeNode current) {
		if (current == null) {
			return null;
		}
		if (current.left == null && current.right == null) {
			return current;
		}
		if (current.left == null) {
			return helper(current.right);
		}
		if (current.right == null) {
			return helper(current.left);
		}
		current.right = helper(current.right);
		current.left = helper(current.left);
		return current;
	}
}
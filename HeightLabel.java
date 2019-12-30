public class HeightLabel {
	public TreeNode rewire(TreeNode t) {
		TreeNode newHead = new TreeNode(1, null, null);
		TreeNode right = helper(t.right);
		newHead.right = right;
		TreeNode left = helper(t.left);
		newHead.left = left;
		if (right != null && left != null) {
			newHead.info = Math.max(right.info, left.info) + 1;
		} else if (right != null) {
			newHead.info = right.info + 1;
		} else if (left != null) {
			newHead.info = left.info + 1;
		}
		return newHead;
	}
	private TreeNode helper(TreeNode originalNode) {
		if (originalNode == null) {
			return null;
		}
		if (originalNode.left == null && originalNode.right == null) {
			return new TreeNode(1, null, null);
		}
		TreeNode newNode = new TreeNode(0, null, null);
		TreeNode right = helper(originalNode.right);
		TreeNode left = helper(originalNode.left);
		newNode.right = right;
		newNode.left = left;
		if (right != null && left != null) {
			newNode.info = Math.max(right.info, left.info) + 1;
		} else if (right != null) {
			newNode.info = right.info + 1;
		} else if (left != null) {
			newNode.info = left.info + 1;
		}
		return newNode;

	}

}


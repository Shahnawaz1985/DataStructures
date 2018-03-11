package com.bac.btree;

public class BinaryTree {

	private int data;
	private BinaryTree left;
	private BinaryTree right;

	public BinaryTree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	public BinaryTree getRight() {
		return right;
	}

	public void setRight(BinaryTree right) {
		this.right = right;
	}

	public void addNode(int num) {
		if (num < this.data) {
			if (null != this.left) {
				this.left.addNode(num);
			} else {
				this.left = new BinaryTree(num);
			}
		} else if (num > this.data) {
			if (null != this.right) {
				this.right.addNode(num);
			} else {
				this.right = new BinaryTree(num);
			}
		}
	}

	/**
	 * Depth First Search .
	 * 
	 */
	public void traverseInOrder() {
		if (this.left != null) {
			this.left.traverseInOrder();
		}

		System.out.println(this.data);

		if (this.right != null) {
			this.right.traverseInOrder();
		}
	}

	/**
	 * Depth First Search . Depth First Traversals: (a) Inorder (Left, Root, Right)
	 * : 4 2 5 1 3 (b) Preorder (Root, Left, Right) : 1 2 4 5 3 (c) Postorder (Left,
	 * Right, Root) : 4 5 2 3 1
	 * 
	 */
	public void traversePostOrder() {
		if (this.left != null) {
			this.left.traversePostOrder();
		}
		if (this.right != null) {
			this.right.traversePostOrder();
		}
		System.out.println(this.data);
	}

	/**
	 * Depth First Search .
	 * 
	 */
	public void traversePreOrder() {
		System.out.println(this.data);
		if (this.left != null) {
			this.left.traversePreOrder();
		}
		if (this.right != null) {
			this.right.traversePreOrder();
		}
	}

	/**
	 * Breadth First Search or Level Order traversal.
	 * 
	 * @param node
	 */
	public void levelOrderTraversal(BinaryTree node) {
		System.out.println("Level order traversal.");
		int heightOfRoot = getHeight(node);
		for (int i = 1; i <= heightOfRoot; i++) {
			printGivenLevel(node, i);
		}
	}

	private void printGivenLevel(BinaryTree node, int i) {
		if (null == node) {
			return;
		}
		if (i == 1) {
			System.out.printf(" %d ", node.getData());
		} else if (i > 1) {
			printGivenLevel(node.getLeft(), i - 1);
			printGivenLevel(node.getRight(), i - 1);
		}

	}

	public int getHeight(BinaryTree node) {
		int height = 0;
		int leftHeight = 0;
		int rightHeight = 0;
		BinaryTree tempLeft = node;
		BinaryTree tempRight = node;
		if (node == null) {
			height = 0;
		} else {
			while (tempLeft.getLeft() != null) {
				leftHeight++;
				tempLeft = tempLeft.getLeft();
			}
			while (tempRight.getRight() != null) {
				rightHeight++;
				tempRight = tempRight.getRight();
			}
			if (leftHeight > rightHeight) {
				height = leftHeight + 1;
			} else if (rightHeight > leftHeight) {
				height = rightHeight + 1;
			} else if (rightHeight == leftHeight) {
				height = rightHeight + 1;
			}
		}
		return height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BinaryTree other = (BinaryTree) obj;
		if (data != other.data)
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}

}
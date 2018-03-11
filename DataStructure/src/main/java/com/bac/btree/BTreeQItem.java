package com.bac.btree;

public class BTreeQItem {
	
	private BinaryTree node;
	int horizontalDistance;
	
	public BTreeQItem(BinaryTree node, int horizontalDistance) {
		super();
		this.node = node;
		this.horizontalDistance = horizontalDistance;
	}

	public BinaryTree getNode() {
		return node;
	}

	public void setNode(BinaryTree node) {
		this.node = node;
	}

	public int getHorizontalDistance() {
		return horizontalDistance;
	}

	public void setHorizontalDistance(int horizontalDistance) {
		this.horizontalDistance = horizontalDistance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + horizontalDistance;
		result = prime * result + ((node == null) ? 0 : node.hashCode());
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
		BTreeQItem other = (BTreeQItem) obj;
		if (horizontalDistance != other.horizontalDistance)
			return false;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		return true;
	}
	
	
}

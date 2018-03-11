package com.bac.btree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class BinaryTreeTest {

	private static int max_level = 0;

	public static void main(String[] args) {
		BinaryTree btree = new BinaryTree(10);
		btree.addNode(5);
		btree.addNode(17);
		btree.addNode(27);
		btree.addNode(7);
		btree.addNode(5);
		btree.addNode(47);
		btree.addNode(65);
		btree.addNode(2);
		btree.addNode(23);

		btree.traverseInOrder();

		btree.traversePostOrder();

		System.out.println("btree height:" + btree.getHeight(btree));

		BinaryTreePrinter.printNode(btree);
		System.out.println("-------------");
		BinaryTree btree1 = new BinaryTree(15);
		btree1.addNode(10);
		btree1.addNode(17);
		btree1.addNode(18);
		btree1.addNode(16);
		btree1.addNode(11);
		btree1.addNode(9);
		btree1.addNode(17);
		/*
		 * btree1.addNode(21); btree1.addNode(20); btree1.addNode(23);
		 */
		BinaryTreePrinter.printNode(btree1);
		System.out.println("Traverse in Order.");
		btree1.traverseInOrder();
		System.out.println("-------------");
		BinaryTreePrinter.printNode(btree1);
		System.out.println("Traverse Post Order.");
		btree1.traversePostOrder();
		System.out.println("-------------");
		BinaryTreePrinter.printNode(btree1);
		System.out.println("Traverse Pre Order.");
		btree1.traversePreOrder();
		System.out.println("-------------");

		System.out.println("btree1 height:" + btree1.getHeight(btree1));
		BinaryTreePrinter.printNode(btree1);
		System.out.println("Traverse in Level Order.");
		btree1.levelOrderTraversal(btree1);
		System.out.println();
		BinaryTreePrinter.printNode(btree1);
		System.out.println("Left View of Tree.");
		leftViewTree(btree1, 1);

		System.out.println();
		BinaryTreePrinter.printNode(btree);
		max_level = 0;
		leftViewTree(btree, 1);
		System.out.println();
		System.out.println("Top view of btree1 :\n");
		BinaryTreePrinter.printNode(btree1);
		printTopView(btree1);
		System.out.println();
		System.out.println("Bottom view of btree1 :\n");
		printBottomView(btree1);
		System.out.println();
		BinaryTreePrinter.printNode(btree);
		System.out.println("Bottom view of btree :\n");
		printBottomView(btree);

	}

	private static void leftViewTree(BinaryTree node, int level) {
		if (node == null) {
			return;
		}
		if (max_level < level) {
			System.out.print(" " + node.getData());
			max_level = level;
		}
		leftViewTree(node.getLeft(), level + 1);
		leftViewTree(node.getRight(), level + 1);
	}

	private static void printTopView(BinaryTree node) {
		if (null == node) {
			return;
		}
		Set<Integer> set = new HashSet<>();
		Queue<BTreeQItem> Q = new LinkedList<BTreeQItem>();
		Q.add(new BTreeQItem(node, 0));

		while (!Q.isEmpty()) {
			BTreeQItem item = Q.remove();
			int horizontalDist = item.getHorizontalDistance();
			BinaryTree bNode = item.getNode();

			if (!set.contains(horizontalDist)) {
				set.add(horizontalDist);
				System.out.print(bNode.getData() + " ");
			}

			if (bNode.getLeft() != null) {
				Q.add(new BTreeQItem(bNode.getLeft(), horizontalDist - 1));
			}
			if (bNode.getRight() != null) {
				Q.add(new BTreeQItem(bNode.getRight(), horizontalDist + 1));
			}
		}
	}

	private static void printBottomView(BinaryTree node) {
		if (null == node) {
			return;
		}
		Map<Integer, Integer> sortedMap = new TreeMap<>();
		Queue<BTreeQItem> Q = new LinkedList<BTreeQItem>();
		Q.add(new BTreeQItem(node, 0));
		while (!Q.isEmpty()) {
			BTreeQItem item = Q.remove();
			int horizontalDist = item.getHorizontalDistance();
			BinaryTree bNode = item.getNode();

			sortedMap.put(horizontalDist, bNode.getData());

			if (bNode.getLeft() != null) {
				Q.add(new BTreeQItem(bNode.getLeft(), horizontalDist - 1));
			}
			if (bNode.getRight() != null) {
				Q.add(new BTreeQItem(bNode.getRight(), horizontalDist + 1));
			}
		}

		Set<Entry<Integer, Integer>> set = sortedMap.entrySet();
		Iterator<Entry<Integer, Integer>> iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> me = iterator.next();
			System.out.print(me.getValue() + " ");
		}
	}

	private static int countSubtreeforSum(BinaryTree root, int sum) {
		if (null == root) {
			return 0;
		}
		int count = 0;
		int ls = countSubtreeforSum(root.getLeft(), sum);
		int rs = countSubtreeforSum(root.getRight(), sum);
		int sum_of_Nodes = ls + rs + root.getData();
		if (sum == sum_of_Nodes)
			count++;
		// return subtree's nodes sum
		return count;
	}

}

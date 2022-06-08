// File: MinAVLTree.java
// A minimum-sized AVL Tree of a specified height

package edu.ksu.cis.minAVL;

import edu.ksu.cis.viewer.TreeInterface;

/**
 * A minimum-sized AVL Tree of a given height.
 * The contents of the nodes are consecutive integers beginning with 0.
 */
public class MinAVLTree implements TreeInterface {

  /**
   * <tt>true</tt> if this tree is empty.
   */
  private boolean empty;

  /**
   * The contents of the root.
   */
  private Integer root;

  /**
   * The children.
   */
  private MinAVLTree[] children;

  /**
   * The number of nodes in this tree.
   */
  private int size;

  /**
   * Constructs a minimum-sized AVL Tree of the given height.
   * @param height  The height of the tree.  If negative, an empty tree is
   *                constructed.
   * @param start   The smallest value stored in the tree.  This value is
   *                ignored if the tree has negative height.
   */
  public MinAVLTree(int height, int start) {
    if (height < 0) {
      empty = true;
    }
    else {
      children = new MinAVLTree[2];
      children[0] = new MinAVLTree(height - 1, start);
      root = Integer.valueOf(start + children[0].size);
      children[1] = new MinAVLTree(height - 2, root.intValue() + 1);
      size = children[0].size + children[1].size + 1;
    }
  }

  /**
   * Returns the root of this tree.
   */
  public Object getRoot() {
    return root;
  }

  /**
   * Returns the children of this tree.
   */
  public TreeInterface[] getChildren() {
    return children;
  }

  /**
   * Returns <tt>true</tt> if this tree is empty.
   */
  public boolean isEmpty() {
    return empty;
  }
}

package main.java.excersices.treeheight;

public final class TreeController {
    private TreeController() {
    }

    /**
     * Returns the three height taking as a starting point the {@code node} provided as argument.
     *
     * @param node Starting point to start counting the height of the tree.
     * @return {@code -1} if the node is null. Otherwise it will return the height of the three taking {@code node} as
     * the root of the tree.
     */
    public static int getTreeHeight(Node<?> node) {
        if (node == null) {
            return -1;
        }

        return Math.max(getTreeHeight(node.getLeft()), getTreeHeight(node.getRight())) + 1;
    }
}

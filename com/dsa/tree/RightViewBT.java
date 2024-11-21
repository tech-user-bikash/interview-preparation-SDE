package com.dsa.tree;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-right-side-view/submissions/1444173082/
public class RightViewBT {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        rightSideView(root, list, 0);
        return list;
    }

    private void rightSideView(TreeNode root, List<Integer> list, int currentLevel) {
        if (root == null) {
            return;
        }
        if (currentLevel >= list.size()) {
            list.add(root.data);
        }
        rightSideView(root.right, list, currentLevel + 1);
        rightSideView(root.left, list, currentLevel + 1);
    }
}

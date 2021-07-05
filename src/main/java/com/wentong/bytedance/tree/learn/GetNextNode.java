package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeLinkNode;


// 寻找指定节点的后继节点。所谓后继节点，就是在中序遍历的情况下，指定节点的下一个节点。
// 有两种方法解决：
// 1. 根据当前节点，不断找其父节点，最后到达 root，然后根据中序遍历的规则，跑一遍。找到指定节点的下一个节点即可。
// 2. 分情况讨论。
//  当指定节点有右孩子时，找其右孩子的最左侧节点，即为其后继节点。
//  当指定节点没有右孩子时，向上找其父节点，一直到节点不为父节点的右孩子为止。则父节点即为其后继节点。因为按照中序遍历来说，左根右的逻辑是不变的。

// https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&&tqId=11210&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
public class GetNextNode {


    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        if (pNode.right != null) {
            return findMostLeftNode(pNode.right);
        } else {
            TreeLinkNode parent = pNode.next;
            while (parent != null && parent.right == pNode) {
                pNode = parent;
                parent = pNode.next;
            }
            return parent;
        }
    }

    private TreeLinkNode findMostLeftNode(TreeLinkNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}

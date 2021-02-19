package service.desionmode.composite;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.composite$
 * @ClassName: Main$
 * @date ：Created in 2/19/21 4:53 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Main {

    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode c1 = new BranchNode("c1");
        BranchNode c2 = new BranchNode("c2");

        LeafNode l1 = new LeafNode("l1");
        LeafNode l2 = new LeafNode("l2");

        root.addNode(c1);
        root.addNode(c2);
        c1.addNode(l1);
        c2.addNode(l2);
        showTree(root, 0);
    }

    public static void showTree(Node node, int layer) {

        for (int i = 0; i < layer; i++) {
            System.out.print("--");
        }
        node.print();

        if (node instanceof BranchNode) {
            for (Node node1 : ((BranchNode) node).nodes) {
                showTree(node1, layer + 1);
            }
        }
    }
}
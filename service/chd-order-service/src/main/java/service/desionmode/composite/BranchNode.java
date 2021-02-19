package service.desionmode.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.composite$
 * @ClassName: BranchNode$
 * @date ：Created in 2/19/21 4:46 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class BranchNode extends Node {

    List<Node> nodes = new ArrayList<>();

    String name;

    public BranchNode(String name){
        this.name = name;
    }
    @Override
    public void print() {
        System.out.println(name);
    }

    public void addNode(Node node){
        nodes.add(node);
    }
}
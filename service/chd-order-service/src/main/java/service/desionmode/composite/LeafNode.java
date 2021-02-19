package service.desionmode.composite;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.composite$
 * @ClassName: LeafNode$
 * @date ：Created in 2/19/21 4:46 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class LeafNode extends Node {

    String content;

    public LeafNode(String content){
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println(content);
    }
}
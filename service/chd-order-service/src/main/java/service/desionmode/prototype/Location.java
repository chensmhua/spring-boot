package service.desionmode.prototype;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.prototype$
 * @ClassName: Location$
 * @date ：Created in 2/21/21 9:21 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Location /*implements Cloneable*/{
    String street;
    int roomNo;

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }

    public Location (String street,int roomNo){
        this.street = street;
        this.roomNo = roomNo;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
}
package service.jvm.classloader;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.jvm.classloader$
 * @ClassName: CustomerClassLoader$
 * @date ：Created in 3/8/21 9:01 AM
 * @description：自定义类加载器
 * @modified By：
 * @version: 1.01
 */
public class CustomerClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //自定义解析过程
        return super.findClass(name);
    }
}
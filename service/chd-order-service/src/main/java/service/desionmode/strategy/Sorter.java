package service.desionmode.strategy;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.strategy$
 * @ClassName: Sorter$
 * @date ：Created in 2020-09-29 16:02
 * @description：比较器
 * @modified By：
 * @version: 1.01
 */
public class Sorter<T> {


    public void sort(T[] arr,ComparableInterface<T> comparableInterface) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                min = comparableInterface.comparator(arr[j],arr[min]) == -1 ? j : min;
            }
            swap(arr,i,min);
        }

    }

    void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
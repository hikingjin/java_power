package jin.wang.junior.a5_basic_array;

import sun.misc.Unsafe;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Array01 {

    static final Unsafe unsafe = getUnsafe();
    static final boolean is64bit = true;

    public static void main(String[] agrs){


        //定义数组一定要确认长度，这个是内存连续性决定的
        byte[] a_byte= new byte[10];
        short[] a_short= new short[10];
        int[] a_int= new int[10];
        long[] a_long= new long[10];
        float[] a_float= new float[]{1.11f, 1.222f};
        double[] a_double= new double[2];//初始化，数组长度是2
        Object[] a = new Object[1];



        Class test= a.getClass();
        int scale = unsafe.arrayIndexScale(test);//获取数组中元素的增量地址
        System.out.println(scale);


//
//        long add= unsafe.addressSize();
//
//        System.out.println("数组在内存中站位大小" + scale);






    }




    private static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}

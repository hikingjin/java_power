package jin.wang.junior.a1_basic;


import java.math.BigDecimal;

public class Data01BasicData {
    public static void main(String[] params){

        //~~~~~~~~~~~~~~~~~~~八种基本类型

        byte b1= 21;//字节型
        char c1= 21;//字符型，字符型本身就是数值型，显示时候是ASSIC码转换
        short s1= 21;
        int i1= 21; //记住最大值是2的31次方，21亿
        long l1 =1;
        long l2 =10000010101010110L;//超过21亿要加l或者L否则编译报错，
        BigDecimal big1 = new BigDecimal("10000010101010110919191919999");//如果超过long的范围使用BigDecimal

        float f1= 3.32f; //单精度浮点型加f或者


        double d1= 3.3224234234234234d; //双精度用d



        //~~~~~~~~~~~~~~自动转换、强制转换

        l1 = i1;//自动转换：低层级转高等级，不会有精度丢失，byte->short->int->long->float->double； char->shor->int














        //~~~~~~~~~~~~~~~装箱、拆箱

        //拆装箱的目的：封装成类 1、可以有方法处理 2、一些集合必须要类 如ArrayList
        //缺点性能损耗
        Integer i = 10;  //装箱
        int n = i;   //拆箱




        Integer int1 = 100;
        Integer int2 = 100;
        Integer int3 = 200;
        Integer int4 = 200;
        Integer int5 = new Integer(200);

        System.out.println("装箱比较" + (int1 == int2));
        System.out.println("装箱比较" + (int3 == int4));


        //~~~~~~~~~~~~~~~~~~~~~~~~~浮点型计算

        System.out.println("精度不丢失：" + (0.25f-0.125f));
        System.out.println("精度丢失：" + (0.25f-0.122f));

    }
}

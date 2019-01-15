package jin.wang.study.a1_memory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Memory01 {

    static final Unsafe unsafe = getUnsafe();
    static final boolean is64bit = true;

    public static void main(String... args) {
        String[] ascending = new String[16];



        int offset = unsafe.arrayBaseOffset(ascending.getClass());//获取数组第一个元素的偏移地址
        int scale = unsafe.arrayIndexScale(ascending.getClass());//获取数组中元素的增量地址

        System.out.println(offset);
        System.out.println(scale);



     //   for(int i=0;i<ascending.length;i++)
           // ascending[i] = (double) i;

//        System.out.println("Before GC");
//        printAddresses("ascending", ascending);

//        System.gc();
//        System.out.println("\nAfter GC");
//        printAddresses("ascending", ascending);


    }

    public static void printAddresses(String label, Object... objects) {
        System.out.print(label + ": 0x");
        long last = 0;
        int offset = unsafe.arrayBaseOffset(objects.getClass());//获取数组第一个元素的偏移地址
        int scale = unsafe.arrayIndexScale(objects.getClass());//获取数组中元素的增量地址

        System.out.println(offset);
        System.out.println(scale);


        switch (scale) {
            case 4:
                long factor = is64bit ? 8 : 1;
                final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
                System.out.print(Long.toHexString(i1));
                last = i1;
                for (int i = 1; i < objects.length; i++) {
                    final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
                    if (i2 > last)
                        System.out.print(", +" + Long.toHexString(i2 - last));
                    else
                        System.out.print(", -" + Long.toHexString( last - i2));
                    last = i2;
                }
                break;
            case 8:
                throw new AssertionError("Not supported");
        }
        System.out.println();
    }

    private static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }



}

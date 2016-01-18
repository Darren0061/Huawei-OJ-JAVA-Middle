package huawei;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public final class Demo {
    /*
    Description
             �ж��Ƿ���������
    Prototype
               public static boolean isAutoMorphicNum(int num)
    Input Param

          num  ��Ҫ�жϵ���
    Output Param
             ��
    Return Value
             true  ��������
             false ����������
    */
    public static boolean isAutoMorphicNum(int num) {

        String s = num + "";
        // ���ִ����žͽ�����ȥ��
        if (s.charAt(0) < '0' || s.charAt(0) > '9'){
            s = s.substring(1);
        }

        int[] arr = new int[s.length()];
        int[] rst = new int[s.length() * 2];

        // ������ת�����������飬���ҵ�0λ�����λ
        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            arr[j] = s.charAt(i) - '0';
        }

        // ���Ե�λ�Ľ�λ
        int carry = 0;
        // ���������0λ�����λ
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                // arr[i]*arr[j]�Ļ�Ҫ����i+jλ�ϣ�
                // arr[i + j]��ԭ����ֵ
                // carry�����Ե�λ�Ľ�λ
                int sum = arr[i] * arr[j] + rst[i + j] + carry;
                // ��һλ�Ľ�λ
                carry = sum / 10;
                // ��ǰλ�ĺ�
                rst[i + j] = sum % 10;
            }

            // ���н�λ
            if (carry != 0) {
                rst[i + arr.length] = carry;
                carry = 0;
            }
        }

//        BigInteger bi = new BigInteger(s);
//        System.out.println(s);
//        System.out.println(bi.multiply(bi));
//        System.out.println(Arrays.toString(rst));


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != rst[i]) {
                return false;
            }
        }

        return true;
    }


    // ������ʹ��ϵͳAPI�ķ���
    public static boolean isAutoMorphicNum2(int num) {

        if (num < 0) {
            num *= -1;
        }

        String s1 = num + "";
        BigInteger bi = new BigInteger(s1);
        String s2 = bi.multiply(bi).toString();

        return s2.endsWith(s1);

    }
}
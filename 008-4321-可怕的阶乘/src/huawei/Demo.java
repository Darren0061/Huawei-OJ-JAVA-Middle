package huawei;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public final class Demo {

    public static String calcNN(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("��������С��0");
        }

        if (n < 2) {
            return "1";
        }

        int count = countDigit(n);

        // ������
        int[] rst = new int[count * n];
        // �м���
        int[] partialRst = new int[count * n];

        partialRst[0] = 1;

        for (int v = 2; v <= n; v++) {
            int[] mul = getNumArr(v);

            clear(rst);

            for (int i = 0; i < mul.length; i++) {
                int carry = 0;
                for (int j = 0; j < partialRst.length && mul[i] != 0; j++) {

                    // mul[i]*partialRst[j]�Ļ�Ҫ����i+jλ�ϣ�
                    // rst[i + j]��ԭ����ֵ
                    // carry�����Ե�λ�Ľ�λ
                    int sum = mul[i] * partialRst[j] + rst[i + j] + carry;


                    // ��֤�����Чλ��ִ����
                    if (sum == 0 && i + j >= rst.length - 1) {
                        break;
                    } else {
                        // ��һλ�Ľ�λ
                        carry = sum / 10;
                        // ��ǰλ�ĺ�
                        rst[i + j] = sum % 10;
                    }
                }
            }

            // �¼�������Ľ������Ϊ�µ��м�����
            System.arraycopy(rst, 0, partialRst, 0, rst.length);

        }

        // �Ӻ���ǰ�ң��ҵ�һ����0����
        int idx = rst.length - 1;
        while (rst[idx] == 0) {
            idx--;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = idx; i >= 0; i--) {
            builder.append(rst[i]);
        }

        return builder.toString();
    }

    private static void clear(int[] rst) {
        for (int i = 0; i < rst.length; i++) {
            rst[i] = 0;
        }
    }

    // ����һ�����ж���λ
    private static int countDigit(int v) {
        int count = 0;
        do {
            count++;
            v /= 10;
        } while (v != 0);
        return count;
    }

    private static int[] getNumArr(int n) {


        String s = n + "";
        int[] rst = new int[s.length()];
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            rst[i] = s.charAt(j) - '0';
        }

        return rst;
    }


}
package huawei;

import java.util.ArrayList;
import java.util.List;

public final class Demo {

    /*****************************************************************************
     * Description  : �������ⳤ�ȵĳ������, ������
     * Input Param  :
     * String multiplierA  ����A
     * String multiplierB  ����B
     * Return Value :
     * �˷��������������쳣������null
     *****************************************************************************/
    public static String multiply(String multiplierA, String multiplierB) {

        if (!isNumber(multiplierA) || !isNumber(multiplierB)) {
            throw new IllegalArgumentException("��������");
        }




        return null;
    }

    /**
     * �ж�һ�������Ƿ���һ���Ϸ������ִ�
     *
     * @param n ��ƥ���ַ���
     * @return true���Ϸ����ִ���false���Ƿ��ַ���
     */
    public static boolean isNumber(String n) {

        if (n == null) {
            return false;
        }
        n = n.trim();

        return n.matches("([+-]?)(\\d+)((.?)(\\d*))?") || n.matches("([+-]?)((\\d*)(.?))?(\\d+)");
    }

    /**
     * �����ַ����Ľ��й��������������������ַ�����00.1-->0.1 .1->0.1 0.-->0   0.000->0
     *
     * @param s ���������ַ���
     * @return ��������ַ���
     */
    public static String format(String s) {

        if (s != null) {
            // ȥ��ǰ��0
            int pos = 0;
            while (pos < s.length() && s.charAt(pos) == '0') {
                pos++;
            }
            // ȫ�㴮
            if (pos >= s.length()) {
                return "0";
            }

            // С����ǰ�����㣬Ҫ����С����ǰ�ĵ�һ����
            if (s.charAt(pos) == '.') {
                pos--;
            }
            s = s.substring(pos);

            // �����С���㣬��Ҫȥ��β����
            if (s.contains(".")) {
                // ȥ��β��0
                pos = s.length() - 1;
                while (s.charAt(pos) == '0') {
                    pos--;
                }
                // С�������������
                if (s.charAt(pos) == '.') {
                    pos--;
                }

                s = s.substring(0, pos + 1);
            }
        }

        return s;
    }

    /**
     * �������ַ���ת����������������Ϊ�ӵ�λ����λ��ȥ��С����
     *
     * @param s �����ַ���
     * @return ��������
     */
    public static List<Integer> strToArr(String s) {
        List<Integer> list = new ArrayList<Integer>(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                list.add(c - '0');
            }
        }

        return list;
    }
}



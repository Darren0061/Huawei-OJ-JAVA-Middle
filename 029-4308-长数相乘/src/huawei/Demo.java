package huawei;

import java.util.ArrayList;
import java.util.List;

public final class Demo {

    /*****************************************************************************
     * Description  : �������ⳤ�ȵĳ������, ������
     * Input Param  :
     * String ma  ����A
     * String mb  ����B
     * Return Value :
     * �˷��������������쳣������null
     *****************************************************************************/
    public static String multiply(String ma, String mb) {

        if (!isNumber(ma) || !isNumber(mb)) {
            return null;
        }

        // ȥ�����˿ո�
        ma = ma.trim();
        mb = mb.trim();


        // ��¼���������Ǹ���
        boolean aPositive = true;
        boolean bPositive = true;

        // ȥ������
        if (ma.charAt(0) == '+') {
            ma = ma.substring(1);
        } else if (ma.charAt(0) == '-') {
            aPositive = false;
            ma = ma.substring(1);
        }

        if (mb.charAt(0) == '+') {
            mb = mb.substring(1);
        } else if (mb.charAt(0) == '-') {
            bPositive = false;
            mb = mb.substring(1);
        }


        // ���������ַ���
        ma = format(ma);
        mb = format(mb);

        // ��¼�ж���λС��
        int aDecimal = ma.indexOf('.');
        int bDecimal = mb.indexOf('.');


        if (aDecimal == -1) {
            aDecimal = 0;
        } else {
            aDecimal = ma.length() - (aDecimal + 1);
        }

        if (bDecimal == -1) {
            bDecimal = 0;
        } else {
            bDecimal = mb.length() - (bDecimal + 1);
        }

        // ��¼�����С��λ��
        int decimal = aDecimal + bDecimal;

        List<Integer> arr = strToArr(ma);
        List<Integer> brr = strToArr(mb);

        List<Integer> rst = multiply(arr, brr);

        //System.out.println(rst);

        StringBuilder builder = new StringBuilder(rst.size());

        // ��������
        for (int i = rst.size() - 1; i >= decimal; i--) {
            builder.append(rst.get(i));
        }

        // �����С��
        if (decimal > 0) {
            // ���С����
            builder.append('.');
            for (int i = decimal - 1; i >= 0; i--) {
                builder.append(rst.get(i));
            }
        }

        // ɾ��ǰ����
        int pos = 0;
        while (pos < builder.length() && builder.charAt(pos) == '0') {
            pos++;
        }

        // �������0��ֱ�ӷ���0
        if (pos >= builder.length()) {
            return "0";
        }

        // ���������ǰ�涼��0��Ҫ����С����ǰ���һ����
        if (builder.charAt(pos) == '.') {
            pos--;
        }

        int endPos = builder.length() - 1;
        // ��С��
        if (decimal > 0) {
            // ɾ��β����

            while (builder.charAt(endPos) == '0') {
                endPos--;
            }
            // С������涼���㣬Ҫɾ��С����
            if (builder.charAt(endPos) == '.') {
                endPos--;
            }
        }

        String result = builder.substring(pos, endPos + 1);

        if (result.equals("0")) {
            return "0";
        }

        // ���������
        if (aPositive ^ bPositive) {
            result = "-" + result;
        }

        return result;
    }

    private static List<Integer> multiply(List<Integer> arr, List<Integer> brr) {

        int num = arr.size() + brr.size() + 1;
        List<Integer> rst = new ArrayList<Integer>(num);
        for (int i = 0; i < num; i++) {
            rst.add(0);
        }


        int a;
        int b;
        int sum;
        int carry;
        for (int i = 0; i < arr.size(); i++) {
            a = arr.get(i);
            carry = 0;
            if (a == 0) {
                continue;
            }

            for (int j = 0; j < brr.size(); j++) {
                b = brr.get(j);
                sum = a * b + carry + rst.get(i + j);
                carry = sum / 10;
                rst.set(i + j, sum % 10);
            }

            int pos = brr.size() + i;
            while (carry > 0) {
                sum = carry + rst.get(pos);
                carry = sum / 10;
                rst.set(pos, sum % 10);
                pos++;
            }
        }

        return rst;
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
            // �������С�����ͷ��
            if (s.charAt(0) == '.') {
                s = "0" + s;
            }

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



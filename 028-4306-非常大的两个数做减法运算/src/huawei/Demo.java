package huawei;


import java.util.ArrayList;
import java.util.List;

public final class Demo {
    /*****************************************************************************
     * Description  : �������ⳤ�ȵ��������
     * Input Param  : String minuend   ����������\0��ʾ�ַ�������
     * String subtrahend  ��������\0��ʾ�ַ�������
     * Return Value :  ���������������\0��ʾ�ַ�������
     *****************************************************************************/
    public static String decrease(String minuend, String subtrahend) {

        // �ж��ǲ��ǺϷ�������
        if (!isNumber(minuend) || !isNumber(subtrahend)) {
            throw new IllegalArgumentException("��������ȷ�Ĳ���");
        }

        // ȥ�����˿ո�
        minuend = minuend.trim();
        subtrahend = subtrahend.trim();


        // ��¼���������Ǹ���
        boolean mPositive = true;
        boolean sPositive = true;

        // ȥ������
        if (minuend.charAt(0) == '+') {
            minuend = minuend.substring(1);
        } else if (minuend.charAt(0) == '-') {
            mPositive = false;
            minuend = minuend.substring(1);
        }

        if (subtrahend.charAt(0) == '+') {
            subtrahend = subtrahend.substring(1);
        } else if (subtrahend.charAt(0) == '-') {
            sPositive = false;
            subtrahend = subtrahend.substring(1);
        }


        // ���������ַ���
        minuend = format(minuend);
        subtrahend = format(subtrahend);

        // ��¼�ж���λС��
        int mDecimal = minuend.indexOf('.');
        int sDecimal = subtrahend.indexOf('.');


        if (mDecimal == -1) {
            mDecimal = 0;
        } else {
            mDecimal = minuend.length() - (mDecimal + 1);
        }

        if (sDecimal == -1) {
            sDecimal = 0;
        } else {
            sDecimal = subtrahend.length() - (sDecimal + 1);
        }


        // ��������С��λ��
        if (mDecimal > sDecimal) {
            // �ڼ������������
            subtrahend = appendZero(subtrahend, mDecimal - sDecimal);
        }
        // ������λ����С�ڱ�����
        else {
            // �ڱ������������0
            minuend = appendZero(minuend, sDecimal - mDecimal);
        }

        // ��¼�����С��λ��
        int decimal = mDecimal > sDecimal ? mDecimal : sDecimal;

        List<Integer> m = strToArr(minuend);
        List<Integer> s = strToArr(subtrahend);



        // �������Ƿ���ڵ���s
        boolean isMgeS = mcompares(m, s);

//        System.out.println("m: " + m);
//        System.out.println("s: " + s);
//        System.out.println("isMgeS: " + isMgeS);


        List<Integer> rst = new ArrayList<Integer>();
        boolean isResultPositive = true;

        // �жϽ���������Ǹ���
        // �������������������ҵ�һ������С�ڵڶ�����
        if (mPositive && sPositive && isMgeS) {
            isResultPositive = true;
            rst = minus(m, s);
        }
        // �������������������ҵ�һ����С�ڵڶ�����
        else if (mPositive && sPositive && !isMgeS) {
            isResultPositive = false;
            rst = minus(s, m);
        }
        // ��һ�������������ڶ������Ǹ���
        else if (mPositive && !sPositive) {
            isResultPositive = true;
            rst = add(m, s);
        }
        // ��һ�����Ǹ������ڶ�����������
        else if (!mPositive && sPositive) {
            isResultPositive = false;
            rst = add(m, s);
        }
        // ���������Ƿ����������ҵ�һ�������ڵڶ�����
        else if (!mPositive && !sPositive && isMgeS) {
            isResultPositive = false;
            rst = minus(m, s);
        }
        // ���������Ƿ����������ҵ�һ����С�ڵڶ�����
        else if (!mPositive && !sPositive && !isMgeS) {
            isResultPositive = true;
            rst = minus(s, m);
        }


//        System.out.println(rst);
//        System.out.println(decimal);

        StringBuilder builder = new StringBuilder(rst.size() + 2);

        for (int i = rst.size() - 1; i >= decimal ; i--) {
            builder.append(rst.get(i));
        }

        if (decimal > 0) {
            builder.append('.');
            for (int i = decimal - 1; i >= 0 ; i--) {
                builder.append(rst.get(i));
            }
        }

        // ��С��
        if (decimal > 0) {
            int idx = builder.length() - 1;

            // ȥ����β��0
            while (builder.charAt(idx) == '0') {
                idx--;
            }

            // ���һ��С���㣬ȥ��С����
            if (builder.charAt(idx) == '.') {
                idx--;
            }

            builder.setLength(idx + 1);
        }

        String resultStr = builder.toString();

        // ȥ������ǰ����
        int idx = 0;
        while (resultStr.charAt(idx) == '0') {
            idx++;
        }

        if (resultStr.charAt(idx) == '.') {
            idx--;
        }

        resultStr = resultStr.substring(idx);

        if (!isResultPositive) {
            resultStr = "-" + resultStr;
        }

        return resultStr;

    }

    /**
     * ��m+s��m��s����ͬλ����С��������m��s�Ѿ�����������
     *
     * @param m ����
     * @param s ����
     * @return ��
     */
    private static List<Integer> add(List<Integer> m, List<Integer> s) {
        if (m.size() < s.size()) {
             return add(s, m);

        }

        int max = m.size();
        int min = s.size();
        int i = 0;
        int carry = 0;

        List<Integer> rst = new ArrayList<Integer>(max + 1);

        while (i < min) {
            int sum = s.get(i) + m.get(i) + carry;
            carry = sum / 10;
            rst.add(sum % 10);
            i++;
        }

        while (i < max) {
            int sum = m.get(i) + carry;
            carry = sum / 10;
            rst.add(sum % 10);
            i++;
        }

        if (carry > 0) {
            rst.add(carry);
        }

        return rst;

    }

    /**
     * m-s��ǰ����m���ڵ���s
     *
     * @param m ������
     * @param s ����
     * @return ��
     */
    private static List<Integer> minus(List<Integer> m, List<Integer> s) {

        int max = m.size();
        int min = s.size();

        List<Integer> rst = new ArrayList<Integer>(max);

        // �Ƿ񱻽�λ
        int borrow = 0;
        int i = 0;
        while (i < min) {
            int mBit = m.get(i) - borrow;
            int sBit = s.get(i);

            if (mBit >= sBit) {
                rst.add(mBit - sBit);
                borrow = 0;
            } else {
                rst.add(10 + mBit - sBit);
                borrow = 1;
            }

            i++;
        }

        while (i < max) {
            int mBit = m.get(i) - borrow;
            if (mBit >= 0) {
                rst.add(mBit);
                borrow = 0;
            } else {
                rst.add(10 + mBit);
                borrow = 1;
            }
            i++;
        }

        return rst;
    }

    /**
     * m�Ƿ���ڵ���s��m��s��ͬ�����С����λ������m��s�Ѿ�����������
     *
     * @param m
     * @param s
     * @return
     */
    private static boolean mcompares(List<Integer> m, List<Integer> s) {

        if (m.size() > s.size()) {
            return true;
        } else if (m.size() < s.size()) {
            return false;
        } else {
            for (int i = m.size() - 1; i >= 0; i--) {
                if (m.get(i) > s.get(i)) {
                    return true;
                } else if (m.get(i) < s.get(i)) {
                    return false;
                }
            }
        }

        return true;
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
     * ���С������β����
     *
     * @param s �ַ���
     * @param n ���β����
     * @return ���β����ĺ���ַ���
     */
    public static String appendZero(String s, int n) {
        for (int i = 0; i < n; i++) {
            s += "0";
        }

        return s;
    }

    /**
     * �����ַ����Ľ��й��������������������ַ�����00.1-->0.1 .1->0.1 0.-->0.0
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
            s = s.substring(pos);

            // ���sΪ�վͷ�����
            if (s.isEmpty()) {
                s = "0";
            } else {
                // ������һ���ַ��ǵ�žͲ�����һ����
                if (s.endsWith(".")) {
                    s += "0";
                }

                // �����һ���ǵ�ţ�������ǰҳ�����һ��0
                if (s.isEmpty()) {
                    s = "0" + s;
                }

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
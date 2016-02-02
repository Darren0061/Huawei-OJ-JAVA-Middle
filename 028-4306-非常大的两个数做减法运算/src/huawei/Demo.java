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
        int mDecimal = minuend.charAt('.');
        int sDecimal = subtrahend.charAt('.');
        // ��¼�����С��λ��
        int decimal = mDecimal > sDecimal ? mDecimal : sDecimal;

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


        List<Integer> m = strToArr(minuend);
        List<Integer> s = strToArr(subtrahend);


        // �������Ƿ���ڵ���s
        boolean isMgeS = mcompares(m, s);

        List<Integer> rst;
        // ������������ڵ������
        if (isMgeS) {
            rst = minus(m, s);
        }
        // ������С�ڼ���
        else {
            rst = minus(s, m);
        }


        StringBuilder builder = new StringBuilder(rst.size() + 2);


        return null;

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
            if (mBit >= 0 ) {
                rst.add(mBit);
                borrow = 0;
            } else {
                rst.add(10 + mBit);
                borrow = 1;
            }
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
            for (int i = 0; i < m.size(); i++) {
                if (m.get(i) != s.get(i)) {
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
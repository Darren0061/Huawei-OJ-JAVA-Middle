package huawei;


import java.util.LinkedList;
import java.util.List;

public final class Demo {

    /**
     * ���������ַ���(�������ΪN,�ַ�������С��100)��
     * �밴����Ϊ8���ÿ���ַ�����������µ��ַ������飬
     * ���Ȳ���8���������ַ������ں��油����0�����ַ���������
     */
    public static String[] splitString(String[] input) {

        if (input == null || input.length < 1) {
            return null;
        }

        List<String> list = new LinkedList<String>();
        int splitLen = 8;
        char[] lastPart = new char[splitLen];

        for (String s : input) {

            int pos = splitLen;
            while (pos <= s.length()) {
                list.add(s.substring(pos - splitLen, pos));
                pos += splitLen;
            }

            // ����в���splitLen���ȵ��ַ���
            if (pos - s.length() < splitLen) {
                int i = 0;
                for (int j = pos - splitLen; j < s.length(); j++) {
                    lastPart[i] = s.charAt(j);
                    i++;
                }

                while (i < splitLen) {
                    lastPart[i] = '0';
                    i++;
                }

                list.add(new String(lastPart));
            }
        }

        String[] rst = new String[list.size()];

        int i = 0;
        for (String s : list) {
            rst[i] = s;
            i++;
        }

        return rst;


    }


}



package huawei;


import java.util.LinkedList;
import java.util.List;

public final class Demo {
    /*
    ����:���дһ������������Ϊһ���ַ������飬
	�밴ָ������iInputLenth��������е�ÿ���ַ�����������µ��ַ��������С����Ȳ���iInputLenth���������ַ������ں��油����0��
	���ַ����������������ַ������ʾ����������������ء�
	����:
	    String inputStrArray  (srr)   �ַ�������ָ�� �ַ����������Ϊ50,�ַ����������255
	    int iInputLenth (split)  ָ���ķָ�� iInputLenth>=1 && <=32
	     
	����:�ַ�������ָ��     

	ʾ�� ������8���
	���룺 abc 
	       12345789 
	���أ� abc00000
	       12345678
	       90000000

	*/

    public static String[] convertStringArray(String[] srr, int splitLen) {


        if (srr == null || srr.length < 1 || splitLen < 1 || splitLen > 32) {
            return null;
        }

        List<String> list = new LinkedList<String>();
        char[] lastPart = new char[splitLen];

        for (String s : srr) {

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
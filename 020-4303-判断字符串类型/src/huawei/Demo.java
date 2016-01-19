package huawei;


public final class Demo {

	/*
    ����: ����һ�����ʶ��һ���ض����ַ����ǳ����ļ�������⣬

	���������������ַ������ͣ�

	Slump��һ���ַ��������������ʣ�
	    1.��'D'��'E'��ʼ
	    2.��һ���ַ�����1������'F'
	    3.֮�����һ��Slump��'G'������һ��Slump������
	    4.�����Ķ�����Slump

	���磬DFFEFFFG��Slump

	Slimp��һ���ַ��������������ʣ�
	    1.��һ���ַ���'A'
	    2.���Slimpֻ��2���ַ�����ڶ����ַ���'H'
	    3.�������2���ַ����������2����ʽ
	        a) 'A'���һ��'B'�ٽ�һ��Slimp�ٽ�һ��'C'
	        b) 'A'���һ��Slump�ٽ�һ��'C'
	    4.�����Ķ�����Slimp

	Slurpy��һ��Slimp���һ��Slump���

	���д�����ж�һ���ַ����Ƿ�ΪSlurpy

	����: һ���ַ���
	    
	���: ��
	     
	����: 1����Slurpy
	      0������
	     
	*/

    public static int isSlurpy(String str) {

        if (str == null || str.length() < 1) {
            return 0;
        }

        int[] rst = {0};
        boolean rs = isSlimp(str, 0, rst);
        // ����
        if (!rs) {
            return 0;
        }

        rs = isSlump(str, rst[0] + 1, rst);

        // ����
        if (!rs) {
            return 0;
        }

        if (str.length() == (rst[0] + 1)) {
            return 1;
        } else {
            return 0;
        }

    }

    // �ж�Slumpǰ׺
    public static boolean isSlump(String s, int i, int[] rst) {

        // �ַ�ʾȫ��������
        if (s.length() <= i) {
            return false;
        }

        char c = s.charAt(i);
        // ��һ����ĸ��D����E����Slump�ַ���
        if (c != 'D' && c != 'E') {
            return false;
        }

        i++;
        if (s.length() <= i) {
            return false;
        }

        c = s.charAt(i);
        // �ڶ����ַ���������F
        if (c != 'F') {
            return false;
        }

        i++;
        // ����F֮���F
        // F֮��ĵ�һ����F
        while (i < s.length() && s.charAt(i) == 'F') {
            i++;
        }

        // ��һ��F��Ҫôû���ַ��ˣ�Ҫô����F
        // ����Slump�ַ���
        if (s.length() <= i) {
            return false;
        }

        if (s.charAt(i) == 'G') {
            // Slump�ַ��������һ���ַ�λ��
            rst[0] = i;
            return true;
        } else {
            // F����ܸ���һ��Slump�ַ���
            return isSlump(s, i, rst);
        }

    }

    public static boolean isSlimp(String s, int i, int[] rst) {
        // �ַ�ʾȫ��������
        if (s.length() <= i) {
            return false;
        }

        // ��һ���ַ�������A
        if (s.charAt(i) != 'A') {
            return false;
        }

        i++;
        // ���û�еڶ����ַ�
        if (s.length() <= i) {
            return false;
        }
        // ֻ�������ַ������
        if (s.charAt(i) == 'H') {
            // Slimp�ַ����Ľ���λ��
            rst[0] = i;
            return true;
        } else if (s.charAt(i) == 'B') {
            isSlimp(s, i + 1, rst);
            i = rst[0] + 1;
            if (s.length() <= i) {
                return false;
            } else if (s.charAt(i) == 'C') {
                // Slimp�ַ����Ľ���λ��
                rst[0] = i;
                return true;
            } else {
                return false;
            }
        } else {
            boolean rs = isSlump(s, i, rst);
            if (!rs) {
                return false;
            } else {

                i = rst[0] + 1;

                if (s.length() <= i) {
                    return false;
                } else if (s.charAt(i) == 'C') {
                    // Slimp�ַ����Ľ���λ��
                    rst[0] = i;
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

}



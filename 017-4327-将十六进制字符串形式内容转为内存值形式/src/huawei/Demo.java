package huawei;


public final class Demo {

    /* ���ܣ���ʮ�������ַ�����ʽ����תΪ�ڴ�ֵ��ʽ��ע��pBuffer���ڴ������ɵ����߱�֤��
     * ���룺szHexText��ʮ�������ַ�����ʽ����: "6566"
     * �����dataOutput,���У��ڴ�ֵ��ʽBuffer�����ڴ��{0x65, 0x66}
     * ���أ�����ת���ɹ���buffer����Ч�ֽ���
     */
    public static int[] hexToBin(String szHexText) {

        if (szHexText == null || szHexText.length() < 2) {
            return null;
        }

        StringBuilder builder = new StringBuilder(szHexText.length());

        for (int i = 0; i < szHexText.length(); i++) {
            char c = szHexText.charAt(i);
            if (c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F') {
                builder.append(c);
            }
        }

        if (builder.length() < 2) {
            return null;
        }

        int[] rst = new int[builder.length() / 2];

        for (int i = 0; i + 1 < builder.length(); i += 2) {
            int a = charToInt(builder.charAt(i));
            int b = charToInt(builder.charAt(i + 1));
            rst[i / 2] = a * 16 + b;
        }


        return rst;
    }

    private static int charToInt(char c) {

        if (c >= '0' && c <= '9') {
            return c - '0';
        }

        if (c >= 'a' && c <= 'f') {
            return c - 'a' + 10;
        }

        if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10;
        }

        return 0;
    }


}
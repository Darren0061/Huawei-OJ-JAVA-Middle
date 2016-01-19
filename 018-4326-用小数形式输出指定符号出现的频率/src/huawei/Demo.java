package huawei;

public final class Demo {

	
	/*
    ����: ����Ļ�׼�ַ�����ͳ��ָ���ַ����ֵ�Ƶ��
	      �ַ���������Ӣ�Ĵ�Сд��ĸ�Ϳո񡢶��š����
		  С�������2λ��Ч���֣�����λ��������

	����: String pString  ����Ļ�׼�ַ���
		 char c ָ�����ַ�
	
	����: ���ָ���ַ����ֵ�Ƶ��
	*/

    public static float getRateFromString(String pString, char c) {

        if (pString == null || pString.length() < 1) {
            return 0.00F;
        }


        float count = 0;
        for (int i = 0; i < pString.length(); i++) {
            if (pString.charAt(i) == c) {
                count += 1;
            }
        }


        count = count / pString.length();

        int i = (int) (count * 1000 + 5) / 10;

        return (i / 100.0F);
    }

}
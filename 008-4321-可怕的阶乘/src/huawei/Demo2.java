package huawei;

public final class Demo2 {

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

//            System.out.println(Arrays.toString(mul));
            clear(rst);

//            if (v> 10) {
//                System.out.println("-" + Arrays.toString(mul));
//                System.out.println("-" + Arrays.toString(partialRst));
//            }


            for (int i = 0; i < mul.length; i++) {
                int carry = 0;
                boolean hasRun = false;

                for (int j = 0; j < partialRst.length && mul[i] != 0; j++) {

//                    if (v > 10) {
//                        System.out.println("I am in.");
//                    }

                    // mul[i]*partialRst[j]�Ļ�Ҫ����i+jλ�ϣ�
                    // rst[i + j]��ԭ����ֵ
                    // carry�����Ե�λ�Ľ�λ
                    int sum = mul[i] * partialRst[j] + rst[i + j] + carry;

//                    if (sum > 0) {
//                        hasRun = true;
//                    }

//                    if (v > 10) {
//
//                    }

                    // �˴�һ����ִ�У���Ϊi+partialRst.length�̺ܶ࣬
                    // ����partialRst[i]=0������partialRst[i+j]=0��carry=0
                    // Ϊ�˷�ֹ[0, 2, 1, 0, 0, 0] *[6]���ӵ��������һ�����ʱsumΪ0���Ͳ�ִ������ĳ˷���
                    // ʹ��hasRun���б�֤
                    if (sum == 0 && i + j >= rst.length - 1) {
//                        if (v > 10) {
//                            System.out.println(Arrays.toString(rst) + "===");
//                        }
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


//            System.out.println(Arrays.toString(partialRst));
        }


//        System.out.println(Arrays.toString(partialRst));

        // �Ӻ���ǰ�ң��ҵ�һ����0����
        int idx = partialRst.length - 1;
        while (partialRst[idx] == 0) {
            idx--;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = idx; i >= 0; i--) {
            builder.append(partialRst[i]);
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
import java.util.LinkedList;
import java.util.List;

/**
 * Author: ������
 * Date: 2016-01-23 22:56
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Game24Points {

    // a, b, c, d����[1, 10]��
    public static boolean game24Points(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d, '+', '-', '*', '/'};
        boolean[] used = new boolean[arr.length];
        LinkedList<Integer> list = new LinkedList<Integer>();

        boolean[] rst = {false};

        // ������ϵ��沨�����ʽ
        for (int i = 0; i < 4; i++) {
            used[i] = true;
            list.add(arr[i]);
            to24(arr, used, 1, 0, list, rst);

            if (rst[0]) {
                return true;
            }

            // �ֳ���ԭ
            list.removeLast();
            used[i] = false;
        }


        return false;
    }

    /**
     * @param arr
     * @param used
     * @param numCnt
     * @param optCnt
     * @param list
     * @param rst
     * @return
     */
    private static void to24(int[] arr, boolean[] used, int numCnt, int optCnt,
                             LinkedList<Integer> list, boolean[] rst) {


        // ����Ѿ��ҵ��𰸾Ͳ����в�����
        if (rst[0]) {
            return;
        }
        // �Ѿ�������沨��ʽ�Ĺ���
        if (numCnt > optCnt && numCnt + optCnt == 7) {
            calInversePoland(list, rst);
        }
        // ��Ҫ�����沨��ʽ
        else if (numCnt > optCnt) {

            for (int i = 0; i < arr.length; i++) {
                // ���arr[i]��û�б�ʹ�ù�������arr[i]�������
                if (!used[i] || arr[i] < 0 || arr[i] > 10) {
                    // ���������
                    if (arr[i] >= 0 && arr[i] <= 10) {
                        list.add(arr[i]);
                        numCnt++;
                        used[i] = true;


                        to24(arr, used, numCnt, optCnt, list, rst);

                        // �ҵ���һ���𰸾ͷ���
                        if (rst[0]) {
                            return;
                        }

                        list.removeLast();
                        numCnt--;
                        used[i] = false;

                    }
                    // ����ǲ������������arr[i]֮ǰ������������Ȳ�����������
                    else if (numCnt + 1 > optCnt) {
                        list.add(arr[i]);
                        optCnt++;
                        used[i] = true;


                        to24(arr, used, numCnt, optCnt, list, rst);

                        // �ҵ���һ���𰸾ͷ���
                        if (rst[0]) {
                            return;
                        }

                        list.removeLast();
                        optCnt--;
                        used[i] = false;
                    }
                }
            }

        }


    }

    // �����沨��ʽ��ֵ
    private static void calInversePoland(LinkedList<Integer> list, boolean[] rst) {

//        for (int i : list) {
//            if (i >= 0 && i <= 10) {
//                System.out.print(i + " ");
//            } else {
//                System.out.print((char) i + " ");
//            }
//        }
//
//        System.out.println();


        LinkedList<Integer> stack = new LinkedList<Integer>();

        for (int v : list) {

            // ���������
            if (v >= 0 && v <= 10) {
                stack.add(v);
            } else {
                int a = stack.removeLast();
                int b = stack.removeLast();
                int c = 0;
                switch ((char) v) {
                    case '+':
                        c = a + b;
                        break;
                    case '-':
                        c = a - b;
                        break;
                    case '*':
                        c = a * b;
                        break;
                    case '/':
                        // ��������Ϊ0
                        if (b == 0) {
                            return;
                        }
                        c = a / b;
                        break;
                }

                stack.add(c);
            }

//            System.out.println(stack + "===");
        }

        //System.out.println(stack);

        rst[0] = stack.getFirst() == 24;
    }

}

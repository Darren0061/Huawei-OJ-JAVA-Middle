import java.util.*;

/**
 * Author: ������
 * Date: 2016-02-03 08:17
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data2.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            // �ȴ���ջ�Ļ�ջ
            Deque<Integer> waitTrain = new LinkedList<Integer>();
            // ��վ�еĻ�ջ
            Deque<Integer> inTrain = new LinkedList<Integer>();
            // ��ǰ�⣬�Ѿ���վ�Ļ𳵣������л𳵶���վ������һ����
            List<Integer> currRst = new LinkedList<Integer>();
            // ���н�
            List<List<Integer>> wholeRst = new LinkedList<List<Integer>>();

            for (int i = 0; i < n; i++) {
                waitTrain.add(scanner.nextInt());
            }

            trainDispatch(waitTrain, inTrain, currRst, wholeRst);

            System.out.print(resultToString(wholeRst));
        }

    }

    /**
     * �����ת���ַ���
     *
     * @param wholeRst
     * @return
     */
    private static String resultToString(List<List<Integer>> wholeRst) {

        StringBuilder builder = new StringBuilder(wholeRst.size() * 16);
        for (List<Integer> list : wholeRst) {
            for (Integer i : list) {
                builder.append(i).append(' ');
            }
            builder.setCharAt(builder.length() - 1, '\n');
        }
        return builder.toString();
    }

    /**
     * �𳵵���
     *
     * @param waitTrain �ȴ���ջ�Ļ�ջ
     * @param inTrain   ��վ�еĻ�ջ
     * @param currRst   ��ǰ��
     * @param wholeRst  ���н�
     */
    private static void trainDispatch(Deque<Integer> waitTrain,
                                      Deque<Integer> inTrain,
                                      List<Integer> currRst,
                                      List<List<Integer>> wholeRst) {
        // �Ƿ��еȴ���վ�Ļ�
        boolean hasWait = true;
        // �Ƿ��еȴ���վ�Ļ�
        boolean hasIn = true;

        if (waitTrain.isEmpty()) {
            hasWait = false;
        }

        if (inTrain.isEmpty()) {
            hasIn = false;
        }


        // ���1��û�еȴ��Ļ𳵣���վ��Ҳû�л�
        // ��������е�һ�ֽ�
        if (!hasWait && !hasIn) {

            List<Integer> rst = new LinkedList<Integer>();
            for (Integer i : currRst) {
                rst.add(i);
            }

            wholeRst.add(rst);

            return;
        }
        // ���2����վ���л�Ҫ��վ
        if (hasIn) {

            // ��վ���г���
            int outTrainNumber = inTrain.pop();
            // ��ӵ���վ�Ķ�����
            currRst.add(outTrainNumber);
            trainDispatch(waitTrain, inTrain, currRst, wholeRst);
            // �ֳ���ԭ
            currRst.remove(currRst.size() - 1);
            inTrain.push(outTrainNumber);
        }
        // ���3���еȴ��Ļ�Ҫ��վ
        if (hasWait) {

            // ��վ�Ļ𳵺�
            int inTrainNumber = waitTrain.pop();
            // ��ӵ���վ�Ķ�����
            inTrain.push(inTrainNumber);
            trainDispatch(waitTrain, inTrain, currRst, wholeRst);
            // �ֳ���ԭ
            waitTrain.push(inTrainNumber);
            inTrain.pop();
        }
    }
}

import java.util.*;

/**
 * Author: ������
 * Date: 2016-02-03 08:47
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Train {

    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
        Scanner cin = new Scanner(Main.class.getClassLoader().getResourceAsStream("data2.txt"));
        while (cin.hasNext()) {
            int n = cin.nextInt();

            // �ȴ���ջ�Ļ𳵶���
            Deque<Integer> waitTrain = new LinkedList<Integer>();
            // ��վ�еĻ�ջ
            Deque<Integer> inTrain = new LinkedList<Integer>();
            // ��ǰ�⣬�Ѿ���վ�Ļ𳵣������л𳵶���վ������һ����
            List<Integer> currRst = new LinkedList<Integer>();
            // ���н�
            List<List<Integer>> wholeRst = new LinkedList<List<Integer>>();

            for (int i = 0; i < n; i++) {
                waitTrain.add(cin.nextInt());
            }

            stationDispatch(waitTrain, inTrain, currRst, wholeRst);

            for (List<Integer> li : wholeRst) {
                System.out.println(li);
            }
        }

    }

    private static void stationDispatch(Deque<Integer> waitTrain,
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
            stationDispatch(waitTrain, inTrain, currRst, wholeRst);
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
            stationDispatch(waitTrain, inTrain, currRst, wholeRst);
            // �ֳ���ԭ
            waitTrain.push(inTrainNumber);
            inTrain.pop();
        }
    }
}

import java.util.*;

/**
 * Author: ������
 * Date: 2016-02-03 08:47
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Train2 {

    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
        Scanner cin = new Scanner(Main.class.getClassLoader().getResourceAsStream("data2.txt"));
        while (cin.hasNext()) {
            int n = cin.nextInt();
            Queue<Integer> waitTrain = new LinkedList<Integer>();//�ȴ���ջ�Ļ𳵶���
            Stack<Integer> inTrain = new Stack<Integer>();//��վ�еĻ�ջ
            StringBuffer outTrain = new StringBuffer();//��վ�Ļ�
            List<Integer> currRst = new LinkedList<Integer>(); // ��ǰ��
            List<List<Integer>> wholeRst = new LinkedList<List<Integer>>(); // ���н�

            for (int i = 0; i < n; i++) {
                waitTrain.add(cin.nextInt());
            }


            stationDispatch(waitTrain, inTrain, outTrain, currRst, wholeRst);

            for (List<Integer> li : wholeRst) {
                System.out.println(li);
            }
        }

    }

    private static void stationDispatch(Queue<Integer> waitTrain,
                                        Stack<Integer> inTrain,
                                        StringBuffer outTrain,
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


        //���1��û�еȴ��Ļ𳵣���վ��Ҳû�л�
        if (!hasWait && !hasIn) {
            String out = outTrain.toString();
            System.out.println(out.substring(0, out.length() - 1));

            List<Integer> rst = new LinkedList<Integer>();
            for (Integer i : currRst) {
                rst.add(i);
            }

            //currRst.clear();

            wholeRst.add(rst);

            return;
        }
        //���2����վ���л�Ҫ��վ
        if (hasIn) {
            Queue<Integer> waitTmp = new LinkedList<Integer>(waitTrain);//�ȴ���ջ�Ļ𳵶���
            Stack<Integer> inTmp = (Stack<Integer>) inTrain.clone();//��վ�еĻ𳵶�
            StringBuffer outTmp = new StringBuffer(outTrain);//��վ�Ļ�
            currRst.add(inTmp.peek());
            outTmp.append(inTmp.pop().toString()).append(' ');
            stationDispatch(waitTmp, inTmp, outTmp, currRst, wholeRst);
            currRst.remove(currRst.size() - 1);
        }
        //���3���еȴ��Ļ�Ҫ��վ
        if (hasWait) {
            Queue<Integer> waitTmp = new LinkedList<Integer>(waitTrain);//�ȴ���ջ�Ļ𳵶���
            Stack<Integer> inTmp = (Stack<Integer>) inTrain.clone();//��վ�еĻ𳵶�
            StringBuffer outTmp = new StringBuffer(outTrain);//��վ�Ļ�
            inTmp.push(waitTmp.poll());
            stationDispatch(waitTmp, inTmp, outTmp, currRst, wholeRst);
        }
    }
}

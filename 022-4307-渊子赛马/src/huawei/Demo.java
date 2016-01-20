package huawei;

/*
 ����:�ж�yuanzi �����Ƿ��Ӯ��yuanzi ����Ӯ�ˣ����� YES. ���򷵻� NO

 ���������
 int num: �����������   (1<= num <=1000)
 int[] speedYz: yuanzi ������ٶȣ�
 int[] speedOp: ���ֵ�����ٶȣ�

 ����ֵ��
 String�ͣ�yuanzi ����Ӯ�ˣ����� YES. ���򷵻� NO��
 */

import java.util.Arrays;

public class Demo {
    public String isYuanziWin(int num, int[] speedYz, int[] speedOp) {


        Arrays.sort(speedYz);
        Arrays.sort(speedOp);

        int count = 0;

        int idx = speedOp.length - 1;
        for (int i = speedYz.length - 1; i >= 0; i--) {

            // ��idxλ����ǰ�ң���speedYz[i]�ٶ�������
            while (idx >= 0 && speedYz[i] <= speedOp[idx]) {
                idx--;
            }
            // �ҵ���������Ϳ���Ӯ�ñ���
            if (idx >= 0) {
                count++;
                // speedOp����һ��Ҫ�ҵ���
                idx--;
                if (count > speedYz.length / 2) {
                    return "YES";
                }
            }
        }


        return "NO";
    }
}

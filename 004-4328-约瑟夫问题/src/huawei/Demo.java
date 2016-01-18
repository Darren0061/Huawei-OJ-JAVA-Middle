package huawei;


import java.util.ArrayList;
import java.util.List;

public final class Demo {

	/*
    ����: Լɪ������������֪��ԭʼ��Լɪ�������������ģ���n���ˣ����Ϊ1,2,..., n��վ��һȦ��
	ÿ�ε�m�����ᱻ������ֱ��ֻʣ��һ���ˡ�Լɪ��ͨ������m�������������е�һ���ˡ�
	���統n=6,m=5ʱ��5,4,6,2,3���ᱻ���δ�������1�������⡣

	������k�����ˣ���k�����ˣ�������վ��һȦ��ǰk�����Ǻ��ˣ���k�����ǻ��ˣ�
	��д�������һ����С��m��ʹk�����˶������������������κκ��ˡ�

	    
	����: k Ϊ������
	    
	���: 
	     
	����: ��С��m��ʹk�����˶������������������κκ��ˡ�
	     
	*/


    public static int getMinimumM(int K) {
        boolean flag = false;
        int c = 0;
        // m��ȡֵ
        int m = 0;
        while (!flag) {
            for (int i = (2 * c + 1) * K + 1; i <= 2 * K * (c + 1); i++) {
                List<Integer> tmp = new ArrayList<Integer>();
                for (int j = 0; j < 2 * K; j++) {
                    tmp.add(j + 1);
                }
                if (isFit(tmp, i)) {
                    flag = true;
                    m = i;
                    break;
                }
            }
            c++;
        }
        return m;
    }

    /**
     * �ж϶�����ȡK�Ƿ����
     *
     * @param list
     * @param k
     * @return
     */
    private static boolean isFit(List<Integer> list, int k) {
        //idxΪԪ���±�currNum����ǰidxҪ������
        int idx = 0;
        int currNum = 1;
        int length = list.size();
        int half = length / 2;

        while (length > half) {

            // �Ѿ�������k������
            if (currNum % k == 0) {
                // ȡidxλλ�õ�ֵ
                int value = list.get(idx);
                // ˵�����˱�ǹ���ˣ���������
                if (value <= half) {
                    return false;
                }

                // �������ǹ�л��ˣ�����ɾ������ע���ʱidx��ָ��ɾ�������һ��Ԫ�أ�����û�У�ɾ�����һ�����������
                list.remove(idx);
                // ��������Ҫ������
                currNum = 1;
                // �����еĳ��ȼ���
                length--;
            }
            // û�б�����k����
            else {
                // ��idxһ������������k����
                idx += k - 1;
                // currNumҲһ������������k��������Ϊ���㷨�п�����currNumֻ��ȡ1����k
                currNum += k - 1;
            }

            // ���������˷�Χ����������
            if (idx >= length) {
                idx = idx % length;
            }
        }

        return true;
    }
}



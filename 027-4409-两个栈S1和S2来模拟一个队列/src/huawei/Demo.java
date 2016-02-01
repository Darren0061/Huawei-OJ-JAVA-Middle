package huawei;

import java.util.LinkedList;
import java.util.List;

public final class Demo {

    public static class EnQueueInf {
        public int enElem;
    }

    public static class DeQueueInf {
        public int deElem;
    }
    /*
    ����������ջS1��S2��ģ��һ�����С�

	��֪ջ���ĸ����㶨�����£�
	Init(ST): ��ʼ��STջ����ʼ����ɺ��ջΪ�գ�û���κ�Ԫ�أ�
	Push(ST,x): Ԫ��x��STջ��
	Pop(ST,x): STջ��Ԫ�س�ջ����������x��
	IsEmpty(ST): ��STջ�Ƿ�Ϊ�ա�

	��ô�������ջ��������ʵ�ָö��е��ĸ����㣺
	InitQueue: ��ʼ�����У���ʼ����ɺ�Ķ���Ϊ�գ�û���κ�Ԫ�أ�
	EnQueue: ����һ��Ԫ������У� 
	DeQueue: ɾ��һ��Ԫ�س����У�
	IsEmptyQueue: �ж����Ƿ�Ϊ�ա�

	�㷨˵����
	ջ���ص��Ǻ���ȳ������е��ص����Ƚ��ȳ������ԣ�������ջS1��S2ģ��һ������ʱ��
	S1������ջ�����Ԫ��ѹջ���Դ�ģ�����Ԫ�ص���ӡ�����Ҫ����ʱ����ջS1��ջ����
	��ѹ��ջS2�У�S1��������ջ��Ԫ�أ���S2�д���ջ����S2��ջ���൱�ڶ��еĳ��ӣ�ʵ
	�����Ƚ��ȳ���

	ʵ��Ҫ��
	1��Ҫ������ջS1��S2�ĳ��ȶ���5��Ҳ����˵���������Դ��10��Ԫ�أ�����10��Ԫ����Ҫ����ʧ�ܡ�
	2��EnQueue��DeQueue��IsEmptyQueue�ķ���ֵ���ϸ���˵�����أ���������������
	3���밴���㷨˵��ʵ�ָ��㷨����Ҫ����������ʽʵ�ֶ��С�
	���ϸ�������Ҫ��ʵ�֣����򽫵�������ִ��ʧ�ܡ�

	�Ƽ�ʵ�ֲ��裺
	1������ʵ��ջ���㷨��Ҳ����ջ���ĸ�������
	2��Ȼ��ο��㷨˵����ͨ��������ջ�Ĳ�����ģ��һ�����С�
	*/

    private static List<Object> IN;
    private static List<Object> OUT;


    //��ʼ��STջ����ʼ����ɺ��ջΪ�գ�û���κ�Ԫ�أ�
    public static int initSt(Object st) {
        IN = new LinkedList<Object>();
        OUT = new LinkedList<Object>();
        return 0;
    }

    //Ԫ��x��STջ��
    public static int push(Object st, EnQueueInf x) {
	    /*�ڴ���Ӵ���*/
        if (IN.size() + OUT.size() >= 10) {
            return 1;
        }

        IN.add(x.enElem);
        return 0;
    }

    //STջ��Ԫ�س�ջ����������x��
    public static int pop(Object st, DeQueueInf x) {

        if (IN.isEmpty() && OUT.isEmpty()) {
            return 1;
        }

        if (OUT.isEmpty()) {
            while (!IN.isEmpty()) {
                OUT.add(IN.remove(IN.size() - 1));
            }
        }

        x.deElem = (Integer) OUT.remove(OUT.size() - 1);
        return 0;
    }

    //��STջ�Ƿ�Ϊ�ա�
    public static int isEmpty(Object st) {
        if (IN.isEmpty() && OUT.isEmpty()) {
            return 1;
        }
        return 0;
    }

    //��ʼ�����У���ʼ����ɺ�Ķ���Ϊ�գ�û���κ�Ԫ�أ�
    public static int initQueue() {
        return initSt(null);
    }

    //��Ԫ��Elem������У�������гɹ�����0�����򷵻�1��
    public static int enQueue(EnQueueInf elem) {
        return push(null, elem);
    }

    //�Ӷ�����ȡ��һ��Ԫ�ط���pElem���������гɹ�����0�����򷵻�1��
    public static int deQueue(DeQueueInf elem) {
        return pop(null, elem);
    }

    //���ö����Ƿ�Ϊ�գ�����ǿ��򷵻�1��������ǿ��򷵻�0��
    public static int isEmptyQueue() {
        return isEmpty(null);
    }

    public static void printQueue() {
        System.out.println(IN);
        System.out.println(OUT);
    }
}
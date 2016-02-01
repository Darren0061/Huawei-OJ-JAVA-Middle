package huawei;

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

    //��ʼ��STջ����ʼ����ɺ��ջΪ�գ�û���κ�Ԫ�أ�
    public static int initSt(Object st) {
	    /*�ڴ���Ӵ���*/
        return 0;
    }

    //Ԫ��x��STջ��
    public static int push(Object st, int x) {
	    /*�ڴ���Ӵ���*/
        return 0;
    }

    //STջ��Ԫ�س�ջ����������x��
    public static int pop(Object st, int x) {
	    /*�ڴ���Ӵ���*/
        return 0;
    }

    //��STջ�Ƿ�Ϊ�ա�
    public static int isEmpty(Object st) {
	    /*�ڴ���Ӵ���*/
        return 0;
    }

    //��ʼ�����У���ʼ����ɺ�Ķ���Ϊ�գ�û���κ�Ԫ�أ�
    public static int initQueue() {
	    /*�ڴ���Ӵ���*/
        return 0;
    }

    //��Ԫ��Elem������У�������гɹ�����0�����򷵻�1��
    public static int enQueue(EnQueueInf elem) {
	    /*�ڴ���Ӵ���*/
        return 0;
    }

    //�Ӷ�����ȡ��һ��Ԫ�ط���pElem���������гɹ�����0�����򷵻�1��
    public static int deQueue(DeQueueInf elem) {
	    /*�ڴ���Ӵ���*/
        return 0;
    }

    //���ö����Ƿ�Ϊ�գ�����ǿ��򷵻�1��������ǿ��򷵻�0��
    public static int isEmptyQueue() {
	    /*�ڴ���Ӵ���*/
        return 0;
    }
}
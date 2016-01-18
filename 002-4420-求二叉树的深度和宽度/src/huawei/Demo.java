package huawei;

import java.util.LinkedList;
import java.util.List;

public final class Demo {

    public static class BiNode {

        public char data;
        public BiNode left;
        public BiNode right;

        public BiNode(char data) {
            this.data = data;

        }
    }

    public static class BiNodeInfo {
        public int width = 0;
        public int height = 0;
    }

    /*
     * Description ����һ������������ȡ�ö������Ŀ����ȡ�
     * Input Param: head  ��Ҫ��ȡ��ȵĶ�����ͷ���
     * Return Value: width ��� height �߶�
     */
    public static BiNodeInfo getBiNodeInfo(BiNode head) {
        BiNodeInfo bni = new BiNodeInfo();

        if (head != null) {
            // ��ǰ��
            List<BiNode> currLevel = new LinkedList<BiNode>();
            // ��һ��
            List<BiNode> nextLevel = new LinkedList<BiNode>();

            currLevel.add(head);
            // ��¼�߶�
            bni.height++;
            // ��¼������һ��Ľ�����
            bni.width = currLevel.size();

            while (!currLevel.isEmpty()) {
                BiNode bn = currLevel.remove(0);
                // ��������Ϊ��
                if (bn.left != null) {
                    nextLevel.add(bn.left);
                }

                // ��������Ϊ��
                if (bn.right != null) {
                    nextLevel.add(bn.right);
                }

                // ��ǰ���Ѿ���������
                if (currLevel.isEmpty()) {

                    // ������һ��
                    List<BiNode> tmp = currLevel;
                    currLevel = nextLevel;
                    nextLevel = tmp;

                    // ����������
                    if (!currLevel.isEmpty()) {
                        // �߶�����
                        bni.height++;

                        // ���¿��
                        if (bni.width < currLevel.size()) {
                            bni.width = currLevel.size();
                        }
                    }
                }
            }
        }

        return bni;
    }

}
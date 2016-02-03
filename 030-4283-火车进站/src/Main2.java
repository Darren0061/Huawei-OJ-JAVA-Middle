import java.util.*;

/**
 * Author: ������
 * Date: 2016-02-03 08:17
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main2 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main2.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] ss = new String[n];
            for (int i = 0; i < n; i++) {
                ss[i] = scanner.next();
            }

            System.out.println(trainOut(ss));
        }

        scanner.close();
    }

    private static String trainOut(String[] ss) {

//        Arrays.sort(ss);

        List<List<String>> result = new ArrayList<List<String>>();
        List<String> out = new ArrayList<String>(ss.length);
        List<String> in = new ArrayList<String>(ss.length);
        trainOut(0, ss, out, in, result);

        Collections.sort(result, new Comparator<List<String>>() {

            @Override
            public int compare(List<String> a, List<String> b) {

                int min = a.size() < b.size() ? a.size() : b.size();


                for (int i = 0; i < min; i++) {
                    String as = a.get(i);
                    String bs = b.get(i);
                    if (as.compareTo(bs) != 0) {
                        return as.compareTo(bs);
                    }
                }
                return a.size() - b.size();
            }
        });


        StringBuilder builder = new StringBuilder(256);
        for (List<String> list : result) {
            StringBuilder b = new StringBuilder(64);
            for (String s : list) {
                b.append(s).append(' ');
            }
            b.setCharAt(b.length() - 1, '\n');

            builder.append(b);
        }

        return builder.toString();
    }

    /**
     * �𳵽�վ
     *
     * @param i      �𳵱��
     * @param ss     ���еĻ�
     * @param out    ���Ѿ���վ������
     * @param in  �𳵻�δ��վ������
     * @param result �������п��ܵĽ��
     */
    private static void trainOut(int i, String[] ss, List<String> out, List<String> in, List<List<String>> result) {

        // ���еĻ��Ѿ���վ
        if (i >= ss.length) {
            List<String> list = new ArrayList<String>();
            for (String s : out) {
                list.add(s);
            }

            // �Ƚ����
            for (int j = in.size() - 1; j >= 0; j--) {
                list.add(in.get(j));
            }

            result.add(list);

            return;
        }

        // ��i���������ͳ�ȥ��
        out.add(ss[i]);
        trainOut(i + 1, ss, out, in, result);
        // ��ԭ
        out.remove(out.size() - 1);

        // ��i��������û�г�ȥ
        in.add(ss[i]);
        trainOut(i + 1, ss, out, in, result);
        // ��ԭ
        in.remove(in.size() - 1);
    }
}

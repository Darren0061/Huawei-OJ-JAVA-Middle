import java.util.Scanner;

/**
 * Author: ������
 * Date: 2016-01-19 08:35
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));

        do {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }

            System.out.println(drinkSoda(n));

        } while (true);

        scanner.close();
    }

    private static int drinkSoda(int n) {

        int rst = 0;

        while (n >= 3) {
            // ���λ����Ժȵ�ƿ��
            rst += n / 3;
            // ��������ﻹʣ�¶��ٸ���ƿ��
            n = n / 3 + n % 3;
        }

        // ���ʣ����ƿ�ӣ����Խ�һƿ���ȣ�������������ƿ�ӣ��ֿ��Ի�һƿ������ƿ�黹
        if (n == 2) {
            rst++;
        }

        return rst;
    }
}

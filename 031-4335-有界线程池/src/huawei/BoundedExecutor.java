package huawei;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ʵ��һ���н��̳߳أ�ȷ�������ύ�������ܱ�ִ֤�С�
 */
public class BoundedExecutor extends ThreadPoolExecutor {
    private static final int CORESIZE = 10;
    private static final int MAXSIZE = 15;
    private static final int ALIVETIME = 30;
    private static final int QUEUESIZE = 5;

    public BoundedExecutor() {
        super(CORESIZE, MAXSIZE, ALIVETIME, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(QUEUESIZE));
    }

    //��ʾ����Ҫ�Զ���ܾ�����
    public static class RejectedExecution implements RejectedExecutionHandler {

        private Map<Runnable, Boolean> runnableSet = new HashMap<Runnable, Boolean>();

        /**
         * ʵ��һ���н��̳߳أ����̳߳���ʱ�������ȴ����ȵ��п����߳�ʱ���ټ����ύ��
         * ��֤�����ύ��������ִ�е��ǲ������ظ��ύ��
         *
         * @param r
         * @param executor
         */
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if (runnableSet.containsKey(runnableSet)) {
                return;
            }


        }
    }
}

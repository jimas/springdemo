package net.hubs1.com.snowflake;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.LinkedHashSet;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SnowflakeZkFactoryTest2 {
    private static final Logger logger = LoggerFactory.getLogger(SnowflakeTest.class);

    @Test
    public void testGetID() {
        String zkUrl = "192.168.20.56:2181,192.168.20.57:2181,192.168.20.58:2181";
        String appUrl = "/testapp";
        Snowflake idWorker = SnowflakeZkFactory.init(zkUrl, appUrl);

        LinkedHashSet<Long> idSet = new LinkedHashSet<>();
        long workerId = 2L;

        long lastTimestamp = 0;
        long lastSequence = 0;

        for (int i = 0; i < 10000000; i++) {

            // 获取Snowflake生成ID与其Timestamp,WorkId,Sequence
            long generateId = idWorker.getId();
            long generateTimestamp = generateId >>> 22;
            long generateWorkId = generateId << 42 >>> 54;
            long generateSequence = generateId << 52 >>> 52;

            // 测试Timestamp是否正确
            assertThat("timestamp is not equal!", idWorker.getLastTimestamp(), equalTo(generateTimestamp));

            // 测试WorkId是否正确
            assertThat("workId is not equal!", workerId, equalTo(generateWorkId));

            // 测试Sequence是否正确
            if (lastTimestamp == generateTimestamp) {
                assertThat("sequence is not equal!", generateSequence, equalTo(lastSequence + 1L));
            } else {
                assertThat("sequence is not equal!", generateSequence, equalTo(0L));
            }

            lastSequence = generateSequence;
            lastTimestamp = generateTimestamp;

            // 测试生成ID是否重复
            if (idSet.size() == 100000) {
                idSet.clear();
            }
            assertThat("id is duplicate!", idSet.add(generateId), equalTo(true));

        }

    }

    @Test()
    public void performanceTest() {
        String zkUrl = "192.168.20.56:2181,192.168.20.57:2181,192.168.20.58:2181";
        String appUrl = "/testapp";
        Snowflake idWorker = SnowflakeZkFactory.init(zkUrl, appUrl);

        // 性能测试
        logger.info(System.lineSeparator() + "performance testing start.");
        long testTimes = 10000000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            idWorker.getId();
        }
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        long timesPerSecond = testTimes * 1000 / costTime;
        logger.info(System.lineSeparator() + "generated " + testTimes + " times," + " cost " + costTime + " millisecond." + System.lineSeparator()
                + timesPerSecond + " per second." + System.lineSeparator() + "performance testing end.");

    }
}

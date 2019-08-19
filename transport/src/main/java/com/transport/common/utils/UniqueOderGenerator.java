package com.transport.common.utils;


import java.util.concurrent.TimeoutException;

/**
 * @author Administrator
 */

public class UniqueOderGenerator {


    private final long workerId;
    private static final long SNS_EPOCH = 1330328109047L;
    private long sequence = 0L;
    private static final long WORKER_ID_BITS = 10L;
    private static final long MAX_WORKER_ID = -1L ^ -1L << WORKER_ID_BITS;
    private static final long SEQUENCE_BITS = 12L;

    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;
    private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
    private static final long SEQUENCE_MASK = -1L ^ -1L << SEQUENCE_BITS;

    private long lastTimestamp = -1L;

    private UniqueOderGenerator(long workerId) {
        super();
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", MAX_WORKER_ID));
        }
        this.workerId = workerId;
    }

    private static UniqueOderGenerator uniqueOderGenerator = null;

    @SuppressWarnings("all")
    public static UniqueOderGenerator getInstance() {
        if (uniqueOderGenerator == null) {
            synchronized (UniqueOderGenerator.class) {
                if (uniqueOderGenerator == null) {
                    uniqueOderGenerator = new UniqueOderGenerator(0);
                }
            }
        }
        return uniqueOderGenerator;
    }

    public synchronized String create() throws TimeoutException {
        long timestamp = this.timeGen();
        if (this.lastTimestamp == timestamp) {
            this.sequence = sequence + 1 & SEQUENCE_MASK;
            if (this.sequence == 0) {
                timestamp = this.utilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0;
        }
        if (timestamp < this.lastTimestamp) {
            throw new TimeoutException(String.format("Clock moved backwards.Refusing to generate id for %d milliseconds", (this.lastTimestamp - timestamp)));
        }

        this.lastTimestamp = timestamp;
        long id = timestamp - SNS_EPOCH << TIMESTAMP_LEFT_SHIFT | this.workerId << WORKER_ID_SHIFT | this.sequence;
        return String.valueOf(id);
    }

    /**
     * 保证返回的毫秒数在参数之后
     *
     * @param lastTimestamp
     * @return
     */
    private long utilNextMillis(long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }

    /**
     * @return 获得以毫秒数为单位的当前时间
     */
    private long timeGen() {
        return System.currentTimeMillis();
    }

}

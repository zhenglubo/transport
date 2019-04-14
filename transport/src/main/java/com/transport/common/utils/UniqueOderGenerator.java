package com.transport.common.utils;

/**
 * @author Administrator
 */

public class UniqueOderGenerator {


    private final long workerId;
    private final long snsEpoch = 1330328109047L;
    private long sequence = 0L;
    private final long workerIdBits = 10L;
    private final long maxWorkerId = -1L ^ -1L << this.workerIdBits;
    private final long sequenceBits = 12L;

    private final long workerIdShift = this.sequenceBits;
    private final long timestampLeftShift = this.sequenceBits + this.workerIdBits;
    private final long sequenceMask = -1L ^ -1L << this.sequenceBits;

    private long lastTimestamp = -1L;

    private UniqueOderGenerator(long workerId) {
        super();
        if (workerId > this.maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", this.maxWorkerId));
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

    public synchronized String create() throws Exception {
        long timestamp = this.timeGen();
        if (this.lastTimestamp == timestamp) {
            this.sequence = this.sequence + 1 & this.sequenceMask;
            if (this.sequence == 0) {
                timestamp = this.utilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0;
        }
        if (timestamp < this.lastTimestamp) {
            throw new Exception(String.format("Clock moved backwards.Refusing to generate id for %d milliseconds", (this.lastTimestamp - timestamp)));
        }

        this.lastTimestamp = timestamp;
        long id = timestamp - this.snsEpoch << this.timestampLeftShift | this.workerId << this.workerIdShift | this.sequence;
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

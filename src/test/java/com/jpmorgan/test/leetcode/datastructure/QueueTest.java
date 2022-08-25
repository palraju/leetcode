package com.jpmorgan.test.leetcode.datastructure;

import com.jpmorgan.leetcode.datastructure.Queue;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class QueueTest {

    @Test
    public void testQueue () {
        Queue<Integer> testQueue = new Queue<>();
        testQueue.push(1);
        testQueue.push(2);
        Assert.isTrue(!testQueue.isEmpty(),"Queue is Empty");
        Assert.isTrue(testQueue.size() == 2,"Queue size not 2");
        Assert.isTrue(testQueue.pop().equals(1),"First Element is not 1");
    }
}

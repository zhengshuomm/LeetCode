/*
Database & Consistent Hashing

Consistent Hashing

一般的数据库进行horizontal shard的方法是指，把 id 对 数据库服务器总数 n 取模，然后来得到他在哪台机器上。这种方法的缺点是，当数据继续增加，我们需要增加数据库服务器，将 n 变为 n+1 时，几乎所有的数据都要移动，这就造成了不 consistent。为了减少这种 naive 的 hash方法(%n) 带来的缺陷，出现了一种新的hash算法：一致性哈希的算法——Consistent Hashing。这种算法有很多种实现方式，这里我们来实现一种简单的 Consistent Hashing。

将 id 对 360 取模，假如一开始有3台机器，那么让3台机器分别负责0~119, 120~239, 240~359 的三个部分。那么模出来是多少，查一下在哪个区间，就去哪台机器。
当机器从 n 台变为 n+1 台了以后，我们从n个区间中，找到最大的一个区间，然后一分为二，把一半给第n+1台机器。
比如从3台变4台的时候，我们找到了第3个区间0~119是当前最大的一个区间，那么我们把0~119分为0~59和60~119两个部分。0~59仍然给第1台机器，60~119给第4台机器。
然后接着从4台变5台，我们找到最大的区间是第3个区间120~239，一分为二之后，变为 120~179, 180~239。
假设一开始所有的数据都在一台机器上，请问加到第 n 台机器的时候，区间的分布情况和对应的机器编号分别是多少？

If the maximal interval is [x, y], and it belongs to machine id z, when you add a new machine with id n, you should divide [x, y, z] into two intervals:

[x, (x + y) / 2, z] and [(x + y) / 2 + 1, y, n]
*/

public class Solution {
    /**
     * @param n a positive integer
     * @return n x 3 matrix
     */
    public List<List<Integer>> consistentHashing(int n) {
        // Write your code here
        List<List<Integer>> machineInterval = new ArrayList<List<Integer>>();
        if(n == 0)
            return machineInterval;
        Machine init = new Machine(0, 359, 1);
        PriorityQueue<Machine> queue = new PriorityQueue<Machine>();
        queue.offer(init);
        for(int i = 2 ; i <= n; i ++){
            Machine oldMac = queue.poll();
            Machine newMac = new Machine((oldMac.start + oldMac.end) / 2 + 1, oldMac.end, i);
            oldMac.end = (oldMac.start + oldMac.end) / 2;
            queue.offer(newMac);
            queue.offer(oldMac);
        }
        
        while(!queue.isEmpty()){
            machineInterval.add(queue.poll().toIntegerList());
        }
        Collections.sort(machineInterval, new Comparator<List<Integer>>(){
            public int compare(List<Integer> l1, List<Integer> l2){
                return l1.get(0) - l2.get(0);
            }
        }
        );
        return machineInterval;
        
    }
    
    
    class Machine implements Comparable<Machine>{
        int start;
        int end;
        int num;
        public Machine(int start, int end, int num){
            this.start = start;
            this.end = end;
            this.num = num;
        }

        public int compareTo(Machine comMac){
            int curSize = this.end - this.start + 1;
            int comMacSize = comMac.end - comMac.start + 1;
            if(curSize == comMacSize)
                return this.num - comMac.num;
            else
                return comMacSize - curSize;
        }
        
        public List<Integer> toIntegerList(){
            List<Integer> result = new ArrayList<Integer>();
            result.add(this.start);
            result.add(this.end);
            result.add(this.num);
           return result;
        }
    }
}
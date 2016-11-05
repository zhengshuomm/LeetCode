/*
2 - Database & Consistent Hashing
Consistent Hashing II

在 Consistent Hashing I 中我们介绍了一个比较简单的一致性哈希算法，这个简单的版本有两个缺陷：

增加一台机器之后，数据全部从其中一台机器过来，这一台机器的读负载过大，对正常的服务会造成影响。
当增加到3台机器的时候，每台服务器的负载量不均衡，为1:1:2。
为了解决这个问题，引入了 micro-shards 的概念，一个更好的算法是这样：

将 360° 的区间分得更细。从 0~359 变为一个 0 ~ n-1 的区间，将这个区间首尾相接，连成一个圆。
当加入一台新的机器的时候，随机选择在圆周中撒 k 个点，代表这台机器的 k 个 micro-shards。
每个数据在圆周上也对应一个点，这个点通过一个 hash function 来计算。
一个数据该属于那台机器负责管理，是按照该数据对应的圆周上的点在圆上顺时针碰到的第一个 micro-shard 点所属的机器来决定。
n 和 k在真实的 NoSQL 数据库中一般是 2^64 和 1000。

请实现这种引入了 micro-shard 的 consistent hashing 的方法。主要实现如下的三个函数：

create(int n, int k)
addMachine(int machine_id) // add a new machine, return a list of shard ids.
getMachineIdByHashCode(int hashcode) // return machine id

*/


public class Solution {
    private TreeMap<Integer, Integer> shards_map;
    private int keySpace;
    private int shardsNum;
    
    private Solution(int n, int k){
        shards_map = new TreeMap<>();
        keySpace = n;
        shardsNum = k;
    }
    // @param n a positive integer
    // @param k a positive integer
    // @return a Solution object
    public static Solution create(int n, int k) {
        // Write your code here
        return new Solution(n, k);
    }

    // @param machine_id an integer
    // @return a list of shard ids
    public List<Integer> addMachine(int machine_id) {
        // Write your code here
        List<Integer> randomMachinePos = new ArrayList<Integer>();
        Random rm = new Random();
        for(int i = 0 ; i < shardsNum ; i ++){
            int num = rm.nextInt(keySpace);
            while(shards_map.containsKey(num)){
                num = rm.nextInt(keySpace);
            }
            shards_map.put(num, machine_id);
            randomMachinePos.add(num);
        }
        return randomMachinePos;
    }

    // @param hashcode an integer
    // @return a machine id
    public int getMachineIdByHashCode(int hashcode) {
        // Write your code here
        Integer nextMachinePos = shards_map.ceilingKey(hashcode);
        if(nextMachinePos == null){
            nextMachinePos = shards_map.firstKey();
        }
        return shards_map.get(nextMachinePos);
    }
}
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * Created by swang on 2/23/2017.
 */
public class ZigZagIterator {
    Iterator<Integer> it1;
    Iterator<Integer> it2;
    int turn;
    public ZigZagIterator(List<Integer> it1, List<Integer> it2){
        this.it1 = it1.iterator();
        this.it2 = it2.iterator();
        turn = 0;
    }

    public int next(){
        if(!hasNext()){
            return 0;
        }
        turn ++;
        if((turn % 2 == 1 && it1.hasNext()) ||(!it2.hasNext())){
            return it1.next();
        }else if ((turn % 2 == 0 && it2.hasNext()) ||(!it1.hasNext())){
            return it2.next();
        }
        return 0;
    }


    public boolean hasNext(){
        return it1.hasNext() || it2.hasNext();
    }
}


class ZigZagIteratorMulti {
    Queue<Iterator<Integer>> it;

    public ZigZagIteratorMulti(List<Iterator<Integer>> list){
        for(Iterator<Integer> i : list){
            if(i.hasNext()){
                it.offer(i);
            }
        }
    }

    public int next(){
        if(!hasNext()){
            return 0;
        }
        Iterator<Integer> cur = it.poll();
        int next = cur.next();
        if(cur.hasNext()){
            it.offer(cur);
        }
        return next;
    }


    public boolean hasNext(){
        return !it.isEmpty();
    }
}

/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/animal-shelter
@Language: Java
@Datetime: 16-10-19 03:40
*/

public class AnimalShelter {
    LinkedList<AnimalCount> cats;
    LinkedList<AnimalCount> dogs;
    int total ;
   
    public AnimalShelter() {
        // do initialize if necessary
        cats = new LinkedList<AnimalCount>();
        dogs = new LinkedList<AnimalCount>();
        total = 0;
    }

    /**
     * @param name a string
     * @param type an integer, 1 if Animal is dog or 0
     * @return void
     */
    void enqueue(String name, int type) {
        // Write your code here
        AnimalCount cur = new AnimalCount(name, type, total ++);
        if(type == 0){
            cats.add(cur);
        }else dogs.add(cur);
    }

    public String dequeueAny() {
        // Write your code here
        if(cats.isEmpty()){
            return dequeueDog();
        }else if(dogs.isEmpty()){
            return dequeueCat();
        }else{
            if(cats.peek().num < dogs.peek().num ){
                return dequeueCat();
            }else return dequeueDog();
        }
    }

    public String dequeueDog() {
        // Write your code here
        String name = dogs.peek().name;
        dogs.removeFirst();
        return name;
    }

    public String dequeueCat() {
        // Write your code here
        String name = cats.peek().name;
        cats.removeFirst();
        return name;
    }
}

class AnimalCount{
    String name ;
    int type;
    int num;
    public AnimalCount(String name,    int type, int num){
       this.name = name;
       this.type = type;
       this.num = num;
    }
}

/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/implement-three-stacks-by-single-array
@Language: Java
@Datetime: 16-10-24 01:06
*/

public class ThreeStacks {
    private int [] arr;
    private int s1;
    private int s2;
    private int s3;
    private int size;
    
    public ThreeStacks(int size) {
        // do intialization if necessary
        arr = new int [size * 3];
        this.size = size;
        s1 = - 1;
        s2 = size - 1;
        s3 = size * 2 - 1;
    }

    public void push(int stackNum, int value) {
        // Write your code here
        // Push value into stackNum stack
        if(stackNum == 0){
            arr[++ s1] = value;
        }else if(stackNum == 1){
            arr[++ s2] = value;
        }else{
            arr[++ s3] = value;
        } 
    }
    
    public int pop(int stackNum) {
        // Write your code here
        // Pop and return the top element from stackNum stack
        int result ;
        if(stackNum == 0){
            result = arr[ s1 -- ];
        }else if(stackNum == 1){
            result = arr[ s2 -- ];
        }else{
            result = arr[ s3 -- ];
        }
        return result;
    }

    public int peek(int stackNum) {
        // Write your code here
        // Return the top element
        int result ;
        if(stackNum == 0){
            result = arr[ s1 ];
        }else if(stackNum == 1){
            result = arr[ s2  ];
        }else{
            result = arr[ s3 ];
        }
        return result;
    }

    public boolean isEmpty(int stackNum) {
        // Write your code here
        if(stackNum == 0){
            return s1 == -1;
        }else if(stackNum == 1){
            return s2 == (size - 1);
        }else{
            return s3 == (size * 2 - 1);
        }
    }
}
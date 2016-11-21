/*
 9 - Message System & Rate Limiter

497. Shape Factory

actory is a design pattern in common usage. Implement a ShapeFactory that can generate correct shape.

You can assume that we have only tree different shapes: Triangle, Square and Rectangle.

Have you met this question in a real interview? Yes
Example
ShapeFactory sf = new ShapeFactory();
Shape shape = sf.getShape("Square");
shape.draw();
>>  ----
>> |    |
>> |    |
>>  ----

shape = sf.getShape("Triangle");
shape.draw();
>>   /\
>>  /  \
>> /____\

shape = sf.getShape("Rectangle");
shape.draw();
>>  ----
>> |    |
>>  ----

*/

/**
 * Your object will be instantiated and called as such:
 * ShapeFactory sf = new ShapeFactory();
 * Shape shape = sf.getShape(shapeType);
 * shape.draw();
 */
interface Shape {
    void draw();
}

class Rectangle implements Shape {
    // Write your code here
    public void draw(){
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println(" ---- ");
    }
 }

class Square implements Shape {
    // Write your code here
    public void draw(){
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println("|    |");
        System.out.println(" ---- ");
    }
}

class Triangle implements Shape {
    // Write your code here
    public void draw(){
        System.out.println("  /\\");
        System.out.println(" /  \\");
        System.out.println("/____\\");
    }
}

public class ShapeFactory {
    /**
     * @param shapeType a string
     * @return Get object of type Shape
     */
    public Shape getShape(String shapeType) {
        // Write your code here
        if(shapeType.equals("Rectangle")){
            return new Rectangle();
        }
        if(shapeType.equals("Square")){
            return new Square();
        }
        if(shapeType.equals("Triangle")){
            return new Triangle();
        }
        return null;
    }
}
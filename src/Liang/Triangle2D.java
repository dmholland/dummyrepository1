package Liang;

 class MyPoint{
    double x;
    double y;

    MyPoint(){

    }

    MyPoint(double x, double y){
        this.x=x;
        this.y=y;
    }
}             //end of MyPoint class
public class Triangle2D {

    MyPoint p1;
    MyPoint p2;
    MyPoint p3;


    Triangle2D(){
        this(new MyPoint(0,0),new MyPoint(1,1),new  MyPoint(2,5));
    }

    Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3){
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
    }
public static double getDistance(MyPoint p1, MyPoint p2){    //uses pythagorean thereom
  double distance=Math.sqrt(Math.pow((p1.y-p2.y),2)+Math.pow((p1.x-p2.x),2));
    System.out.println("Distance is "+distance);
    return distance;
}


public double getArea(){
        double s=getPerimeter()/2;
        double area=Math.sqrt(s*(s-getDistance(p1,p2))*(s-getDistance(p2,p3))*(s-getDistance(p3,p1)));
        return area;
}

public double getPerimeter(){
        double perimeter=(getDistance(p1,p2)+getDistance(p2,p3)+getDistance(p3,p1));

        return perimeter;
}


public boolean contains(MyPoint p){
        if(getDistance(p1,p)<getDistance(p1,p2)
                &&getDistance(p1,p)<getDistance(p1,p3)
                && getDistance(p2,p)<getDistance(p2,p3))
            return true;
        //else
        return false;
}
   public boolean contains(Triangle2D t){
          if(this.contains(t.p1) && this.contains(t.p2) && this.contains(t.p3))
              return true;
          //else
        return false;
   }




   public boolean overlaps(Triangle2D t){
         if(!this.contains(t)){
             if(this.contains(t.p1) || this.contains(t.p2) || this.contains(t.p3))
                 return true;



         }
        return false;
    }
}//end of triangle class

package Liang;

public class Circle2D {
    double x;
    double y;
    double radius;

    Circle2D(){
       this(0,0,1);
    }

    Circle2D(double x,double y,double radius){
        this.x=x;
        this.y=y;
        this.radius=radius;
    }

  public double getArea(){
        return (Math.PI*Math.pow(radius,2));
  }

  public double getParimeter(){
        return(2*Math.PI*radius);
  }

   public boolean contains(double x, double y){  //checks for a point in the circle
        if(Math.abs(this.x-x)<=this.radius && Math.abs(this.y-y)<=this.radius)return true;
        return false;
   }


    public boolean contains(Circle2D circle){  // Checks by comaparing distances of center to differences in radius

        if(Math.abs(this.y-circle.y)<=this.radius-circle.radius && Math.abs(this.x-circle.x)<=this.radius-circle.radius)return true;
        return false;

    }

    public boolean overlaps(Circle2D circle){
        if (this.contains(circle)==false && (Math.abs(this.y-circle.y)<=this.radius+circle.radius || Math.abs(this.x-circle.x)<=this.radius+circle.radius))return true;
        return false;
    }

    //end of file
}

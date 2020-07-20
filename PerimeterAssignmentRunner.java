import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints(Shape s) {
        int num= 0;
        for(Point currPt:s.getPoints()){
             num = num+1;  
        }
        return num;
    }

    public double getAverageLength(Shape s) {
        int num= getNumPoints(s);
        double length= getPerimeter(s);
        return length/num;
    }

    public double getLargestSide(Shape s) {
        Point prevPt=s.getLastPoint();
        double largSide=0;
      for(Point currPt:s.getPoints())
      {
         double currDist = prevPt.distance(currPt);
            if(currDist>=largSide)
                largSide = currDist;
            prevPt=currPt;
            }   
      return largSide;
    }

    public double getLargestX(Shape s) {
        double largX = 0;
        for(Point currPt:s.getPoints()){
            double X= currPt.getX();
            if(X>=largX)
             largX=X;
            }
        return largX;
    }

    public double getLargestPerimeterMultipleFiles() {
         double Larglength=0.0;
         DirectoryResource dr = new DirectoryResource();
         for (File f : dr.selectedFiles()) {
            FileResource fr= new FileResource(f);
            Shape s = new Shape(fr);
            double length= getPerimeter(s);
            if(length>=Larglength)
             Larglength=length;
            }
        return Larglength;
    }

    public String getFileWithLargestPerimeter() {
        File temp = null;
         double Larglength=0.0;
         DirectoryResource dr = new DirectoryResource();
         for (File f : dr.selectedFiles()) {
            FileResource fr=new FileResource(f);
            Shape s = new Shape(fr);
            double length= getPerimeter(s);
            if(length>=Larglength){
             Larglength=length;
             temp= f ;
            }
        }
        return temp.getName() ;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getLargestSide(s);
        System.out.println("The Largest Value of x-coordinate = " + length);
    }
    
    public void testPerimeterMultipleFiles() {
        double length= getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter in the files = " + length);
    }

    public void testFileWithLargestPerimeter() {
         String length= getFileWithLargestPerimeter();
         System.out.println("File Name of the Largest Perimeter= " + length);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr =new PerimeterAssignmentRunner();
        pr.testFileWithLargestPerimeter();
    }
}

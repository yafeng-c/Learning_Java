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

    public int getNumPoints (Shape s) {
        // Put code here
        int pointnum = 0;
        for (Point currPt : s.getPoints()){
            pointnum = pointnum + 1;
        
        }
        return pointnum;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double aveLength = 0;
        double length = getPerimeter(s);
        int num = getNumPoints(s);
        aveLength = length/num;
        return aveLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largest = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) { 
            double currDist = prevPt.distance(currPt);
            if (largest<=currDist){
                largest = currDist;
            }
            prevPt = currPt;
        }
        
        return largest;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) { 
            double currX = currPt.getX();
            if (largestX <= currX){
                largestX = currX;            
            }
            prevPt = currPt;
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestP = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currP = getPerimeter(s);
            if (largestP <= currP){
                largestP = currP;
            }
        }
        return largestP;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;
        double largestP = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currP = getPerimeter(s);
            if (largestP <= currP){
                largestP = currP;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int num = getNumPoints(s);
        double aveLength = getAverageLength(s);
        double largest = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("point number = " + num);
        System.out.println("average length = " + aveLength);
        System.out.println("largest side = " + largest);
        System.out.println("largest X = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largestP = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter = " + largestP);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String name = getFileWithLargestPerimeter();
        System.out.println("file with the largest perimeter = " + name);
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
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}

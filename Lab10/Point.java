package Lab10;

public class Point {
    private int x = 10;
    private int y = 10;
    private static int count = 0;

    public Point() {
        setX(xValue);
        setY(yValue);
        count++;

        // finalizer
        protected void finalize() {
            count--;
        }

        //set x in coordinate pair
        public void setX(int xValue) {
            x = xValue;
        }

        //return x from coordinate pair
        public int getX() {
            return x;
        }

        public void setY(int yValue) {
            y = yValue;
        }

        public int getY() {
            return y;
        }

        public static int getCount() {
            return count;
        }

        public String toString() {
            return "[" + getX() + ", " + getY() + "]";
        }

        
    }
}

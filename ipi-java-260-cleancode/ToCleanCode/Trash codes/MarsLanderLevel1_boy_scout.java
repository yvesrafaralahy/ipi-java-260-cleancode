import java.util.Scanner;

class Player {

    private static final double GRAVITY = 3.711;
    public static final int REQUIRED = 1000;
    private static final int VITESS = 40;
    private static final int MAX_POWER = 4;
    private static int FLAT_Y;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        calculateFlatHeight(in);

        double timeToBrake = initializeAndCalculateTimeToBreak(in);
        boolean brakingFullPowerReached = false;
        int time = 1;
        
        // game loop
        while (true) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int HS = in.nextInt(); 
            int VS = in.nextInt(); 
            int F = in.nextInt(); 
            int R = in.nextInt(); 
            int P = in.nextInt(); 

            if (!brakingFullPowerReached && time > timeToBrake) { // brake
                if (++P == 4) {
                    brakingFullPowerReached = true;
                }
            } else if (brakingFullPowerReached) { // economize fuel
                double endSpeed = Math.sqrt(VS * VS + 2 * (Y - FLAT_Y) * (MARS_GRAVITY - (P - 1))) + 1;
                if (endSpeed < V_LIMIT) {
                    P--;
                }
            }

            System.out.println(R + " " + P); 
            time++;
        }
    }

    private static void calculateHeightOfOurSurface(Scanner in) {
        int N = in.nextInt(); // the number of points used to draw the surface of Mars.
        int LAND_PREV_X = in.nextInt();
        int LAND_PREV_Y = in.nextInt();
        for (int i = 1; i < N; i++) {
            int LAND_X = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int LAND_Y = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            if (LAND_PREV_Y == LAND_Y && LAND_X - LAND_PREV_X >= REQUIRED_FLAT_GROUND) {
                FLAT_Y = LAND_Y;
                System.err.println("Flat on: " + LAND_Y + ", start: " + LAND_PREV_X + ", length: " + (LAND_X - LAND_PREV_X));
            }
            LAND_PREV_X = LAND_X;
            LAND_PREV_Y = LAND_Y;
        }
    }

    private static double CalculateTimeTheToBreak(Scanner in) {
        int X = in.nextInt();
        int Y = in.nextInt();
        int HS = in.nextInt();
        int VS = in.nextInt(); 
        int F = in.nextInt(); 
        int R = in.nextInt(); 
        int P = in.nextInt(); 
        
        double g2 = MAX_POWER - GRAVITY;
       
        double distanceBeforeBraking = (V_LIMIT * V_LIMIT + 2 * g2 * (Y - FLAT_Y)) / (2 * (MARS_GRAVITY + g2));
        System.err.println("distanceBeforeBraking=" + distanceBeforeBraking);
        // h = (g * t^2) / 2  ==>  t = squareRoot(2 * h / g)
        double timeToBrake = Math.floor(Math.sqrt(2 * distanceBeforeBraking / MARS_GRAVITY)) - 3;
        System.err.println("timeToBrake=" + timeToBrake);

        System.out.println(R + " " + P);
        return timeToBrake;
    }
}

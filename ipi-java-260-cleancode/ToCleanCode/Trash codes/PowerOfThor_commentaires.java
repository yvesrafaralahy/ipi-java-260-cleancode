import java.util.Scanner;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int LX = in.nextInt();
        int LY = in.nextInt(); 
        int TX = in.nextInt(); 
        int TY = in.nextInt(); 
        
        while (true) {

            int E = in.nextInt(); 
            String goTo = "";

            if (TY > LY) { 
                TY -= 1;
            } else if (TY < LY) { 
                goTo = "S";
                TY += 1;
            }

            if (TX > LX) {
                TX -= 1;
            } else if (TX < LX) { 
                goTo += "E";
                TX += 1;
            }

            System.out.println(goTo);
        }
    }
}

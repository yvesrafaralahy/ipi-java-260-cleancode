
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;


public class BowlingGameTest {
	  private BowlingGame g = new BowlingGame();


	  void rollMany(int numberRolls, int numberPins) {
	        for (int i = 0; i < numberRolls; i++) {
	            g.roll(numberPins);
	        }
	    }

	  @Test
	  public void queDesGoutieresDonne0Points() {
	    rollMany(20, 0);
	    assertEquals(0, g.score());
	  }
	  
	  @Test
	  public void uneSeuleQuille() {
	        g.roll(1);
	        rollMany(19, 0);
	        assertEquals(1, g.score());
	   }
	  
	  @Test
	  public void bonusDuSpare() {
	        g.roll(8);
	        g.roll(2);
	        g.roll(1);
	        rollMany(17, 0);
	        assertEquals(12, g.score());
	    }
	  
	   @Test
	   public void unSeulStrike() {
	    	g.roll(10);
	    	g.roll(3);
	    	g.roll(4);
			rollMany(16, 0);
			assertEquals(24, g.score());
		}
	    
	    @Test
	    public void unJeuParfait() {
	    	rollMany(12, 10);
			assertEquals(300, g.score());
	    }
}

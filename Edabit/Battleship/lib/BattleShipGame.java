import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import junit.framework.TestCase;


class Battleship {
	
    private String[] scheme;
    private String[] target;
    private int totalHits = 0;
    private String[][] board = new String[][] {
        {"○", "○", "○", "○", "○"}, 
        {"○", "○", "○", "○", "○"}, 
        {"○", "○", "○", "○", "○"}, 
        {"○", "○", "○", "○", "○"}, 
        {"○", "○", "○", "○", "○"}};

    public Battleship(String[] scheme, String[] target) {

        this.scheme = scheme;
        this.target = target;
        this.setBoard();
        this.guess();
    }
    
    private void setBoard()
    {
        for (String location : this.scheme){
            
            Integer rowIndex = location.charAt(0) - 'A';
            Integer columnIndex = Character.getNumericValue(location.charAt(1)) - 1;
            board[rowIndex][columnIndex] = "●";
        }
    }

    private void guess() {

        for (String guess : this.target) {
            
            Integer rowIndex = guess.charAt(0) - 'A';
            Integer columnIndex = Character.getNumericValue(guess.charAt(1)) - 1;

            if (board[rowIndex][columnIndex] == "●") {
                board[rowIndex][columnIndex] = "☀";
                this.totalHits++;
            } else {
                board[rowIndex][columnIndex] = "☼";
            }

        }
    }

    public String[][] board() {

        return this.board;
    }
	public int hits() {

        return this.totalHits;
    }
	public int sunk() {
        
        int count = 0;

        for(int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (i >= 1 && board[i][j] == "☀" && board[i - 1][j] == "☀")
                {
                    count++;
                } else if (j >= 1 && board[i][j] == "☀" && board[i][j - 1] == "☀") {
                    count++;
                }
            }
        }

        return count;
    }
	public int points() {
        return this.hits() + this.sunk() * 2;
    }
}

public class BattleShipGame extends TestCase{
    public static void main(String[] args) throws Exception {
        
    }

    @Test
	public void test01() {

		Battleship battleship = new Battleship(new String[] {"A1", "C1", "B2", "B3", "D2", "E2", "E4", "E5", "A5"}, new String[] {"A1", "B2", "C3", "D4", "E5", "E4"});
		assertArrayEquals(new String[][] {
			{"☀", "○", "○", "○", "●"}, 
			{"○", "☀", "●", "○", "○"}, 
			{"●", "○", "☼", "○", "○"}, 
			{"○", "●", "○", "☼", "○"}, 
			{"○", "●", "○", "☀", "☀"}}, battleship.board());
		assertEquals(4, battleship.hits());
		assertEquals(1, battleship.sunk());
		assertEquals(6, battleship.points());
		battleship = null;
	}

    @Test
	public void test02() {
		Battleship battleship = new Battleship(new String[] {"A1", "C1", "B2", "B3", "D2", "E2", "E4", "E5", "A5"}, new String[] {"A2", "B4", "C1", "D3", "E5", "A5"});
		assertArrayEquals(new String[][] {
			{"●", "☼", "○", "○", "☀"}, 
			{"○", "●", "●", "☼", "○"}, 
			{"☀", "○", "○", "○", "○"}, 
			{"○", "●", "☼", "○", "○"}, 
			{"○", "●", "○", "●", "☀"}}, battleship.board());
		assertEquals(3, battleship.hits());
		assertEquals(0, battleship.sunk());
		assertEquals(3, battleship.points());
		battleship = null;
	}
    @Test
	public void test03() {
		Battleship battleship = new Battleship(new String[] {"A1", "C1", "B2", "B3", "D2", "E2", "E4", "E5", "A5"}, new String[] {"A1", "B1", "D1", "E1", "A3", "A4"});
		assertArrayEquals(new String[][] {
			{"☀", "○", "☼", "☼", "●"}, 
			{"☼", "●", "●", "○", "○"}, 
			{"●", "○", "○", "○", "○"}, 
			{"☼", "●", "○", "○", "○"}, 
			{"☼", "●", "○", "●", "●"}}, battleship.board());
		assertEquals(1, battleship.hits());
		assertEquals(0, battleship.sunk());
		assertEquals(1, battleship.points());
		battleship = null;
	}
	
	@Test
	public void test04() {
		Battleship battleship = new Battleship(new String[] {"A1", "B1", "D1", "E1", "A3", "A4", "D3", "E4", "D5"}, new String[] {"A1", "B2", "C3", "D4", "E5", "E4"});
		assertArrayEquals(new String[][] {
			{"☀", "○", "●", "●", "○"}, 
			{"●", "☼", "○", "○", "○"}, 
			{"○", "○", "☼", "○", "○"}, 
			{"●", "○", "●", "☼", "●"}, 
			{"●", "○", "○", "☀", "☼"}}, battleship.board());
		assertEquals(2, battleship.hits());
		assertEquals(0, battleship.sunk());
		assertEquals(2, battleship.points());
		battleship = null;
	}
	
	@Test
	public void test05() {
		Battleship battleship = new Battleship(new String[] {"A1", "B1", "D1", "E1", "A3", "A4", "D3", "E4", "D5"}, new String[] {"A2", "B4", "C1", "D3", "E5", "A5"});
		assertArrayEquals(new String[][] {
			{"●", "☼", "●", "●", "☼"}, 
			{"●", "○", "○", "☼", "○"}, 
			{"☼", "○", "○", "○", "○"}, 
			{"●", "○", "☀", "○", "●"}, 
			{"●", "○", "○", "●", "☼"}}, battleship.board());
		assertEquals(1, battleship.hits());
		assertEquals(0, battleship.sunk());
		assertEquals(1, battleship.points());
		battleship = null;
	}
	
	@Test
	public void test06() {
		Battleship battleship = new Battleship(new String[] {"A1", "B1", "D1", "E1", "A3", "A4", "D3", "E4", "D5"}, new String[] {"A1", "B1", "D1", "E1", "A3", "A4"});
		assertArrayEquals(new String[][] {
			{"☀", "○", "☀", "☀", "○"}, 
			{"☀", "○", "○", "○", "○"}, 
			{"○", "○", "○", "○", "○"}, 
			{"☀", "○", "●", "○", "●"}, 
			{"☀", "○", "○", "●", "○"}}, battleship.board());
		assertEquals(6, battleship.hits());
		assertEquals(3, battleship.sunk());
		assertEquals(12, battleship.points());
		battleship = null;
	}
	
	@Test
	public void test07() {
		Battleship battleship = new Battleship(new String[] {"A2", "A4", "C1", "C2", "E3", "C4", "C5", "D3", "E5"}, new String[] {"A1", "B2", "C3", "D4", "E5", "E4"});
		assertArrayEquals(new String[][] {
			{"☼", "●", "○", "●", "○"}, 
			{"○", "☼", "○", "○", "○"}, 
			{"●", "●", "☼", "●", "●"}, 
			{"○", "○", "●", "☼", "○"}, 
			{"○", "○", "●", "☼", "☀"}}, battleship.board());
		assertEquals(1, battleship.hits());
		assertEquals(0, battleship.sunk());
		assertEquals(1, battleship.points());
		battleship = null;
	}
	
	@Test
	public void test08() {
		Battleship battleship = new Battleship(new String[] {"A2", "A4", "C1", "C2", "E3", "C4", "C5", "D3", "E5"}, new String[] {"A2", "B4", "C1", "D3", "E5", "A5"});
		assertArrayEquals(new String[][] {
			{"○", "☀", "○", "●", "☼"}, 
			{"○", "○", "○", "☼", "○"}, 
			{"☀", "●", "○", "●", "●"}, 
			{"○", "○", "☀", "○", "○"}, 
			{"○", "○", "●", "○", "☀"}}, battleship.board());
		assertEquals(4, battleship.hits());
		assertEquals(0, battleship.sunk());
		assertEquals(4, battleship.points());
		battleship = null;
	}
	
	@Test
	public void test09() {
		Battleship battleship = new Battleship(new String[] {"A2", "A4", "C1", "C2", "E3", "C4", "C5", "D3", "E5"}, new String[] {"A1", "B1", "D1", "E1", "A3", "A4"});
		assertArrayEquals(new String[][] {
			{"☼", "●", "☼", "☀", "○"}, 
			{"☼", "○", "○", "○", "○"}, 
			{"●", "●", "○", "●", "●"}, 
			{"☼", "○", "●", "○", "○"}, 
			{"☼", "○", "●", "○", "●"}}, battleship.board());
		assertEquals(1, battleship.hits());
		assertEquals(0, battleship.sunk());
		assertEquals(1, battleship.points());
		battleship = null;
	}
}

import org.junit.Test;
import static org.junit.Assert.*;

public class nQueensTest {
    @Test public void testInValidPlacement() {
        ChessBoard board = new ChessBoard();

        board.addPiece(new Queen(1,1));

        assertFalse("Can't place queen on another queen",
            board.canSafelyPlacePiece(new Queen(1,1)));

        assertFalse("Can't place queen on another queen's diagonal",
            board.canSafelyPlacePiece(new Queen(0,0)));

        assertFalse("Can't place queen on another queen's diagonal",
            board.canSafelyPlacePiece(new Queen(2,2)));
        
        assertFalse("Can't place queen on another queen's diagonal",
            board.canSafelyPlacePiece(new Queen(0,2)));

        assertFalse("Can't place queen on another queen's diagonal",
            board.canSafelyPlacePiece(new Queen(2,0)));


        assertFalse("Can't place queen out of range",
            board.canSafelyPlacePiece(new Queen(100,5)));

        assertFalse("Can't place queen out of range",
            board.canSafelyPlacePiece(new Queen(1,50)));

        assertFalse("Can't place queen out of range",
            board.canSafelyPlacePiece(new Queen(100,-1)));
            
        assertFalse("Can't place queen out of range",
            board.canSafelyPlacePiece(new Queen(-1,4)));
    }

    @Test public void testValidPlacement() {
        ChessBoard board = new ChessBoard();

        board.addPiece(new Queen(0,0));

        assertTrue("can place queen somewhere safe",
            board.canSafelyPlacePiece(new Queen(2,5)));
    }

    @Test public void testSameLinePlacement() {
        ChessBoard board = new ChessBoard();

        board.addPiece(new Queen(0,0));

        Queen q2 = new Queen(2,1);
        assertTrue("can place queen somewhere safe",
            board.canSafelyPlacePiece(q2));
        board.addPiece(q2);

        assertFalse("cannot place queen on straight line diagonal",
            board.canSafelyPlacePiece(new Queen(4,2)));
    }

    @Test public void testSameLinePlacementOtherDirection() {
        ChessBoard board = new ChessBoard();

        board.addPiece(new Queen(0,0));

        Queen q2 = new Queen(1,2);
        assertTrue("can place queen somewhere safe",
            board.canSafelyPlacePiece(q2));
        board.addPiece(q2);

        assertFalse("cannot place queen on straight line diagonal",
            board.canSafelyPlacePiece(new Queen(2,4)));
    }

    @Test public void testSameLinePlacementExtraPiecesSafe() {
        ChessBoard board = new ChessBoard();

        board.addPiece(new Queen(0,0));

        //Does affect the three piece limit.
        Queen q3 = new Queen(5,6);
        assertTrue("can place queen somewhere safe",
            board.canSafelyPlacePiece(q3));
        board.addPiece(q3);

        Queen q2 = new Queen(1,2);
        assertFalse("can place queen somewhere safe",
            board.canSafelyPlacePiece(q2));

    }

    @Test public void testSameLinePlacementExtraPiecesNotSafe() {
        ChessBoard board = new ChessBoard();
        board.addPiece(new Queen(0,0));

        //Doesn't affect the three piece limit.
        Queen q3 = new Queen(6,1);
        assertTrue("can place queen somewhere safe",
            board.canSafelyPlacePiece(q3));
        board.addPiece(q3);

        Queen q2 = new Queen(1,2);
        assertTrue("can place queen somewhere safe",
            board.canSafelyPlacePiece(q2));
        board.addPiece(q2);

        assertFalse("cannot place queen on straight line diagonal",
            board.canSafelyPlacePiece(new Queen(2,4)));
    }

}
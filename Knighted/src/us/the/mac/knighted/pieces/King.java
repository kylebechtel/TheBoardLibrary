package us.the.mac.knighted.pieces;

import us.the.mac.board.Board.Piece;
import us.the.mac.knighted.R;
import android.content.Context;
import android.util.AttributeSet;


public class King extends Piece{
	
	public King(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void setUpMoves() {
		int kingsremaining = 4;
		for(int i = 1; i<=kingsremaining; i++){
			move_1 = validateMove(i*MOVE_UP);// 6
			move_2 = validateMove(i*MOVE_LEFT);// 15;
			move_3 = validateMove(i*MOVE_DOWN);// 17;
			move_4 = validateMove(i*MOVE_RIGHT);// 10;
			move_5 = validateMove(i*MOVE_DOWN_RIGHT);// -6;
			move_6 = validateMove(i*MOVE_DOWN_LEFT);// -15;
			move_7 = validateMove(i*MOVE_UP_LEFT);// -17;
			move_8 = validateMove(i*MOVE_UP_RIGHT);// -10;
			
		}
	}
	
private int validateMove(int move) {
		
		int possibleMove = fromCurPos(move);
		Piece p = getPieceAt(possibleMove);
		
		boolean hasPiece = p != null;
		boolean isOpponent = hasPiece && p.isOpponent(color);
		
		if(isOpponent || !hasPiece) 
			return possibleMove;
		
		return INVALID_MOVE;
	}
	
	
		
	protected int firstColor() {
		return R.drawable.k__;
	}
	
	@Override
	protected int secondColor() {
		return R.drawable.k_;
	}
	
	protected String pieceLetter() {
		return "K";
	}

}

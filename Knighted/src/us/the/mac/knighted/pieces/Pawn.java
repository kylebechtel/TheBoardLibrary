package us.the.mac.knighted.pieces;

import us.the.mac.board.Board.Piece;
import us.the.mac.knighted.R;
import android.content.Context;
import android.util.AttributeSet;

public class Pawn extends Piece {

	public Pawn(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	
	@Override
	public void setUpMoves() {
	move_1 = validateMove(MOVE_UP);// 6;
	move_2 = validateAttack(MOVE_UP_LEFT);// 15;
	move_3 = validateAttack(MOVE_UP_RIGHT);// 17;
	move_4 = INVALID_MOVE;
	move_5 = INVALID_MOVE;
	move_6 = INVALID_MOVE;
	move_7 = INVALID_MOVE;
	move_8 = INVALID_MOVE;
	}
	
	//allows the pawn to be promoted to another piece
	private void promotion(int location){
		//should call a method that goes to the 
		//UI allowing the user to select a piece
		//for upgrading. 
		Piece p = getPieceAt(location);
		
		
		//will then place piece at current location
		//and remove pawn.
	}
	
	
	//Checks forward left/right for opponent piece
	private int validateAttack(int move) {
		
		int possibleMove = fromCurPos(move);
		Piece p = getPieceAt(possibleMove);
		
		boolean hasPiece = p != null;
		boolean isOpponent = hasPiece && p.isOpponent(color);
		
		if(isOpponent) 
			return possibleMove;
		
		return INVALID_MOVE;
	}
	
	private int validateMove(int move) {
		
		int possibleMove = fromCurPos(move);
		Piece p = getPieceAt(possibleMove);
		
		boolean hasPiece = p != null;
		
		if(!hasPiece) 
			return possibleMove;
		
		return INVALID_MOVE;
	}
	
	
	protected int firstColor() {
		return R.drawable.p__;
	}

	@Override
	protected int secondColor() {
		return R.drawable.p_;
	}
	
	protected String pieceLetter() {
		return "P";
	}
	
	

}

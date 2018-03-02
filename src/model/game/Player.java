package model.game;

import java.util.ArrayList;

public class Player {
	private String name;
	private int payloadPos;
	private int sideKilled;
	//object until we make class Piece
	private ArrayList<Object> deadCharacters;
	
	public Player(String name) {
		this.name = name;
		deadCharacters = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public int getPayloadPos() {
		return payloadPos;
	}
	
	public void setPayloadPos(int payloadPos) {
		this.payloadPos = payloadPos;
	}
	
	public int getSideKilled() {
		return sideKilled;
	}
	
	public void setSideKilled(int sideKilled) {
		this.sideKilled = sideKilled;
	}
	
	public ArrayList<Object> getDeadCharacters() {
		return deadCharacters;
	}
}

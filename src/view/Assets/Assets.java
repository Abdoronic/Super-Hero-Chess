package view.Assets;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.TreeMap;

import javax.swing.ImageIcon;

public class Assets {
	
	private int frameWidth;
	private int frameHeight;
	private int cellWidth;
	private int cellHeight;
	TreeMap<String, Image> characters;
	
	public Assets() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameWidth = (int)screenSize.getWidth();
		frameHeight = (int)screenSize.getHeight();
		cellWidth = frameWidth/7;
		cellHeight = frameHeight/7;
		loadCharacters();
	}
	
	public Font getGameFont(Float size) {
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, Assets.class.getResourceAsStream("gameFont.ttf"));
		} catch(Exception ex) {
			System.out.println("File not Found!");
		}
		font = font.deriveFont(size);
		return font;
	}
	
	public TreeMap<String, Image> getCharacters() {
		return characters;
	}
	
	public Image getCharacter(String name) {
		return characters.get(name);
	}
	
	
	public int getFrameWidth() {
		return frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public int getCellWidth() {
		return cellWidth;
	}

	public int getCellHeight() {
		return cellHeight;
	}

	public void loadCharacters() {
		characters = new TreeMap<>();
		ImageIcon character = null;
		Image scaledCharacter = null;
		String[] names = {"ArmoredP1", "ArmoredP2", "MedicP1", "MedicP2", "RangedP1",
				"RangedP2", "SideKickP1", "SideKickP2", "SpeedsterP1", "SpeedsterP2",
				"SuperP1", "SuperP2", "TechP1", "TechP2"};
		for(String name : names) {
			character = new ImageIcon(Assets.class.getResource(name + ".gif"));
			int widthMargin = 0;
			int heightMargin = 0;
			scaledCharacter = character.getImage().getScaledInstance
					(cellWidth - widthMargin, cellHeight - heightMargin,Image.SCALE_DEFAULT);
			characters.put(name, scaledCharacter);
		}
	}

}

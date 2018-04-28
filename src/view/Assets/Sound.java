package view.Assets;

import java.io.FileInputStream;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Sound {

	private AudioPlayer backgroundPlayer = AudioPlayer.player;
	private AudioStream BG;
	private AudioData AD = null;
	private ContinuousAudioDataStream loop = null;

	public Sound() {
//		String path = Assets.class.getResource("movinout.wav").toString();
		try {
			BG = new AudioStream(new FileInputStream("movinout.wav"));
			AD = BG.getData();
			loop = new ContinuousAudioDataStream(AD);
		} catch (Exception ex) {
			System.out.println("File not fond");
		}

	}

	public void startMusic() {
		backgroundPlayer.start(loop);
	}

	public void stopMusic() {
		backgroundPlayer.stop(loop);
	}

	public void PlayAttackSound() {
//		String path = Assets.class.getResource("attack.wav").toString();
		try {
			backgroundPlayer.start(new AudioStream(new FileInputStream("attack.wav")));
		} catch (Exception ex) {
			System.out.println("File not Found");
		}
	}

	public void playAbilitySound() {
//		String path = Assets.class.getResource("ability.wav").toString();
		try {
			backgroundPlayer.start(new AudioStream(new FileInputStream("ability.wav")));
		} catch (Exception ex) {
			System.out.println("File not Found");
		}
	}

	public void playWinSound() {
//		String path = Assets.class.getResource("win.wav").toString();
		try {
			backgroundPlayer.start(new AudioStream(new FileInputStream("win.wav")));
		} catch (Exception ex) {
			System.out.println("File not Found");
		}
	}
	

}
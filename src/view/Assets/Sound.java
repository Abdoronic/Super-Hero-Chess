package view.Assets;

import java.io.FileInputStream;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Sound {

	private AudioPlayer backgroundPlayer = AudioPlayer.player;
	private AudioStream BG;
	private AudioData AD;
	private ContinuousAudioDataStream loop;

	public Sound() {
		try {
			BG = new AudioStream(new FileInputStream("movinout.wav"));
			AD = BG.getData();
			loop = new ContinuousAudioDataStream(AD);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void startMusic() {
		backgroundPlayer.start(loop);
	}

	public void stopMusic() {
		backgroundPlayer.stop(loop);
	}

	public void PlayAttackSound() {

		try {
			backgroundPlayer.start(new AudioStream(new FileInputStream("attack.wav")));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void playAbilitySound() {
		try {
			backgroundPlayer.start(new AudioStream(new FileInputStream("ability.wav")));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void playWinSound() {
		try {
			backgroundPlayer.start(new AudioStream(new FileInputStream("win.wav")));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
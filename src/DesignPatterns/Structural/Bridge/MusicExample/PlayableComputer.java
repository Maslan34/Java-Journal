package DesignPatterns.Structural.Bridge.MusicExample;

public abstract class PlayableComputer {

    protected VoiceDevice voiceDevice;
    protected MusicPlayer musicPlayer;

    public PlayableComputer() {

    }

    public PlayableComputer(VoiceDevice voiceDevice, MusicPlayer musicPlayer) {
        this.voiceDevice = voiceDevice;
        this.musicPlayer = musicPlayer;

    }

    void playMusic(Music music) {
        String voice =musicPlayer.playMusic(music);
        voiceDevice.playVoice(voice);
    }

    public void setVoiceDevice(VoiceDevice voiceDevice) {
        this.voiceDevice = voiceDevice;
    }

    public void setMusicPlayer(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }
}

package DesignPatterns.Structural.Bridge.MusicExample;

public class Computer {

    private Spotify spotify;
    private Speaker speaker;

    public Computer(){
        spotify = new Spotify();
        speaker = new Speaker();
    }

    public void playMusic(Music music){
        System.out.println("Computer Worked");
        String Voice = spotify.playMusic(music);
        speaker.playVoice(Voice);
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Spotify getSpotify() {
        return spotify;
    }

    public void setSpotify(Spotify spotify) {
        this.spotify = spotify;
    }
}

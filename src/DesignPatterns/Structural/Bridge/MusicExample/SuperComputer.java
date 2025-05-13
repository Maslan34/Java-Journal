package DesignPatterns.Structural.Bridge.MusicExample;

public class SuperComputer extends PlayableComputer{
    public SuperComputer() {
        this.voiceDevice = new HeadPhone();
        this.musicPlayer=  new Fizy();
    }

    @Override
    void playMusic(Music music) {
        System.out.println("Super Computer Worked");
        super.playMusic(music);
    }
}

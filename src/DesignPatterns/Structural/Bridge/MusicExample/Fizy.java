package DesignPatterns.Structural.Bridge.MusicExample;

public class Fizy implements MusicPlayer{

    @Override
    public String playMusic(Music music) {
        System.out.println("Fizy is playing " + music.getTitle()+" song");
        return  music.getTitle();
    }
}

package DesignPatterns.Structural.Bridge.MusicExample;

public class Spotify {


    public String playMusic(Music music) {
        System.out.println("Spotify is playing " + music.getTitle() +" song.");

        return music.getTitle();
    }
}

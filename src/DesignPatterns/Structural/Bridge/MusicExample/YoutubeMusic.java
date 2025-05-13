package DesignPatterns.Structural.Bridge.MusicExample;

public class YoutubeMusic  implements MusicPlayer{

    @Override
    public String playMusic(Music music) {
        System.out.println("Youtube Music is playing " + music.getTitle()+" song");
        return  music.getTitle();
    }
}

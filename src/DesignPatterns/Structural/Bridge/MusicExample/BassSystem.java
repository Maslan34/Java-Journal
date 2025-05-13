package DesignPatterns.Structural.Bridge.MusicExample;

public class BassSystem implements VoiceDevice{

    @Override
    public void playVoice(String voice) {
        System.out.println("Bass System is playing voice:"+voice);

    }
}


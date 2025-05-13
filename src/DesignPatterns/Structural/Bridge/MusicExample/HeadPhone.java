package DesignPatterns.Structural.Bridge.MusicExample;

public class HeadPhone implements VoiceDevice{

    @Override
    public void playVoice(String voice) {
        System.out.println("Head Phone is playing voice:"+voice);

    }
}

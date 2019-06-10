package com.starry.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.starry.game.Ball.BallManager;

public class MusicManager
{
    Music mp3Music;
    private static MusicManager instance;
    public static synchronized MusicManager getInstance(){
        if(instance == null){
            instance = new MusicManager();
        }
        return instance;
    }

    public void PlayMusic(String strPath)//"data/Logo_BGM.mp3"
    {

        if(mp3Music != null)
        {
            mp3Music.stop();
            mp3Music.dispose();
        }
        mp3Music = Gdx.audio.newMusic(Gdx.files.internal(strPath));
        if(mp3Music != null)
            mp3Music.play();

    }


    public void Caching(String strPath)
    {

    }
    public void PlayEffect(String strPath)
    {
        Sound newSound = Gdx.audio.newSound(Gdx.files.internal(strPath));
        newSound.play();
    }
}

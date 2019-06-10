package com.starry.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.starry.game.Ball.BallManager;

import java.util.HashMap;

public class MusicManager
{
    Music mp3Music;
    public PlatformService service;
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

    HashMap<String, Sound> soundHashMap = new HashMap<String, Sound>();

    public void Caching(String strPath)
    {
        soundHashMap.put(strPath, Gdx.audio.newSound(Gdx.files.internal(strPath)));
    }

    public void PlayEffect(String strPath)
    {
        soundHashMap.get(strPath).play();
    }
}

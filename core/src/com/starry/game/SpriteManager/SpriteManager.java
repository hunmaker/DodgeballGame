package com.starry.game.SpriteManager;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

///스프라이트 등록후 일괄렌더, 렌더가 복잡해질만큼 많이 필요하면 추가
public class SpriteManager
{
    private static SpriteManager instance;
    public static synchronized SpriteManager getInstance(){
        if(instance == null){
            instance = new SpriteManager();
        }
        return instance;
    }


    private List<Batch> batchList = new ArrayList<Batch>();

    //등록
    public void Enlist(Batch batch)
    {

    }

    //해제
    public void Delist(Batch batch)
    {

    }
}

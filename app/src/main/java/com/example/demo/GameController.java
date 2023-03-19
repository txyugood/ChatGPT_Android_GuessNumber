package com.example.demo;

public class GameController {

    private GameModel gameModel; // 一个GameController对象对应一个GameModel对象

    public GameController() {
        gameModel = new GameModel(); // 在构造函数中创建一个GameModel对象
    }

    public String guess(String guessStr) { // 猜数字的方法
        return gameModel.guess(guessStr); // 调用GameModel中的guess方法
    }

    public void reset() { // 重置游戏的方法
        gameModel.reset(); // 调用GameModel中的reset方法
    }
}

package com.example.demo;

import java.util.Arrays;

public class GameModel {
    private int[] answer; // 存储答案的数组
    private int tries; // 猜测的次数

    public GameModel() {
        reset(); // 初始化答案和次数
    }

    // 猜测方法，接收一个字符串参数，表示用户猜测的数字
    public String guess(String guessStr) {
        if (guessStr.length() != 4) { // 如果猜测的数字长度不为4，则返回提示信息
            return "请输入4个数字";
        }

        int[] guess = new int[4]; // 用于存储猜测的数字
        for (int i = 0; i < 4; i++) {
            char c = guessStr.charAt(i); // 获取猜测数字的每一位
            if (c < '0' || c > '9') { // 如果不是数字，则返回提示信息
                return "请输入4个数字";
            }
            guess[i] = c - '0'; // 将字符转换为数字，并存储到数组中
        }

        int a = 0, b = 0; // 分别表示数字和位置都猜对的个数和数字猜对但位置不对的个数
        for (int i = 0; i < 4; i++) {
            if (guess[i] == answer[i]) { // 如果数字和位置都猜对，则a加1
                a++;
            } else {
                for (int j = 0; j < 4; j++) {
                    if (guess[i] == answer[j]) { // 如果数字猜对但位置不对，则b加1
                        b++;
                        break;
                    }
                }
            }
        }

        tries++; // 猜测次数加1
        if (a == 4) { // 如果全部猜对，则返回恭喜信息和总共猜测次数
            return "恭喜你猜对了，总共猜了" + tries + "次";
        } else { // 否则返回当前猜测次数和猜对的数字和位置的个数和猜对的数字但位置不对的个数
            return "第" + tries + "次猜测，" + a + "A" + b + "B";
        }
    }

    // 重置答案和猜测次数
    public void reset() {
        answer = generateAnswer(); // 生成新的答案
        tries = 0; // 猜测次数归零
    }

    private int[] generateAnswer() { // 生成答案的方法
        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // 用来存储可选数字的数组
        int[] answer = new int[4]; // 用来存储答案的数组
        for (int i = 0; i < 4; i++) { // 循环4次，每次从digits数组中取出一个数字加入answer数组
            int j = (int) (Math.random() * (10 - i)); // 生成一个随机数j，使得0<=j<10-i，表示在digits数组中剩余可选数字的数量中随机选择一个数字的下标
            answer[i] = digits[j]; // 将digits[j]加入answer数组中
            digits[j] = digits[9 - i]; // 将digits[j]与digits数组中剩余可选数字的最后一个数字交换，保证每次随机选择的数字不重复
        }
        return answer; // 返回答案
    }

}

package homeTask20240111.pattern;

import homeTask20240111.pattern.exchanger.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger videoExchanger = new Exchanger("Video");
        Exchanger audioExchanger = new Exchanger("Audio");
        Exchanger gameExchanger = new Exchanger("Game");

        Thread videoThread = new Thread(videoExchanger::exchange);
        Thread audioThread = new Thread(audioExchanger::exchange);
        Thread gameThread = new Thread(gameExchanger::exchange);

        videoThread.start();
        audioThread.start();
        gameThread.start();

        try {
            videoThread.join();
            audioThread.join();
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


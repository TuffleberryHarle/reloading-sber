package com.counting;

import java.io.File;
import java.util.Scanner;

import static com.counting.Constants.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        File f = new File("./0.out");
        if (!f.isFile()) {
            Counter counter = new Counter();
            counter.write(0);
        }

        Main main = new Main();
        main.start();

    }


    public void start() {
        Counter counter = new Counter();
        counter.setCounter(counter.read());
        Scanner scanner = new Scanner(System.in);

        System.out.print(STARTING_INFO);
        System.out.format(DISPLAYING_INFO, counter.getCounter());
        System.out.print(PENDING_INFO);

        int outHc = 4;

        do {
            String command = scanner.nextLine().trim();
            int inHc = command.hashCode();
            switch (inHc) {
                case 1453974144:
                    if (command.equals(RESETTING))
                        counter.handler((byte) 1);
                    outHc = inHc;
                    break;
                case 1504591:
                    if (command.equals(INCREMENTING))
                        counter.handler((byte) 2);
                    outHc = inHc;
                    break;
                case 46946481:
                    if (command.equals(STOPPING))
                        counter.handler((byte) 3);
                    outHc = 0;
                    break;
                default:
                    System.out.print("Какую-то дичь мне втираешь...\nПопробуй снова!\n");
            }
        }
        while (outHc > 3);
    }
}

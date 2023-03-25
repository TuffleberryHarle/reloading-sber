package com.counting;

import java.io.*;

import static com.counting.Constants.*;

public class Counter implements Serializable {

    public int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void handler(byte var) {

        try {
            switch (var) {
                case 1:
                    reset();
                    break;
                case 2:
                    increment();
                    break;
                case 3:
                    stop();
                default:
            }
        } catch (Exception ex) {
            System.out.print("Какую-то дичь мне втираешь...\n###\n");
        }
    }

    private void reset() {
        System.out.print(RESETTING_INFO);
        this.setCounter(0);
        System.out.format(DISPLAYING_INFO, this.getCounter());
        this.write(getCounter());
        System.out.print(PENDING_INFO);
    }

    private void increment() {
        System.out.print(INCREMENTING_INFO);
        int num = this.getCounter();
        this.setCounter(++num);
        System.out.format(DISPLAYING_INFO, this.getCounter());
        this.write(getCounter());
        System.out.print(PENDING_INFO);
    }

    private void stop() {
        System.out.format(DISPLAYING_INFO, this.getCounter());
        System.out.print(STOPPING_INFO);
        this.write(getCounter());
    }

    protected void write(int num) {
        Counter counter = new Counter();
        counter.setCounter(num);

        try
                (FileOutputStream fos = new FileOutputStream("0.out");
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected int read() {
        Counter readObject = null;
        try
                (FileInputStream fis = new FileInputStream("0.out");
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
            readObject = (Counter) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return readObject != null ? readObject.getCounter() : 0;
    }

}

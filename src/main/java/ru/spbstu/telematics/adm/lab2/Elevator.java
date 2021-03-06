package ru.spbstu.telematics.adm.lab2;

import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author klyushkin
 *
 * @ToDO Лифт. Лифт имеет максимальную вместимость 10 человек. В модели системы
 * управления лифтом, пассажиры входящие в лифт обозначены действием «enter» а
 * пассажиры, выходящие из лифта, обозначены действием «exit». В лифте не может
 * быть больше 10 человек. Построить модель системы в которой каждый пассажир и
 * лифт представлены отдельными потоками.
 */
public class Elevator implements Runnable { // класс, описывающий лифт

    static private final int maxPeople = 10;      // максимальное кол-во людей в лифте
    static Semaphore countPpl = new Semaphore(maxPeople);
    static Semaphore isMoving = new Semaphore(1);       // лифт двигается
    //=========================== Move Up ======================================

    private void moveUp() { // движение вверх
        try {
            isMoving.acquire(); // лифт поехал
        } catch (InterruptedException ex) {
            Logger.getLogger(Elevator.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println(new Date() + " Elevator moves up");
            Thread.sleep(5000); //едем 5 сек
        } catch (InterruptedException ex) {
            Logger.getLogger(Elevator.class.getName()).log(Level.SEVERE, null, ex);
        }
        isMoving.release(); // не едем больше
    }
    //==========================================================================

    //========================== Move Down =====================================
    private void moveDown() { //движение вниз
        try {
            isMoving.acquire(); //лифт поехал
        } catch (InterruptedException ex) {
            Logger.getLogger(Elevator.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println(new Date() + " Elevator moves down");
            Thread.sleep(5000); //едем
        } catch (InterruptedException ex) {
            Logger.getLogger(Elevator.class.getName()).log(Level.SEVERE, null, ex);
        }
        isMoving.release();//больше не едем
    }
    //==========================================================================

    //=========================== Wait People ==================================
    private void waitPeople() { //выпускаем и запускаем людей
        System.out.println(new Date() + " Elevator waiting!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Elevator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //==========================================================================

    @Override
    public void run() {
        while (true) {

            waitPeople();
            moveUp();
            waitPeople();
            moveDown();

        }
    }

    private static class People implements Runnable {

        private void enter() {
//            System.out.println(new Date() + " " + Thread.currentThread().getName() + " try enter");
            
                try {
                    countPpl.acquire(); //можно войти?
                    isMoving.acquire(); //лифт стоит?
                    isMoving.release(); 
                } catch (InterruptedException ex) {
                    Logger.getLogger(Elevator.class.getName()).log(Level.SEVERE, null, ex);
                }
           
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " enter");
        }

        private void exit() {
//            System.out.println(new Date() + " " + Thread.currentThread().getName() + " try"
//                    + "exit");
            try {
                isMoving.acquire(); //можно выйти?
                countPpl.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Elevator.class.getName()).log(Level.SEVERE, null, ex);
            }
            isMoving.release();
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " exit");
        }

        @Override
        public void run() {
            enter();
            try {
                Thread.sleep(6000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Elevator.class.getName()).log(Level.SEVERE, null, ex);
            }
            exit();
        }

    }
/*
    будем считать, что люди не все на первом этаже
    */
    public static void main(String[] args) {
        Thread thread = new Thread(new Elevator(), "Elevator");
        thread.start();
        for (int i = 0; i < 10; i++) {
            new Thread(new People(), "People№ "+ i).start();
        }
    }

}

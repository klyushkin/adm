package ru.spbstu.telematics.adm.lab2;

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
public class Elevator implements Runnable{ // класс, описывающий лифт
    public int countPeople = 0;            // число людей в лифте
    private final int maxPeople = 10;      // максимальное кол-во людей в лифте
    public Boolean isMoving = false;       // лифт двигается

    synchronized public int getCountPeople() {
        return countPeople;
    }

    synchronized public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }
    //=========================== Move Up ======================================
    synchronized void moveUp(){
        isMoving = true;
        try {
            System.out.println("Elevetor moving up");
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Elevator.class.getName()).log(Level.SEVERE, null, ex);
        }
        isMoving = false;
    }
    //==========================================================================
    
    //========================== Move Down =====================================
    synchronized void moveDown(){
        isMoving = true;
        try {
            System.out.println("Elevetor moving down");
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Elevator.class.getName()).log(Level.SEVERE, null, ex);
        }
        isMoving = false;
    }
    //==========================================================================
    
    //=========================== Wait People ==================================
    private void waitPeople(){
        System.out.println("Wait People! You can eneter!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Elevator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //==========================================================================
    
    @Override
    public void run() {
        waitPeople();
        moveUp();
        waitPeople();
        moveDown();
    }
    
}

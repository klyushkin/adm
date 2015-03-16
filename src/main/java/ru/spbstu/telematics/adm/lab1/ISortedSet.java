/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.spbstu.telematics.adm.lab1;

/**
 *
 * @author alexandr
 */
/**
 * Коллекция-множество хранит данные в упорядоченном порядке
 */

public interface ISortedSet<T extends Comparable<T>> {

    /**
     * Добавить элемент в дерево
     *
     * @param e
     */
    void add(T e);

    /**
     * Удалить элемент из дерева
     */
    boolean remove(T o);

    /**
     * Возвращает true, если элемент содержится в дереве
     */
    boolean contains(T o);
}

/**
 * @param args the command line arguments
 */

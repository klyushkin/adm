/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.spbstu.telematics.labs;

/**
 *
 * @author alexandr
 */
/**
 * Коллекция-множество хранит данные в упорядоченном порядке
 */
public interface ISortedSet {

    /**
     * Добавить элемент в дерево
     *
     * @param e
     */
    void add(Comparable e);

    /**
     * Удалить элемент из дерева
     */
    boolean remove(Comparable o);

    /**
     * Возвращает true, если элемент содержится в дереве
     */
    boolean contains(Comparable o);
}

/**
 * @param args the command line arguments
 */

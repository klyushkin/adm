/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.spbstu.telematics.labs;

import java.util.Iterator;

/**
 *
 * @author alexandr
 */
public class MySortedSet<T extends Comparable<T>> implements ISortedSet<T>, Iterable<T> {

    private class Tree {

        public T data;
        Tree left;
        Tree right;

        public Tree(T data) {
            this.data = data;
        }

        public Tree() {
        }

        public void setData(T data) {
            this.data = data;
        }

        public void add(Tree node) {
            if (node.data.compareTo(data) == -1) {
                if (left != null) {
                    left.add(node);
                } else {
                    left = node;
                }
            } else if (right != null) {
                right.add(node);
            } else {
                right = node;
            }
        }

    }

    private Tree tree = null;

    /**
     * Добавить элемент в дерево
     *
     */
    @Override
    public void add(T e) {
        if (tree == null) {
            tree = new Tree(e);
        } else {
            tree.add(new Tree(e));
        }
    }

    /**
     * Удалить элемент из дерева
     */
    @Override
    public boolean remove(T o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Возвращает true, если элемент содержится в дереве
     */
    @Override
    public boolean contains(T o) {

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

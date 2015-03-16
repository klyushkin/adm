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
public class SortedSet implements ISortedSet {

    private class Tree {

        public Object data;
        Tree left;
        Tree right;

        public Tree(Object data) {
            this.data = data;
        }

        public Tree() {
        }

        public void setData(Object data) {
            this.data = data;
        }

        public void add(Tree node) {
            if (node.data.hashCode() < data.hashCode()) {
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
        public boolean contains(Object o){
            
            
            return true;
        }

    }
    
    
    public Tree tree = new Tree();

    /**
     * Добавить элемент в дерево
     *
     */
    @Override
    public void add(Comparable e) {
        Tree newTree = new Tree(e);
        newTree.add(tree);
    }

    /**
     * Удалить элемент из дерева
     */
    @Override
    public boolean remove(Comparable o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Возвращает true, если элемент содержится в дереве
     */
    @Override
    public boolean contains(Comparable o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

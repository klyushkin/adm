/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.spbstu.telematics.adm.lab1;

import java.util.Iterator;
import java.util.Stack;

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

        public Tree(Tree tree) {
            this.data = tree.data;
            this.left = tree.left;
            this.right = tree.right;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void insert(Tree node) {
            if (node.data.compareTo(data) < 1) {
                if (left != null) {
                    left.insert(node);
                } else {
                    left = node;
                }
            } else {
                if (right != null) {
                    right.insert(node);
                } else {
                    right = node;
                }
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
            tree.insert(new Tree(e));
        }
    }

    /**
     * Удалить элемент из дерева
     *
     * @param o
     * @return
     */
    @Override
    public boolean remove(T o) {
        Tree treeToRemove = findToRemove(o, tree, null);
        if (treeToRemove != null) {
            recurciveAdd(treeToRemove);
            return true;
        }
        return false;
    }

    private void recurciveAdd(Tree tree) {
        if (tree.left != null) {
            add(tree.left.data);
            recurciveAdd(tree.left);
        }

        if (tree.right != null) {
            add(tree.right.data);
            recurciveAdd(tree.right);
        }

    }

    private Tree findToRemove(T o, Tree targetTree, Tree parent) {
        int compare = targetTree.data.compareTo(o);
        if (compare == 0) {
            if (parent != null) {
                if (parent.left == targetTree) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else {
                targetTree = new Tree(this.tree);
                this.tree = null;
            }
            return targetTree;
        } else if (compare > 0) {
            if (targetTree.left != null) {
                return findToRemove(o, targetTree.left, targetTree);
            }
        } else if (compare < 0) {
            if (targetTree.right != null) {
                return findToRemove(o, targetTree.right, targetTree);
            }
        }
        return null;

    }

    private boolean traverse(T o, Tree tree) {
        int compare = tree.data.compareTo(o);
        if (compare == 0) {
            return true;
        } else if (compare > 0) {
            if (tree.left != null) {
                return traverse(o, tree.left);
            }
        } else if (compare < 0) {
            if (tree.right != null) {
                return traverse(o, tree.right);
            }
        }
        return false;
    }

    /**
     * Возвращает true, если элемент содержится в дереве
     *
     * @param o
     * @return
     */
    @Override
    public boolean contains(T o) {
        return traverse(o, tree);

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Stack stack = new Stack();

            {
                stack.push(tree);
            }

            @Override
            public boolean hasNext() {
                if (stack.empty()) {
                    return false;
                }
                return !stack.empty() || ((Tree) stack.peek()).left != null || ((Tree) stack.peek()).right != null;
            }

            @Override
            public T next() {
                Tree curent = (Tree) stack.pop();
                if (curent.left != null) {
                    stack.push(tree.left);
                }
                if (curent.right != null) {
                    stack.push(tree.right);
                }
                return curent.data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
    }
}

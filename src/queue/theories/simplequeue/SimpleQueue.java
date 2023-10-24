/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue.theories.simplequeue;

/**
 *
 * @author duyvu
 */
public class SimpleQueue<E extends Comparable<E>> {

    // ======================================
    // = Fields
    // ======================================
    Node head, tail;

    // ======================================
    // = Constructor
    // ======================================
    public SimpleQueue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // ======================================
    // = Utility Methods
    // ======================================
    /**
     * Add last node to the tail
     *
     * @param info
     */
    public void enqueue(E info) {
        Node p = new Node(info);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.nextNode = p;
            tail = p;
        }
    }

    /**
     * Remove first node
     *
     * @return
     */
    public Node dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node pNode = this.head;
        head = head.nextNode;
        return pNode;
    }

    /**
     * Observe the front of the queue
     *
     * @return
     */
    public Node front() {
        if (isEmpty()) {
            return null;
        }
        Node pNode = this.head;
        return pNode;
    }

    public void clear() {
        head = tail = null;
    }
}

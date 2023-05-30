package com.链表

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis


fun main() {


    val node = ListNode.createNode(1, 4, 3, 2, 5, 2)


    val value = partition(node, 3)
    println(ListNode.printNode(value));

}


fun partition(head: ListNode?, x: Int): ListNode? {
    var currentNode = head

    val minHeadNode = ListNode(-1)
    val maxHeadNode = ListNode(-1)

    var currentMinNode = minHeadNode
    var currentMaxNode = maxHeadNode

    while (currentNode != null) {
        if (currentNode.`val` < x) {
            currentMinNode.next = currentNode
            currentMinNode = currentMinNode.next
        } else {
            currentMaxNode.next = currentNode
            currentMaxNode = currentMaxNode.next
        }
        currentNode = currentNode.next
    }
    currentMinNode.next = maxHeadNode.next
    currentMaxNode.next = null
    return minHeadNode.next
}
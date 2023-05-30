package com.链表

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis


fun main() {


    val node1 = ListNode.createNode(1, 4, 5)
    val node2 = ListNode.createNode(1, 3, 4)
    val node3 = ListNode.createNode(2, 6)

    val input = arrayOf(node1, node2, node3)

    val value = mergeKLists(input)
    println(ListNode.printNode(value));

}


fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    return null
}

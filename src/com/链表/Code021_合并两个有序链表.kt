package com.链表

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis


fun main() {

    val nodeA1 = ListNode(1)
    val nodeA2 = ListNode(2)
    val nodeA3 = ListNode(4)

    val nodeB1 = ListNode(1)
    val nodeB2 = ListNode(3)
    val nodeB3 = ListNode(4)



    nodeA1.next = nodeA2
    nodeA2.next = nodeA3
    nodeB1.next = nodeB2
    nodeB2.next = nodeB3



    repeat(10) {
        val nodeA1 = ListNode(1)
        val nodeA2 = ListNode(2)
        val nodeA3 = ListNode(4)

        val nodeB1 = ListNode(1)
        val nodeB2 = ListNode(3)
        val nodeB3 = ListNode(4)



        nodeA1.next = nodeA2
        nodeA2.next = nodeA3
        nodeB1.next = nodeB2
        nodeB2.next = nodeB3

        val timeCost2 = measureNanoTime {
            val value = mergeTwoLists(nodeA1, nodeB1)
//        println(ListNode.printNode(value));
        }
        println("耗时 $timeCost2")
    }

}


fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

    val headNode = ListNode(0)
    var currentNode: ListNode = headNode
    var list1Point: ListNode? = list1
    var list2Point: ListNode? = list2

    while (list1Point != null && list2Point != null) {
        if (list1Point.`val` <= list2Point.`val`) {
            currentNode.next = list1Point
            list1Point = list1Point.next
        } else {
            currentNode.next = list2Point
            list2Point = list2Point.next
        }
        currentNode = currentNode.next
    }

    if (list1Point != null) {
        currentNode.next = list1Point
    } else if (list2Point != null) {
        currentNode.next = list2Point
    }
    return headNode.next
}


fun mergeTwoListsFast(list1: ListNode?, list2: ListNode?): ListNode? {
    var oldNode1: ListNode? = list1
    var oldNode2: ListNode? = list2
    var newNode = ListNode(0)
    var tempNode: ListNode? = newNode
    while (oldNode1 != null && oldNode2 != null) {
        if (oldNode1.`val` <= oldNode2.`val`) {
            tempNode?.next = oldNode1
            oldNode1 = oldNode1.next
        } else {
            tempNode?.next = oldNode2
            oldNode2 = oldNode2.next
        }
        tempNode = tempNode?.next
    }
    tempNode?.next = oldNode1 ?: oldNode2
    return newNode.next
}
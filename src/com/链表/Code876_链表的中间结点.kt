package com.链表


fun main() {


    val node = ListNode.createNode(1)

    val value = middleNode(node)
    println(ListNode.printNode(value));

}


fun middleNode(head: ListNode?): ListNode? {

    var left = head
    var right = head

    while (right != null && right.next != null) {
        left = left?.next
        right = right.next?.next
    }

    return left
}
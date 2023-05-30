package com.链表


fun main() {


    val node = ListNode.createNode(1,2,3,4,5)

    val value = removeNthFromEnd(node, 2)
    println(ListNode.printNode(value));

}


fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    // 虚拟头结点
    val dummy = ListNode(-1)
    dummy.next = head

    var right: ListNode? = dummy
    for (i in 0 until  n+1) {
        right = right?.next
    }

    var left: ListNode? = dummy

    while (right != null) {
        left = left?.next
        right = right.next
    }
    left?.next = left?.next?.next
    return dummy.next
}
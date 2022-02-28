package com.华为机试;

import com.链表.ListNode;

import java.util.Scanner;
import java.util.TreeSet;

public class 考古学家 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);


        node1.next = node2;
        node2.next = node3;
//        node1.next = node2;
        node4.next = node5;

        mergeTwoLists(node1,node4);

    }

    public static ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        ListNode headNode;

        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        ListNode mergeListNode;

        if(l1.val < l2.val){
            mergeListNode = l1;
            headNode= l1;
            currentL1 = currentL1.next;
        }else{
            mergeListNode = l2;
            headNode= l2;
            currentL2 = currentL2.next;
        }


        while(true){
            if(currentL1 !=null && currentL2 !=null){
                if(currentL1.val < currentL2.val){
                    mergeListNode.next = currentL1;
                    currentL1 = currentL1.next;
                }else{
                    mergeListNode.next = currentL2;
                    currentL2 = currentL2.next;
                }
            }else if(currentL1 ==null && currentL2 !=null){
                mergeListNode.next = currentL2;
                currentL2 = currentL2.next;
            }else if(currentL1 !=null && currentL2 ==null){
                mergeListNode.next = currentL1;
                currentL1 = currentL1.next;
            }else{
                break;
            }
        }
        return headNode;

    }

}

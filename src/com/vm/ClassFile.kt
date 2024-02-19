package com.vm


import com.链表.Code
import java.math.BigInteger

val CONSTANT_Utf8_info = 1

//类或接口的全限定名
val CONSTANT_Class_info = 7

val CONSTNAT_Methodref_info = 10

//方法签名: 方法名+参数
val CONSTANT_NameAndType_info = 12

val sb = StringBuilder()
fun main() {
    //魔数
    appendU4("CAFEBABE")

    //副版本号
    appendU2(0)
    //主版本号
    appendU2(52)


    appendU2(16)

    appendReferenceConstant(CONSTNAT_Methodref_info, 3, 13)


    appendReferenceConstant(CONSTANT_Class_info, 14)
    appendReferenceConstant(CONSTANT_Class_info, 15)



    appendUtf8("<init>")
    appendUtf8("()V")
    appendUtf8("Code")
    appendUtf8("LineNumberTable")
    appendUtf8("LocalVariableTable")
    appendUtf8("this")
    appendUtf8("Lcom/TT;")
    appendUtf8("SourceFile")
    appendUtf8("TT.java")

    //init 方法 void init()
    appendReferenceConstant(CONSTANT_NameAndType_info, 4, 5)
    appendUtf8("com/TT")
    appendUtf8("java/lang/Object")

    //访问标志位
    appendU4(0x0021)
    //类名
    appendU4(0x0002)
    //父类
    appendU4(0x0003)

    // 接口数量
    appendU4(0x0000)

    // filed 数量
    appendU4(0x0000)

    // 方法数量, 一个 init 方法
    appendU4(0x0001)
    // public void init()
    appendMethod(0x0001, 4, 5)
    appendMethodCode(6, 47)
    appendMethodCodeTable(1, 1, 5)
    appendInstruction(Code.aload_0)
    appendInstruction(Code.invokespecial)
    appendU2(1)
    //exception_table_length
    appendU2(0)
    //属性表个数
    appendU2(2)
    appendLineNumberTable(7, 6, 1)
    appendLineNumber(0, 3)

    appendInstruction(Code.return_)

    print()

}


fun appendU1(value: Int) {
    if (value !in 0..0XFF) {
        throw Exception("appendU1 error:${value}")
    }
    sb.append(String.format("%02x", value))
}


//添加一个字符串常量
fun appendUtf8(value: String) {
    appendU1(CONSTANT_Utf8_info)
    appendU2(value.length)
    val bytes: ByteArray = value.toByteArray()
    val hexString = BigInteger(1, bytes).toString(16)
    sb.append(hexString)
}

//添加引用类型的常量
fun appendReferenceConstant(type: Int, index: Int) {
    appendU1(type)
    appendU2(index)
}

fun appendReferenceConstant(type: Int, index: Int, index2: Int) {
    appendU1(type)
    appendU2(index)
    appendU2(index2)
}


//访问标志 方法名 方法出参入参
fun appendMethod(accessFlags: Int, methodName: Int, descriptor: Int) {
    appendU2(accessFlags)
    appendU2(methodName)
    appendU2(descriptor)
}

//属性名称
fun appendMethodCode(attributeName: Int, length: Long) {
    appendU2(attributeName)
    appendU4(length)
}

//属性名称
fun appendMethodCodeTable(maxStack: Int, maxLocals: Int, codeLength: Long) {
    appendU2(maxStack)
    appendU2(maxLocals)
    appendU4(codeLength)
}

fun appendInstruction(code: Int) {
    appendU1(code)
}

fun appendLineNumberTable(attributeName: Int, attributeLength: Long, tableLength: Int) {
    appendU2(attributeName)
    appendU4(attributeLength)
    appendU2(tableLength)
}

fun appendLineNumber(startPc: Int, lineNum: Int) {
    appendU2(startPc)
    appendU2(lineNum)
}


fun appendU2(value: Int) {
    if (value !in 0..0XFFFF) {
        throw Exception("appendU2 error:${value}")
    }
    sb.append(String.format("%04x", value))
}


fun appendU2(value: String) {
    if (value.length != 4) {
        throw Exception("appendU2 error:${value}")
    }
    sb.append(value)
}


fun appendU4(num: Long) {
    sb.append(String.format("%08x", num))
}

fun appendU4(value: String) {
    if (value.length != 8) {
        throw Exception("appendU4 error:${value}")
    }
    sb.append(value)
}


fun print() {
    val sb = sb.toString().toCharArray()
    var count = 0
    for (v in sb) {
        print(v)
        count++
        if (count % 8 == 0) {
            print(" ")
        }
    }
}

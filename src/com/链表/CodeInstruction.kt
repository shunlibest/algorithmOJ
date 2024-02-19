package com.链表


object Code {
    //java常量指令集合

    //None
    val nop = 0x00

    //将null推送至栈顶
    val aconst_null = 0x01

    //将int型-1推送至栈顶
    val iconst_m1 = 0x02

    //将int型0推送至栈顶
    val iconst_0 = 0x03

    //将int型1推送至栈顶
    val iconst_1 = 0x04

    //将int型2推送至栈顶
    val iconst_2 = 0x05

    //将int型3推送至栈顶
    val iconst_3 = 0x06

    //将int型4推送至栈顶
    val iconst_4 = 0x07

    //将int型5推送至栈顶
    val iconst_5 = 0x08

    //将long型0推送至栈顶
    val lconst_0 = 0x09

    //将long型1推送至栈顶
    val lconst_1 = 0x0a

    //将float型0推送至栈顶
    val fconst_0 = 0x0b

    //将float型1推送至栈顶
    val fconst_1 = 0x0c

    //将float型2推送至栈顶
    val fconst_2 = 0x0d

    //将double型0推送至栈顶
    val dconst_0 = 0x0e

    //将double型1推送至栈顶
    val dconst_1 = 0x0f


    //栈操作指令集合
    //将单字节的常量值(-128~127)推送至栈顶
    val bipush = 0x10

    //将一个短整型常量(-32768~32767)推送至栈顶
    val sipush = 0x11

    //将int,float或String型常量值从常量池中推送至栈顶
    val ldc = 0x12

    //将int,float或String型常量值从常量池中推送至栈顶(宽索引)
    val ldc_w = 0x13

    //将long或double型常量值从常量池中推送至栈顶(宽索引)
    val ldc2_w = 0x14

    //将指定的int型本地变量推送至栈顶
    val iload = 0x15

    //将指定的long型本地变量推送至栈顶
    val lload = 0x16

    //将指定的float型本地变量推送至栈顶
    val fload = 0x17

    //将指定的double型本地变量推送至栈顶
    val dload = 0x18

    //将指定的引用类型本地变量推送至栈顶
    val aload = 0x19

    //将第一个int型本地变量推送至栈顶
    val iload_0 = 0x1a

    //将第二个int型本地变量推送至栈顶
    val iload_1 = 0x1b

    //将第三个int型本地变量推送至栈顶
    val iload_2 = 0x1c

    //将第四个int型本地变量推送至栈顶
    val iload_3 = 0x1d

    //将第一个long型本地变量推送至栈顶
    val lload_0 = 0x1e

    //将第二个long型本地变量推送至栈顶
    val lload_1 = 0x1f

    //将第三个long型本地变量推送至栈顶
    val lload_2 = 0x20

    //将第四个long型本地变量推送至栈顶
    val lload_3 = 0x21

    //将第一个float型本地变量推送至栈顶
    val fload_0 = 0x22

    //将第二个float型本地变量推送至栈顶
    val fload_1 = 0x23

    //将第三个float型本地变量推送至栈顶
    val fload_2 = 0x24

    //将第四个float型本地变量推送至栈顶
    val fload_3 = 0x25

    //将第一个double型本地变量推送至栈顶
    val dload_0 = 0x26

    //将第二个double型本地变量推送至栈顶
    val dload_1 = 0x27

    //将第三个double型本地变量推送至栈顶
    val dload_2 = 0x28

    //将第四个double型本地变量推送至栈顶
    val dload_3 = 0x29

    //将第一个引用类型本地变量推送至栈顶
    val aload_0 = 0x2a

    //将第二个引用类型本地变量推送至栈顶
    val aload_1 = 0x2b

    //将第三个引用类型本地变量推送至栈顶
    val aload_2 = 0x2c

    //将第四个引用类型本地变量推送至栈顶
    val aload_3 = 0x2d

    //将int型数组指定索引的值推送至栈顶
    val iaload = 0x2e

    //将long型数组指定索引的值推送至栈顶
    val laload = 0x2f

    //将float型数组指定索引的值推送至栈顶
    val faload = 0x30

    //将double型数组指定索引的值推送至栈顶
    val daload = 0x31

    //将引用类型数组指定索引的值推送至栈顶
    val aaload = 0x32

    //将boolean或byte型数组指定索引的值推送至栈顶
    val baload = 0x33

    //将char型数组指定索引的值推送至栈顶
    val caload = 0x34

    //将short型数组指定索引的值推送至栈顶
    val saload = 0x35

    //将栈顶int型数值存入指定本地变量
    val istore = 0x36

    //将栈顶long型数值存入指定本地变量
    val lstore = 0x37

    //将栈顶float型数值存入指定本地变量
    val fstore = 0x38

    //将栈顶double型数值存入指定本地变量
    val dstore = 0x39

    //将栈顶引用类型数值存入指定本地变量
    val astore = 0x3a

    //将栈顶int型数值存入第一个本地变量
    val istore_0 = 0x3b

    //将栈顶int型数值存入第二个本地变量
    val istore_1 = 0x3c

    //将栈顶int型数值存入第三个本地变量
    val istore_2 = 0x3d

    //将栈顶int型数值存入第四个本地变量
    val istore_3 = 0x3e

    //将栈顶long型数值存入第一个本地变量
    val lstore_0 = 0x3f

    //将栈顶long型数值存入第二个本地变量
    val lstore_1 = 0x40

    //将栈顶long型数值存入第三个本地变量
    val lstore_2 = 0x41

    //将栈顶long型数值存入第四个本地变量
    val lstore_3 = 0x42

    //将栈顶float型数值存入第一个本地变量
    val fstore_0 = 0x43

    //将栈顶float型数值存入第二个本地变量
    val fstore_1 = 0x44

    //将栈顶float型数值存入第三个本地变量
    val fstore_2 = 0x45

    //将栈顶float型数值存入第四个本地变量
    val fstore_3 = 0x46

    //将栈顶double型数值存入第一个本地变量
    val dstore_0 = 0x47

    //将栈顶double型数值存入第二个本地变量
    val dstore_1 = 0x48

    //将栈顶double型数值存入第三个本地变量
    val dstore_2 = 0x49

    //将栈顶double型数值存入第四个本地变量
    val dstore_3 = 0x4a

    //将栈顶引用型数值存入第一个本地变量
    val astore_0 = 0x4b

    //将栈顶引用型数值存入第二个本地变量
    val astore_1 = 0x4c

    //将栈顶引用型数值存入第三个本地变量
    val astore_2 = 0x4d

    //将栈顶引用型数值存入第四个本地变量
    val astore_3 = 0x4e

    //将栈顶int型数值存入指定数组的指定索引位置
    val iastore = 0x4f

    //将栈顶long型数值存入指定数组的指定索引位置
    val lastore = 0x50

    //将栈顶float型数值存入指定数组的指定索引位置
    val fastore = 0x51

    //将栈顶double型数值存入指定数组的指定索引位置
    val dastore = 0x52

    //将栈顶引用型数值存入指定数组的指定索引位置
    val aastore = 0x53

    //将栈顶boolean或byte型数值存入指定数组的指定索引位置
    val bastore = 0x54

    //将栈顶char型数值存入指定数组的指定索引位置
    val castore = 0x55

    //将栈顶short型数值存入指定数组的指定索引位置
    val sastore = 0x56

    //将栈顶数值弹出(数值不能是long或double类型的)
    val pop = 0x57

    //将栈顶的一个(对于非long或double类型)或两个数值(对于非long或double的其他类型)弹出
    val pop2 = 0x58

    //复制栈顶数值并将复制值压入栈顶
    val dup = 0x59

    //复制栈顶数值并将两个复制值压入栈顶
    val dup_x1 = 0x5a

    //复制栈顶数值并将三个(或两个)复制值压入栈顶
    val dup_x2 = 0x5b

    //复制栈顶一个(对于long或double类型)或两个(对于非long或double的其他类型)数值并将复制值压入栈顶
    val dup2 = 0x5c

    //dup_x1指令的双倍版本
    val dup2_x1 = 0x5d

    //dup_x2指令的双倍版本
    val dup2_x2 = 0x5e


    //方法调用指令集合
    //从当前方法返回int
    val ireturn = 0xac

    //从当前方法返回long
    val lreturn = 0xad

    //从当前方法返回float
    val freturn = 0xae

    //从当前方法返回double
    val dreturn = 0xaf

    //从当前方法返回对象引用
    val areturn = 0xb0

    //从当前方法返回void
    val return_ = 0xb1

    //获取指定类的静态域, 并将其压入栈顶
    val getstatic = 0xb2

    //为指定类的静态域赋值
    val putstatic = 0xb3

    //获取指定类的实例域, 并将其压入栈顶
    val getfield = 0xb4

    //为指定类的实例域赋值
    val putfield = 0xb5

    //调用实例方法
    val invokevirtual = 0xb6

    //调用超类构建方法, 实例初始化方法, 私有方法
    val invokespecial = 0xb7

    //调用静态方法
    val invokestatic = 0xb8

    //调用接口方法
    val invokeinterface = 0xb9

    //调用动态方法
    val invokedynamic = 0xba

    //创建一个对象, 并将其引用引用值压入栈顶
    val new = 0xbb

    //创建一个指定的原始类型(如int, float, char等)的数组, 并将其引用值压入栈顶
    val newarray = 0xbc

    //创建一个引用型(如类, 接口, 数组)的数组, 并将其引用值压入栈顶
    val anewarray = 0xbd

    //获取数组的长度值并压入栈顶
    val arraylength = 0xbe

    //将栈顶的异常抛出
    val athrow = 0xbf

    //检验类型转换, 检验未通过将抛出 ClassCastException
    val checkcast = 0xc0

    //检验对象是否是指定类的实际, 如果是将1压入栈顶, 否则将0压入栈顶
    val instanceof = 0xc1

    //获得对象的锁, 用于同步方法或同步块
    val monitorenter = 0xc2

    //释放对象的锁, 用于同步方法或同步块
    val monitorexit = 0xc3

    //扩展本地变量的宽度
    val wide = 0xc4

    //创建指定类型和指定维度的多维数组(执行该指令时, 操作栈中必须包含各维度的长度值), 并将其引用压入栈顶
    val multianewarray = 0xc5

    //为null时跳转
    val ifnull = 0xc6

    //不为null时跳转
    val ifnonnull = 0xc7

    //无条件跳转(宽索引)
    val goto_w = 0xc8

    //跳转至指定的32位offset位置, 并将jsr_w的下一条指令地址压入栈顶
    val jsr_w = 0xc9
}
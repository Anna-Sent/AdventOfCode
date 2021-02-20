package test

class A : B()
open class B : C()
open class C

fun test() {
    val listA = arrayListOf(A(), A())
    val listB = arrayListOf(B(), B())
    val listC = arrayListOf(C(), C())

    //printIn(listA)
    printIn(listB)
    printIn(listC)
    printOut(listA)
    printOut(listB)
    //printOut(listC)
}

fun printIn(list: ArrayList<in B>) {
    println(list)
}

fun printOut(list: ArrayList<out B>) {
    println(list)
}

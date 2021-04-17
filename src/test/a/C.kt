package test.a

class C {

    private val a = A()

    init {
        println(a.publicField)
        // println(a.privateField)
        // println(a.protectedField)
        println(a.internalField)
    }
}

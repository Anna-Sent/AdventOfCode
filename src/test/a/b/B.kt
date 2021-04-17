package test.a.b

import test.a.A

class B : A() {

    init {
        println(publicField)
        // println(privateField)
        println(protectedField)
        println(internalField)
    }
}

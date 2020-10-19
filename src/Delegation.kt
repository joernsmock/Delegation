// Delegation (from kotlinlan/reference)
fun main(args: Array<String>) {
    print("Delegation:")
    main1()
    main2()
    main3()
}

interface Base1 {
    fun print()
}

class BaseImpl(val x: Int) : Base1 {
    override fun print() { print(x) }
}

class Derived1(b: Base1) : Base1 by b

fun main1() {
    val b = BaseImpl(10)
    Derived1(b).print()
}

// --------------------------------------------

interface Base2 {
    fun printMessage()
    fun printMessageLine()
}

class Base2Impl(val x: Int) : Base2 {
    override fun printMessage() { print(x) }
    override fun printMessageLine() { println(x) }
}

class Derived2(b: Base2) : Base2 by b {
    override fun printMessage() { print("abc (2)") }
}

fun main2() {
    val b = Base2Impl(10)
    Derived2(b).printMessage()
    Derived2(b).printMessageLine()
}

// --------------------------------------------

interface Base3 {
    val message: String
    fun print()
}

class Base3Impl(val x: Int) : Base3 {
    override val message = "Base3Impl: x = $x"
    override fun print() { println(message) }
}

class Derived3(b: Base3) : Base3 by b {
    // This property is not accessed from b's implementation of `print`
    override val message = "Message of Derived3"
}

fun main3() {
    val b = Base3Impl(10)
    val derived = Derived3(b)
    derived.print()
    println(derived.message)
}

// --------------------------------------------

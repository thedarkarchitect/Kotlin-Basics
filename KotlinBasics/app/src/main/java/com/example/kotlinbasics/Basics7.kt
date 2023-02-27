package com.example.kotlinbasics

fun main(){
    val stringList: List<String> = listOf(
        "Denis", "Frank", "Michael", "Garry"
    )
    val mixedTypeList: List<Any> = listOf(
        "Denis", 31, 5, "BDay", 70.5, "weighs", "kg"
    )

    for (value in mixedTypeList){
        if(value is Int){
            println("Integer: '$value'")
        }else if (value is Double){
            println("Double: '$value' with Floor value ${Math.floor(value)}")
        }else if(value is String){
            println("String: '$value' of length ${value.length}")
        }else{
            println("Unknown Type")
        }
    }

    //Alternatively
    for(value in mixedTypeList){
        when(value){
            //these are lambda experssions and this what Kotlin prefers compared to the above
            is Int -> println("Integer: $value")
            is Double -> println("Double: $value with Floor value ${Math.floor(value)}")
            is String -> println("String: '$value' of length ${value.length}")
            else -> println("Unknown Type")
        }
    }

    //SMART CAST
    val obj1: Any = "I have a dream"
    if (obj1 !is String){
        println("Not a String")
    }else{
        //obj is automatically cast to a String in this scope
        println("Found a String of length ${obj1.length}")
    }

    //Explicit (unsafe) Casting using "as" keyword - can go wrong
    val str1: String = obj1 as String
    println(str1.length)

    //this will fail cuz is not string
   // val obj2: Any = 1337
    //val str2: String = obj2 as String
    //println(str2)

    //Explicit(safe) casting using the "as?" keyword
    val obj3: Any = 1337
    val str3: String? = obj3 as? String // Works
    println(str3) // Prints null
}
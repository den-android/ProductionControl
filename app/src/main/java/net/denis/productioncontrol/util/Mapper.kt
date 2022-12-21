package net.denis.productioncontrol.util

interface Mapper<Input, Output> {

    fun from(input: Input?): Output

    fun to(output: Output): Input

    fun fromList(list : List<Input>?) : List<Output> {
        return list?.mapNotNull { from(it) } ?: listOf()
    }

    fun toList(list : List<Output>?) : List<Input> {
        return list?.mapNotNull { to(it) } ?: listOf()
    }

}
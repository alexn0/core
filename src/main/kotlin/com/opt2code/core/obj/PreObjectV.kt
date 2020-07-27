/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj


interface PreObjectExtV: PreObjectV {
    fun elements(): List<ObjectV> = arrayListOf()
}

interface PreObjectV {

    var el_: List<ObjectV>?

    fun operations(): List<ObjectV> = ArrayList()

    fun new_(substitute: Boolean = false): ObjectV = throw IllegalArgumentException("Should be implemented")

    fun addOperation(object_: ObjectV)

    fun isSubstitute(): Boolean = data_.substitute || globalSubstitute()

    val data_: Data

    var argInfo: ArgParam

    var isNullable: Boolean

    fun isFixed(): Boolean = false

    fun fixedValue(): Any? = null

    fun isOrdering(): Boolean
}

data class ArgParam(
        var isArg: Boolean = false,
        var isChildArg: Boolean = false,
        var parent: ObjectV? = null,
        var reverseFormulaElement: List<ObjectV> = arrayListOf(),
        var inverseFunction: Function<*>? = null,
        var functionIsInited: Boolean = false
)

/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.enum

interface EnumVisitor {
    fun <T: Enum<T>> visit(vDate: EnumV<T>)
}
/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj

interface PrevVisitor {
    fun <S: ObjectV, T: ObjectV> visit(vDate: PrevV<S, T>)
}
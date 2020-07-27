/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj

interface NextVisitor {
    fun <S: ObjectV, T: ObjectV> visit(vDate: NextV<S, T>)
}
/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map.pair

import com.opt2code.core.obj.ObjectV

interface PairVisitor {
    fun <S: ObjectV, T: ObjectV> visit(vFunction: PairV<S, T>)
}
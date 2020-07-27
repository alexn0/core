/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map.map

import com.opt2code.core.obj.ObjectV

interface PutOperationVisitor {
    fun <S: ObjectV, T: ObjectV> visit(vDate: PutOperationV<S, T>)
}
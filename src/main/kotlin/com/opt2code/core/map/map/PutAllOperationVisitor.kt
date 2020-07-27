/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map.map

import com.opt2code.core.obj.ObjectV

interface PutAllOperationVisitor {
    fun <S: ObjectV, T: ObjectV> visit(vDate: PutAllOperationV<S, T>)
}
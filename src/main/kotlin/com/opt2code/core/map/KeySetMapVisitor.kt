/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map

import com.opt2code.core.obj.ObjectV

interface KeySetMapVisitor {
    fun <S: ObjectV, T: ObjectV> visit(vDate: KeySetMapV<S, T>)
}
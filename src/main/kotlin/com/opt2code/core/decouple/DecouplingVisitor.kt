/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.decouple

import com.opt2code.core.obj.ObjectV

interface DecouplingVisitor {
    fun <S: ObjectV> visit(vDate: DecouplingV<S>)
}
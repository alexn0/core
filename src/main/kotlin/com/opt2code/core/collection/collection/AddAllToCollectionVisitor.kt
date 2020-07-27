/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection.collection

import com.opt2code.core.obj.ObjectV

interface AddAllToCollectionVisitor {
    fun <S: ObjectV> visit(vDate: AddAllToCollectionV<S>)
}
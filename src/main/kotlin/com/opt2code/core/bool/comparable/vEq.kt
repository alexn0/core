/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool.comparable

import com.opt2code.core.bool.comparable.EqV_.Companion.eqV
import com.opt2code.core.obj.ObjectV

fun ObjectV.vEq(second: ObjectV) = eqV(this, second)
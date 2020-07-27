/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool.comparable

import com.opt2code.core.bool.comparable.LtOrEqV_.Companion.ltOrEqV
import com.opt2code.core.obj.ComparableV

fun <T: ComparableV> T.vLtOgEq(second: T) = ltOrEqV(this, second)
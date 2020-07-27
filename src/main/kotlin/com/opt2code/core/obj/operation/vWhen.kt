/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.obj.ObjectV

fun <T: ObjectV> vWhen(vararg f: Pair<BooleanV, () -> T>, g: () -> T): T {
    return when (f.size) {
        0 -> g()
        1 -> vIf(f[0].first) { f[0].second() }
                .vElse { g() }()
        2 -> vIf(f[0].first) { f[0].second() }
                .vElseIf(f[1].first) { f[1].second() }
                .vElse { g() }()
        else -> vIf(f[0].first) { f[0].second() }.let {
            var i = 1
            var v = it
            while (i < f.size) {
                v = v.vElseIf(f[i].first) { f[i].second() }
                i++
            }
            v.vElse { g() }()
        }
    }
}
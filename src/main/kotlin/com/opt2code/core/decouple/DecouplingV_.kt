/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.decouple

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_
import com.opt2code.core.obj.new
import com.opt2code.core.obj.operation

class DecouplingV_<S: ObjectV> private constructor(
        private val default: S,
        private val result: S,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, DecouplingV<S> {

    override fun new_(substitute: Boolean): DecouplingV<S> = DecouplingV_(default, result, data_.copy(substitute = substitute))

    override fun elements(): List<ObjectV> = arrayListOf(implementation())

    override fun invoke(): S = default.new(substitute = true).operation(this)

    override fun implementation(): S = result

    companion object {
        fun <S: ObjectV> decouple(s: S, data: Data = Data.data(), invoke: () -> S): S = DecouplingV_<S>(s, invoke(), data)()

        fun <S: ObjectV> de(s: S, data: Data = Data.data(), invoke: () -> S): S = decouple(s, data, invoke)
    }
}
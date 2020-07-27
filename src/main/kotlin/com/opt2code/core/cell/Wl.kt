/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.cell

import com.opt2code.core.cell.CellV_.Companion.cellV
import com.opt2code.core.cell.EagerlyWl.Companion.eagerlyWl
import com.opt2code.core.cell.Vl.Companion.vl
import com.opt2code.core.cell.Wl.Companion.wl
import com.opt2code.core.obj.ArgParam
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV

class Wl<T: ObjectV> private constructor(private val wl: () -> EagerlyWl<T>): CellV<T> {
    private val origWl by lazy { wl() }

    override var el_: List<ObjectV>?
        get() = origWl.el_
        set(value) {
            origWl.el_ = value
        }

    val orig: T by lazy { origWl.orig }

    val t: () -> T by lazy { origWl.t }

    override val t_: ObjectV by lazy { origWl.t_ }

    override var parent: ObjectV?
        get() = origWl.parent
        set(value) {
            origWl.parent = value
        }

    override fun isOrdering(): Boolean = origWl.isOrdering()

    override val data_: Data by lazy { origWl.data_ }

    override fun addOperation(object_: ObjectV) = origWl.addOperation(object_)

    override var argInfo: ArgParam
        get() = t_.argInfo
        set(value) {
            t_.argInfo = value
        }


    override var isNullable: Boolean = origWl.isNullable

    override fun elements(): List<ObjectV> = origWl.elements()

    override fun getFieldClass(): Class<T> = origWl.getFieldClass()

    override fun invoke() = origWl.invoke()

    override fun update(t: T) = origWl.update(t)

    override fun update(t: CellV<T>) = update(t())

    infix fun up(t: CellV<T>) = update(t())

    override fun dataObj(): Data = origWl.dataObj()

    fun cell() = origWl.dataObj()

    override fun new_(substitute: Boolean): Wl<T> = wl(data_.copy(substitute = substitute), t)

    companion object {
        fun <T: ObjectV> wl(data: Data, t: () -> T): Wl<T> {
            return Wl({ eagerlyWl(data, t) })
        }

        fun <T: ObjectV> wl(t: () -> T): Wl<T> = wl(Data(), t)

    }
}

private class EagerlyWl<T: ObjectV> private constructor(private val vl: Vl<CellV<T>>,
                                                         val orig: T,
                                                         val t: () -> T,
                                                         override val t_: ObjectV = orig): CellV<T> {
    override var el_: List<ObjectV>?
        get() = vl.value.el_
        set(value) {
            vl.value.el_ = value
        }

    override var parent: ObjectV?
        get() = vl.value.parent
        set(value) {
            vl.value.parent = value
        }

    override fun isOrdering(): Boolean = vl.value.data_.ordering

    override val data_: Data = vl.value.data_

    override fun addOperation(object_: ObjectV) = vl().addOperation(object_)

    override var argInfo: ArgParam
        get() = t_.argInfo
        set(value) {
            t_.argInfo = value
        }

    override var isNullable: Boolean = vl.value.isNullable

    override fun elements(): List<ObjectV> = vl.value.elements() //TODO or arrayListOf(orig)

    override fun getFieldClass(): Class<T> = vl.value.getFieldClass()

    override fun invoke() = vl()()

    override fun update(t: T) = vl().update(t)

    override fun update(t: CellV<T>) = update(t())

    infix fun up(t: CellV<T>) = update(t())

    override fun dataObj(): Data = orig.data_

    fun cell() = vl()

    override fun new_(substitute: Boolean): Wl<T> = wl(data_.copy(substitute = substitute), t)


    companion object {
        fun <T: ObjectV> eagerlyWl(data: Data, t: () -> T): EagerlyWl<T> {
            val orig = t()
            return EagerlyWl(vl({ cellV(t(), data = data) }, cellV(orig)), orig, t)
        }
    }
}
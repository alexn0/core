/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.bool.BooleanV_.Companion.booleanV
import com.opt2code.core.cell.CellV
import com.opt2code.core.list.ListV
import com.opt2code.core.list.ListV_.Companion.listV
import com.opt2code.core.map.AsSetMapV_.Companion.asSetMapV
import com.opt2code.core.map.GetMapV_.Companion.getMapV
import com.opt2code.core.map.KeySetMapV_.Companion.keySetMapV
import com.opt2code.core.map.ToSetMapV_.Companion.toSetMapV
import com.opt2code.core.map.ValueListMapV_.Companion.valueListMapV
import com.opt2code.core.map.map.ContainsKeyOperationV_.Companion.containsKeyOperationV
import com.opt2code.core.map.map.PutAllOperationV_.Companion.putAllOperationV
import com.opt2code.core.map.map.PutOperationV_.Companion.putOperationV
import com.opt2code.core.map.pair.PairV
import com.opt2code.core.map.pair.PairV_.Companion.pairV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor
import com.opt2code.core.obj.newOperation
import com.opt2code.core.obj.operation
import com.opt2code.core.obj.operation.vIf
import com.opt2code.core.obj.pv
import com.opt2code.core.set.SetV
import com.opt2code.core.set.SetV_.Companion.setV


interface MapV<S: ObjectV, T: ObjectV>: ObjectV {
    fun <K: ObjectV, L: ObjectV> new(commonArg: () -> K, commonResult: () -> L): MapV<K, L>

    fun common(): PairV<S, T> = pairV(commonArg(), commonResult())

    val commonArg: CellV<S>

    val commonResult: CellV<T>

    fun containsKey(s: S): BooleanV = containsKeyOperationV(s, this)

    operator fun get(s: S): T = commonResult().operation(getMapV(s, this))

    fun keySet(): SetV<S> = setV({ commonArg() }).operation(keySetMapV(this))

    fun toSet(): SetV<PairV<S, T>> = setV({ common() }).operation(toSetMapV(this))

    fun asSet(): SetV<PairV<S, T>> = setV({ common() }).operation(asSetMapV(this))

    fun valueList(): ListV<T> = listV { commonResult() }.operation(valueListMapV(this))

    fun put(key: S, value: T): BooleanV = booleanV().operation(putOperationV(key, value, this))

    fun putAll_(map: Map<S, T>): MapV<S, T> = this.let {
        var res = it
        map.forEach {
            val p = it
            res = res.pv {
                res.put(p.key, p.value)
            }
        }
        res
    }

    fun putAll(map: MapV<S, T>) = newOperation(putAllOperationV(map))

    fun putIfNotExist(key: S, value: T) = vIf(containsKey(key).not()) { put(key, value) }

    override fun getInterfaceClass(): Class<*> = MapV::class.java

    fun accept(r: MapVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is MapVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}






/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj

import com.opt2code.core.function.arg.AsArgReplacementV
import com.opt2code.core.function.arg.AsFunctionV
import com.opt2code.core.obj.NextV_.Companion.nextV
import com.opt2code.core.obj.PrevV_.Companion.prevV
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

interface ObjectV: PreObjectExtV {

    fun getInterfaceClass(): Class<*>

    fun accept(r: ObjectVisitor) {
        r.visit(this)
    }

    fun setAsArg() {
        if (!argInfo.isArg) {
            argInfo.isArg = true
            getLazyElements().forEach {
                it.setAsChildArg(this)
            }
        }
    }

    fun setAsChildArg(parent: ObjectV) {
        if (!argInfo.isArg) {
            argInfo.isArg = true
            argInfo.isChildArg = true
            argInfo.parent = parent
            getLazyElements().forEach {
                it.setAsChildArg(this)
            }
        }
    }

}

fun <T: ObjectV> T.new(substitute: Boolean = false): T {
    if (isSubstituteGlobal) {
        return this
    }
    isSubstituteGlobal = true
    val res = new_(substitute) as T
    isSubstituteGlobal = false
    if (substitute) {
        val orig = toOriginalObjectV.get(this)
        if (orig != null) {
            toOriginalObjectV.put(res, orig)
        } else if (res != this) {
            toOriginalObjectV.put(res, this)
        }
    } else {
        toOriginalObjectV.put(res, this)
    }

    return res
}


fun ObjectV.getLazyElements(): List<ObjectV> {
    if (el_ == null) {
        el_ = elements()
    }
    return if (argInfo.isChildArg && argInfo.functionIsInited) {
        argInfo.reverseFormulaElement
    } else if (argInfo.isArg) {
        emptyList()
    } else {
        el_!!
    }
}

fun <T: ObjectV> T.setArg(): T {
    return this.new().also {
        it.setAsArg()
    }
}

fun <T: ObjectV> T.new__(substitute: Boolean = false): T { //helper
    val res = new_(substitute) as T
    return res
}

fun <T: ObjectV> T.new___(substitute: Boolean = false): T { //helper
    val old = isSubstituteGlobal
    isSubstituteGlobal = false
    val res = new(substitute)
    isSubstituteGlobal = old
    return res
}

val toOriginalObjectV: IdentityHashMap<ObjectV, ObjectV> = IdentityHashMap()


private var isSubstituteGlobal = false

fun globalSubstitute() = isSubstituteGlobal


fun <S> originalObject(any: S): S {
    if (any is ObjectV && any.data_.substitute) {
        val res = toOriginalObjectV[any]
        return res as? S ?: any
    }
    return any
}

fun ObjectV.toDescription(identificators: HashSet<Int> = HashSet()): ObjectVDesc {
    if (this is AsFunctionV<*>) {
        return this.toDescription(identificators)
    } else if (this is AsArgReplacementV) {
        return this.hiddenElement.toDescription(identificators)
    }
    val objClassName = this::class.java.simpleName
    val desc = ObjectVDesc(
            hashValue = hashCode(),
            objClassName = objClassName,
            realObject = getRealObjectName() ?: objClassName,
            className = getInterfaceClass().simpleName,
            fixedValue = fixedValue(),
            hasChildren = !getLazyElements().isEmpty())
    if (desc.hasChildren && !identificators.contains(desc.hashValue)) {
        identificators.add(desc.hashValue)
        getLazyElements().forEach {
            if (!identificators.contains(it.hashCode())) {
                desc.children.add(it.toDescription(identificators))
            }
        }
    }
    return desc
}

private fun ObjectV.getRealObjectName(): String? {
    return (this as? Parent)?.parent_?.let { it::class.java.simpleName }
}

fun AsFunctionV<*>.toDescription(identificators: HashSet<Int> = HashSet()): ObjectVDesc {
    val objClassName = this::class.java.simpleName
    val desc = ObjectVDesc(
            hashValue = hashCode(),
            objClassName = objClassName,
            realObject = getRealObjectName() ?: objClassName,
            className = getInterfaceClass().simpleName,
            fixedValue = fixedValue(),
            hasChildren = true)
    if (desc.hasChildren && !identificators.contains(desc.hashValue)) {
        identificators.add(desc.hashValue)
        if (!identificators.contains(this.hiddenMainElement().hashCode())) {
            identificators.add(this.hiddenMainElement().hashCode())
            desc.children.add(this.hiddenMainElement().toDescription(identificators))
        }
    }
    return desc
}

data class ObjectVDesc(
        val objClassName: String,
        val realObject: String,
        val className: String,
        val fixedValue: Any?,
        val hasChildren: Boolean,
        val hashValue: Int,
        val children: MutableList<ObjectVDesc> = ArrayList()
)


fun <T: PreObjectV, S: ObjectV> T.operation(object_: S): T = this.apply { addOperation(object_) }

fun <T: ObjectV, S: ObjectV> T.nt(object_: (T).() -> S): S = object_().let {
    val res = it.new(substitute = true)
    res.operation(nextV(this, it))
    res
}

fun <T: ObjectV, S: ObjectV> T.pv(force: Boolean = false, object_: (T).() -> S): T = this.let {
    if (!isSubstitute()) {
        val res = it.new(substitute = true)
        res.operation(prevV(it, object_()))
        res
    } else {
        it
        if (globalSubstitute() || force) {
            it
        } else {
            it.new(substitute = true).operation(prevV(it, object_()))
        }
    }
}

fun <T: PreObjectV, S: ObjectV> T.newOperation(object_: S): S = object_.new().operation(object_)

fun <T: ObjectV> pv(t: T, vararg arg: ObjectV): T {
    var h = t
    arg.forEach {
        val k = it
        h = h.pv { k }
    }
    return h
}

fun <T: ObjectV> nt(vararg arg: ObjectV, t: T): T {
    var h = t
    arg.asList().asReversed().forEach {
        h = it.nt { h }
    }
    return h
}

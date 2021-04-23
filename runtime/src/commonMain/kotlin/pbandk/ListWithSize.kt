package pbandk

import kotlin.js.JsExport
import kotlin.js.JsName

@PublicForGeneratedCode
@JsExport
class ListWithSize<T> internal constructor(val list: List<T>, val protoSize: Int?) : List<T> by list {
    @JsName("initWithSizeFn")
    constructor(list: List<T>, sizeFn: (T) -> Int) : this(list, list.sumBy(sizeFn))

    override fun equals(other: Any?) = list == other
    override fun hashCode() = list.hashCode()
    override fun toString() = list.toString()

    class Builder<T> private constructor(val list: ArrayList<T>): MutableList<T> by list {
        @JsName("init")
        constructor() : this(ArrayList())

        fun fixed() = ListWithSize(list.also { it.trimToSize() }, protoSize = null)

        companion object {
            fun <T> fixed(bld: Builder<T>?) = bld?.fixed() ?: Empty
        }
    }

    companion object {
        val Empty = ListWithSize(emptyList<Nothing>(), 0)
    }
}

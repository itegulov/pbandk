package pbandk

import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
class InvalidProtocolBufferException : RuntimeException {
    @JsName("fromMessage")
    constructor(message: String) : super(message)
    @JsName("fromMessageAndCause")
    constructor(message: String, cause: Throwable) : super(message, cause)
}

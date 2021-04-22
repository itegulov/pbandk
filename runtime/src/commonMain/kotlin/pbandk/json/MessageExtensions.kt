package pbandk.json

import pbandk.ExperimentalProtoJson
import pbandk.Message
import pbandk.internal.json.JsonMessageEncoder
import pbandk.internal.json.JsonMessageDecoder
import kotlin.js.JsExport

@ExperimentalProtoJson
@JsExport
fun <T : Message> T.encodeToJsonString(jsonConfig: JsonConfig = JsonConfig.DEFAULT): String =
    JsonMessageEncoder(jsonConfig).also { it.writeMessage(this) }.toJsonString()

@ExperimentalProtoJson
@JsExport
fun <T : Message> Message.Companion<T>.decodeFromJsonString(
    data: String,
    jsonConfig: JsonConfig = JsonConfig.DEFAULT
): T = decodeWith(JsonMessageDecoder.fromString(data, jsonConfig))

package pbandk

import kotlin.js.JsExport
import kotlin.reflect.KClass

@JsExport
class MessageDescriptor<T : Message>(
    @PublicForGeneratedCode
    val messageClass: KClass<T>,
    @PublicForGeneratedCode
    val messageCompanion: Message.Companion<T>,
    val fields: Collection<FieldDescriptor<T, *>>
)

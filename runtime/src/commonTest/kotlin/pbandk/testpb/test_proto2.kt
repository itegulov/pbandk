@file:OptIn(pbandk.PublicForGeneratedCode::class)

package pbandk.testpb

data class MessageWithRequiredField(
    val foo: Boolean = false,
    override val unknownFields: Map<Int, pbandk.UnknownField> = emptyMap()
) : pbandk.Message {
    override operator fun plus(other: pbandk.Message?) = protoMergeImpl(other)
    override val descriptor get() = Companion.descriptor
    override val protoSize by lazy { super.protoSize }
    companion object : pbandk.Message.Companion<MessageWithRequiredField> {
        val defaultInstance by lazy { MessageWithRequiredField() }
        override fun decodeWith(u: pbandk.MessageDecoder) = MessageWithRequiredField.decodeWithImpl(u)

        override val descriptor: pbandk.MessageDescriptor<MessageWithRequiredField> by lazy {
            pbandk.MessageDescriptor(
                messageClass = MessageWithRequiredField::class,
                messageCompanion = this,
                fields = listOf(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this::descriptor,
                        name = "foo",
                        number = 1,
                        type = pbandk.FieldDescriptor.Type.Primitive.Bool(),
                        jsonName = "foo",
                        value = MessageWithRequiredField::foo
                    )
                )
            )
        }
    }
}

fun MessageWithRequiredField?.orDefault() = this ?: MessageWithRequiredField.defaultInstance

private fun MessageWithRequiredField.protoMergeImpl(plus: pbandk.Message?): MessageWithRequiredField = (plus as? MessageWithRequiredField)?.copy(
    unknownFields = unknownFields + plus.unknownFields
) ?: this

@Suppress("UNCHECKED_CAST")
private fun MessageWithRequiredField.Companion.decodeWithImpl(u: pbandk.MessageDecoder): MessageWithRequiredField {
    var foo = false

    val unknownFields = u.readMessage(this) { _fieldNumber, _fieldValue ->
        when (_fieldNumber) {
            1 -> foo = _fieldValue as Boolean
        }
    }
    return MessageWithRequiredField(foo, unknownFields)
}

package pbandk

import pbandk.testpb.MessageWithMap
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MapTest {
    @Test
    fun testMap() {
        val testMap = mapOf("1" to "a", "2" to "b", "blahblahblah" to "5000")
        // Generate a Java version of the proto and deserialize Kotlin version and vice-versa
        val builtJavaObj = pbandk.testpb.java.Test.MessageWithMap.newBuilder().putAllMap(testMap).build()
        val builtKotlinObj = MessageWithMap(testMap)
        kotlinJavaRoundtripTest(builtJavaObj, builtKotlinObj, MessageWithMap.Companion)
    }

    @Test
    fun testMapDecodeType() {
        val messageWithMap = MessageWithMap(mapOf("1" to "a", "2" to "b", "blahblahblah" to "5000"))
        val deserialized = MessageWithMap.decodeFromByteArray(messageWithMap.encodeToByteArray())

        // Check that map-with-size
        assertTrue(deserialized.map is MessageMap)
    }
}
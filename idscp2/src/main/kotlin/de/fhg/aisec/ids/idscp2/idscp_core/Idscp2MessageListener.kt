package de.fhg.aisec.ids.idscp2.idscp_core

/**
 * An interface for an IDSCP message listener
 */
fun interface Idscp2MessageListener {
    /*
     * notify the listener about new data
     */
    fun onMessage(connection: Idscp2Connection, data: ByteArray)
}
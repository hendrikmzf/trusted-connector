package de.fhg.aisec.ids.idscp2.idscp_core.configuration

import de.fhg.aisec.ids.idscp2.idscp_core.Idscp2Connection
import de.fhg.aisec.ids.idscp2.idscp_core.secure_channel.SecureChannel
import de.fhg.aisec.ids.idscp2.idscp_core.server.ServerConnectionListener
import java.util.concurrent.CompletableFuture

/**
 * An callback interface that implements callback functions that notify about new
 * SecureChannels
 *
 * @author Leon Beckmann (leon.beckmann@aisec.fraunhofer.de)
 */
interface SecureChannelInitListener<CC: Idscp2Connection> {
    /**
     * Notify the server about new secureChannel
     */
    fun onSecureChannel(
            secureChannel: SecureChannel,
            serverListenerPromise: CompletableFuture<ServerConnectionListener<CC>>
    )

    fun onError(t: Throwable)
}
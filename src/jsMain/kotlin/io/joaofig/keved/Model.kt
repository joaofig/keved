package io.joaofig.keved

import dev.kilua.rpc.getService

object Model {

    private val pingService = getService<IPingService>()

    suspend fun ping(message: String): String {
        return pingService.ping(message)
    }

}

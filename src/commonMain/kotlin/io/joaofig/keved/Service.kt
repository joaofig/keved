package io.joaofig.keved

import dev.kilua.rpc.annotations.RpcService

@RpcService
interface IPingService {
    suspend fun ping(message: String): String
}

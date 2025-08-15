package io.joaofig.keved

class PingService : IPingService {

    override suspend fun ping(message: String): String {
        println(message)
        return "Hello world from server!"
    }
}

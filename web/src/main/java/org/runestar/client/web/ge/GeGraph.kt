package org.runestar.client.web.ge

import org.runestar.client.web.httpClient
import java.util.concurrent.CompletableFuture

object GeGraph {

    private val client = GeGraphClient(httpClient)

    private val cache = HashMap<Int, CompletableFuture<Int?>>()

    fun itemPrice(id: Int): CompletableFuture<Int?> {
        return cache.computeIfAbsent(id) { client[id].thenApply { it?.latestPrice } }
    }
}
package com.abhash.chatapp.chatapp

import com.pusher.rest.Pusher
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/message")
class MessageController {
    private val pusher = Pusher("1455387", "8e2732eec7542f0c8eaa", "d3d90fc2e986de7f69c8")

    init {
        pusher.setCluster("ap2")
    }

    @PostMapping
    fun postMessage(@RequestBody message: Message) : ResponseEntity<Unit> {
        pusher.trigger("chat", "new_message", message)
        return ResponseEntity.ok().build()
    }
}
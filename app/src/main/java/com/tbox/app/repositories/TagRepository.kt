package com.tbox.app.repositories

import com.tbox.app.models.Tag
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TagRepository @Inject constructor() {

    private val tags = mutableListOf<Tag>(
        Tag(1, "אקשן"),
        Tag(2, "קומדיה"),
        Tag(3, "דרמה")
    )

    suspend fun getAllTags(): List<Tag> {
        delay(200)
        return tags.toList()
    }

    suspend fun addTag(tag: Tag) {
        val nextId = (tags.maxByOrNull { it.id }?.id ?: 0) + 1
        tags.add(tag.copy(id = nextId))
    }

    suspend fun deleteTag(tag: Tag) {
        tags.removeIf { it.id == tag.id }
    }
}

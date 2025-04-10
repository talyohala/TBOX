package com.tbox.app.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tbox.app.models.Tag

@Entity(tableName = "tags")
data class TagEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
)

fun TagEntity.toDomain(): Tag = Tag(id = id, name = name)
fun Tag.toEntity(): TagEntity = TagEntity(id = id, name = name)

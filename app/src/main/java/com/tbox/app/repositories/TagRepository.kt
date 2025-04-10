package com.tbox.app.repositories

import com.tbox.app.database.daos.TagDao
import com.tbox.app.models.Tag
import com.tbox.app.models.toDomain
import com.tbox.app.models.toEntity
import javax.inject.Inject

class TagRepository @Inject constructor(
    private val tagDao: TagDao
) {
    suspend fun getAllTags(): List<Tag> = tagDao.getAll().map { it.toDomain() }

    suspend fun addTag(tag: Tag) = tagDao.insert(tag.toEntity())

    suspend fun deleteTag(tag: Tag) = tagDao.delete(tag.toEntity())
}

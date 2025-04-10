package com.tbox.app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tbox.app.models.Tag
import com.tbox.app.repositories.TagRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TagViewModel @Inject constructor(
    private val repository: TagRepository
): ViewModel() {

    private val _tags = MutableStateFlow<List<Tag>>(emptyList())
    val tags: StateFlow<List<Tag>> = _tags

    init {
        loadTags()
    }

    fun loadTags() {
        viewModelScope.launch {
            _tags.value = repository.getAllTags()
        }
    }

    fun addTag(tag: Tag) {
        viewModelScope.launch {
            repository.addTag(tag)
            loadTags()
        }
    }

    fun deleteTag(tag: Tag) {
        viewModelScope.launch {
            repository.deleteTag(tag)
            loadTags()
        }
    }
}

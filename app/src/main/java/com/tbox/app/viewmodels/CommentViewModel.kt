package com.tbox.app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tbox.app.data.entities.CommentEntity
import com.tbox.app.repository.CommentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(
    private val repository: CommentRepository
) : ViewModel() {

    private val _comments = MutableStateFlow<List<CommentEntity>>(emptyList())
    val comments: StateFlow<List<CommentEntity>> = _comments

    fun loadComments(movieId: String) {
        viewModelScope.launch {
            _comments.value = repository.getCommentsForMovie(movieId)
        }
    }

    fun addComment(comment: CommentEntity, movieId: String) {
        viewModelScope.launch {
            repository.addComment(comment)
            loadComments(movieId)
        }
    }

    fun deleteComment(comment: CommentEntity, movieId: String) {
        viewModelScope.launch {
            repository.deleteComment(comment)
            loadComments(movieId)
        }
    }
}

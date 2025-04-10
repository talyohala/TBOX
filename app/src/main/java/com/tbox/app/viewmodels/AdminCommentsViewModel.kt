package com.tbox.app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tbox.app.models.Comment
import com.tbox.app.repositories.CommentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminCommentsViewModel @Inject constructor(
    private val repository: CommentRepository
) : ViewModel() {

    private val _comments = MutableStateFlow<List<Comment>>(emptyList())
    val comments: StateFlow<List<Comment>> = _comments

    fun loadComments(movieId: String = "all") {
        viewModelScope.launch {
            _comments.value = repository.getCommentsForMovie(movieId)
        }
    }

    fun deleteComment(comment: Comment) {
        viewModelScope.launch {
            repository.deleteComment(comment)
            loadComments()
        }
    }
}

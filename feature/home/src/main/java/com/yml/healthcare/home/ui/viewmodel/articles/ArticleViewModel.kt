package com.yml.healthcare.home.ui.viewmodel.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yml.healthcare.home.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(val repository: HomeRepository) : ViewModel() {

/*    // Create Initial State of View
    private val initialState: HomeViewState by lazy {  }*/

    private val _viewState: MutableStateFlow<ArticlesViewState> =
        MutableStateFlow(ArticlesViewState.UnInitialized())
    val viewState get() = _viewState.asStateFlow()

    private val intent: MutableSharedFlow<ArticleUserIntent> = MutableSharedFlow()

    private val _effect: Channel<ArticlesNavEffect> = Channel()
    val homeEffect
        get() = _effect.receiveAsFlow()

    init {
        subscribeIntent()
    }

    /**
     * Start listening to Intent
     */
    private fun subscribeIntent() {
        viewModelScope.launch {
            intent.collect {
                handleUserIntent(it)
            }
        }
    }

    /**
     * Set new UserIntent
     */
    fun performAction(intent: ArticleUserIntent) {
        viewModelScope.launch {
            this@ArticleViewModel.intent.emit(intent)
        }
    }

    /**
     * Emit new ViewState
     */
    private fun emitViewState(reduce: ArticlesViewState.() -> ArticlesViewState) {
        val newState = viewState.value.reduce()
        _viewState.value = newState
    }

    /**
     * Set new NavEffect
     */
    private fun sendNavEffect(builder: () -> ArticlesNavEffect) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }

    private fun handleUserIntent(intent: ArticleUserIntent) {
        when (intent) {
            ArticleUserIntent.FetchArticles -> {
                // emit loading
                emitViewState { ArticlesViewState.InitialLoading() }
                sendNavEffect {
                    ArticlesNavEffect.SnackMessage("Fetching Data")
                }
                viewModelScope.launch {
                    val homeData = repository.fetchArticles()
                    emitViewState {
                        ArticlesViewState.Loaded(homeData)
                    }
                }
            }
            else -> {}
        }
    }

}
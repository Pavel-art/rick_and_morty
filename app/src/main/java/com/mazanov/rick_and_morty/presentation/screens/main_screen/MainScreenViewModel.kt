package com.mazanov.rick_and_morty.presentation.screens.main_screenimport androidx.lifecycle.LiveDataimport androidx.lifecycle.MutableLiveDataimport androidx.lifecycle.ViewModelimport androidx.lifecycle.viewModelScopeimport com.mazanov.rick_and_morty.domain.models.PersonModel.Companion.TOTAL_PAGESimport com.mazanov.rick_and_morty.domain.useCases.GetAllCharactersUseCaseimport dagger.hilt.android.lifecycle.HiltViewModelimport kotlinx.coroutines.flow.launchInimport kotlinx.coroutines.flow.onEachimport kotlinx.coroutines.flow.onStartimport javax.inject.Inject@HiltViewModelclass MainScreenViewModel @Inject constructor(    private val getAllCharactersUseCase: GetAllCharactersUseCase) : ViewModel() {    private val _mainScreenState = MutableLiveData<MainScreenState>(MainScreenState.Initial)    val mainScreenState = _mainScreenState    private var _isNextPage = MutableLiveData(false)    val isNextPage: LiveData<Boolean> = _isNextPage    private val _page = MutableLiveData(1)    init {        _mainScreenState.value = MainScreenState.Loading        getAllCharactersFromRepository()    }    private fun getAllCharactersFromRepository(page: Int = _page.value ?: 1) {        try {            getAllCharactersUseCase.invoke(page)                .onStart { _isNextPage.value = false }                .onEach { response ->                    _mainScreenState.value = MainScreenState.Load(content = response)                }                .launchIn(viewModelScope)        } catch (error: Exception) {            _mainScreenState.value = MainScreenState.Error(exception = error.message.toString())        }    }    fun getNextPage() {        if (requireNotNull(_page.value) < TOTAL_PAGES) {            val nexPage = nextCountPage()            _isNextPage.value = true            getAllCharactersFromRepository(nexPage)        }    }    private fun nextCountPage(): Int {        if (requireNotNull(_page.value) < TOTAL_PAGES) {            _page.value = _page.value?.plus(1)        }        return _page.value ?: 1    }}
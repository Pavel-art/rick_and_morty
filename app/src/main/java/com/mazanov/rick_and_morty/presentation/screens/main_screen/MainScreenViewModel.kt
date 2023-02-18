package com.mazanov.rick_and_morty.presentation.screens.main_screenimport androidx.lifecycle.MutableLiveDataimport androidx.lifecycle.ViewModelimport androidx.lifecycle.viewModelScopeimport com.mazanov.rick_and_morty.domain.models.PersonModel.Companion.TOTAL_PAGESimport com.mazanov.rick_and_morty.domain.useCases.GetAllCharactersUseCaseimport dagger.hilt.android.lifecycle.HiltViewModelimport kotlinx.coroutines.launchimport javax.inject.Inject@HiltViewModelclass MainScreenViewModel @Inject constructor(    private val getAllCharactersUseCase: GetAllCharactersUseCase) : ViewModel() {    private val _mainScreenState = MutableLiveData<MainScreenState>(MainScreenState.Initial)    val mainScreenState = _mainScreenState    private val _page = MutableLiveData(1)    init {        _mainScreenState.value = MainScreenState.Loading        getAllCharactersFromRepository()    }    private fun getAllCharactersFromRepository(page: Int = _page.value ?: 1) {        viewModelScope.launch {            try {                val response = getAllCharactersUseCase.invoke(page)                _mainScreenState.value = MainScreenState.Load(content = response)            } catch (error: Exception) {                _mainScreenState.value = MainScreenState.Error(exception = error.message.toString())            }        }    }    fun getNextPage() {        if (requireNotNull(_page.value) < TOTAL_PAGES)            viewModelScope.launch {                val secondPage = nextCountPage()                val nextPage = nextCountPage()                try {                    val response = getAllCharactersUseCase.invoke(secondPage)                    _mainScreenState.value = MainScreenState.Load(                        content = response,                        nextDataIsLoading = true                    )                    getAllCharactersFromRepository(nextPage)                } catch (error: Exception) {                    _mainScreenState.value =                        MainScreenState.Error(exception = error.message.toString())                }            }    }    private fun nextCountPage(): Int {        if (requireNotNull(_page.value) < TOTAL_PAGES) {            _page.value = _page.value?.plus(1)        }        return _page.value ?: 1    }}
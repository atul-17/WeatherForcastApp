package com.atul.apps10xsampleproject.viewmodels


import androidx.lifecycle.*
import com.atul.apps10xsampleproject.data.WeatherInfoRepo
import com.atul.apps10xsampleproject.data.retrofit_response.ModelForecastDataEntity
import com.atul.apps10xsampleproject.utils.DataState
import com.atul.apps10xsampleproject.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherInfoViewModel
@Inject constructor(
    val weatherInfoRepo: WeatherInfoRepo,
     val savedStateHandle: SavedStateHandle
 ) : ViewModel(){

private val _dateState :
        MutableLiveData<DataState<ModelForecastDataEntity>> = MutableLiveData()

    val dataState : LiveData<DataState<ModelForecastDataEntity>>
    get() = _dateState

    fun setStateEvent(mainStateEvent: MainStateEvent){
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetWeatherForecastEvents->{
                    weatherInfoRepo.getForecastData()
                        .onEach {
                        dataState ->
                        _dateState.value = dataState
                    }.launchIn(viewModelScope)
                }
                is MainStateEvent.None->{

                }
            }
        }
    }




//    fun getWeatherData() = liveData(Dispatchers.IO) {
//        emit(Resource.loading(data = null))
//        try {
//            emit(Resource.success(data = weatherInfoRepo.getCurrentWeatherData()))
//        }catch (exception:Exception){
//            emit(Resource.error(data = null,message = exception.message?:"Something went wrong"))
//        }
//    }

//    fun getForecastData() = liveData(Dispatchers.IO) {
//        emit(Resource.loading(data = null))
//        try {
//            emit(Resource.success(data = weatherInfoRepo.getForecastData()))
//        }catch (ex:Exception){
//            emit(Resource.error(data = null,message = ex.message?:"Something went wrong"))
//        }
//    }
}
sealed class MainStateEvent{
    object GetWeatherForecastEvents : MainStateEvent()
    object None : MainStateEvent()
}
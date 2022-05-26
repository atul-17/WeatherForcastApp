package com.atul.apps10xsampleproject.ui.activities


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.atul.apps10xsampleproject.R
import com.atul.apps10xsampleproject.data.ApiHelper
import com.atul.apps10xsampleproject.data.retrofit_response.ModelForecastDataEntity
import com.atul.apps10xsampleproject.databinding.WeatherForecastActivityLayoutBinding
import com.atul.apps10xsampleproject.ui.fragments.SomethingWentWrongFragment
import com.atul.apps10xsampleproject.ui.fragments.WeatherInfoDetailsFragment
import com.atul.apps10xsampleproject.utils.DataState
import com.atul.apps10xsampleproject.utils.RetrofitBuilder
import com.atul.apps10xsampleproject.utils.Status
import com.atul.apps10xsampleproject.viewmodels.MainStateEvent
import com.atul.apps10xsampleproject.viewmodels.WeatherInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
class WeatherInfoActivity : AppCompatActivity() {

    private lateinit var weatherForecastActivityLayoutBinding: WeatherForecastActivityLayoutBinding

//    private  var viewModelProvider : ViewModelProvider?=null
//    private lateinit var weatherInfoViewModel: WeatherInfoViewModel

    private val viewModel: WeatherInfoViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weatherForecastActivityLayoutBinding =
            WeatherForecastActivityLayoutBinding.inflate(layoutInflater)
        val rootView = weatherForecastActivityLayoutBinding.root
        setContentView(rootView)

        //setupWeatherInfoViewModel()
        setUpObservers()
        //MVI arch
        viewModel.setStateEvent(MainStateEvent.GetWeatherForecastEvents)
    }


//    private fun setupWeatherInfoViewModel(){
//        viewModelProvider = ViewModelProvider(this,ViewModelFactory(ApiHelper(RetrofitBuilder.apiService)))
//       weatherInfoViewModel =  viewModelProvider!!.get(WeatherInfoViewModel::class.java)
//
//    }

    private fun showProgressBar() {
        weatherForecastActivityLayoutBinding.progressBar.visibility = View.VISIBLE
    }

    private fun dismissProgressBar() {
        weatherForecastActivityLayoutBinding.progressBar.visibility = View.GONE
    }

    fun setUpObservers() {
        showProgressBar()
        viewModel.dataState.observe(this, Observer { dataState ->
            when (dataState) {
                is DataState.Success<ModelForecastDataEntity> -> {
                    //TOdo
                    Log.d(
                        WeatherInfoActivity::class.simpleName,
                        dataState.data.city?.name.toString()
                    )
                }
                is DataState.Error -> {

                }
                is DataState.Loading -> {

                }
            }
        })
    }
}













//        weatherInfoViewModel.getWeatherData().observe(this, Observer {
//            it?.let { resource ->
//                when (resource.status) {
//                    Status.SUCCESS -> {
//                        //Toast.makeText(this, "Sucess", Toast.LENGTH_LONG).show()
//                       // var weatherInfoDetailsFragment = WeatherInfoDetailsFragment()
//                        resource.data?.let { weatherInfoData->
//
//                            var bundle = Bundle()
//                            bundle.putSerializable("weatherInfoData",weatherInfoData)
//
//                            supportFragmentManager.beginTransaction()
//                                .add(
//                                    R.id.fragmentContainer,
//                                    WeatherInfoDetailsFragment::class.java, bundle,"WeatherInfoFragment")
//                                .commit()
//                                dismissProgressBar()
//                        }
//                    }
//                    Status.ERROR -> {
//                        dismissProgressBar()
//                        supportFragmentManager.beginTransaction()
//                            .add(  R.id.fragmentContainer,SomethingWentWrongFragment::class.java,null, "SomethingWentWrongFragment")
//                            .commit()
//                    }
//                }
//}
//})

//        weatherInfoViewModel.getForecastData().observe(this, Observer {
//            it?.let { resource ->
//                when (resource.status) {
//                    Status.SUCCESS -> {
//                        resource.data?.let {
//                                forecastData->
//                            val fm: FragmentManager = supportFragmentManager
//
//                            val fragment: WeatherInfoDetailsFragment =
//                                fm.findFragmentByTag("WeatherInfoFragment") as WeatherInfoDetailsFragment
//                            fragment.compareDatesAndToList(forecastData.list)
//
//
//                        }
//                    }
//                    Status.ERROR -> {
//
//                    }
//  }
//}
//})
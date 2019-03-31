package com.app.newsapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.newsapp.data.model.NewsFeedResponse
import com.app.newsapp.data.repository.NewsFeedRepository
import com.app.newsapp.dependency.module.SCHEDULER_IO
import com.app.newsapp.dependency.module.SCHEDULER_MAIN_THREAD
import io.reactivex.Scheduler
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject
import javax.inject.Named


/**
 * @author Pranav Bhoraskar
 *
 * @see <a href="https://developer.android.com/topic/libraries/architecture/viewmodel.html">
 *     ViewModel </a>
 *
 */
class MainViewModel @Inject constructor(
    private var newsFeedRepository: NewsFeedRepository,
    @Named(SCHEDULER_IO) private val subscribeOnScheduler: Scheduler,
    @Named(SCHEDULER_MAIN_THREAD) private val observeOnScheduler: Scheduler
) : ViewModel() {

    lateinit var disposableObserver: DisposableObserver<NewsFeedResponse>

    var newsApiLiveData = MutableLiveData<NewsFeedResponse>()
    var responseError = MutableLiveData<String>()
    var responseLoader = MutableLiveData<Boolean>()

    /**
     * Function to initiate DisposableObserver and then make network call to fetch the data.
     *
     * Repository instance is used to make the necessary network calls.
     */
    fun fetchNewsFeed() {
        getDisposableObserever()

        newsFeedRepository.fetchNewsFeed(getQueryParameters(), getLimitParameters())
            .subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
            .subscribe(disposableObserver)
    }

    private fun getLimitParameters(): HashMap<String, Int> {
        val queryMap = HashMap<String, Int>()
        queryMap.put("pageSize", 100)
        return queryMap
    }

    private fun getQueryParameters(): HashMap<String, String> {
        val queryMap = HashMap<String, String>()
        queryMap.put("country", "in")
        queryMap.put("category", "general")
        return queryMap
    }

    /**
     * @return newsApiLiveData - LiveData<NewsFeedResponse>
     */
    fun newsApiSuccess(): LiveData<NewsFeedResponse> = newsApiLiveData

    /**
     * @return responseError - LiveData<String>
     */
    fun newsApiError(): LiveData<String> = responseError

    /**
     * @return responseLoader - LiveData<Boolean>
     */
    fun newsApiLoader(): LiveData<Boolean> = responseLoader

    /**
     * Function for DisposableObserver
     */
    private fun getDisposableObserever() {
        disposableObserver = object : DisposableObserver<NewsFeedResponse>() {
            override fun onComplete() {
            }

            override fun onNext(response: NewsFeedResponse) {
                newsApiLiveData.postValue(response)
                responseLoader.postValue(false)
            }

            override fun onError(error: Throwable) {
                responseError.postValue(error.message)
                responseLoader.postValue(false)
            }
        }
    }

    fun disposeObserver() {
        if (disposableObserver != null && !disposableObserver.isDisposed) {
            disposableObserver.dispose()
        }
    }

}
# NewsFeedApp

Android App to fetch News Feed from India powered by <a href="https://newsapi.org/"><b>NewsAPI.org</b></a>. App shows all the top headlines.


### Architecture and Libraries used
------------------------------------

* Kotlin
* [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/) - MVVM design pattern + [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel.html) + [LiveData](https://developer.android.com/topic/libraries/architecture/livedata.html)
* Dependency Injection ([Dagger2](http://google.github.io/dagger/)) to separate configuration (properties, imageClient, httpClient, etc.) and UI usage
* [RxJava & RxAndroid](https://github.com/ReactiveX/RxAndroid) as Retrofit2 call adapter - NetworkInterceptor, OkHttpClient
* [Glide](https://github.com/bumptech/glide) library for image processing
* [Timber](https://github.com/JakeWharton/timber) for logging
* [Mockito](http://mockito.org/) for unit testing

### Screenshots
------------------------------------
<p align="left">
 <img height="380" src="https://github.com/pbhoraskar911/NewsFeedApp/blob/master/screenshots/NewsFeed4.png" />
 <img height="380" src="https://github.com/pbhoraskar911/NewsFeedApp/blob/master/screenshots/NewsFeed1.png" />
 <img height="380" src="https://github.com/pbhoraskar911/NewsFeedApp/blob/master/screenshots/NewsFeed2.png" />
 <img height="380" src="https://github.com/pbhoraskar911/NewsFeedApp/blob/master/screenshots/NewsFeed3.png" />
 </p><br>

### Developed By
------------------------------------

* Pranav Bhoraskar

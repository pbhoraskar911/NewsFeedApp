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

 ![Screenshot1 - Launcher](/screenshots/NewsFeed4.png)
 ![Screenshot2](/screenshots/NewsFeed1.png)
 ![Screenshot3](/screenshots/NewsFeed2.png)
 ![Screenshot4](/screenshots/NewsFeed3.png)

### Developed By
------------------------------------

* Pranav Bhoraskar

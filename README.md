# simple-offline-caching-app
Simple MVVM app gets its data from REST API and caches them phone storage locally. 

This app is built by MVVM architecture. This app gets its data from REST API with the help of Retrofit2 and Kotlin Coroutines and caches them to Room database. NetworkBoundResource helper method is implemented with the help of Kotlin Flow. Dependencies are injected by Hilt.

<a href="https://random-data-api.com/">Random Data API</a>

<a href="https://github.com/raheemadamboev/simple-offline-caching-app/blob/master/app-debug.apk">Demo app</a>

**Screenshots:**

<img src="https://github.com/raheemadamboev/simple-offline-caching-app/blob/master/video_2021-10-27_01-02-49.gif" alt="Italian Trulli" width="200" height="434">

**Tech stack:**

- MVVM
- Dependency Injection (Hilt)
- ViewBinding
- Kotlin Courotines
- Retrofit
- Flow, Livedata
- Git
- Caching (NetworkBoundResource)
- Room
- Glide

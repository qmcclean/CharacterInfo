CharacterInfoApp
A simple demo project for DuckDuckGo DB based on MVVM clean architecture.

App Features
Users can view list of Simpsons character of their choice.
Users can view list of The Wire character of their choice.
Users can filter the list of names based on title or description.
Users can click on any character and see detailed information about the character.

App Architecture
Based on mvvm architecture and repository pattern.

The app includes the following main components:
A web api service.
A repository that works with the database and the api service, providing a unified data interface.
A ViewModel that provides data specific for the UI.
The UI, which shows a visual representation of the data in the ViewModel.

App Packages
api - contains the api classes to make api calls to DuckDuckGo server, using Retrofit.
repository - contains the repository classes, responsible for triggering api requests and saving the response in the database.
di - contains dependency injection classes, using Koin.
ui - contains classes needed to display Activity and Fragment.

App Specs
Minimum SDK 17
Java8 (in master branch) & Kotlin (in kotlin_support branch)
MVVM Architecture
Android Architecture Components (LiveData, Lifecycle, ViewModel, ConstraintLayout)
Koin for dependency injection.
Retrofit 2 for API integration.
Gson for serialisation.
Okhhtp3 for implementing interceptor, logging and mocking web server.
Picasso for image loading.

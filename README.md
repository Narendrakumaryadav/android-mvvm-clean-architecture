# Android MVVM + Clean Architecture

This is android application to show the MVVM design pattern with Clean Architecture approach. This application is having koin as dependency injection

# Moduler programming

This is multi module application, This application have 4 modules

> App (Presentation) module : This module has UI layer and having all UI component like Activity, Fragment, Adapter etc.
> Domain module : This module has domain layer and having all business logic like UseCase
> Data module : This module has data layer and having datat form remote or local like Repository implementation 
> Common module : This module has common code or classes for other project also like Base classes, components etc.

# Communication between layers

> UI calls method from ViewModel.
> ViewModel executes Use case.
> Use case get data from Repositories.
> Each Repository returns data from a Data Source (Cached or Remote).
> Information flows back to the UI where we display.

# In this project you'll find:

> Kotlin Coroutines for background operations.
> A single-activity architecture, using the Navigation component to manage fragment operations.
> A presentation layer that contains a fragment (View) and a ViewModel per screen (or feature).
> Reactive UIs using Flow collected and Data Binding.
> A data layer with a repository (remote) that are queried with one-shot operations (no listeners or data streams).
> A collection of unit tests of each layer.

# Screenshot

![Screenshot_1648711266](https://user-images.githubusercontent.com/1405127/161000084-a9f72162-5561-4597-8118-e00d7e63aff6.png)
![Screenshot_1648711270](https://user-images.githubusercontent.com/1405127/161000114-bf377da2-a09a-4b60-b6d0-d726565e8dae.png)


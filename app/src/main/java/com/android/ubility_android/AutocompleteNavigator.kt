package com.android.ubility_android

/**
 * Allows navigation within place view model because functionality is only available in fragments and activities
 * resource for inspiration
 * https://github.com/googlesamples/android-architecture/blob/todo-mvvm-databinding/todoapp/app/src/main/java/com/example/android/architecture/blueprints/todoapp/tasks/TasksNavigator.java
 */
interface AutocompleteNavigator {
    fun navigateToPlace()
}
package com.mazanov.rick_and_morty.presentation.navigationimport androidx.compose.runtime.Composableimport androidx.compose.runtime.rememberimport androidx.navigation.NavHostControllerimport androidx.navigation.compose.rememberNavControllerclass NavigationState(    val navHostController: NavHostController) {    fun navigateTo(rout: String) {        navHostController.navigate(rout) {            launchSingleTop = true        }    }}@Composablefun rememberNavigationState(    navHostController: NavHostController = rememberNavController()): NavigationState {    return remember {        NavigationState(navHostController)    }}
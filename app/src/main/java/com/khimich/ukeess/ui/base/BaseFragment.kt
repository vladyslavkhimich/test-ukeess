package com.khimich.ukeess.ui.base

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.khimich.ukeess.R

abstract class BaseFragment : Fragment() {
    open fun getNavOptions(): NavOptions? {
        return NavOptions.Builder()
            .setEnterAnim(R.anim.nav_enter_anim)
            .setExitAnim(R.anim.wait_anim)
            .setPopEnterAnim(R.anim.wait_anim)
            .setPopExitAnim(R.anim.nav_pop_exit_anim)
            .build()
    }

    fun navigate(destination: NavDirections, navOptions: NavOptions? = null) {
        val navController = NavHostFragment.findNavController(this)
        val navDestination = navController.currentDestination
        if (navDestination != null) {
            val navAction = navDestination.getAction(destination.actionId)
            if (navAction != null) {
                navController.navigate(destination, navOptions ?: getNavOptions())
            }
        }
    }
}
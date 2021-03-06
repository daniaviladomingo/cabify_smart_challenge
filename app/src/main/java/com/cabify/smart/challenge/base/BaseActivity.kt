package com.cabify.smart.challenge.base

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.cabify.smart.challenge.R
import com.cabify.smart.challenge.di.activity.DaggerActivity
import com.cabify.smart.challenge.ui.data.ResourceState
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.view_error.*
import javax.inject.Inject

abstract class BaseActivity : DaggerActivity(){

    @Inject
    protected lateinit var fragmentManager: FragmentManager

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory


    var toolbar: Toolbar? = null
    private lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (getLayoutId() == 0) {
            throw RuntimeException("Invalid Layout ID")
        }

        setContentView(R.layout.activity_base)

        view = layoutInflater.inflate(getLayoutId(), null)
        (view_base as FrameLayout).addView(view, LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT))

        view_empty.emptyListener = checkAgain()
        view_error.errorListener = tryAgain()

        initializeToolbar()
    }

    private fun initializeToolbar() {}

    protected abstract fun getLayoutId(): Int

    protected fun managementResourceState(resourceState: ResourceState, message: String?) {
        when (resourceState) {
            ResourceState.LOADING -> {
                view.visibility = VISIBLE
                view_error.visibility = GONE
                view_empty.visibility = GONE
                view_progress.visibility = VISIBLE
            }
            ResourceState.SUCCESS -> {
                view.visibility = VISIBLE
                view_error.visibility = GONE
                view_empty.visibility = GONE
                view_progress.visibility = GONE
            }
            ResourceState.EMPTY -> {
                view.visibility = GONE
                view_error.visibility = GONE
                view_empty.visibility = VISIBLE
                view_progress.visibility = GONE
            }
            ResourceState.ERROR -> {
                view.visibility = GONE
                view_error.visibility = VISIBLE
                error_message.text = message ?: ""
                view_empty.visibility = GONE
                view_progress.visibility = GONE
            }
        }
    }

    abstract fun checkAgain(): () -> Unit

    abstract fun tryAgain(): () -> Unit
}
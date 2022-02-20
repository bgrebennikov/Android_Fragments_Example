package com.edricaazaza.learningfragments.ui.fragments.base

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import java.lang.IllegalStateException
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentBindingDelegate<T: ViewBinding>(
    private val fragment: Fragment,
    private val viewBindingFactory : (View) -> T
) : ReadOnlyProperty<Fragment, T> {

    private var _binding : T? = null

    init {
        fragment.lifecycle.addObserver(object : LifecycleEventObserver{
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                if(event == Lifecycle.Event.ON_CREATE){
                    fragment.viewLifecycleOwnerLiveData.observe(fragment, Observer {
                        it.lifecycle.addObserver(object: LifecycleEventObserver{
                            override fun onStateChanged(
                                source: LifecycleOwner,
                                event: Lifecycle.Event
                            ) {
                                if(event == Lifecycle.Event.ON_DESTROY) _binding = null
                            }

                        })
                    })
                }
            }

        })
    }


    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        val binding = _binding
        if(binding != null) return binding

        val lifecycle = fragment.viewLifecycleOwner.lifecycle

        if(lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)){
            throw IllegalStateException("Should not initialized lifecycle when fragment is destroyed")
        }

        return viewBindingFactory.invoke(thisRef.requireView()).also {
            _binding = it
        }
    }

}

fun <T: ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> T) = FragmentBindingDelegate(this, viewBindingFactory)
package com.edricaazaza.learningfragments.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.edricaazaza.learningfragments.MainActivity.Companion.MAIN_FRAGMENT_CONTAINER
import com.edricaazaza.learningfragments.databinding.FragmentHomeBinding
import com.edricaazaza.learningfragments.ui.fragments.base.BaseFragment
import com.edricaazaza.learningfragments.ui.fragments.base.viewBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(MAIN_FRAGMENT_CONTAINER, SecondFragment.newInstance())
                .addToBackStack(this::class.simpleName)
                .commit()
        }

    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
package com.edricaazaza.learningfragments.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edricaazaza.learningfragments.R
import com.edricaazaza.learningfragments.databinding.FragmentSecondBinding
import com.edricaazaza.learningfragments.ui.fragments.base.BaseFragment
import com.edricaazaza.learningfragments.ui.fragments.base.viewBinding

class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

    }

    companion object {
        fun newInstance() = SecondFragment()
    }
}
package com.edricaazaza.learningfragments.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edricaazaza.learningfragments.R
import com.edricaazaza.learningfragments.databinding.FragmentArticleBinding

private const val TITLE_ARG = "title"
private const val BODY_ARG = "body"

class ArticleFragment : Fragment() {

    private var titleArg : String? = null
    private var bodyArg : String? = null

    private var _binding : FragmentArticleBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            titleArg = it.getString(TITLE_ARG)
            bodyArg = it.getString(BODY_ARG)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.title.text = titleArg
        binding.body.text = bodyArg

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(title: String, body: String) : ArticleFragment {
            return ArticleFragment().apply {
                arguments = Bundle().apply {
                    putString(TITLE_ARG, title)
                    putString(BODY_ARG, body)
                }
            }
        }
    }




}
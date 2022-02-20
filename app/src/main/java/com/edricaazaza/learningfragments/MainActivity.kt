package com.edricaazaza.learningfragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.edricaazaza.learningfragments.databinding.ActivityMainBinding
import com.edricaazaza.learningfragments.ui.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(MAIN_FRAGMENT_CONTAINER, HomeFragment.newInstance())
                .commit()
        }


    }

    companion object {
        const val MAIN_FRAGMENT_CONTAINER = R.id.fragmentContainerMain
    }

}
package com.demo.fragmentdemo3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSend.setOnClickListener {
            val msg = textMessage.text.toString()
            if(msg.isNotEmpty()){
                val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(msg)
                Navigation.findNavController(view).navigate(action)
            } else {
                Snackbar.make(requireView(),"Please enter message", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

}
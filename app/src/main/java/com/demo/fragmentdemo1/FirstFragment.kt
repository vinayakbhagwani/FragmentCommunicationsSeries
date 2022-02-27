package com.demo.fragmentdemo1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import java.lang.Exception
import java.lang.RuntimeException

class FirstFragment : Fragment() {

    lateinit var firstFragmentListener: FirstFragmentListener
    lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v: View = inflater.inflate(R.layout.fragment_first, container, false)
        editText = v.findViewById<EditText>(R.id.editText)
        var btnOk: Button = v.findViewById<Button>(R.id.btnOk)
        btnOk.setOnClickListener(View.OnClickListener {
            var input = editText.text.toString()
            firstFragmentListener.onInputFirstSent(input)
        })

        return v;
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FirstFragmentListener) {
            firstFragmentListener = context as FirstFragmentListener
        } else {
            throw Exception(RuntimeException(context.toString()
            + " must implement FirstFragmentListener"))
        }
    }

    override fun onDetach() {
        super.onDetach()
        //set firstFragmentListener as null
    }

    fun updateEditText(newtext: String) {
        editText.setText(newtext)
    }
}
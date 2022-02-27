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

class SecondFragment : Fragment() {

    lateinit var secondFragmentListener: SecondFragmentListener
    lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v: View = inflater.inflate(R.layout.fragment_second, container, false)
        editText = v.findViewById<EditText>(R.id.edit_text)
        var btnOk: Button = v.findViewById<Button>(R.id.btnOk)
        btnOk.setOnClickListener(View.OnClickListener {
            var input = editText.text.toString()
            secondFragmentListener.onInputSecondSent(input)
        })

        return v;
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is SecondFragmentListener) {
            secondFragmentListener = context as SecondFragmentListener
        } else {
            throw Exception(RuntimeException(context.toString()
                    + " must implement SecondFragmentListener"))
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
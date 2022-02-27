package com.demo.fragmentdemo2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class SecondFragment : Fragment() {

    lateinit var editText: EditText
    lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v: View = inflater.inflate(R.layout.fragment_second, container, false)
        editText = v.findViewById<EditText>(R.id.edit_text)
        var btnOk: Button = v.findViewById<Button>(R.id.btnOk)
        btnOk.setOnClickListener(View.OnClickListener {
            var input = editText.text.toString()
            sharedViewModel.setText(input)
        })

        return v;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        sharedViewModel.text.observe(viewLifecycleOwner, Observer { editText.setText(it) })
    }
}
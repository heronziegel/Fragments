package com.example.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner

class ColorSelectionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_color_selection, container, false)

        val spinner = layout.findViewById<Spinner>(R.id.spinner)

        // requireContext() == context!!
        spinner.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, arrayOf("White", "Red","Yellow", "Black", "Cyan"))

        spinner.onItemSelectedListener = object: OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                p0?.run{
                    layout.setBackgroundColor(Color.parseColor(getItemAtPosition(p2).toString()))
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        return layout
    }

}
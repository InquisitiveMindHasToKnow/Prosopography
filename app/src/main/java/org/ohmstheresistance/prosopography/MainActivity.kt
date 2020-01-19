package org.ohmstheresistance.prosopography

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.prosopography.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }


    private fun addNickName(view: View) {


        binding.apply {
            invalidateAll()
            binding.nickNameTextview.text = binding.nickNameEditText.text
            binding.nickNameEditText.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nickNameTextview.visibility = View.VISIBLE

        }

        val hideKeyboardWhenDone =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hideKeyboardWhenDone.hideSoftInputFromWindow(view.windowToken, 0)


    }
}

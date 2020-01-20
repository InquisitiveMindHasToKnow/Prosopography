package org.ohmstheresistance.prosopography

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.prosopography.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Jeremy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }

        binding.myName = myName
    }


    private fun addNickName(view: View) {


        binding.apply {
            invalidateAll()
//            binding.nickNameTextview.text = binding.nickNameEditText.text

            //because binding data directly using the MyName class, the line below does exactly what the commented line above did!
            myName?.nickname = nickNameEditText.text.toString()
            binding.nickNameEditText.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nickNameTextview.visibility = View.VISIBLE

        }

        val hideKeyboardWhenDone =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hideKeyboardWhenDone.hideSoftInputFromWindow(view.windowToken, 0)


    }
}

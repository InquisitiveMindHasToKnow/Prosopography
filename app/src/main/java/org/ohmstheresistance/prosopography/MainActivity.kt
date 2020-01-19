package org.ohmstheresistance.prosopography

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View){

        val nickNameEdittext = findViewById<EditText>(R.id.nickname_editText)
        val nickNameTextView = findViewById<TextView>(R.id.nickname_textview)

        nickNameTextView.text = nickNameEdittext.text
        nickNameEdittext.visibility = View.GONE
        view.visibility = View.GONE
        nickNameTextView.visibility = View.VISIBLE


        val hideKeyboardWhenDone = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hideKeyboardWhenDone.hideSoftInputFromWindow(view.windowToken, 0)


    }
}

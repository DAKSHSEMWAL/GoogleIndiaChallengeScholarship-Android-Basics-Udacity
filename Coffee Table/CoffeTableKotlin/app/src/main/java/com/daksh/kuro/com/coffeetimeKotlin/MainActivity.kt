package com.daksh.kuro.com.coffeetimeKotlin

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


import java.text.NumberFormat

/**
 * This app displays an order form to order coffee.
 */
class MainActivity : AppCompatActivity() {

    internal var quantity = 0
    internal var cpc = 0
    internal var price = 0
    lateinit var caramel: CheckBox
    lateinit var wpc: CheckBox
    lateinit var choclate: CheckBox
    lateinit var user: String
    lateinit var us: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        us = findViewById<View>(R.id.user) as EditText
        user = us.text.toString()
        caramel = findViewById(R.id.caramel)
        wpc = findViewById(R.id.Whipped_cream)
        choclate = findViewById(R.id.choclate)


    }

    /**
     * This method is called when the order button is clicked.
     */
    fun submitOrder(view: View) {


        var message = "Welcome to Café de Piccolo\nName: $user"
        message = (message + "\nNumber of Cups: " + quantity + "\nWhipped Cream: " + wpc.isChecked + "\nCaramel:"
                + caramel.isChecked + "\nChoclate: " + choclate.isChecked + "\nPrice: $" + price)
        message = "$message\nThank You!"
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order For $user")
        intent.putExtra(Intent.EXTRA_TEXT, message)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
        displayMessage(message)
    }

    /**
     * This method is called when the + button is clicked.
     */
    fun increment(view: View) {
        cpc = 150
        if (caramel.isChecked) {
            cpc = cpc + 20
        }
        if (wpc.isChecked) {
            cpc = cpc + 25
        }
        if (choclate.isChecked) {
            cpc = cpc + 30
        }
        quantity = quantity + 1
        displayQuantity(quantity)
        price = cpc * quantity
        displayPrice(price)
    }

    fun add4(view: View) {
        cpc = 147
        if (caramel.isChecked) {
            cpc = cpc + 20
        }
        if (wpc.isChecked) {
            cpc = cpc + 25
        }
        if (choclate.isChecked) {
            cpc = cpc + 30
        }

        quantity = quantity + 4
        price = cpc * quantity
        displayQuantity(quantity)
        displayPrice(price)

    }

    /**
     * This method is called when the - button is clicked.
     */
    fun decrement(view: View) {
        cpc = 150
        quantity = quantity - 1
        if (caramel.isChecked) {
            cpc = cpc + 20
        }
        if (wpc.isChecked) {
            cpc = cpc + 25
        }
        if (choclate.isChecked) {
            cpc = cpc + 30
        }

        if (quantity <= 0) {
            quantity = 0
            price = 0
            displayPrice(price)
            displayQuantity(quantity)
        } else {
            price = cpc * quantity
            displayQuantity(quantity)
            displayPrice(price)
        }
    }

    fun getUser(view: View) {}

    /**
     * This method displays the given quantity value on the screen.
     */
    private fun displayQuantity(number: Int) {
        val quantityTextView = findViewById<View>(R.id.quantity) as TextView
        quantityTextView.text = "" + number
    }

    /**
     * This method displays the given price value on the screen.
     */
    private fun displayPrice(number: Int) {
        val price = findViewById<View>(R.id.price) as TextView
        price.text = NumberFormat.getCurrencyInstance().format(number.toLong())
    }

    /**
     * This method displays the message on the screen.
     */
    private fun displayMessage(message: String) {
        val price = findViewById<View>(R.id.price) as TextView
        price.text = message
    }
}

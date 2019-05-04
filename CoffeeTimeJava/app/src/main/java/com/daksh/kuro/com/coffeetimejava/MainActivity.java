package com.daksh.kuro.com.coffeetimejava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int cpc = 0;
    int price = 0;
    CheckBox caramel,wpc,choclate;
    String user;
    EditText us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        us = (EditText) findViewById(R.id.user);
        user = us.getText().toString();
        caramel = findViewById(R.id.caramel);
        wpc = findViewById(R.id.Whipped_cream);
        choclate = findViewById(R.id.choclate);


    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {



        String message = "Welcome to Café de Piccolo\nName: " + user;
        message = message + "\nNumber of Cups: " + quantity + "\nWhipped Cream: " + wpc.isChecked() + "\nCaramel:"
                + caramel.isChecked() + "\nChoclate: " + choclate.isChecked() + "\nPrice: $" + price;
        message = message + "\nThank You!";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order For " + user);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        displayMessage(message);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        cpc = 150;
        if (caramel.isChecked()) {
            cpc =cpc + 20;
        }
        if (wpc.isChecked()) {
            cpc = cpc + 25;
        }
        if (choclate.isChecked()) {
            cpc = cpc + 30;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
        price = cpc * quantity;
        displayPrice(price);
    }

    public void add4(View view) {
        cpc = 147;
        if (caramel.isChecked()) {
            cpc =cpc + 20;
        }
        if (wpc.isChecked()) {
            cpc = cpc + 25;
        }
        if (choclate.isChecked()) {
            cpc = cpc + 30;
        }

        quantity = quantity + 4;
        price = cpc * quantity;
        displayQuantity(quantity);
        displayPrice(price);

    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        cpc = 150;
        quantity = quantity - 1;
        if (caramel.isChecked()) {
            cpc =cpc + 20;
        }
        if (wpc.isChecked()) {
            cpc = cpc + 25;
        }
        if (choclate.isChecked()) {
            cpc = cpc + 30;
        }

        if (quantity <= 0) {
            quantity=0;
            price = 0;
            displayPrice(price);
            displayQuantity(quantity);
        } else {
            price = cpc * quantity;
            displayQuantity(quantity);
            displayPrice(price);
        }
    }

    public void getUser(View view) {
        ;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price value on the screen.
     */
    private void displayPrice(int number) {
        TextView price = (TextView) findViewById(R.id.price);
        price.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the message on the screen.
     */
    private void displayMessage(String message) {
        TextView price = (TextView) findViewById(R.id.price);
        price.setText(message);
    }
}

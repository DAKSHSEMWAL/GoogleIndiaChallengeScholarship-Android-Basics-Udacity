package com.example.dsemw.justjava;

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

    int quantity=0;
    int cpc=150;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view)
    {
        int price=0;
        EditText us=(EditText) findViewById(R.id.user);
        String user=us.getText().toString();
        CheckBox caramel=findViewById(R.id.caramel);
        CheckBox wpc=findViewById(R.id.Whipped_cream);
        CheckBox choclate=findViewById(R.id.choclate);
        if(caramel.isChecked()==true)
        {
            price=quantity*(cpc+20);
        }
        if(wpc.isChecked()==true)
        {
            price=quantity*(cpc+25);
        }
        if(choclate.isChecked()==true)
        {
            price=quantity*(cpc+30);
        }
        else
        {
            price=quantity*cpc;
        }
        String message="Welcome to Café de Piccolo\nName: "+user;
        message=message+"\nNumber of Cups: "+quantity+"\nWhipped Cream: "+wpc.isChecked()+"\nCaramel:"
                +caramel.isChecked()+"\nChoclate: "+choclate.isChecked()+"\nPrice: $"+price;
        message=message+"\nThank You!";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT,"Order For "+user);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        if(intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent);
        }
        displayMessage(message);
    }
    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        quantity=quantity+1;
        displayQuantity(quantity);
    }
    public void add4(View view) {
        cpc=147;
        quantity=quantity+4;
        displayQuantity(quantity);
    }
    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        quantity=quantity-1;
        displayQuantity(quantity);
    }

    public void getUser(View view)
    {
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
    private void displayPrice(int number){
        TextView price = (TextView) findViewById(R.id.price);
        price.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the message on the screen.
     */
    private void displayMessage(String message){
        TextView price = (TextView) findViewById(R.id.price);
        price.setText(message);
    }
}

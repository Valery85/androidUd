package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int quatintityCups = 2;
    private int priceOfCup = 5;
    private boolean isWhippedCream = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_id);
//        if (checkBox.isChecked()) {
//            checkBox.setChecked(false);
//        }

    }

    public void isWhippedCream(View view){
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_id);
        if (checkBox.isChecked()){
            isWhippedCream = true;
            Log.i("MainActivity", "isWhippedCream: " + isWhippedCream + " !");
        } else {
            isWhippedCream = false;
            Log.i("MainActivity", "isWhippedCream: " + isWhippedCream + " !");
        }
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String messageToCustumer = "Total:  $" + quatintityCups*priceOfCup + "\n" +
                "Add whipped cream? " + isWhippedCream + "\n" +
                "Thank you!";
        //       display(quatintityCups);
        //      displayPrice(quatintityCups*priceOfCup);
        displayMessage(messageToCustumer);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given price with message to customer on the screen.
     */

    private void displayMessage(String message) {
        TextView priceMessageView = (TextView) findViewById(R.id.price_text_view);
        priceMessageView.setText(message);
    }

    public void increment(View view) {
        quatintityCups++;
        display(quatintityCups);
    }

    public void decrement(View view) {
        quatintityCups--;
        display(quatintityCups);
    }

}
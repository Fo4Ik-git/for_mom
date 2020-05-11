package com.fo4ik.formom.ui.home;

import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeBrains extends AppCompatActivity {

    public void calculate(EditText surface, EditText lakme, EditText powder, EditText oxi, EditText time, EditText discount, TextView res) {
        float materials = 0;
        float expenses = 0;
        float full = 0;
        HomeFragment homeFragment = new HomeFragment();
        String[] data = new String[]{"30", "40", "50"};
        int pos = homeFragment.pos;


        try {
            if (!surface.getText().toString().equals("")) {
                float sufface_float = sum(surface.getText().toString());
                materials = materials + (sufface_float * 15);
            }
            if (!lakme.getText().toString().equals("")) {
                float lakme_float = sum(lakme.getText().toString());
                materials = materials + (lakme_float * 10);
            }
            if (!powder.getText().toString().equals("")) {
                float powder_float = sum(powder.getText().toString());
                materials = materials + (powder_float * 5);
            }
            if (!oxi.getText().toString().equals("")) {
                float oxi_float = sum(oxi.getText().toString());
                materials = materials + oxi_float;
            }
            if (!time.getText().toString().equals("")) {
                float time_float = Float.parseFloat(time.getText().toString());
                expenses = expenses + (time_float * 600);
            }
            if (!discount.getText().toString().equals("")) {
                float discount_float = Float.parseFloat(discount.getText().toString());
                float tmp = (expenses * discount_float) / 100;
                expenses = expenses - tmp;

            }


            full = materials + expenses;
            materials = materials + Integer.parseInt(data[pos]);

                    res.setText(
                            "Материалы: " + materials + " \n" + "Работа: " + expenses + " \n" + "Общее: " + full + " \n"

                    );

        } catch (Exception e) {
            res.setText("Error");
        }


    }


    public float sum(String value) {
        float tmp_float = 0;
        String[] tmp = value.split("\\+");
        for (int i = 0; i < tmp.length; i++) {
            tmp_float = tmp_float + Float.parseFloat(tmp[i]);
        }

        return tmp_float;
    }

}

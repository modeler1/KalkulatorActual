package ru.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText1;
    EditText editText2;
    int rezult1;
    int rezult2;
    int result;
    String status;
    int metka = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView4);
        editText1 = (EditText)findViewById(R.id.editTextTextPersonName);
        editText2 = (EditText)findViewById(R.id.editTextTextPersonName2);




    }

    public void plus(View view)
    {
        status = "plus";
        proverkaTexta();


    }
    public void minus(View view)
    {
        status = "minus";
        proverkaTexta();


    }
    public void umnoshenie(View view)
    {
        status = "umnoshenie";
        proverkaTexta();


    }
    public void delenie(View view)
    {
        status = "delenie";
        proverkaTexta();

    }

    void resultat()
    {

        Log.e("1111", String.valueOf(result));
        if (metka == 1)
        {
            textView.setText(String.valueOf(result));
        }
        if (metka == 2)
        {
            String resultSTR = String.valueOf(result);
            if (resultSTR.length() <= 2 )
            {
                char resultSTRvn1 = resultSTR.charAt(0);
                char resultSTRvn2 = resultSTR.charAt(1);
                String resultSTRvnn1 = letterToNumber(resultSTRvn1);
                String resultSTRvnn2 = letterToNumber(resultSTRvn2);
                String resultStRACT = resultSTRvnn1 + resultSTRvnn2;
                textView.setText(String.valueOf(result));
            }
            if (resultSTR.length() == 3 )
            {
                textView.setText("C");
            }


        }


    }

    void proverkaTexta()
    {
        String rezult1_check = editText1.getText().toString();
        String rezult2_check  = editText2.getText().toString();

        if (rezult1_check.length() < 1 || rezult2_check.length() < 1) {
            textView.setText("Введите значения!");
        }
        else if (rezult1_check.length() > 10 || rezult2_check.length() > 10)
        {
            textView.setText("Необходимо чтобы каждое число не было больше 10ти");
        }
        else
        {
            Log.e("тест", String.valueOf(Roman.valueOf("X").toInt()));
            switch (status) {
                case  ("plus"):
                    try{
                        rezult1 = Integer.parseInt(editText1.getText().toString());
                        rezult2 = Integer.parseInt(editText2.getText().toString());
                        metka = 1;
                    } catch (NumberFormatException e) {
                        rezult1 = Roman.valueOf(editText1.getText().toString()).toInt();
                        rezult2 = Roman.valueOf(editText2.getText().toString()).toInt();
                        metka = 2;
                    }
                    result = rezult1 + rezult2;
                    resultat();
                    break;
                case ("minus"):
                    try{
                        rezult1 = Integer.parseInt(editText1.getText().toString());
                        rezult2 = Integer.parseInt(editText2.getText().toString());
                        metka = 1;
                    } catch (NumberFormatException e) {
                        rezult1 = Roman.valueOf(editText1.getText().toString()).toInt();
                        rezult2 = Roman.valueOf(editText2.getText().toString()).toInt();
                        metka = 2;
                    }
                    result = rezult1 - rezult2;
                    resultat();
                    break;
                case ("umnoshenie"):
                    try{
                        rezult1 = Integer.parseInt(editText1.getText().toString());
                        rezult2 = Integer.parseInt(editText2.getText().toString());
                        metka = 1;
                    } catch (NumberFormatException e) {
                        rezult1 = Roman.valueOf(editText1.getText().toString()).toInt();
                        rezult2 = Roman.valueOf(editText2.getText().toString()).toInt();
                        metka = 2;
                    }
                    result = rezult1 * rezult2;
                    resultat();
                    break;
                case ("delenie"):
                    try{
                        rezult1 = Integer.parseInt(editText1.getText().toString());
                        rezult2 = Integer.parseInt(editText2.getText().toString());
                        metka = 1;
                    } catch (NumberFormatException e) {
                        rezult1 = Roman.valueOf(editText1.getText().toString()).toInt();
                        rezult2 = Roman.valueOf(editText2.getText().toString()).toInt();
                        metka = 2;
                    }
                    result = rezult1 / rezult2;
                    resultat();
                    break;
            }

        }

    }


    public enum Roman {
        I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), IIX(8), IX(9), X(10),;
        private final int value;
        private Roman(int value) {
            this.value = value;
        }
        public int toInt() {
            return value;
        }
    }


    private static String letterToNumber(int letter){
        switch (letter) {
            case 1:  return "I";
            case 2:  return "II";
            case 3:  return "III";
            case 4:  return "IV";
            case 5:  return "V";
            case 6:  return "VI";
            case 7:  return "VII";
            case 8:  return "IIX";
            case 9:  return "IX";
            case 10:  return "X";
            default:   return "C";
        }
    }




}
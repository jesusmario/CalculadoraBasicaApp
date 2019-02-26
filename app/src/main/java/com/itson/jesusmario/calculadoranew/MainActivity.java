package com.itson.jesusmario.calculadoranew;

import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.widget.Toast;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private double subtotal = 0;
Button boton0, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9,
    botonPunto, botonSumar, botonRestar, botonMultiplicacion, botonDividir, botonIgual, botonC, botonCE, btnencender;

String operacion;
int valorInicial;

TextView txtview1,txtview2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se Enlazan con el textview donde es mostrado el numero en la pantalla.
        txtview1 = (TextView) findViewById(R.id.textview);
        txtview2 = (TextView) findViewById(R.id.textview2);


        //Programación de los botones numéricos de la calculadora.
        boton0 = (Button) findViewById(R.id.btn0);
        boton0.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                txtview2.setText(txtview2.getText()+"0");
            }

        });


        boton1 = (Button) findViewById(R.id.btn1);
        boton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                txtview2.setText(txtview2.getText()+"1");
            }
        });

        boton2 = (Button) findViewById(R.id.btn2);
        boton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                txtview2.setText(txtview2.getText()+"2");
            }
        });

        boton3 = (Button) findViewById(R.id.btn3);
        boton3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                txtview2.setText(txtview2.getText()+"3");
            }
        });

        boton4 = (Button) findViewById(R.id.btn4);
        boton4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                txtview2.setText(txtview2.getText()+"4");
            }
        });

        boton5 = (Button) findViewById(R.id.btn5);
        boton5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                txtview2.setText(txtview2.getText()+"5");
            }
        });

        boton6 = (Button) findViewById(R.id.btn6);
        boton6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                txtview2.setText(txtview2.getText()+"6");
            }
        });

        boton7 = (Button) findViewById(R.id.btn7);
        boton7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                txtview2.setText(txtview2.getText()+"7");
            }
        });

        boton8 = (Button) findViewById(R.id.btn8);
        boton8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                txtview2.setText(txtview2.getText()+"8");
            }
        });

        boton9 = (Button) findViewById(R.id.btn9);
        boton9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                txtview2.setText(txtview2.getText()+"9");
            }
        });



        //Programacion del boton de suma
        botonSumar = (Button) findViewById(R.id.btnmas);
        botonSumar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                subtotal = Double.valueOf((String) txtview2.getText()).doubleValue();
                txtview2.setText("");
                txtview1.setText("+");
            }

        });



        //Restar la operacion
        botonRestar = (Button) findViewById(R.id.btnmenos);
        botonRestar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                subtotal = Double.valueOf((String) txtview2.getText()).doubleValue();
                txtview2.setText("");
                txtview1.setText("-");
            }

        });


        //Multiplicar
        botonMultiplicacion = (Button) findViewById(R.id.btnmultiplicar);
        botonMultiplicacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                subtotal = Double.valueOf((String) txtview2.getText()).doubleValue();
                txtview2.setText("");
                txtview1.setText("X");

            }

        });

        //Código del botón para dividir en la calculadora.
        botonDividir = (Button) findViewById(R.id.btndividir);
        botonDividir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                subtotal = Double.valueOf((String) txtview2.getText()).doubleValue();
                txtview2.setText("");
                txtview1.setText("/");
            }

        });



        //Se obtiene el resultado al presionar el botón igual =.
        botonIgual = (Button) findViewById(R.id.btnigual);
        botonIgual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double numero = Double.valueOf((String) txtview2.getText()).doubleValue();
                String operacion = txtview1.getText().toString();
                if (operacion != "") {
                    if (operacion == "+")
                        subtotal = numero + subtotal;
                    else if (operacion == "-")
                        subtotal = subtotal - numero;
                    else if (operacion == "X")
                        subtotal = subtotal * numero;
                    else if (operacion == "/")
                        subtotal = subtotal / numero;
                    String resultado = String.valueOf(subtotal);
                    int longitud = resultado.length();

                    //Si acaba en .0 muestro como entero
                    if ((resultado.charAt(longitud - 2) == '.') && (resultado.charAt(longitud - 1) == '0'))
                        resultado = resultado.substring(0, resultado.length() - 2);
                    txtview2.setText(resultado);
                    txtview1.setText("");
                }
            }

        });




        //Al presionar el boton C vacia todos los campos donde se han ingresado los datos.
        botonC = (Button) findViewById(R.id.btnc);
        botonC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                subtotal = 0;
                txtview2.setText("");
                txtview1.setText("");
            }

        });

        btnencender = (Button)findViewById(R.id.btnencender);
        btnencender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    txtview1.setText("");
            }
        });

        //Representa el código de la función del botón CE donde se elimina el último digito tecleado en la calculadora.
        botonCE = (Button) findViewById(R.id.btnce);
        botonCE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operacion= txtview2.getText().toString();
                operacion="";
                String [] array = operacion.split("");
                for (int i = 0; i<array.length-1; i++){

                    operacion+=array[i];
                }
                txtview2.setText(operacion);
            }

        });





    }
}

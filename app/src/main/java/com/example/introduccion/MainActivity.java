package com.example.introduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declarar las variables
    EditText etCantidad;
    EditText etTipoCambio;
    TextView tvResultado;
    RadioGroup rgMoneda;
    ImageView ivBanderas;
    CheckBox chkMostratImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //e es una clase estática
        Log.e("TAG", "Paso por onCreate");

        //Inicializar las variables
        //Encontrar el elementos por medio de su ID, da una referencia
        etCantidad = findViewById(R.id.edtCantidad);
        etTipoCambio = findViewById(R.id.edtTipoCambio);
        tvResultado = findViewById(R.id.tvResultado);
        ivBanderas = findViewById(R.id.ivBanderas);

        rgMoneda = findViewById(R.id.rgMoneda);
        chkMostratImagen = findViewById(R.id.chkMostratImagen);

        chkMostratImagen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    ivBanderas.setVisibility(View.VISIBLE);
                }
                else
                {
                    ivBanderas.setVisibility(View.GONE);
                }
            }
        });

        //Agregar un listener-> un objeto de otra clase
        rgMoneda.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if (etCantidad.getText().toString().isEmpty())
                {
                    etCantidad.setText("1");
                }
                if (etTipoCambio.getText().toString().isEmpty())
                {
                    etTipoCambio.setText("1");
                }
                double dblCantidad = 0;
                double dblTipoCambio = 0;
                double dblResultado = 0;

                dblCantidad = Double.parseDouble(etCantidad.getText().toString());
                dblTipoCambio = Double.parseDouble(etTipoCambio.getText().toString());

                //Verificar cual es el radioButton seleccionado
                switch (checkedId)
                {
                    case R.id.rbPesoDolares:
                        dblResultado = dblCantidad / dblTipoCambio;
                        ivBanderas.setImageResource(R.drawable.pesos_dolares);
                        break;

                    default:
                        dblResultado = dblCantidad * dblTipoCambio;
                        ivBanderas.setImageResource(R.drawable.dolares_pesos);
                        break;
                }
                tvResultado.setText("Resultado: " + dblResultado);
            }
        });//Se crea un objeto
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        Log.e("TAG", "Paso por onStart");
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        Log.e("TAG", "Paso por onResume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        Log.e("TAG", "Paso por onPause");
    }

    @Override
    protected void onStop()
    {
        super.onStop();

        Log.e("TAG", "Paso por onStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        Log.e("TAG", "Paso por onDestroy");
    }
}
/*
    //Método para convertir al dar clic sobre el botón
    public void Convertir(View view) //Tipo de dato, nombre de la variable
    {
        if (etCantidad.getText().toString().isEmpty())
        {
            etCantidad.setText("0");
        }
        if (etTipoCambio.getText().toString().isEmpty())
        {
            etTipoCambio.setText("0");
        }

        //getText() para obtener el texto, establecer setText()
        /*double dblCantidad = Double.parseDouble(etCantidad.getText().toString());
        double dblTipoCambio = Double.parseDouble(etTipoCambio.getText().toString());
        //double dblResultado = dblCantidad / 18.4;
        double dblResultado = dblCantidad / dblTipoCambio;

        tvResultado.setText("Resultado: " + dblResultado);*/
        /*
        double dblCantidad = 0;
        double dblTipoCambio = 0;
        double dblResultado = 0;

        dblCantidad = Double.parseDouble(etCantidad.getText().toString());
        dblTipoCambio = Double.parseDouble(etTipoCambio.getText().toString());

        //Preguntar directamente al radio group que radio button esta seleccionado
        if (rgMoneda.getCheckedRadioButtonId() == R.id.rbPesoDolares)
        {
            dblResultado = dblCantidad / dblTipoCambio;
        }
        else
        {
            dblResultado = dblCantidad * dblTipoCambio;
        }

        tvResultado.setText("Resultado: " + dblResultado);
    }
}*/
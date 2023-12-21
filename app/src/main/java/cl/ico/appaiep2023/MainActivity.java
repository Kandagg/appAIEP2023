package cl.ico.appaiep2023;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //1 - Crear objetos de lo que están en las activitys
    private EditText texto1;
private EditText pass;
private Button limpiar,accion,calcular;
private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        /* Create a new user with a first and last name*/
        Map<String, Object> user = new HashMap<>();
                user.put("First", "Camila");
                user.put("Last", "Gomez");
                user.put("Born", 1993);

// Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener (new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}" + documentReference.getId());
            }
        })

                .addOnFailureListener (new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                       Log.w(TAG, "Error adding document", e);
                }
          });

        //2 - Casting de los objetos y asociarlos a los de la activity
        texto1=(EditText)findViewById(R.id.txtMensaje);
        pass=(EditText)findViewById(R.id.txtPassword);
        limpiar=(Button)findViewById(R.id.btnLimpiar);
        accion=(Button)findViewById(R.id.btnAccion);
        resultado=(TextView)findViewById(R.id.lblResultado);
        calcular=(Button)findViewById(R.id.btnCalcular);

        //3- Programacion de los eventos de la activity
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto1.setText("");
                pass.setText("");
                resultado.setText("0");
                texto1.requestFocus();
            }
        });
        accion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  texto1.setText("Hola Mundo Android!!!");
            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=10;
                int b=Integer.parseInt(texto1.getText().toString());
                int r=a+b;
                resultado.setText(String.valueOf(r));

            }
        });

    }
}
package com.example.luisyao.lab_8;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    EditText et_nombre;
    EditText et_correo;
    EditText et_numero;
    Button guardar;
    Button borrar;
    Button actualizar;
    Button adelante;
    Button atras;
    ListView lista_contacto;

    List <contact> listaContacto;
    CustomAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //definir los controles que estan en el main.xml

        et_nombre = (EditText) findViewById(R.id.et1);
        et_correo = (EditText) findViewById(R.id.et2);
        et_numero = (EditText) findViewById(R.id.et3);

        guardar = (Button) findViewById(R.id.bt_insert);
        borrar = (Button) findViewById(R.id.bt_delete);
        actualizar = (Button) findViewById(R.id.bt_update);

        adelante = (Button) findViewById(R.id.bt_adelante);
        atras = (Button) findViewById(R.id.bt_atras);

        listaContacto = new ArrayList<contact>();
        lista_contacto = (ListView) findViewById(R.id.lv_contacts);
        adapter = new CustomAdapter(MainActivity.this,listaContacto);
        lista_contacto.setAdapter(adapter);

        setContactlist();

        //Abrir la bd en modo escritura

        ClaseSQLiteBD1 csql = new ClaseSQLiteBD1(this, "Estudiantes.db", null, 1);

        final SQLiteDatabase db = csql.getWritableDatabase();

        //creando un cursor para obtener los datos de la BD
        final Cursor c = db.rawQuery("select * from contacto", null);

        //declaracion del proveedor de contenidos
        final ContentValues nuevoRegistro = new ContentValues();

        //declaracion de builder
        final AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
        alerta.setCancelable(true);
        alerta.setTitle("Mensaje de Seguridad");
        alerta.setMessage("Está seguro(a) que desea realizar esta acción?");


        //boton guardar
        guardar.setOnClickListener(new

                                           OnClickListener() {
                                               public void onClick(View v) {

                                                   alerta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                                       @Override
                                                       public void onClick(DialogInterface dialogInterface, int i) {

                                                           //seteamos los registros al contenedor
                                                           nuevoRegistro.put("NOMBRE", et_nombre.getText().toString());
                                                           nuevoRegistro.put("CORREO", et_correo.getText().toString());
                                                           nuevoRegistro.put("NÚMERO", et_numero.getText().toString());


                                                           //insertamos el nuevo registro a la BD usando insert
                                                           db.insert("contacto", null, nuevoRegistro);
                                                           Toast.makeText(getApplicationContext(), "Contacto añadido correctamente", Toast.LENGTH_LONG).show();
                                                           et_nombre.setText("");
                                                           et_correo.setText("");
                                                           et_numero.setText("");


                                                       }

                                                   });

                                                   alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                                       @Override
                                                       public void onClick(DialogInterface dialogInterface, int i) {
                                                           dialogInterface.cancel();
                                                       }
                                                   });

                                                   final AlertDialog dialog = alerta.create();
                                                   dialog.show();

                                                   setContactlist();

                                               }
                                           });

        //boton borrar
        borrar.setOnClickListener(new

                                          OnClickListener() {
                                              public void onClick(View v) {
                                                  try {

                                                      alerta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                                          @Override
                                                          public void onClick(DialogInterface dialogInterface, int i) {

                                                              db.delete("contacto", "_id=?", new String[]{String.valueOf(c.getInt(0))});
                                                              et_nombre.setText("");
                                                              et_correo.setText("");
                                                              et_numero.setText("");


                                                              Context context = getApplicationContext();
                                                              CharSequence text = "REGISTRO ELIMINADO";
                                                              int duration = Toast.LENGTH_LONG;

                                                              Toast toast = Toast.makeText(context, text, duration);
                                                              toast.show();
                                                          }

                                                      });

                                                      alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                                          @Override
                                                          public void onClick(DialogInterface dialogInterface, int i) {
                                                              dialogInterface.cancel();
                                                          }
                                                      });

                                                      final AlertDialog dialog = alerta.create();
                                                      dialog.show();
                                                      setContactlist();

                                                  } catch (Exception e) {

                                                  }

                                              }
                                          });

        //actualizar
        actualizar.setOnClickListener(new

                                              OnClickListener() {
                                                  public void onClick(View arg0) {
                                                      try {
                                                          alerta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                                              @Override
                                                              public void onClick(DialogInterface dialogInterface, int i) {

                                                                  nuevoRegistro.put("NOMBRE", et_nombre.getText().toString());
                                                                  nuevoRegistro.put("CORREO", et_correo.getText().toString());
                                                                  nuevoRegistro.put("NÚMERO", et_numero.getText().toString());

                                                                  int cant = db.update("contacto", nuevoRegistro, "_id=?", new String[]{String.valueOf(c.getInt(0))});

                                                                  if (cant == 1)
                                                                      Toast.makeText(getApplicationContext(), "Se modificaron los datos", Toast.LENGTH_SHORT).show();
                                                                  else
                                                                      Toast.makeText(getApplicationContext(), "No existe un contacto con dicho documento", Toast.LENGTH_SHORT).show();
                                                              }

                                                          });

                                                          alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                                              @Override
                                                              public void onClick(DialogInterface dialogInterface, int i) {
                                                                  dialogInterface.cancel();
                                                              }
                                                          });

                                                          final AlertDialog dialog = alerta.create();
                                                          dialog.show();
                                                          setContactlist();
                                                      } catch (Exception e) {

                                                      }


                                                  }
                                              });

        //boton atras
        atras.setOnClickListener(new

                                         OnClickListener() {
                                             public void onClick(View v) {
                                                 // TODO Auto-generated method stub
                                                 try {
                                                     //mueve el cursor una posicion atras
                                                     c.moveToPrevious();
                                                     et_nombre.setText(c.getString(1));
                                                     et_correo.setText(c.getString(2));
                                                     et_numero.setText(c.getString(3));

                                                 } catch (Exception e) {

                                                 }
                                             }

                                         });

        //boton adelante
        adelante.setOnClickListener(new

                                            OnClickListener() {
                                                public void onClick(View v) {
                                                    // TODO Auto-generated method stub
                                                    try {
                                                        //mueve el cursor una posicion adelante
                                                        c.moveToNext();
                                                        et_nombre.setText(c.getString(1));
                                                        et_correo.setText(c.getString(2));
                                                        et_numero.setText(c.getString(3));
                                                    } catch (Exception e) {

                                                    }
                                                }

                                            });
    }

    public void setContactlist(){
        ClaseSQLiteBD1 csql = new ClaseSQLiteBD1(this, "Estudiantes.db", null, 1);
        listaContacto = csql.getAllcontact();
        adapter.setAdapterData(listaContacto);
        adapter.notifyDataSetChanged();

    }
}
package id.ac.poliban.mi.purnamae020317039;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Switch Switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch switch1 = findViewById(R.id.switch1);
        Button btClear = findViewById(R.id.btClear);
        Button btSubmit= findViewById(R.id.btSubmit);
        EditText etNim = findViewById(R.id.etNim);
        EditText etNama = findViewById(R.id.etNama);
        EditText etAlamat = findViewById(R.id.etAlamat);
        EditText etTelp = findViewById(R.id.etTelp);
        TextView tvNim = findViewById(R.id.tvNim);
        TextView tvNama = findViewById(R.id.tvNama);
        TextView tvAlamat = findViewById(R.id.tvAlamat);
        TextView tvTelp = findViewById(R.id.tvTelp);
        TextView tvGender = findViewById(R.id.tvGender);
        RadioGroup jk = findViewById(R.id.jk);
        RadioButton rbLaki = findViewById(R.id.rblaki);
        RadioButton rbPer = findViewById(R.id.rbPer);
        RadioButton pilihan;
        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(switch1.isChecked()){
                etNama.setEnabled(true);
                etNim.setEnabled(true);
                etAlamat.setEnabled(true);
                jk.setEnabled(true);
                etTelp.setEnabled(true);
                rbLaki.setEnabled(true);
                rbPer.setEnabled(true);
                btSubmit.setEnabled(true);
                btClear.setEnabled(true);
            } else {
                etNama.setEnabled(false);
                etNim.setEnabled(false);
                etAlamat.setEnabled(false);
                jk.setEnabled(false);
                etTelp.setEnabled(false);
                rbLaki.setEnabled(false);
                rbPer.setEnabled(false);
                btSubmit.setEnabled(false);
                btClear.setEnabled(false);
            }
        });

        int selectRadio = jk.getCheckedRadioButtonId();
        pilihan = (RadioButton)findViewById(selectRadio);


        jk.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton radioButton = jk.findViewById(checkedId);
                    }
                }
        );

        btSubmit.setOnClickListener(v ->{
            {
                String jenisKelamin;
                if (rbLaki.isChecked()){
                    jenisKelamin = "Laki - laki";
                }else{
                    jenisKelamin = "Perempuan";
                }
            }
            new AlertDialog.Builder(this).setTitle("Info")
                    .setMessage("Nim: "+etNim.getText().toString()+"\n"+"Nama: "+etNama.getText().toString()+"\n"+"Gender: "+jk.getCheckedRadioButtonId()+"\n"
                            +"Alamat: "+etAlamat.getText().toString()+"\n"+"Telp: "+etTelp.getText().toString()+"\n").setNegativeButton("Cancel", null).setPositiveButton("Ok",null).show();

        });

        btClear.setOnClickListener(v -> {

        etNim.setText("");
        etNama.setText("");
        etAlamat.setText("");
        etTelp.setText("");
        jk.clearCheck();
    });

}}






package com.ipbeja.estig.packagetracker3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EditCarrierActivity extends AppCompatActivity {

    private Carrier carrier = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_carrier);

        Intent intent = getIntent();

        if(intent.hasExtra("CarrierEdit")){
            this.carrier = (Carrier) intent.getSerializableExtra("CarrierEdit");
        }else {
            this.carrier = new Carrier();
        }
        this.updateLayoutFromCarrier();
    }

    private void updateLayoutFromCarrier() {

        TextView txtID = (TextView) findViewById(R.id.txtEditCarrierId);
        EditText txtName = (EditText) findViewById(R.id.txtEditCarrierName);
        EditText txtSlug = (EditText) findViewById(R.id.txtEditCarrierSlug);
        EditText txtOther = (EditText) findViewById(R.id.txtEditCarrierOther);
        EditText txtURL = (EditText) findViewById(R.id.txtEditCarrierURL);

        txtID.setText("" + this.carrier.getId());
        txtName.setText((this.carrier.getName() == null ? "" : this.carrier.getName()));
        txtSlug.setText((this.carrier.getSlug() == null ? "" : this.carrier.getSlug()));
        txtOther.setText((this.carrier.getOtherName() == null ? "" : this.carrier.getOtherName()));
        txtURL.setText((this.carrier.getUrl() == null ? "" : this.carrier.getUrl()));

    }

    private void updateCarrierFromLayout(){

        EditText txtName = (EditText) findViewById(R.id.txtEditCarrierName);
        EditText txtSlug = (EditText) findViewById(R.id.txtEditCarrierSlug);
        EditText txtOther = (EditText) findViewById(R.id.txtEditCarrierOther);
        EditText txtURL = (EditText) findViewById(R.id.txtEditCarrierURL);

        this.carrier.setName(txtName.getText().toString());
        this.carrier.setSlug(txtSlug.getText().toString());
        this.carrier.setOtherName(txtOther.getText().toString());
        this.carrier.setUrl(txtURL.getText().toString());

    }

    @Override
    public void finish(){
        this.updateCarrierFromLayout();
        Intent res = new Intent();
        res.putExtra("EditedCarrier", this.carrier);
        setResult(RESULT_OK, res);
        super.finish();
    }
}

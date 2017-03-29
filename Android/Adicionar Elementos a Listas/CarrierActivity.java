package com.ipbeja.estig.packagetracker3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CarrierActivity extends AppCompatActivity {

    private List<Carrier> carriers = new ArrayList<>();
    private final static int EDIT_CARRIER = 234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrier);

        this.updateViewCarrierNumber();

    }

    private void updateViewCarrierNumber() {
        TextView txtCarrierNumber = (TextView) findViewById(R.id.txtNrCarriers);
        txtCarrierNumber.setText("" + this.carriers.size());
    }

    public void addCarrier_click(View view) {

        Carrier carrier = new Carrier(Carrier.getNextCarrierID());
        this.carriers.add(carrier);

        this.updateViewCarrierNumber();

        Intent intent = new Intent(this, EditCarrierActivity.class);
        intent.putExtra("CarrierEdit", carrier);
        startActivityForResult(intent, CarrierActivity.EDIT_CARRIER);

    }

    public void editCarrier_click(View view) {

        TextView txtCarrierID = (TextView) findViewById(R.id.txtCarrierID);
        String sNum = txtCarrierID.getText().toString();

        if (sNum.length() == 0) {
            Toast.makeText(this, "Empty Number u Dumbass", Toast.LENGTH_SHORT).show();
        } else {
            int numCarrier = 0;
            try {
                numCarrier = Integer.parseInt(sNum);
            } catch (Exception ignored) {

            }
            if (numCarrier <= 0 || numCarrier > this.carriers.size()) {
                Toast.makeText(this, "Invalid Carrier number", Toast.LENGTH_SHORT).show();
            } else {
                numCarrier--;
                Carrier carrier = this.carriers.get(numCarrier);
                Intent intent = new Intent(this, EditCarrierActivity.class);
                intent.putExtra("CarrierEdit", carrier);
                startActivityForResult(intent, CarrierActivity.EDIT_CARRIER);
            }
        }

    }

    public void deleteCarrier_click(View view) {

        EditText txtCarrierNumber = (EditText) findViewById(R.id.txtCarrierID);
        String sNum = txtCarrierNumber.getText().toString();

        if (sNum.length() == 0) {
            Toast.makeText(this, "Empty number", Toast.LENGTH_SHORT).show();
        } else {
            int numCarrier = 0;
            try {
                numCarrier = Integer.parseInt(sNum);
            } catch (Exception ignored) {
            }
            if (numCarrier <= 0 || numCarrier > this.carriers.size()) {
                Toast.makeText(this, "Invalid carrier number.", Toast.LENGTH_SHORT).show();
            } else {
                numCarrier--;
                this.carriers.remove(numCarrier);

                this.updateViewCarrierNumber();
            }
        }


    }

    public void viewCarrier_click(View view) {

        EditText txtCarrierNumber = (EditText) findViewById(R.id.txtCarrierID);
        String sNum = txtCarrierNumber.getText().toString();

        if (sNum.length() == 0) {
            Toast.makeText(this, "Empty Number", Toast.LENGTH_SHORT).show();
        } else {
            int numCarrier = 0;
            try {
                numCarrier = Integer.parseInt(sNum);
            } catch (Exception ex) {
                //Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show();
            }
            if (numCarrier <= 0 || numCarrier > this.carriers.size()) {
                Toast.makeText(this, "Invalid client number.", Toast.LENGTH_SHORT).show();
            } else {
                numCarrier--;
                Carrier carrier = this.carriers.get(numCarrier);
                Toast.makeText(this, this.clientToString(carrier), Toast.LENGTH_LONG).show();
            }
        }

    }

    private String clientToString(Carrier carrier) {
        return
                "ID: " + (carrier.getId() > 0 ? carrier.getId() : "----") +
                        "\nName: " + (carrier.getName() != null ? carrier.getName() : "----") +
                        "\nPhone: " + (carrier.getSlug() != null ? carrier.getSlug() : "----") +
                        "\nOther Name: " + (carrier.getOtherName() != null ? carrier.getOtherName() : "---") +
                        "\nUrl :" + (carrier.getUrl() != null ? carrier.getUrl() : "----");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == CarrierActivity.EDIT_CARRIER) {
            if(resultCode == RESULT_OK){
                if (data.hasExtra("EditedCarrier")){
                    Carrier carrier = (Carrier) data.getSerializableExtra("EditedCarrier");
                    for (int i = 0 ; i < this.carriers.size(); i++){
                        if (this.carriers.get(i).getId() == carrier.getId()){
                            this.carriers.remove(i);
                            this.carriers.add(carrier);
                            break;
                        }
                    }
                }
            }else {
                Toast.makeText(this, "Carrier edition canceled", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

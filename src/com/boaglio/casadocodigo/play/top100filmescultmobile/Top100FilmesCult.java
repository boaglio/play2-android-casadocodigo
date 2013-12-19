package com.boaglio.casadocodigo.play.top100filmescultmobile;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;

import com.example.play2_android_casadocodigo.R;

public class Top100FilmesCult extends ListActivity implements OnClickListener {

	private static final String NOME = "nome";
	private static final String ANO = "ano";

	ArrayList<String> listItems = new ArrayList<String>();

	ArrayAdapter<String> adapter;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_main);
		setTitle(R.string.titulo);
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
		setListAdapter(adapter);
		findViewById(R.id.buscarBtn).setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {

		try {

			JSONParser jParser = new JSONParser();

			JSONArray json = jParser.getJSONFromUrl("http://192.168.0.101:9000/filmesJSON");

			for (int i = 0 ; i < json.length() ; i++) {

				try {

					JSONObject c = json.getJSONObject(i);
					String nome = c.getString(NOME);
					String ano = c.getString(ANO);

					listItems.add(ano + " - " + nome);

				} catch (JSONException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		adapter.notifyDataSetChanged();

	}

}

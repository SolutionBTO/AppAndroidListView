package br.solutionbto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private ListView listView;
	private List<String> countries=new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView=(ListView)findViewById(R.id.main_listview);
		
		final String[] locales = Locale.getISOCountries();
		
		for (String countryCode : locales) {
			Locale obj = new Locale("", countryCode);
			countries.add(obj.getCountry()+" - "+obj.getDisplayCountry());
		}
		
		listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, countries));
		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Toast.makeText(MainActivity.this, "Country is: "+countries.get(position), Toast.LENGTH_LONG).show();
			}
			
		});
	}
}

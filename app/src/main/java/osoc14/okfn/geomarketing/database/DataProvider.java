package osoc14.okfn.geomarketing.database;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import osoc14.okfn.geomarketing.database.restTemplate.History;

/**
 * Created by Samuel on 02/07/14.
 */
public class DataProvider {

    TextView txtView;

    public DataProvider() {
    }

    public void attachData(TextView txtView) {
        this.txtView = txtView;
        new HttpRequestTask().execute();
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, History[]> {
        @Override
        protected History[] doInBackground(Void... params) {
            try {
                final String url = "http://213.118.155.236:5900/history/2";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                History[] stores = restTemplate.getForObject(url, History[].class);
                //Greeting greeting = restTemplate.getForObject(url, Greeting.class);
                return stores;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(History[] stores) {
            //TextView greetingIdText = (TextView) findViewById(R.id.txtView);
            txtView.setText("ojo" + stores[3].getName());
        }

    }
}

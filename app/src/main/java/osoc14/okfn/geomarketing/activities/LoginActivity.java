package osoc14.okfn.geomarketing.activities;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;

import osoc14.okfn.geomarketing.MyApp;
import osoc14.okfn.geomarketing.R;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new LoginFragment())
                    .commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class LoginFragment extends Fragment {

        public LoginFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_login, container, false);

            Button bttnLogin = (Button )rootView.findViewById(R.id.bttnLogin);
            bttnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    MyApp.loggedIn = true;

                    Intent in = new Intent(getActivity(), MainActivity.class);
                    in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(in);


                }
            });
            return rootView;
        }
    }
}

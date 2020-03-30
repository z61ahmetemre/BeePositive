package com.example.android.bee;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.Serializable;

import butterknife.ButterKnife;
import butterknife.BindView;

public class LoginActivity extends AppCompatActivity implements Serializable {
  private static final String TAG = "LoginActivity";
  private static final int REQUEST_SIGNUP = 0;

  private FirebaseAuth mAuth;
  private User user;
  private ServerManager sm;

  @BindView(R.id.input_email) EditText _emailText;
  @BindView(R.id.input_password) EditText _passwordText;
  @BindView(R.id.btn_login) Button _loginButton;
  @BindView(R.id.link_signup) TextView _signupLink;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);

    mAuth = FirebaseAuth.getInstance();
    user = User.getInstance();
    sm = ServerManager.getInstance();

    _loginButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        login();
      }
    });

    _signupLink.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        // Start the Signup activity
        Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
        startActivityForResult(intent, REQUEST_SIGNUP);
      }
    });
  }

  public void login() {
    Log.d(TAG, "Login");

    if (!validate()) {
      onLoginFailed();
      return;
    }

    _loginButton.setEnabled(false);

    final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
        R.style.Theme_AppCompat_DayNight_Dialog);
    progressDialog.setIndeterminate(true);
    progressDialog.setMessage("Authenticating...");
    progressDialog.show();

    String email = _emailText.getText().toString();
    String password = _passwordText.getText().toString();
    final boolean[] success = {false};

    // TODO: Implement your own authentication logic here.
    mAuth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
              // Sign in success, update UI with the signed-in user's information
              Log.d(TAG, "signInWithEmail:success");
              success[0] = true;
              //updateUI(user);
            } else {
              // If sign in fails, display a message to the user.
              Log.w(TAG, "signInWithEmail:failure", task.getException());
              success[0] = false;
              Toast.makeText(LoginActivity.this, "Authentication failed.",
                  Toast.LENGTH_SHORT).show();
              //updateUI(null);
            }

            // ...
          }
        });

    new android.os.Handler().postDelayed(
        new Runnable() {
          public void run() {
            // On complete call either onLoginSuccess or onLoginFailed
            if(success[0])
              onLoginSuccess();
            else
              onLoginFailed();
            progressDialog.dismiss();
          }
        }, 3000);
  }


  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_SIGNUP) {
      if (resultCode == RESULT_OK) {

        // TODO: Implement successful signup logic here
        // By default we just finish the Activity and log them in automatically
        this.finish();
      }
    }
  }

  @Override
  public void onBackPressed() {
    // disable going back to the MainActivity
    moveTaskToBack(false);
  }

  public void onLoginSuccess() {
    _loginButton.setEnabled(true);

    sm.syncronize();
    //TODO: signupdan sonra buraya bak
    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
    startActivityForResult(intent,0);
    //finish();
  }

  public void onLoginFailed() {
    Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

    _loginButton.setEnabled(true);
  }

  public boolean validate() {
    boolean valid = true;

    String email = _emailText.getText().toString();
    String password = _passwordText.getText().toString();

    if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
      _emailText.setError("Enter a valid email address");
      valid = false;
    } else {
      _emailText.setError(null);
    }

    if (password.isEmpty() || password.length() < 6 || password.length() > 10) {
      _passwordText.setError("Between 6 and 10 alphanumeric characters");
      valid = false;
    } else {
      _passwordText.setError(null);
    }

    return valid;
  }
}
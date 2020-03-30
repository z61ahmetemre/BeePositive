package com.example.android.bee;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.NonNull;

public class SignupActivity extends AppCompatActivity implements Serializable, OnCompleteListener {
  private static final String TAG = "SignupActivity";

  private FirebaseAuth mAuth;
  private ServerManager sm;
  private User user;
  private DatabaseReference mDatabase;

  @BindView(R.id.input_name) EditText _nameText;
  @BindView(R.id.input_age) EditText _ageText;
  @BindView(R.id.input_email) EditText _emailText;
  @BindView(R.id.input_password) EditText _passwordText;
  @BindView(R.id.btn_signup) Button _signupButton;
  @BindView(R.id.link_login) TextView _loginLink;
  @BindView(R.id.male_button) RadioButton _maleButton;
  @BindView(R.id.female_button) RadioButton _femaleButton;
  @BindView(R.id.no_gender_button) RadioButton _noGenderButton;



  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_signup);
    ButterKnife.bind(this);

    mAuth = FirebaseAuth.getInstance();
    sm = ServerManager.getInstance();
    user = User.getInstance();
    mDatabase = FirebaseDatabase.getInstance().getReference();

    _signupButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        signup();
      }
    });

    _loginLink.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // Finish the registration screen and return to the Login activity
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivityForResult(intent,0);
        //finish();
      }
    });
  }

  public void signup() {
    Log.d(TAG, "Signup");

    if (!validate()) {
      onSignupFailed();
      return;
    }

    _signupButton.setEnabled(false);

    final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
        R.style.Theme_AppCompat_DayNight_Dialog);
    progressDialog.setIndeterminate(true);
    progressDialog.setMessage("Creating Account...");
    progressDialog.show();

    String name = _nameText.getText().toString();
    String email = _emailText.getText().toString();
    String password = _passwordText.getText().toString();
    final boolean[] success = {false};
    // TODO: Implement your own signup logic here.
    mAuth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
              // Sign in success, update UI with the signed-in user's information
              Log.d(TAG, "createUserWithEmail:success");
              FirebaseUser user = mAuth.getCurrentUser();
              success[0] = true;
              //updateUI(user);
            } else {
              // If sign in fails, display a message to the user.
              success[0] = false;
              Log.w(TAG, "createUserWithEmail:failure", task.getException());
              Toast.makeText(SignupActivity.this, "Authentication failed.",
                  Toast.LENGTH_SHORT).show();
              //updateUI(null);
            }

            // [START_EXCLUDE]
            //hideProgressBar();
            // [END_EXCLUDE]
          }
        });

    new android.os.Handler().postDelayed(
        new Runnable() {
          public void run() {
            // On complete call either onSignupSuccess or onSignupFailed
            // depending on success
            if(success[0])
              onSignupSuccess();
            else
              onSignupFailed();
            progressDialog.dismiss();
          }
        }, 3000);
  }


  public void onSignupSuccess() {
    _signupButton.setEnabled(true);
    setResult(RESULT_OK, null);

    //Initialize the user with given informations
    user.setName(_nameText.getText().toString());
    user.setUserID(_emailText.getText().toString());
    user.setAge(Integer.parseInt(_ageText.getText().toString()));
    user.setPassword(_passwordText.getText().toString());
    if(_maleButton.isChecked())
      user.setSex(1);
    else if (_femaleButton.isChecked())
      user.setSex(0);
    else if (_noGenderButton.isChecked())
      user.setSex(-1);
    user.setIsRegistered(true);

    //Authentication is OK. Finish the creating account part.
    sm.createAccount();

    Toast.makeText(SignupActivity.this, "Welcome to Bee+",
        Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
    startActivityForResult(intent,0);

    //finish();
  }

  public void onSignupFailed() {
    Toast.makeText(getBaseContext(), "SignUp failed", Toast.LENGTH_LONG).show();

    _signupButton.setEnabled(true);
  }

  public boolean validate() {
    boolean valid = true;

    String name = _nameText.getText().toString();
    int age = 0;
    if(!_ageText.getText().toString().isEmpty())
      age = Integer.parseInt(_ageText.getText().toString());
    String email = _emailText.getText().toString();
    String password = _passwordText.getText().toString();

    if (name.isEmpty() || name.length() < 3) {
      _nameText.setError("at least 3 characters");
      valid = false;
    } else {
      _nameText.setError(null);
    }

    if(_ageText.getText().toString().isEmpty() || _ageText.getText().toString().length() > 2 || age < 7 || age > 99) {
      _ageText.setError("invalid age please check");
      valid = false;
    }
    else {
      _ageText.setError(null);
    }

    if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
      _emailText.setError("enter a valid email address");
      valid = false;
    } else {
      _emailText.setError(null);
    }

    if (password.isEmpty() || password.length() < 6 || password.length() > 10) {
      _passwordText.setError("between 6 and 10 alphanumeric characters");
      valid = false;
    } else {
      _passwordText.setError(null);
    }

    if(valid)
      _signupButton.setClickable(true);
    return valid;
  }

  @Override
  public void onComplete(@android.support.annotation.NonNull Task task) {

  }
}
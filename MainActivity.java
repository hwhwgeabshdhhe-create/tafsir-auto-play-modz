package com.tafsir.autoplay;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * UI starter only. Authentication is DEMO/local and is not production-secure.
 * Replace DemoAuth with a server-side authentication API before real release.
 */
public class MainActivity extends Activity {
    private static final String DEMO_USER = "admin";
    private static final String DEMO_PASS = "ChangeMe123!";
    private LinearLayout root;
    private EditText username, password;

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        showLogin();
    }

    private int dp(float value) {
        return (int)(value * getResources().getDisplayMetrics().density + 0.5f);
    }

    private GradientDrawable bg(int color, int radius) {
        GradientDrawable d = new GradientDrawable();
        d.setColor(color);
        d.setCornerRadius(dp(radius));
        return d;
    }

    private TextView label(String text, int size, int color) {
        TextView v = new TextView(this);
        v.setText(text);
        v.setTextSize(size);
        v.setTextColor(color);
        return v;
    }

    private void base() {
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER_HORIZONTAL);
        root.setPadding(dp(24), dp(28), dp(24), dp(24));
        root.setBackgroundColor(Color.rgb(18, 17, 34));
        setContentView(root);
    }

    private void addSpace(int h) {
        View v = new View(this);
        root.addView(v, new LinearLayout.LayoutParams(1, dp(h)));
    }

    private void showLogin() {
        base();
        addSpace(34);
        TextView brand = label("TAFSIR", 16, Color.rgb(182, 166, 255));
        brand.setGravity(Gravity.CENTER);
        brand.setTypeface(null, Typeface.BOLD);
        root.addView(brand, new LinearLayout.LayoutParams(-1, -2));

        TextView title = label("AUTO PLAY MODZ", 27, Color.WHITE);
        title.setTypeface(null, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);
        root.addView(title, new LinearLayout.LayoutParams(-1, -2));

        TextView subtitle = label("Private access • Sign in to continue", 14, Color.LTGRAY);
        subtitle.setGravity(Gravity.CENTER);
        root.addView(subtitle, new LinearLayout.LayoutParams(-1, -2));
        addSpace(34);

        username = new EditText(this);
        username.setSingleLine(true);
        username.setHint("Username");
        username.setTextColor(Color.WHITE);
        username.setHintTextColor(Color.LTGRAY);
        username.setPadding(dp(16), dp(12), dp(16), dp(12));
        username.setBackground(bg(Color.rgb(39, 37, 61), 12));
        root.addView(username, new LinearLayout.LayoutParams(-1, dp(54)));
        addSpace(14);

        password = new EditText(this);
        password.setSingleLine(true);
        password.setHint("Password");
        password.setInputType(129);
        password.setTextColor(Color.WHITE);
        password.setHintTextColor(Color.LTGRAY);
        password.setPadding(dp(16), dp(12), dp(16), dp(12));
        password.setBackground(bg(Color.rgb(39, 37, 61), 12));
        root.addView(password, new LinearLayout.LayoutParams(-1, dp(54)));
        addSpace(22);

        Button login = new Button(this);
        login.setText("LOGIN");
        login.setTextColor(Color.WHITE);
        login.setAllCaps(false);
        login.setBackground(bg(Color.rgb(100, 75, 220), 12));
        root.addView(login, new LinearLayout.LayoutParams(-1, dp(52)));
        login.setOnClickListener(v -> {
            String u = username.getText().toString().trim();
            String p = password.getText().toString();
            if (DEMO_USER.equals(u) && DEMO_PASS.equals(p)) {
                showAdmin();
            } else {
                Toast.makeText(this, "Login failed. Check username/password.", Toast.LENGTH_LONG).show();
            }
        });

        addSpace(22);
        TextView note = label("DEMO BUILD — connect secure server before real use.", 12, Color.rgb(255, 205, 120));
        note.setGravity(Gravity.CENTER);
        root.addView(note, new LinearLayout.LayoutParams(-1, -2));
        addSpace(12);
        TextView creds = label("Demo login: admin / ChangeMe123!", 12, Color.LTGRAY);
        creds.setGravity(Gravity.CENTER);
        root.addView(creds, new LinearLayout.LayoutParams(-1, -2));
    }

    private void showAdmin() {
        base();
        addSpace(18);
        TextView title = label("Admin Dashboard", 26, Color.WHITE);
        title.setTypeface(null, Typeface.BOLD);
        root.addView(title);
        addSpace(8);
        TextView sub = label("TAFSIR AUTO PLAY MODZ", 14, Color.rgb(182, 166, 255));
        root.addView(sub);
        addSpace(22);

        addCard("USER MANAGEMENT", "Create and manage approved user accounts.");
        addCard("SUBSCRIPTION", "Demo expiry status: " +
                new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date()) +
                " (sample only)");
        addCard("ENGINE STATUS", "Aim AI Engine integration: not yet connected.");
        addSpace(14);

        Button manage = new Button(this);
        manage.setText("Demo: Add user");
        manage.setAllCaps(false);
        manage.setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle("Admin feature placeholder")
                .setMessage("A secure backend is required to create users, issue subscription keys, and enforce expiry. This demo does not store real users.")
                .setPositiveButton("OK", null).show());
        root.addView(manage, new LinearLayout.LayoutParams(-1, dp(50)));

        Button logout = new Button(this);
        logout.setText("Log out");
        logout.setAllCaps(false);
        logout.setOnClickListener(v -> showLogin());
        root.addView(logout, new LinearLayout.LayoutParams(-1, dp(50)));
    }

    private void addCard(String heading, String body) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(16), dp(14), dp(16), dp(14));
        card.setBackground(bg(Color.rgb(39, 37, 61), 14));
        TextView h = label(heading, 13, Color.rgb(182, 166, 255));
        h.setTypeface(null, Typeface.BOLD);
        card.addView(h);
        TextView b = label(body, 15, Color.WHITE);
        LinearLayout.LayoutParams bp = new LinearLayout.LayoutParams(-1, -2);
        bp.topMargin = dp(7);
        card.addView(b, bp);
        LinearLayout.LayoutParams cp = new LinearLayout.LayoutParams(-1, -2);
        cp.bottomMargin = dp(12);
        root.addView(card, cp);
    }
}

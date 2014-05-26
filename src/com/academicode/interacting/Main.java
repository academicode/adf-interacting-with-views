package com.academicode.interacting;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.academicode.interactingwithviews.R;

/**
 * This is the first (and only) Activity the user sees when the application is launched.  We currently
 * have the user participate in a simple conversation with the Android image. 
 * 
 * The layout file associated with this Activity is "layout\main.xml"
 * 
 * @author Marc J. McDougall
 */
public class Main extends Activity {

	// References to the Views included in this Activity.
	private TextView text;
	private Button reply;
	private EditText et;
	
	// Note: this View is actually not used in the code anywhere.
	private ImageView image;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// Mandatory parent method call.
		super.onCreate(savedInstanceState);
		
		// We set the content view to the appropriate XML layout file.
		setContentView(R.layout.main);
		
		// We hook all of our Java Views to the correct XML components.
		image = (ImageView) findViewById(R.id.imageView1);
		text = (TextView) findViewById(R.id.textView2);
		reply = (Button) findViewById(R.id.button1);
		et = (EditText) findViewById(R.id.editText1);

		// Here, we set a click listener to react to any touch events on the "reply" button.
		reply.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// Removed as a debug output.
//				Toast.makeText(Main.this, "Clicked!", Toast.LENGTH_SHORT).show();
				
				// Modify the text of our TextView using our private helper method (modifyText).
				modifyText("Welcome to the application, " + et.getText().toString() + "!");
				
				// Reset the EditText View to the null string.
				et.setText("");
			}
		});
	}
	
	/**
	 * This method simply modifies the text of the TextView using the "setText(String)" method,
	 * and concatenates two quotes on either side to imply that the Android image is "saying something". 
	 * 
	 * @param newText The text that will be displayed by the TextView.
	 */
	private void modifyText(String newText){
		
		// Simply use the TextView's setText(String) method to update the text.
		text.setText("'" + newText + "'");
	}
}

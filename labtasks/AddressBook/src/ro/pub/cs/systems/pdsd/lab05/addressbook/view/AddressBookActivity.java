package ro.pub.cs.systems.pdsd.lab05.addressbook.view;

import ro.pub.cs.systems.pdsd.lab05.addressbook.R;
import ro.pub.cs.systems.pdsd.lab05.addressbook.general.Constants;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class AddressBookActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_address_book);
		
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.contact_basic_details, new ContactBasicDetailsFragment());
		fragmentTransaction.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.address_book, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		// TODO: exercise 6a
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		switch(requestCode) {
			case Constants.OPERATION_INSERT:
				if (resultCode == Activity.RESULT_OK) {
					Toast.makeText(this, "Insert operation succeeded", Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(this, "Insert operation failed", Toast.LENGTH_LONG).show();
				}
				break;
			case Constants.OPERATION_UPDATE:
				FragmentManager fragmentManager = getFragmentManager();
				ContactAdditionalDetailsFragment contactAdditionalDetailsFragment = (ContactAdditionalDetailsFragment)fragmentManager.findFragmentById(R.id.contact_additional_details);
				if (contactAdditionalDetailsFragment != null) {
					contactAdditionalDetailsFragment.refresh();
				}
				if (resultCode == Activity.RESULT_OK) {
					Toast.makeText(this, "Update operation succeeded", Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(this, "Update operation failed", Toast.LENGTH_LONG).show();
				}
				break;
		}
	}
}

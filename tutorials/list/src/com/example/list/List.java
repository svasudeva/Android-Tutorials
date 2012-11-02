package com.example.list;

 import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class List extends Activity {
	
	static final private int ADD_NEW_TODO = Menu.FIRST;
	static final private int REMOVE_TODO = Menu.FIRST + 1;
	
	@Override public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		// Create and add new menu items.
		MenuItem itemAdd = menu.add(0, ADD_NEW_TODO, Menu.NONE,R.string.add_new_item); 
		MenuItem itemRem = menu.add(0, REMOVE_TODO, Menu.NONE,R.string.remove_item);
		// Assign icons
		itemAdd.setIcon(R.drawable.add_new_item);
		itemRem.setIcon(R.drawable.remove_item);
		// Allocate shortcuts to each of them.
		itemAdd.setShortcut('0','a');
		itemRem.setShortcut('1','r');
		return true;
	}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
   
        ListView myListView = (ListView) findViewById(R.id.myListView);
        final EditText myTextView = (EditText) findViewById(R.id.myTextView);
        
final ArrayList<String> todoItem = new ArrayList<String>();
int resID = R.layout.todolist_item ;
final ArrayAdapter<String> aa = new ArrayAdapter<String>(this, resID,todoItem);
myListView.setAdapter(aa);

myTextView.setKeyListener(new KeyListener() 
{ public <KeyEvent> boolean onKey(View v, int keyCode, KeyEvent event) 
{
	if (((android.view.KeyEvent) event).getAction() ==android.view.KeyEvent.ACTION_DOWN) 
		if (keyCode == android.view.KeyEvent.KEYCODE_DPAD_CENTER) 
		{ 
			todoItem.add(0, myTextView.getText().toString()); 
			aa.notifyDataSetChanged(); 
			myTextView.setText("");
			return true;
		}
		return false;
	}

@Override
public void clearMetaKeyState(View arg0, Editable arg1, int arg2) {
	// TODO Auto-generated method stub
	
}

@Override
public int getInputType() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public boolean onKeyDown(View arg0, Editable arg1, int arg2,
		android.view.KeyEvent arg3) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean onKeyOther(View arg0, Editable arg1, android.view.KeyEvent arg2) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean onKeyUp(View arg0, Editable arg1, int arg2,
		android.view.KeyEvent arg3) {
	// TODO Auto-generated method stub
	return false;
} 
});  
    }

}

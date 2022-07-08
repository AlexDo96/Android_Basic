package com.example.administrator.demo2;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    private List<String> directoryEntries =
            new ArrayList<String>();
    private File currentDirectory = new File("/");
    private enum DISPLAYMODE{ ABSOLUTE, RELATIVE; }
    private final DISPLAYMODE displayMode = DISPLAYMODE.ABSOLUTE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        browseToRoot();

    }

    private void browseToRoot()
    {
        browseTo(new File("/"));
    }

    private void browseTo(final File aDirectory){
        if (aDirectory.isDirectory()){
            this.currentDirectory = aDirectory;
            fill(aDirectory.listFiles());
        }else{

        }
    }
    private void fill(File[] files) {
        this.directoryEntries.clear();

        // Add the "." == "current directory"
        // and the ".." == 'Up one level'
        this.directoryEntries.add(getString(R.string.current_dir));
        if(this.currentDirectory.getParent() != null)
            this.directoryEntries.add(getString(R.string.up_one_level));

        switch(this.displayMode){
            case ABSOLUTE:
                for (File file : files){
                    this.directoryEntries.add(file.getPath());
                }
                break;
            case RELATIVE: // On relative Mode, we have to add the current-path to the beginning
                int currentPathStringLenght = this.currentDirectory.getAbsolutePath().length();
                for (File file : files){
                    this.directoryEntries.add(file.getAbsolutePath().substring(currentPathStringLenght));
                }
                break;
        }
        ArrayAdapter<String> directoryList = new ArrayAdapter<String>(this,
                R.layout.file_row, this.directoryEntries);

        this.setListAdapter(directoryList);
    }

    private void upOneLevel(){
        if(this.currentDirectory.getParent() != null)
            this.browseTo(this.currentDirectory.getParentFile());
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);
        int selectionRowID = (int)id;
        String selectedFileString = this.directoryEntries.get(selectionRowID);
        Toast.makeText(getApplicationContext(), selectionRowID + "vao" + selectedFileString, Toast.LENGTH_SHORT).show();
        if (selectedFileString.equals(".")) {
            // Refresh
            this.browseTo(this.currentDirectory);
        } else if(selectedFileString.equals("..")){
            this.upOneLevel();
        } else {
            File clickedFile = null;
            switch(this.displayMode){
                case RELATIVE:
                    clickedFile = new File(this.currentDirectory.getAbsolutePath()
                            + this.directoryEntries.get(selectionRowID));
                    break;
                case ABSOLUTE:
                    clickedFile = new File(this.directoryEntries.get(selectionRowID));
                    break;
            }
            if(clickedFile != null)
                this.browseTo(clickedFile);
        }

    }
}

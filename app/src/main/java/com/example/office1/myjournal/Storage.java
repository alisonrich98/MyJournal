package com.example.office1.myjournal;

import android.os.Environment;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

public class Storage extends AppCompatActivity {
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    private File getTargetFolder(Context context, String folderName) {
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), folderName);
        file.mkdirs();
        return file;

    }
}

package com.example.vitaly.yandexapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

/**
 * Created by vitaly on 18.03.18.
 */

public class NoteEditorActivity extends AppCompatActivity {

    public static final String NODE_EDITOR_DATA = "node_editor_data";

    private boolean redactionMode = false;
    private ListNote note;

    private EditText descriptionEditor;
    private EditText captionEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_editor);

        descriptionEditor = (EditText) findViewById(R.id.description_editor);
        captionEditor = (EditText) findViewById(R.id.caption_editor);

        Intent intent = getIntent();
        if (intent.hasExtra(MainActivity.REDACTED_NOTE)) {
            note = (ListNote) intent.getSerializableExtra(MainActivity.REDACTED_NOTE);
            setNoteViews(note);
            redactionMode = true;
        }
    }

    private void setNoteViews(ListNote note) {
        descriptionEditor.setText(note.getDescription());
        captionEditor.setText(note.getCaption());

        TextView date = (TextView) findViewById(R.id.date_editor);
        String dateString = note.getTime() + " " + note.getDate();
        date.setText(dateString);
    }

    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Caption is empty")
                .setMessage("Please add any information in caption!")
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private boolean captionIsEmpty() {
        return captionEditor.getText().toString().trim().length() == 0;
    }

    private ListNote getNewNote() {
        String caption = captionEditor.getText().toString();
        String description = descriptionEditor.getText().toString();
        Date date = new Date();
        int color = ColorProvider.getRandomColor();

        return new ListNote(color, caption, description, date);
    }

    private ListNote getRedactedNode() {
        String caption = captionEditor.getText().toString();
        String description = descriptionEditor.getText().toString();

        note.setCaption(caption);
        note.setDescription(description);

        return note;
    }

    public void save(View view) {

        if (captionIsEmpty()) {
            showAlert();
            return;
        }

        ListNote listNote = (redactionMode) ? getRedactedNode() : getNewNote();
        Intent backIntent = new Intent();

        if (redactionMode) {
            Intent intent = getIntent();
            int i = intent.getIntExtra(MainActivity.REDACTED_NOTE_NUMBER, 0);
            backIntent.putExtra(MainActivity.REDACTED_NOTE_NUMBER, i);
        }

        backIntent.putExtra(NODE_EDITOR_DATA, listNote);
        setResult(RESULT_OK, backIntent);
        finish();
    }

}

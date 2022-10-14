package com.example.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TODO: fix it after finishing the Video
 */
public class AllBooksActivity extends AppCompatActivity {

    private static final String TAG = "AllBooksActivity";

    private RecyclerView booksRecView;
    private BooksRecViewAdapter adapter;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

//
// Use MotionLayout
//        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

  //      Objects.requireNonNull(getSupportActionBar());

        // TODO Fix it at:2:25:48

        // ActionBar.setDefaultDisplayHomeAsUpEnabled can only be called from within the same library group prefix (referenced groupId=androidx.appcompat with prefix androidx from groupId=My Library)
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        adapter = new BooksRecViewAdapter(this, "allBooks");
        booksRecView = findViewById(R.id.booksRecView);

        booksRecView.setAdapter(adapter);
//        booksRecView.setLayoutManager(new GridLayoutManager(this, 2));
        booksRecView.setLayoutManager(new LinearLayoutManager(this));


        adapter.setBooks(Utils.getInstance(this).getAllBooks());
        Log.d(TAG, "onCreate is finished");
    }

//    @Override
//    public void finish() {
//        super.finish();
//        overridePendingTransition(R.anim.slide_out, R.anim.slide_in);
//    }


    // TODO fix it, at 2:25:48
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
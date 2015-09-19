package com.example.mybookshelf;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentStatePagerAdapter;

import com.example.mybookshelf.model.Books;

/**
 * Created by Promlert on 9/20/2015.
 */
public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private Books mBooks;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
        mBooks = Books.getInstance(context);
    }

    @Override
    public int getCount() {
        return mBooks.getBooks().size();
    }

    @Override
    public Fragment getItem(int position) {
        return BookDetailsFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return mBooks.getBooks().get(position).getTitle();
    }
}
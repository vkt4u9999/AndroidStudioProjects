package com.vkt4u9999.clubolympus;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.vkt4u9999.clubolympus.data.ClubOlympusContract;

public class MemberCursorAdapter extends CursorAdapter {

    public MemberCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater. from(context).inflate(R.layout.member_item,viewGroup,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvFirstTextView= (TextView)view.findViewById(R.id.firstNameTextView);
        TextView tvSecondTextView= (TextView)view.findViewById(R.id.lastNameTextView);
        TextView tvThirdTextView= (TextView)view.findViewById(R.id.sportNameTextView);

        String firstTName= cursor.getString(cursor.getColumnIndexOrThrow(ClubOlympusContract.MemberEntry.COLUMN_FIRST_NAME));
        String lastName= cursor.getString(cursor.getColumnIndexOrThrow(ClubOlympusContract.MemberEntry.COLUMN_LAST_NAME));
        String sport = cursor.getString(cursor.getColumnIndexOrThrow(ClubOlympusContract.MemberEntry.COLUMN_SPORT));
        tvFirstTextView.setText(firstTName);
        tvSecondTextView.setText(lastName);
        tvThirdTextView.setText(sport);

    }
}

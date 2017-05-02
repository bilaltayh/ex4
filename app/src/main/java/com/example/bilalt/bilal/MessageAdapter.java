package com.example.bilalt.bilal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class ChatArrayAdapter extends ArrayAdapter< MessageOBJ> {

    private TextView chatText;
    private List<MessageOBJ> chatMessageList = new ArrayList<>();
    private Context main;

    @Override
    public void add(MessageOBJ object) {

        chatMessageList.add(object);
        super.add(object);
    }

    public ChatArrayAdapter(Context main, int textViewResourceId) {

        super(main, textViewResourceId);
        this.main = main;
    }

    public void delete(int num){
        chatMessageList.remove(num);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.chatMessageList.size();
    }

    public int getNum(int position) {
        MessageOBJ chatMessageObj = getItem(position);
        return chatMessageObj.num;
    }

    public MessageOBJ getItem(int index) {
        return this.chatMessageList.get(index);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        MessageOBJ chatMessageObj = getItem(position);
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(R.layout.list, parent, false);
        final int Num = chatMessageObj.num;

        chatText = chatMessageObj.color == true ? (TextView) row.findViewById(R.id.messageR):(TextView) row.findViewById(R.id.messageB);


        chatText.setText(chatMessageObj.message);
        return row;
    }
}
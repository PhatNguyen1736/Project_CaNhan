package com.example.foodorder_project;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatNhaHang#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatNhaHang extends Fragment {
    private RecyclerView rcvMessage;
    private List<Message> mListMessage;
    private EditText edtMessage;
    private MessageAdapter messageAdapter;
    private AppCompatButton btnSend;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChatNhaHang() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatNhaHang.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatNhaHang newInstance(String param1, String param2) {
        ChatNhaHang fragment = new ChatNhaHang();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat_nha_hang, container, false);

        edtMessage = view.findViewById(R.id.edt_message); // Tìm EditText trong layout của Fragment

        btnSend = view.findViewById(R.id.btn_send);

        rcvMessage = view.findViewById(R.id.rcv_message);

        mListMessage= new ArrayList<>();
        messageAdapter= new MessageAdapter();
        messageAdapter.setData(mListMessage);
        rcvMessage.setAdapter(messageAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        rcvMessage.setLayoutManager(linearLayoutManager);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        return view;
    }

    private void sendMessage() {
        String strMessage = edtMessage.getText().toString().trim();
        if(TextUtils.isEmpty(strMessage)){
            return;
        }

        mListMessage.add(new Message(strMessage));
        messageAdapter.notifyDataSetChanged();
        rcvMessage.scrollToPosition(mListMessage.size()-1);
        edtMessage.setText("");

    }
}
package com.centling.findplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MineFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class MineFragment extends Fragment {
    private boolean player;
    private final String item_img = "item_img";
    private final String item_name = "item_name";
    private final String item_arrow = "item_arrow";


    public MineFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        TextView myNickname = (TextView)getActivity().findViewById(R.id.mine_nickname);
        myNickname.setText("我是美妞");
        TextView myAge = (TextView)getActivity().findViewById(R.id.mine_age);
        myAge.setText("23");
        //Need interface to decide if this user is a player
        player = false;
        ListView mineList = (ListView)getActivity().findViewById(R.id.mine_item_list);
        initialListView(mineList);
    }
    private void initialListView(ListView lv){
        ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();
        //我的钱包
        HashMap<String, Object> item_wallet = new HashMap<String, Object>();
        item_wallet.put(item_img, R.drawable.me_wallet);
        item_wallet.put(item_name, "我的钱包");
        item_wallet.put(item_arrow, R.drawable.right_arrow);
        itemList.add(item_wallet);

        if (player){
            HashMap<String, Object> item_clan = new HashMap<String, Object>();
            item_clan.put(item_img, R.drawable.me_clan);
            item_clan.put(item_name, "申请公会");
            item_clan.put(item_arrow, R.drawable.right_arrow);
            itemList.add(item_clan);

        }else{
            HashMap<String, Object> item_gamegod = new HashMap<String, Object>();
            item_gamegod.put(item_img,R.drawable.me_game_god);
            item_gamegod.put(item_name, "申请游神");
            item_gamegod.put(item_arrow, R.drawable.right_arrow);
            itemList.add(item_gamegod);
        }

        HashMap<String, Object> item_attention = new HashMap<String, Object>();
        item_attention.put(item_img, R.drawable.me_attention);
        item_attention.put(item_name, "我的关注");
        item_attention.put(item_arrow, R.drawable.right_arrow);
        itemList.add(item_attention);

        HashMap<String, Object> item_partner = new HashMap<String, Object>();
        item_partner.put(item_img, R.drawable.me_partner);
        item_partner.put(item_name, "我的陪玩");
        item_partner.put(item_arrow, R.drawable.right_arrow);
        itemList.add(item_partner);

        HashMap<String, Object> item_set = new HashMap<String, Object>();
        item_set.put(item_img, R.drawable.me_set);
        item_set.put(item_name, "设置");
        item_set.put(item_arrow, R.drawable.right_arrow);
        itemList.add(item_set);

        String[] from = {item_img, item_name, item_arrow};
        int[] to = {R.id.mine_item_img, R.id.mine_item_name, R.id.mine_item_arrow};
        SimpleAdapter sa = new SimpleAdapter(getActivity(), itemList, R.layout.mine_item_list_layout, from, to);
        lv.setAdapter(sa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "you click on "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

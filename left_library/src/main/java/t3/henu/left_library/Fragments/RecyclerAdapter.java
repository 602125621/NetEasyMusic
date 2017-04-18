package t3.henu.left_library.Fragments;

import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import t3.henu.left_library.R;


/**
 * Created by 高逸博 on 2017/4/13.
 */

public class RecyclerAdapter extends BaseMultiItemQuickAdapter<RecyclerData> {
    private final String  TAG="RecyclerAdapter";
    private List<RecyclerData>datas;
    public RecyclerAdapter(List<RecyclerData> data) {
        super(data);
        this.datas=data;
        addItemType(RecyclerData.STYLE, R.layout.recyclerviewitem);
        addItemType(RecyclerData.DIVIDER, R.layout.recyclerview_divider);
        addItemType(RecyclerData.GEDAN,R.layout.recyclerview_gedan);
        addItemType(RecyclerData.DIVIDER_CHILD,R.layout.recyclerview_gedan_item);
    }

    @Override
    protected int getDefItemViewType(int position) {
        //Log.e(TAG, "convert: "+ position );
        if (position < 9) {
            if (position%2 == 0) {
                return RecyclerData.STYLE;
            } else if(position%2==1) {
                return RecyclerData.DIVIDER;
            }
        }else {
            return RecyclerData.GEDAN;
        }
        return RecyclerData.STYLE;
    }



    @Override
    protected void convert(final BaseViewHolder baseViewHolder, RecyclerData recyclerData) {
        switch (baseViewHolder.getItemViewType()) {
            case RecyclerData.STYLE:
                int pos=baseViewHolder.getPosition();

                baseViewHolder.setImageResource(R.id.id_recycler_Allmusic_recyclerItem_iview1, recyclerData.getImage());
                baseViewHolder.setText(R.id.id_recycler_Allmusic_recyclerItem_tview1, recyclerData.getText());
                baseViewHolder.setText(R.id.id_recycler_Allmusic_recyclerItem_tview2, recyclerData.getNum());
                break;
            case RecyclerData.DIVIDER:break;
            case RecyclerData.GEDAN:
                baseViewHolder.setText(R.id.id_recycler_Allmusic_recyclerItem_gedan_tview1,recyclerData.getText());
                baseViewHolder.setText(R.id.id_recycler_Allmusic_recyclerItem_gedan_tview2,recyclerData.getNum());

                baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos=baseViewHolder.getAdapterPosition();
                       /* if(){
                            collapse(pos);
                        }else{
                            expand(pos);
                        }*/
                    }
                });
                break;

        }
    }
}

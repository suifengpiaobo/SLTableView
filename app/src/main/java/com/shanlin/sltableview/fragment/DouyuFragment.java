package com.shanlin.sltableview.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shanlin.library.sltableview.SLIndexPath;
import com.shanlin.library.sltableview.SLTableView;
import com.shanlin.sltableview.R;
import com.shanlin.sltableview.fragment.base.DouyuBaseFragment;
import com.shanlin.sltableview.fragment.bean.DouyuBaseBean;
import com.shanlin.sltableview.fragment.bean.DouyuHeadBean;
import com.shanlin.sltableview.fragment.bean.DouyuHotAuthorBean;
import com.shanlin.sltableview.fragment.bean.DouyuRoomBean;
import com.shanlin.sltableview.fragment.bean.DouyuType;
import com.shanlin.sltableview.fragment.bean.DouyuYanzhiBean;

import java.util.ArrayList;

/**
 * 斗鱼demo
 */
public class DouyuFragment extends DouyuBaseFragment {

    private  int table_padding ;
    private  int table_padding_s2 ;


    @Override
    public int layoutId() {
        return R.layout.fragment_douyu;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        table_padding = context.getResources().getDimensionPixelSize(R.dimen.cell_padding);
        table_padding_s2 = context.getResources().getDimensionPixelSize(R.dimen.cell_padding_s2);
    }

    @Override
    public void initView(ViewGroup view) {
        tableView = new SLTableView.Builder(context)
                .setTableViewDataSource(this)
                .setTableViewDataSourcePlus(this)
                .setTableViewLayoutManagerExpand(this)
                .showStickyHeader(false)
                .setBgColor(context.getResources().getColor(R.color.color_white))
                .setLayoutManager(new GridLayoutManager(context,2))
                .build();
        view.addView(tableView);
    }

    @Override
    public void initData() {
        dataLists.clear();
        ArrayList<DouyuBaseBean> list = new ArrayList<>();
        list.add(new DouyuHeadBean("最热"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        list.add(new DouyuRoomBean("暴走漫画出品","暴走漫画 再看最后一集","6.6万"));
        dataLists.add(list);
        list = new ArrayList<>();
        list.add(new DouyuHeadBean("颜值"));
        list.add(new DouyuYanzhiBean("Cherry宛夕","4.1万","北京市"));
        list.add(new DouyuYanzhiBean("Cherry宛夕","4.1万","北京市"));
        list.add(new DouyuYanzhiBean("Cherry宛夕","4.1万","北京市"));
        list.add(new DouyuYanzhiBean("Cherry宛夕","4.1万","北京市"));
        dataLists.add(list);
        list = new ArrayList<>();
        list.add(new DouyuHeadBean("英雄联盟"));
        list.add(new DouyuRoomBean("凉风有兴","斗鱼第一亚索","8万"));
        list.add(new DouyuRoomBean("凉风有兴","斗鱼第一亚索","8万"));
        list.add(new DouyuRoomBean("凉风有兴","斗鱼第一亚索","8万"));
        list.add(new DouyuRoomBean("凉风有兴","斗鱼第一亚索","8万"));
        dataLists.add(list);
        list = new ArrayList<>();
        list.add(new DouyuHeadBean("魔兽世界"));
        list.add(new DouyuRoomBean("文艺冉","七煌|文艺冉 M勇气试炼","2113"));
        list.add(new DouyuRoomBean("文艺冉","七煌|文艺冉 M勇气试炼","2113"));
        list.add(new DouyuRoomBean("文艺冉","七煌|文艺冉 M勇气试炼","2113"));
        list.add(new DouyuRoomBean("文艺冉","七煌|文艺冉 M勇气试炼","2113"));
        dataLists.add(list);
        list = new ArrayList<>();
        list.add(new DouyuHeadBean("DOTA2"));
        list.add(new DouyuRoomBean("战术大师rubick","[战术大师] CDEC大师","4550"));
        list.add(new DouyuRoomBean("战术大师rubick","[战术大师] CDEC大师","4550"));
        list.add(new DouyuRoomBean("战术大师rubick","[战术大师] CDEC大师","4550"));
        list.add(new DouyuRoomBean("战术大师rubick","[战术大师] CDEC大师","4550"));
        dataLists.add(list);
        list = new ArrayList<>();
        list.add(new DouyuHeadBean("热门作者"));
        list.add(new DouyuHotAuthorBean("萝菽菽_acfun","72","9237"));
        list.add(new DouyuHotAuthorBean("鱼小碗","30","437"));
        dataLists.add(list);
        tableView.getAdapter().notifyDataSetChanged();
    }


    //SLTableViewDataSourcePlus
    @Override
    public boolean hiddenHeaderInSection(SLTableView tableView, int section) {
        return true;
    }

    @Override
    public boolean hiddenFooterInSection(SLTableView tableView, int section) {
        return true;
    }

    //SLTableViewLayoutManagerExpand
    @Override
    public int gridSpanSizeOfIndexPath(SLIndexPath indexPath) {
        int section = indexPath.getSection();
        int row = indexPath.getRow();
        if (row == 0) return  2;
        DouyuBaseBean baseBean = (DouyuBaseBean) dataLists.get(section).get(row); // head
        if (baseBean.getType() == DouyuType.TYPE_HOT_AUTHOR){
            return 2;
        }
        return 1;
    }

    @Override
    public void getItemOffsets(Rect outRect, SLIndexPath indexPath) {
        int section = indexPath.getSection();
        int row = indexPath.getRow();
        DouyuBaseBean baseBean = (DouyuBaseBean) dataLists.get(section).get(row); // head
        if (baseBean.getType() == DouyuType.TYPE_HOT_AUTHOR){
            return;
        }
        if (baseBean.getType() == DouyuType.TYPE_HEAD){
            return;
        }
        if (row >0 && row % 2 == 1){
            outRect.left = table_padding;
            outRect.right = table_padding_s2;
            outRect.top = table_padding_s2;
            outRect.bottom = table_padding_s2;

        }else if(row > 0 && row %2 == 0){
            outRect.right = table_padding;
            outRect.left = table_padding_s2;
            outRect.top = table_padding_s2;
            outRect.bottom = table_padding_s2;
        }
    }

    //SLCellViewClickListener
    @Override
    public void onCellViewClick(View view, SLIndexPath indexPath, Object userData) {
        int section = indexPath.getSection();
        int row = indexPath.getRow();
        String message = "";
        DouyuBaseBean baseBean = dataLists.get(section).get(row);
        switch (baseBean.getType()){
            case TYPE_HEAD:
                DouyuHeadBean douyuHead = (DouyuHeadBean) baseBean;
                message = String.format("点击<%s>更多,类型:<%s>",douyuHead.getTitle(),baseBean.getType());
                break;
            case TYPE_ROOM:
                DouyuRoomBean roomBean = (DouyuRoomBean) baseBean;
                message = String.format("点击<%s>的房间,类型:<%s>",roomBean.getRoomOwner(),baseBean.getType());
                break;
            case TYPE_HOT_AUTHOR:
                DouyuHotAuthorBean authorBean = (DouyuHotAuthorBean)baseBean;
                message = String.format("点击<%s>的房间,类型:<%s>",authorBean.getAuthorName(),baseBean.getType());
                break;
            case TYPE_ROOM_YANZHI:
                DouyuYanzhiBean yanzhiBean = (DouyuYanzhiBean)baseBean;
                message = String.format("点击<%s>的房间,类型:<%s>",yanzhiBean.getRoomOwner(),baseBean.getType());
                break;

        }
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }


}

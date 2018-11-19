package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 将 {@link Word}列表的数据 转换为 @{@link android.widget.ListView}的视图
 */
public class WordAdapter extends ArrayAdapter<Word>
{

    /**
     * Adapter构造器
     *
     * @param context 上下文
     * @param source  R.layout.list_item
     * @param objects 数据列表
     */
    public WordAdapter(Context context, int source, List<Word> objects)
    {
        super(context, source, objects);
    }

    /**
     * 用数据列表和视图模板构造视图并返回
     *
     * @param position    数据列表的位置 用来获取列表的数据
     * @param convertView R.layout.list_item
     * @param parent      R.id.list
     * @return convertView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // R.layout.list_item
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // 从数据列表获取当前位置的Word
        Word currentWord = getItem(position);

        // R.layout.list_item 的 R.id.default_text_view
        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);

        // 设置源语言
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // R.layout.list_item 的 R.id.miwok_text_view
        TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);

        // 设置 miwok 翻译
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = listItemView.findViewById(R.id.list_item_icon);

        // 判断是否有图片并设置资源id或4
        if (currentWord.hasImage()) {
            iconView.setImageResource(currentWord.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);
        } else {
            iconView.setVisibility(View.GONE);
        }


        // 返回 ListView
        return listItemView;
    }
}
